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
public class Facil extends Dificultad
{
    public Facil()
    {
        super("Facil");
    }

    @Override
    public HashMap<Integer, Character> getNuevaPalabra()
    {
        HashMap<Integer, Character> mapPalabraSecreta = new HashMap<Integer, Character>();
        mapPalabraSecreta.put(0, 'J');
        mapPalabraSecreta.put(1, 'A');
        mapPalabraSecreta.put(2, 'V');
        mapPalabraSecreta.put(3, 'A');
        return mapPalabraSecreta;
    }
}
