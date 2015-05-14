/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesDAO;

import BD.AccesoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class UsuarioDAO
{

    private AccesoBD acceso;

    public UsuarioDAO()
    {
        this.acceso = new AccesoBD();
    }

    public boolean buscarUsuario(String userName, String pass)
    {
        HashMap<Integer, String> mapa = new HashMap<Integer, String>();
        mapa.put(1, userName);
        mapa.put(2, pass);

        ResultSet rs = acceso.ConsultaSQL("{ call dbo.buscarUsuario(?,?)}", mapa);
        if (rs != null)
        {
            try
            {
                return(rs.next());
                //rs.close();
            }
            catch (SQLException ex)
            {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean crearUsuario(String nomUsuario, String pass)
    {
        return true;
    }
}
