/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoahorcado;

import java.util.HashMap;

/**
 *
 * @author Gabriel
 */
public abstract class Dificultad
{
    String descripcion;
    Palabra palabra;

    public Dificultad(String dificultad)
    {
        this.descripcion = dificultad;        
        palabra = new Palabra(getNuevaPalabra());
    }

    public void setPalabra(Palabra palabra)
    {
        this.palabra = palabra;
    }

    public Palabra getPalabra()
    {
        return palabra;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String d)
    {
        descripcion = d;
    }

    public static Dificultad nuevaDificultad(String d)
    {
        switch (d)
        {
            case "Facil":
                return new Facil();
            case "Medio":
                return new Medio();
            case "Dificil":
                return new Dificil();
            default:
                return null;
        }
    }

    public abstract HashMap<Integer, Character> getNuevaPalabra();
}
