/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoahorcado;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class GestorPartida
{

    private List<Partida> listaPartidas;

    public GestorPartida()
    {
        listaPartidas = new ArrayList<Partida>();
    }

    public Partida buscarPartida(String dificultad, String modoJuego)
    {
        Partida partida = null;

        if ("multiplayer".equals(modoJuego))
        {
            for (int i = 0; i < listaPartidas.size(); i++)
            {
                if (listaPartidas.get(i).buscarPartida(dificultad, modoJuego))
                {
                    partida = listaPartidas.get(i);
                    break;
                }
            }
        }

        if (partida == null)
        {
            return new Partida(dificultad, modoJuego);
        }

        return partida;
    }
}
