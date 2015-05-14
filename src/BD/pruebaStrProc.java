/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import static BD.AccesoBD.GetConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class pruebaStrProc
{

    public static void main(String[] args)
    {
        AccesoBD acceso = new AccesoBD();
        ResultSet resultadoConsulta;
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=ARQUITECTURA;user=ARQUITECTURA;password=ARQUITECTURA";
            String consulta = "{ call dbo.buscarUsuario(?,?)}";
            Connection conexion = DriverManager.getConnection(url);
            CallableStatement proc_stmt = conexion.prepareCall(consulta);
            HashMap<Integer, String> mapa = new HashMap<Integer, String>();
            mapa.put(1, "prueba");
            mapa.put(2,  "prueba");

            Iterator it = mapa.entrySet().iterator();
            while (it.hasNext())
            {
                Map.Entry<Integer, String> entry = (Map.Entry) it.next();
                proc_stmt.setString(entry.getKey(), entry.getValue());
            }

            //Ejecuta la consulta y devuelve el ResultSet
            resultadoConsulta = proc_stmt.executeQuery();
        }
        catch (SQLException e)
        {
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(pruebaStrProc.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
           
        }
    }
}
