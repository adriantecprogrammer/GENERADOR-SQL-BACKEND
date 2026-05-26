package CRUD;

import Gramatica.Tabla;
import Gramatica.Atributo;
import java.util.List;

public class GeneradorHTML {

    public String generar(String nombreBD, List<Tabla> tablas) {
        return generar(nombreBD, tablas, null);
    }

    public String generar(String nombreBD, List<Tabla> tablas, String nombreTabla) {
        List<Tabla> tablasFiltradas = tablas;
        if (nombreTabla != null && !nombreTabla.isBlank()) {
            tablasFiltradas = tablas.stream()
                .filter(t -> t.nombre.equalsIgnoreCase(nombreTabla))
                .toList();
            if (tablasFiltradas.isEmpty()) {
                throw new RuntimeException("No se encontró la tabla '" + nombreTabla + "'");
            }
        }

        StringBuilder sb = new StringBuilder();
        generarHeader(sb, nombreBD);
        generarTabs(sb, tablasFiltradas);
        for (int i = 0; i < tablasFiltradas.size(); i++) {
            generarContenidoTabla(sb, tablasFiltradas.get(i), i == 0);
        }
        generarModal(sb);
        generarScript(sb, tablasFiltradas, nombreBD);
        generarFooter(sb);
        return sb.toString();
    }

