// $ANTLR 3.5.2 gramatica.g 2026-03-28 17:21:14
package Gramatica;
import java.util.ArrayList;
import java.util.List;
import Gramatica.Tabla;
import Gramatica.Atributo;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


@SuppressWarnings("all")
public class gramaticaParser extends Parser {
    public static final String[] tokenNames = new String[] {
            "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALFABETICO", "CERRARTABLA", "CREAR",
            "FECHA", "FIN", "ID", "INICIOATRIBUTOS", "NUMERICO", "RELACION", "TABLA",
            "TERMINAR", "USAR", "WS", "'que es'"
    };

    public static final int EOF=-1;
    public static final int T__17=17;
    public static final int ALFABETICO=4;
    public static final int CERRARTABLA=5;
    public static final int CREAR=6;
    public static final int FECHA=7;
    public static final int FIN=8;
    public static final int ID=9;
    public static final int INICIOATRIBUTOS=10;
    public static final int NUMERICO=11;
    public static final int RELACION=12;
    public static final int TABLA=13;
    public static final int TERMINAR=14;
    public static final int USAR=15;
    public static final int WS=16;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public gramaticaParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public gramaticaParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    @Override public String[] getTokenNames() { return gramaticaParser.tokenNames; }
    @Override public String getGrammarFileName() { return "gramatica.g"; }


