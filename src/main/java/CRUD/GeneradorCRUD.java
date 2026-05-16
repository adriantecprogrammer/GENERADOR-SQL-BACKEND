package CRUD;

import Gramatica.Tabla;
import Gramatica.Atributo;
import java.util.List;

public class GeneradorCRUD {

    public String generar(String nombreBD, List<Tabla> tablas) {
        StringBuilder sb = new StringBuilder();
        generarHeader(sb, nombreBD);
        generarImports(sb);
        generarConexion(sb, nombreBD);
        for (Tabla t : tablas) {
            generarRutasTabla(sb, t);
        }
        generarFooter(sb);
        return sb.toString();
    }

    private void generarHeader(StringBuilder sb, String nombreBD) {
        sb.append("// ============================================\n");
        sb.append("// CRUD API para la base de datos: ").append(nombreBD).append("\n");
        sb.append("// ============================================\n");
        sb.append("// INSTRUCCIONES:\n");
        sb.append("//   1. Crear una carpeta nueva\n");
        sb.append("//   2. Guardar este archivo como server.js\n");
        sb.append("//   3. Ejecutar: npm init -y\n");
        sb.append("//   4. Ejecutar: npm install express mysql2\n");
        sb.append("//   5. Cambiar el password en DB_CONFIG\n");
        sb.append("//   6. Ejecutar: node server.js\n");
        sb.append("// ============================================\n\n");
    }

    private void generarImports(StringBuilder sb) {
        sb.append("const express = require('express');\n");
        sb.append("const mysql = require('mysql2/promise');\n\n");
        sb.append("const app = express();\n");
        sb.append("app.use(express.json());\n\n");
    }

    private void generarConexion(StringBuilder sb, String nombreBD) {
        sb.append("// ========== CONFIGURACION ==========\n");
        sb.append("const DB_CONFIG = {\n");
        sb.append("    host: 'localhost',\n");
        sb.append("    user: 'root',\n");
        sb.append("    password: 'TU_PASSWORD_AQUI',  // <-- Cambiar esto\n");
        sb.append("    database: '").append(nombreBD).append("'\n");
        sb.append("};\n");
        sb.append("// ====================================\n\n");
        sb.append("const pool = mysql.createPool(DB_CONFIG);\n\n");
    }

    private void generarRutasTabla(StringBuilder sb, Tabla t) {
        String nombre = t.nombre;
        String pk = nombre + "_key";
        List<Atributo> attrs = t.atributos;

        sb.append("// ========== ").append(nombre.toUpperCase()).append(" ==========\n\n");

        generarCreateRoute(sb, t, nombre, pk, attrs);
        generarReadAllRoute(sb, nombre, pk);
        generarReadOneRoute(sb, nombre, pk);
        generarUpdateRoute(sb, t, nombre, pk, attrs);
        generarDeleteRoute(sb, nombre, pk);
    }

    private void generarCreateRoute(StringBuilder sb, Tabla t, String nombre, String pk, List<Atributo> attrs) {
        sb.append("app.post('/api/").append(nombre).append("', async (req, res) => {\n");
        sb.append("    try {\n");

        StringBuilder columnas = new StringBuilder();
        StringBuilder placeholders = new StringBuilder();
        StringBuilder valores = new StringBuilder();
        for (int i = 0; i < attrs.size(); i++) {
            Atributo a = attrs.get(i);
            if (i > 0) {
                columnas.append(", ");
                placeholders.append(", ");
                valores.append(", ");
            }
            columnas.append(a.nombreAtributo);
            placeholders.append("?");
            valores.append("req.body.").append(a.nombreAtributo);
        }

        sb.append("        const [result] = await pool.execute(\n");
        sb.append("            'INSERT INTO ").append(nombre).append(" (")
          .append(columnas).append(") VALUES (").append(placeholders).append(")',\n");
        sb.append("            [").append(valores).append("]\n");
        sb.append("        );\n");

        sb.append("        res.status(201).json({ ")
          .append(pk).append(": result.insertId");

        for (Atributo a : attrs) {
            sb.append(", ").append(a.nombreAtributo).append(": req.body.").append(a.nombreAtributo);
        }
        sb.append(" });\n");

        sb.append("    } catch (err) {\n");
        sb.append("        res.status(500).json({ error: err.message });\n");
        sb.append("    }\n");
        sb.append("});\n\n");
    }

