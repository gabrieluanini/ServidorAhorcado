package juegoahorcado;

import java.util.ArrayList;
import org.quickserver.net.server.*;

/**
 * Created by Gabriel on 03/04/2015.
 */
public class GestorJuego implements ClientData
{

    private Jugador jugador;
    private GestorPartida gestorPartida;
    private ArrayList<Character> listaLetra;

    public ArrayList<Character> getListaLetra()
    {
        return listaLetra;
    }

    public void setListaLetra(ArrayList<Character> listaLetra)
    {
        this.listaLetra = listaLetra;
    }

    public GestorJuego()
    {
        this.jugador = new Jugador();
        this.gestorPartida = new GestorPartida();
        listaLetra = new ArrayList<Character>();
    }

    public void nuevaPartida(String dificultad, String modoJuego)
    {
        this.jugador.nuevaPartida(gestorPartida.buscarPartida(dificultad, modoJuego));
    }

    private String getEstadoPalabra()
    {
        return jugador.getEstadoPalabra();
    }

    public String controlarLetra(char letra)
    {
        if (letra == '*')
        {
            return getEstadoPalabra();
        }

        if (letra != '+')
        {
            jugador.controlarLetra(letra);
            return getEstadoPalabra();
        }
        else
        {
            if (jugador.getCantMonedas() > 0)
            {
                jugador.controlarLetra(letra);
            }
            return getEstadoPalabra();
        }
    }

    public int finJuego()
    {
        return jugador.finJuego();
    }

    public Jugador getJugador()
    {
        return this.jugador;
    }

    public Partida getPartidaJugador()
    {
        return this.jugador.getPartida();
    }

    public void setPartidaJugador(Partida partida)
    {
        this.jugador.setPartida(partida);
    }

    public GestorPartida getGestorPartida()
    {
        return gestorPartida;
    }

    public void setGestorPartida(GestorPartida gestorPartida)
    {
        this.gestorPartida = gestorPartida;
    }
}
