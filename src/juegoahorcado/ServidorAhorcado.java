/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoahorcado;

import org.quickserver.net.AppException;
import org.quickserver.net.server.QuickServer;

/**
 *
 * @author Gabriel
 */
public class ServidorAhorcado
{
    public static void main(String[] args)
    {
        QuickServer myServer = new QuickServer("juegoahorcado.ManejadorDeMensajes",4123);
        myServer.setClientAuthenticationHandler("juegoahorcado.GestorUsuario");
        myServer.setClientData("juegoahorcado.GestorJuego");
        myServer.setName("Servidor Ahorcado v 1.0");
        
        try
        {
            myServer.startServer();
        }
        catch (AppException e)
        {
            System.err.println("Error en el servidor : " + e);
        }
    }
}
