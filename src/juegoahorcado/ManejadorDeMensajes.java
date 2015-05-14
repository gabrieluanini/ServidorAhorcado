/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoahorcado;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import org.quickserver.net.server.ClientCommandHandler;
import org.quickserver.net.server.ClientHandler;

/**
 *
 * @author Gabriel
 */
public class ManejadorDeMensajes implements ClientCommandHandler
{
    //private GestorJuego gestor;

    public void gotConnected(ClientHandler handler)
            throws SocketTimeoutException, IOException
    {
        handler.sendClientMsg("++++++++++++++++++++++++++++++++++++++");
        handler.sendClientMsg("|     Bienvenido al Ahorcado v 2.0   |");
        handler.sendClientMsg("|      Enviar 'Quitar' para salir    |");
        handler.sendClientMsg("++++++++++++++++++++++++++++++++++++++");
        handler.sendClientMsg("Ingrese el usuario y contraseña");

        //gestor = new GestorJuego((Jugador) handler.getClientData());
    }

    public void lostConnection(ClientHandler handler)
            throws IOException
    {
        handler.sendSystemMsg("Conexión Perdida : "
                + handler.getSocket().getInetAddress());
    }

    public void closingConnection(ClientHandler handler)
            throws IOException
    {
        handler.sendSystemMsg("Cerrando Conexión : "
                + handler.getSocket().getInetAddress());
    }

    @Override
    public void handleCommand(ClientHandler handler, String command)
            throws SocketTimeoutException, IOException
    {
        if (((GestorJuego) handler.getClientData()).getPartidaJugador() == null)
        {
            handler.sendClientMsg("Ingrese la dificultad");
            handler.sendClientMsg("1-Fácil");
            handler.sendClientMsg("2-Medio");
            handler.sendClientMsg("3-Dificil");
            ((GestorJuego) handler.getClientData()).nuevaPartida("Medio", "multiplayer");

            handler.sendClientMsg("--------------------------------------------------");
            handler.sendClientMsg(((GestorJuego) handler.getClientData()).controlarLetra('*'));
            handler.sendClientMsg("Cantidad de vidas" + ((GestorJuego) handler.getClientData()).getJugador().getCantVidas());
            handler.sendClientMsg("Cantidad de pistas disponibles" + ((GestorJuego) handler.getClientData()).getJugador().getCantMonedas());
            handler.sendClientMsg("Ingrese una letra");
            handler.sendClientMsg("Ingrese '+' para usar una pista");
            handler.sendClientMsg("--------------------------------------------------");
        }
        else
        {
            handler.sendClientMsg("--------------------------------------------------");
            if (command.equals("Quitar"))
            {
                handler.sendClientMsg("¡Adios!");
                handler.closeConnection();
            }
            else
            {
                String stringIn = command;
                char letra = stringIn.charAt(0);

                if (((GestorJuego) handler.getClientData()).getListaLetra().contains(letra))
                {
                    handler.sendClientMsg("Letra ya elegida, ingrese otra letra");
                }
                else
                {
                    if (letra != '+')
                    {
                        ((GestorJuego) handler.getClientData()).getListaLetra().add(letra);
                    }
                    handler.sendClientMsg(((GestorJuego) handler.getClientData()).controlarLetra(letra));
                }
            }
            handler.sendClientMsg("Cantidad de vidas" + ((GestorJuego) handler.getClientData()).getJugador().getCantVidas());
            handler.sendClientMsg("Cantidad de pistas disponibles" + ((GestorJuego) handler.getClientData()).getJugador().getCantMonedas());
            handler.sendClientMsg("Ingrese una letra");
            handler.sendClientMsg("Ingrese '+' para usar una pista");
            handler.sendClientMsg("--------------------------------------------------");

            if (((GestorJuego) handler.getClientData()).finJuego() != 0)
            {
                if (((GestorJuego) handler.getClientData()).finJuego() > 0)
                {
                    handler.sendClientMsg("Felicitaciones ha ganado");
                }
                else
                {
                    handler.sendClientMsg("Ha perdido");
                }
                ((GestorJuego) handler.getClientData()).setPartidaJugador(null);
                ((GestorJuego) handler.getClientData()).setListaLetra(new ArrayList<Character>());
            }
        }
    }
}