    private void generarReadAllRoute(StringBuilder sb, String nombre, String pk) {
        sb.append("app.get('/api/").append(nombre).append("', async (req, res) => {\n");
        sb.append("    try {\n");
        sb.append("        const [rows] = await pool.execute('SELECT * FROM ").append(nombre).append("');\n");
        sb.append("        res.json(rows);\n");
        sb.append("    } catch (err) {\n");
        sb.append("        res.status(500).json({ error: err.message });\n");
        sb.append("    }\n");
        sb.append("});\n\n");
    }

    private void generarReadOneRoute(StringBuilder sb, String nombre, String pk) {
        sb.append("app.get('/api/").append(nombre).append("/:id', async (req, res) => {\n");
        sb.append("    try {\n");
        sb.append("        const [rows] = await pool.execute(\n");
        sb.append("            'SELECT * FROM ").append(nombre).append(" WHERE ").append(pk).append(" = ?',\n");
        sb.append("            [req.params.id]\n");
        sb.append("        );\n");
        sb.append("        if (rows.length === 0) return res.status(404).json({ error: 'No encontrado' });\n");
        sb.append("        res.json(rows[0]);\n");
        sb.append("    } catch (err) {\n");
        sb.append("        res.status(500).json({ error: err.message });\n");
        sb.append("    }\n");
        sb.append("});\n\n");
    }

    private void generarUpdateRoute(StringBuilder sb, Tabla t, String nombre, String pk, List<Atributo> attrs) {
        sb.append("app.put('/api/").append(nombre).append("/:id', async (req, res) => {\n");
        sb.append("    try {\n");
        sb.append("        const fields = Object.keys(req.body);\n");
        sb.append("        const values = Object.values(req.body);\n");
        sb.append("        if (fields.length === 0) return res.status(400).json({ error: 'No hay datos para actualizar' });\n");
        sb.append("        const setClause = fields.map(f => `${f} = ?`).join(', ');\n");
        sb.append("        const [result] = await pool.execute(\n");
        sb.append("            `UPDATE ").append(nombre).append(" SET ${setClause} WHERE ").append(pk).append(" = ?`,\n");
        sb.append("            [...values, req.params.id]\n");
        sb.append("        );\n");
        sb.append("        if (result.affectedRows === 0) return res.status(404).json({ error: 'No encontrado' });\n");
        sb.append("        res.json({ mensaje: 'Actualizado correctamente' });\n");
        sb.append("    } catch (err) {\n");
        sb.append("        res.status(500).json({ error: err.message });\n");
        sb.append("    }\n");
        sb.append("});\n\n");
    }

    private void generarDeleteRoute(StringBuilder sb, String nombre, String pk) {
        sb.append("app.delete('/api/").append(nombre).append("/:id', async (req, res) => {\n");
        sb.append("    try {\n");
        sb.append("        const [result] = await pool.execute(\n");
        sb.append("            'DELETE FROM ").append(nombre).append(" WHERE ").append(pk).append(" = ?',\n");
        sb.append("            [req.params.id]\n");
        sb.append("        );\n");
        sb.append("        if (result.affectedRows === 0) return res.status(404).json({ error: 'No encontrado' });\n");
        sb.append("        res.json({ mensaje: 'Eliminado correctamente' });\n");
        sb.append("    } catch (err) {\n");
        sb.append("        res.status(500).json({ error: err.message });\n");
        sb.append("    }\n");
        sb.append("});\n\n");
    }

    private void generarFooter(StringBuilder sb) {
        sb.append("const PORT = 3000;\n");
        sb.append("app.listen(PORT, () => {\n");
        sb.append("    console.log(`CRUD API corriendo en http://localhost:${PORT}`);\n");
        sb.append("});\n");
    }
}
