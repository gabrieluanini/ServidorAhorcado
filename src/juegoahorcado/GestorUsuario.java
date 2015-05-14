/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoahorcado;

import EntidadesDAO.UsuarioDAO;
import java.io.IOException;
import org.quickserver.net.server.*;

/**
 *
 * @author Gabriel
 */
public class GestorUsuario extends QuickAuthenticator
{

    UsuarioDAO usrDao = new UsuarioDAO();

    @Override
    public boolean askAuthorisation(ClientHandler clientHandler) throws IOException
    {
        String password = askStringInput(clientHandler, "password");
        String userName = askStringInput(clientHandler, "userName");

        if (userName != null && password != null)
        {
            if (userName.equalsIgnoreCase("QUIT"))
            {
                sendString(clientHandler, "Logged out.");
                clientHandler.closeConnection();
                return false;
            }
            
            if (usrDao.buscarUsuario(userName, password))
            {
                sendString(clientHandler, "Autorización OK");
                //store the username in ClientData
                Jugador jugador = ((GestorJuego) clientHandler.getClientData()).getJugador();
                jugador.setUsuario(new Usuario(userName, password));
                return true;
            }
            else
            {
                sendString(clientHandler, "Autorización FALLO");
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
