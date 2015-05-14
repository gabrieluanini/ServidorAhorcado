/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoahorcado;

/**
 *
 * @author Gabriel
 */
public class Partida
{
    private PlanDeJuego planDeJuego;
    private EstadoPartida estado;
    private int idPartida;

    public Partida(String dificultad, String modoJuego)
    {
        this.planDeJuego = new PlanDeJuego(dificultad, modoJuego);
        this.estado = new EstadoPartida("Inicial");
        this.idPartida = 0;
    }

    public boolean buscarPartida(String dificultad, String modoJuego)
    {
       return planDeJuego.esPlanDeJuego(dificultad, modoJuego);
    }

    public PlanDeJuego planDeJuego()
    {
        return planDeJuego;
    }
    
    public Palabra getPalabra()
    {
        return planDeJuego.getPalabra();
    }
}