    private void generarHeader(StringBuilder sb, String nombreBD) {
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html lang=\"es\">\n<head>\n");
        sb.append("<meta charset=\"UTF-8\">\n");
        sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        sb.append("<title>CRUD - ").append(nombreBD).append("</title>\n");
        sb.append("<style>\n");
        sb.append("* { margin: 0; padding: 0; box-sizing: border-box; }\n");
        sb.append("body { font-family: 'Segoe UI', sans-serif; background: #f0f2f5; color: #333; }\n");
        sb.append(".header { background: #1a73e8; color: white; padding: 20px 30px; display: flex; justify-content: space-between; align-items: center; }\n");
        sb.append(".header h1 { font-size: 1.4rem; }\n");
        sb.append(".tabs { display: flex; background: white; border-bottom: 2px solid #e0e0e0; padding: 0 20px; }\n");
        sb.append(".tab { padding: 12px 24px; cursor: pointer; font-weight: 600; color: #666; border-bottom: 3px solid transparent; transition: all 0.2s; }\n");
        sb.append(".tab:hover { color: #1a73e8; }\n");
        sb.append(".tab.active { color: #1a73e8; border-bottom-color: #1a73e8; }\n");
        sb.append(".content { padding: 20px 30px; }\n");
        sb.append(".tabla-content { display: none; }\n");
        sb.append(".tabla-content.active { display: block; }\n");
        sb.append(".toolbar { display: flex; justify-content: space-between; align-items: center; margin-bottom: 16px; }\n");
        sb.append(".toolbar h2 { font-size: 1.1rem; }\n");
        sb.append(".btn { padding: 8px 16px; border: none; border-radius: 6px; cursor: pointer; font-size: 0.9rem; font-weight: 600; transition: all 0.2s; }\n");
        sb.append(".btn-primary { background: #1a73e8; color: white; }\n");
        sb.append(".btn-primary:hover { background: #1558b0; }\n");
        sb.append(".btn-danger { background: #dc3545; color: white; }\n");
        sb.append(".btn-danger:hover { background: #b02a37; }\n");
        sb.append(".btn-sm { padding: 5px 10px; font-size: 0.8rem; }\n");
        sb.append(".btn-edit { background: #ffc107; color: #333; }\n");
        sb.append(".btn-edit:hover { background: #e0a800; }\n");
        sb.append("table { width: 100%; border-collapse: collapse; background: white; border-radius: 8px; overflow: hidden; box-shadow: 0 1px 3px rgba(0,0,0,0.1); }\n");
        sb.append("th, td { padding: 12px 16px; text-align: left; border-bottom: 1px solid #eee; }\n");
        sb.append("th { background: #f8f9fa; font-weight: 700; color: #555; font-size: 0.85rem; text-transform: uppercase; }\n");
        sb.append("tr:hover { background: #f8f9fa; }\n");
        sb.append(".acciones { white-space: nowrap; gap: 6px; display: flex; }\n");
        sb.append(".modal-overlay { display: none; position: fixed; inset: 0; background: rgba(0,0,0,0.5); z-index: 100; justify-content: center; align-items: center; }\n");
        sb.append(".modal-overlay.active { display: flex; }\n");
        sb.append(".modal { background: white; border-radius: 12px; padding: 24px; width: 90%; max-width: 500px; max-height: 80vh; overflow-y: auto; }\n");
        sb.append(".modal h3 { margin-bottom: 20px; color: #1a73e8; }\n");
        sb.append(".form-group { margin-bottom: 14px; }\n");
        sb.append(".form-group label { display: block; margin-bottom: 4px; font-weight: 600; font-size: 0.85rem; color: #555; }\n");
        sb.append(".form-group input { width: 100%; padding: 9px 12px; border: 1px solid #ddd; border-radius: 6px; font-size: 0.95rem; }\n");
        sb.append(".form-group input:focus { outline: none; border-color: #1a73e8; box-shadow: 0 0 0 3px rgba(26,115,232,0.15); }\n");
        sb.append(".modal-actions { display: flex; justify-content: flex-end; gap: 10px; margin-top: 20px; }\n");
        sb.append(".btn-cancel { background: #e0e0e0; color: #333; }\n");
        sb.append(".btn-cancel:hover { background: #ccc; }\n");
        sb.append(".empty-state { text-align: center; padding: 40px; color: #999; }\n");
        sb.append("</style>\n</head>\n<body>\n");
        sb.append("<div class=\"header\">\n");
        sb.append("<h1>Base de datos: ").append(nombreBD).append("</h1>\n");
        sb.append("<small>CRUD Visual</small>\n");
        sb.append("</div>\n");
    }

    private void generarTabs(StringBuilder sb, List<Tabla> tablas) {
        sb.append("<div class=\"tabs\">\n");
        for (int i = 0; i < tablas.size(); i++) {
            Tabla t = tablas.get(i);
            String active = i == 0 ? " active" : "";
            sb.append("<div class=\"tab").append(active).append("\" onclick=\"mostrarTabla('").append(t.nombre).append("', this)\">")
              .append(t.nombre).append("</div>\n");
        }
        sb.append("</div>\n");
    }

    private void generarContenidoTabla(StringBuilder sb, Tabla t, boolean esPrimera) {
        String active = esPrimera ? " active" : "";
        sb.append("<div class=\"content\">\n");
        sb.append("<div id=\"content-").append(t.nombre).append("\" class=\"tabla-content").append(active).append("\">\n");
        sb.append("<div class=\"toolbar\">\n");
        sb.append("<h2>Tabla: ").append(t.nombre).append("</h2>\n");
        sb.append("<button class=\"btn btn-primary\" onclick=\"abrirModal('").append(t.nombre).append("')\">+ Nuevo registro</button>\n");
        sb.append("</div>\n");
        sb.append("<table>\n<thead><tr>\n");
        for (Atributo a : t.atributos) {
            sb.append("<th>").append(a.nombreAtributo).append("</th>\n");
        }
        sb.append("<th>Acciones</th>\n");
        sb.append("</tr></thead>\n");
        sb.append("<tbody id=\"tbody-").append(t.nombre).append("\"></tbody>\n");
        sb.append("</table>\n");
        sb.append("</div>\n</div>\n");
    }

    private void generarModal(StringBuilder sb) {
        sb.append("<div class=\"modal-overlay\" id=\"modal-overlay\" onclick=\"cerrarModal(event)\">\n");
        sb.append("<div class=\"modal\" onclick=\"event.stopPropagation()\">\n");
        sb.append("<h3 id=\"modal-titulo\">Nuevo registro</h3>\n");
        sb.append("<div id=\"modal-campos\"></div>\n");
        sb.append("<div class=\"modal-actions\">\n");
        sb.append("<button class=\"btn btn-cancel\" onclick=\"cerrarModal()\">Cancelar</button>\n");
        sb.append("<button class=\"btn btn-primary\" id=\"modal-guardar\" onclick=\"guardar()\">Guardar</button>\n");
        sb.append("</div>\n");
        sb.append("</div>\n");
        sb.append("</div>\n");
    }

    private void generarScript(StringBuilder sb, List<Tabla> tablas, String nombreBD) {
        sb.append("<script>\n");
        sb.append("const API = 'http://localhost:3000/api';\n");
        sb.append("let tablaActual = '").append(tablas.get(0).nombre).append("';\n");
        sb.append("let editandoId = null;\n\n");

        sb.append("const tablas = {\n");
        for (Tabla t : tablas) {
            sb.append("  '").append(t.nombre).append("': {\n");
            sb.append("    attrs: [");
            for (int i = 0; i < t.atributos.size(); i++) {
                Atributo a = t.atributos.get(i);
                if (i > 0) sb.append(", ");
                sb.append("'").append(a.nombreAtributo).append("'");
            }
            sb.append("],\n");
            sb.append("    pk: '").append(t.nombre).append("_key'\n");
            sb.append("  },\n");
        }
        sb.append("};\n\n");

        sb.append("function mostrarTabla(nombre, tabEl) {\n");
        sb.append("  tablaActual = nombre;\n");
        sb.append("  document.querySelectorAll('.tab').forEach(t => t.classList.remove('active'));\n");
        sb.append("  document.querySelectorAll('.tabla-content').forEach(t => t.classList.remove('active'));\n");
        sb.append("  tabEl.classList.add('active');\n");
        sb.append("  document.getElementById('content-' + nombre).classList.add('active');\n");
        sb.append("  cargarDatos(nombre);\n");
        sb.append("}\n\n");

        sb.append("async function cargarDatos(nombre) {\n");
        sb.append("  try {\n");
        sb.append("    const res = await fetch(API + '/' + nombre);\n");
        sb.append("    const datos = await res.json();\n");
        sb.append("    const tbody = document.getElementById('tbody-' + nombre);\n");
        sb.append("    const info = tablas[nombre];\n");
        sb.append("    if (!datos.length) { tbody.innerHTML = '<tr><td colspan=\"' + (info.attrs.length + 1) + '\" class=\"empty-state\">No hay registros</td></tr>'; return; }\n");
        sb.append("    tbody.innerHTML = datos.map(fila => {\n");
        sb.append("      let cols = info.attrs.map(a => '<td>' + (fila[a] != null ? fila[a] : '') + '</td>').join('');\n");
        sb.append("      let pk = fila[info.pk];\n");
        sb.append("      return '<tr>' + cols + '<td class=\"acciones\"><button class=\"btn btn-sm btn-edit\" onclick=\"editar(\\'' + nombre + '\\',' + pk + ')\">Editar</button><button class=\"btn btn-sm btn-danger\" onclick=\"eliminar(\\'' + nombre + '\\',' + pk + ')\">Eliminar</button></td></tr>';\n");
        sb.append("    }).join('');\n");
        sb.append("  } catch (e) { console.error(e); }\n");
        sb.append("}\n\n");

        sb.append("function abrirModal(nombre) {\n");
        sb.append("  editandoId = null;\n");
        sb.append("  tablaActual = nombre;\n");
        sb.append("  document.getElementById('modal-titulo').textContent = 'Nuevo registro - ' + nombre;\n");
        sb.append("  const info = tablas[nombre];\n");
        sb.append("  let html = '';\n");
        sb.append("  info.attrs.forEach(a => { html += '<div class=\"form-group\"><label>' + a + '</label><input type=\"text\" id=\"campo-' + a + '\"></div>'; });\n");
        sb.append("  document.getElementById('modal-campos').innerHTML = html;\n");
        sb.append("  document.getElementById('modal-overlay').classList.add('active');\n");
        sb.append("}\n\n");

        sb.append("function editar(nombre, id) {\n");
        sb.append("  tablaActual = nombre;\n");
        sb.append("  editandoId = id;\n");
        sb.append("  fetch(API + '/' + nombre + '/' + id).then(r => r.json()).then(fila => {\n");
        sb.append("    document.getElementById('modal-titulo').textContent = 'Editar registro - ' + nombre;\n");
        sb.append("    const info = tablas[nombre];\n");
        sb.append("    let html = '';\n");
        sb.append("    info.attrs.forEach(a => { html += '<div class=\"form-group\"><label>' + a + '</label><input type=\"text\" id=\"campo-' + a + '\" value=\"' + (fila[a] != null ? fila[a] : '') + '\"></div>'; });\n");
        sb.append("    document.getElementById('modal-campos').innerHTML = html;\n");
        sb.append("    document.getElementById('modal-overlay').classList.add('active');\n");
        sb.append("  });\n");
        sb.append("}\n\n");

        sb.append("async function guardar() {\n");
        sb.append("  const info = tablas[tablaActual];\n");
        sb.append("  const body = {};\n");
        sb.append("  info.attrs.forEach(a => { body[a] = document.getElementById('campo-' + a).value; });\n");
        sb.append("  try {\n");
        sb.append("    if (editandoId !== null) {\n");
        sb.append("      await fetch(API + '/' + tablaActual + '/' + editandoId, { method: 'PUT', headers: {'Content-Type':'application/json'}, body: JSON.stringify(body) });\n");
        sb.append("    } else {\n");
        sb.append("      await fetch(API + '/' + tablaActual, { method: 'POST', headers: {'Content-Type':'application/json'}, body: JSON.stringify(body) });\n");
        sb.append("    }\n");
        sb.append("    cerrarModal();\n");
        sb.append("    cargarDatos(tablaActual);\n");
        sb.append("  } catch (e) { console.error(e); }\n");
        sb.append("}\n\n");

        sb.append("async function eliminar(nombre, id) {\n");
        sb.append("  if (!confirm('¿Estás seguro de eliminar este registro?')) return;\n");
        sb.append("  try {\n");
        sb.append("    await fetch(API + '/' + nombre + '/' + id, { method: 'DELETE' });\n");
        sb.append("    cargarDatos(nombre);\n");
        sb.append("  } catch (e) { console.error(e); }\n");
        sb.append("}\n\n");

        sb.append("function cerrarModal(e) {\n");
        sb.append("  if (e && e.target !== e.currentTarget) return;\n");
        sb.append("  document.getElementById('modal-overlay').classList.remove('active');\n");
        sb.append("}\n\n");

        sb.append("document.addEventListener('DOMContentLoaded', () => cargarDatos('").append(tablas.get(0).nombre).append("'));\n");
        sb.append("</script>\n");
    }

    private void generarFooter(StringBuilder sb) {
        sb.append("</body>\n</html>\n");
    }
}
