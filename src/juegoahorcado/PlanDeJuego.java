/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoahorcado;

/**
 *
 * @author Gabriel
 */
public class PlanDeJuego
{
    private ModoJuego modoJuego;
    private Dificultad dificultad;
    
    public PlanDeJuego(String dificultad, String modoJuego)
    {
        this.modoJuego = new ModoJuego(modoJuego);
        this.dificultad = Dificultad.nuevaDificultad(dificultad);
    }
    
    public boolean esPlanDeJuego(String dificultad, String modoJuego)
    {
        return (this.modoJuego.getDescripcion().equalsIgnoreCase(modoJuego) && this.dificultad.getDescripcion().equalsIgnoreCase(dificultad));       
    }
    
    public Palabra getPalabra()
    {
        return this.dificultad.getPalabra();
    }
}