    List <Tabla> tablas = new ArrayList<Tabla>();
    Tabla tablaActual = null;
    public String nombreBD = "";
    public List<String> sqlTablas = new ArrayList<>();
    private StringBuilder sqlTablaActual = null;


    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        System.out.println("Error sintáctico: " + hdr + " " + msg);
    }



    // $ANTLR start "inicio"
    // gramatica.g:20:1: inicio : creacion usar ( tabla )+ cerrar ;
    public final void inicio() throws RecognitionException {
        try {
            // gramatica.g:20:7: ( creacion usar ( tabla )+ cerrar )
            // gramatica.g:20:9: creacion usar ( tabla )+ cerrar
            {
                pushFollow(FOLLOW_creacion_in_inicio21);
                creacion();
                state._fsp--;

                pushFollow(FOLLOW_usar_in_inicio23);
                usar();
                state._fsp--;

                // gramatica.g:20:23: ( tabla )+
                int cnt1=0;
                loop1:
                while (true) {
                    int alt1=2;
                    int LA1_0 = input.LA(1);
                    if ( (LA1_0==TABLA) ) {
                        alt1=1;
                    }

                    switch (alt1) {
                        case 1 :
                            // gramatica.g:20:23: tabla
                        {
                            pushFollow(FOLLOW_tabla_in_inicio25);
                            tabla();
                            state._fsp--;

                        }
                        break;

                        default :
                            if ( cnt1 >= 1 ) break loop1;
                            EarlyExitException eee = new EarlyExitException(1, input);
                            throw eee;
                    }
                    cnt1++;
                }

                pushFollow(FOLLOW_cerrar_in_inicio28);
                cerrar();
                state._fsp--;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "inicio"



    // $ANTLR start "creacion"
    // gramatica.g:22:1: creacion : CREAR ID ;
    public final void creacion() throws RecognitionException {
        Token ID1=null;

        try {
            // gramatica.g:22:9: ( CREAR ID )
            // gramatica.g:23:2: CREAR ID
            {
                match(input,CREAR,FOLLOW_CREAR_in_creacion36);
                ID1=(Token)match(input,ID,FOLLOW_ID_in_creacion38);
                this.nombreBD = (ID1!=null?ID1.getText():null);
                System.out.println("CREATE DATABASE "+(ID1!=null?ID1.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "creacion"



    // $ANTLR start "usar"
    // gramatica.g:26:1: usar : USAR ID ;
    public final void usar() throws RecognitionException {
        Token ID2=null;

        try {
            // gramatica.g:26:5: ( USAR ID )
            // gramatica.g:26:7: USAR ID
            {
                match(input,USAR,FOLLOW_USAR_in_usar47);
                ID2=(Token)match(input,ID,FOLLOW_ID_in_usar49);
                System.out.println("USE DATABASE "+(ID2!=null?ID2.getText():null));
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "usar"



    // $ANTLR start "tabla"
    // gramatica.g:28:1: tabla : TABLA ID ( campo | relacion )+ CERRARTABLA ;
    public final void tabla() throws RecognitionException {
        Token ID3=null;

        try {
            // gramatica.g:28:6: ( TABLA ID ( campo | relacion )+ CERRARTABLA )
            // gramatica.g:29:2: TABLA ID ( campo | relacion )+ CERRARTABLA
            {
                match(input,TABLA,FOLLOW_TABLA_in_tabla59);
                ID3=(Token)match(input,ID,FOLLOW_ID_in_tabla61);

                //código para generar SQL
                this.sqlTablaActual = new StringBuilder();
                this.sqlTablaActual.append("CREATE TABLE "+(ID3!=null?ID3.getText():null) );
                this.sqlTablaActual.append(" ("+(ID3!=null?ID3.getText():null)+"_key INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL");

                System.out.println("CREATE TABLE "+(ID3!=null?ID3.getText():null) );
                System.out.println(" ("+(ID3!=null?ID3.getText():null)+"_key INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL");
                //código para crear estructura de datos
                Tabla t = new Tabla();
                t.nombre =(ID3!=null?ID3.getText():null);
                tablas.add(t);
                tablaActual = t;
                //

                // gramatica.g:39:22: ( campo | relacion )+
                int cnt2=0;
                loop2:
                while (true) {
                    int alt2=3;
                    int LA2_0 = input.LA(1);
                    if ( (LA2_0==INICIOATRIBUTOS) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==RELACION) ) {
                        alt2=2;
                    }

                    switch (alt2) {
                        case 1 :
                            // gramatica.g:39:23: campo
                        {
                            pushFollow(FOLLOW_campo_in_tabla66);
                            campo();
                            state._fsp--;

                        }
                        break;
                        case 2 :
                            // gramatica.g:39:31: relacion
                        {
                            pushFollow(FOLLOW_relacion_in_tabla70);
                            relacion();
                            state._fsp--;

                        }
                        break;

                        default :
                            if ( cnt2 >= 1 ) break loop2;
                            EarlyExitException eee = new EarlyExitException(2, input);
                            throw eee;
                    }
                    cnt2++;
                }

                match(input,CERRARTABLA,FOLLOW_CERRARTABLA_in_tabla74);

                System.out.println("   );   ");
                this.sqlTablaActual.append("   );   ");
                this.sqlTablas.add(this.sqlTablaActual.toString());

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "tabla"



    // $ANTLR start "campo"
    // gramatica.g:43:1: campo : INICIOATRIBUTOS ID 'que es' (t= NUMERICO |t= ALFABETICO |t= FECHA ) ;
    public final void campo() throws RecognitionException {
        Token t=null;
        Token ID4=null;

        try {
            // gramatica.g:43:6: ( INICIOATRIBUTOS ID 'que es' (t= NUMERICO |t= ALFABETICO |t= FECHA ) )
            // gramatica.g:44:2: INICIOATRIBUTOS ID 'que es' (t= NUMERICO |t= ALFABETICO |t= FECHA )
            {
                match(input,INICIOATRIBUTOS,FOLLOW_INICIOATRIBUTOS_in_campo84);
                ID4=(Token)match(input,ID,FOLLOW_ID_in_campo86);
                match(input,17,FOLLOW_17_in_campo88);
                // gramatica.g:44:30: (t= NUMERICO |t= ALFABETICO |t= FECHA )
                int alt3=3;
                switch ( input.LA(1) ) {
                    case NUMERICO:
                    {
                        alt3=1;
                    }
                    break;
                    case ALFABETICO:
                    {
                        alt3=2;
                    }
                    break;
                    case FECHA:
                    {
                        alt3=3;
                    }
                    break;
                    default:
                        NoViableAltException nvae =
                                new NoViableAltException("", 3, 0, input);
                        throw nvae;
                }
                switch (alt3) {
                    case 1 :
                        // gramatica.g:45:3: t= NUMERICO
                    {
                        t=(Token)match(input,NUMERICO,FOLLOW_NUMERICO_in_campo98);
                    }
                    break;
                    case 2 :
                        // gramatica.g:46:5: t= ALFABETICO
                    {
                        t=(Token)match(input,ALFABETICO,FOLLOW_ALFABETICO_in_campo108);
                    }
                    break;
                    case 3 :
                        // gramatica.g:47:5: t= FECHA
                    {
                        t=(Token)match(input,FECHA,FOLLOW_FECHA_in_campo118);
                    }
                    break;

                }

                //aquí hay que agregar código para generar SQL
                if(((t!=null?t.getText():null)).compareTo("texto")==0) {
                    System.out.println(", "+(ID4!=null?ID4.getText():null) + " VARCHAR(300)" );
                    this.sqlTablaActual.append(", "+(ID4!=null?ID4.getText():null) + " VARCHAR(300)" );
                } else if(((t!=null?t.getText():null)).compareTo("fecha")==0) {
                    System.out.println(", "+(ID4!=null?ID4.getText():null) + " DATE" );
                    this.sqlTablaActual.append(", "+(ID4!=null?ID4.getText():null) + " DATE" );
                } else if(((t!=null?t.getText():null)).compareTo("número")==0) {
                    System.out.println(", "+(ID4!=null?ID4.getText():null) + " INTEGER" );
                    this.sqlTablaActual.append(", "+(ID4!=null?ID4.getText():null) + " INTEGER" );
                } else {
                    System.out.println(", "+(ID4!=null?ID4.getText():null) + " " +(t!=null?t.getText():null) );
                    this.sqlTablaActual.append(", "+(ID4!=null?ID4.getText():null) + " " +(t!=null?t.getText():null) );
                }

                //el que sigue es código para crear estructura de datos
                Atributo a  = new Atributo();
                a.nombreAtributo = (ID4!=null?ID4.getText():null);
                a.tipoAtributo = (t!=null?t.getText():null);
                tablaActual.atributos.add(a);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "campo"



    // $ANTLR start "relacion"
    // gramatica.g:62:1: relacion : RELACION ID ;
    public final void relacion() throws RecognitionException {
        Token ID5=null;

        try {
            // gramatica.g:62:9: ( RELACION ID )
            // gramatica.g:63:2: RELACION ID
            {
                match(input,RELACION,FOLLOW_RELACION_in_relacion131);
                ID5=(Token)match(input,ID,FOLLOW_ID_in_relacion133);

                System.out.println(", "+(ID5!=null?ID5.getText():null) + "_id INTEGER" );
                System.out.println(", FOREIGN KEY ("+(ID5!=null?ID5.getText():null)+"_id) REFERENCES "+(ID5!=null?ID5.getText():null)+"("+(ID5!=null?ID5.getText():null)+"_key)");

                this.sqlTablaActual.append(", "+(ID5!=null?ID5.getText():null) + "_id INTEGER" );
                this.sqlTablaActual.append(", FOREIGN KEY ("+(ID5!=null?ID5.getText():null)+"_id) REFERENCES "+(ID5!=null?ID5.getText():null)+"("+(ID5!=null?ID5.getText():null)+"_key)");

                //el que sigue es código para crear estructura de datos
                Atributo a  = new Atributo();
                a.nombreAtributo = (ID5!=null?ID5.getText():null) + "_id";
                a.tipoAtributo = "FK (llave foranea)";
                tablaActual.atributos.add(a);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "relacion"



    // $ANTLR start "cerrar"
    // gramatica.g:74:1: cerrar : TERMINAR ;
    public final void cerrar() throws RecognitionException {
        try {
            // gramatica.g:74:7: ( TERMINAR )
            // gramatica.g:75:2: TERMINAR
            {
                match(input,TERMINAR,FOLLOW_TERMINAR_in_cerrar143);

                for (int i=0; i<tablas.size(); i++){
                    System.out.println("\nTabla: "+tablas.get(i).nombre);
                    List <Atributo> atribs= tablas.get(i).atributos;

                    for (int j=0; j<atribs.size(); j++){
                        System.out.print("<Atributo>  "+atribs.get(j).nombreAtributo);
                        System.out.println(" \t<TipoAtrib> "+atribs.get(j).tipoAtributo);
                    }
                    System.out.println("");
                }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            // do for sure before leaving
        }
    }
    // $ANTLR end "cerrar"

    // Delegated rules



    public static final BitSet FOLLOW_creacion_in_inicio21 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_usar_in_inicio23 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_tabla_in_inicio25 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_cerrar_in_inicio28 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREAR_in_creacion36 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_creacion38 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USAR_in_usar47 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_usar49 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TABLA_in_tabla59 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_tabla61 = new BitSet(new long[]{0x0000000000001400L});
    public static final BitSet FOLLOW_campo_in_tabla66 = new BitSet(new long[]{0x0000000000001420L});
    public static final BitSet FOLLOW_relacion_in_tabla70 = new BitSet(new long[]{0x0000000000001420L});
    public static final BitSet FOLLOW_CERRARTABLA_in_tabla74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INICIOATRIBUTOS_in_campo84 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_campo86 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_campo88 = new BitSet(new long[]{0x0000000000000890L});
    public static final BitSet FOLLOW_NUMERICO_in_campo98 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALFABETICO_in_campo108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FECHA_in_campo118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RELACION_in_relacion131 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_relacion133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TERMINAR_in_cerrar143 = new BitSet(new long[]{0x0000000000000002L});
}
