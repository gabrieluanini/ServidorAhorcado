/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class AccesoBD
{

    private Connection conexion;
    private ResultSet resultadoConsulta;
    private String error;

    public ResultSet ConsultaSQL(String consultaRecibida, HashMap<Integer, String> mapaParametros)
    {
        conexion = GetConnection();
        try
        {
            if (conexion == null)
            {
                return null;
            }
            CallableStatement proc_stmt = conexion.prepareCall(consultaRecibida);

            Iterator it = mapaParametros.entrySet().iterator();
            while (it.hasNext())
            {
                Map.Entry<Integer, String> entry = (Map.Entry) it.next();
                proc_stmt.setString(entry.getKey(), entry.getValue());
            }

            //Ejecuta la consulta y devuelve el ResultSet
            resultadoConsulta = proc_stmt.executeQuery();

            error = null;
            return resultadoConsulta;
        }
        catch (SQLException e)
        {
            error = e.getMessage();
            return resultadoConsulta;
        }
    }

    public static Connection GetConnection()
    {
        Connection conexion = null;

        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=ARQUITECTURA;user=ARQUITECTURA;password=ARQUITECTURA";
            conexion = DriverManager.getConnection(url);
        }
        catch (ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        }
        finally
        {
            return conexion;
        }
    }
}
