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
class Medio extends Dificultad
{

    public Medio()
    {
        super("Medio");
    }

    @Override
    public HashMap<Integer, Character> getNuevaPalabra()
    {
        HashMap<Integer, Character> mapPalabraSecreta = new HashMap<Integer, Character>();
        mapPalabraSecreta.put(0, 'A');
        mapPalabraSecreta.put(1, 'N');
        mapPalabraSecreta.put(2, 'A');
        mapPalabraSecreta.put(3, 'L');
        mapPalabraSecreta.put(4, 'I');
        mapPalabraSecreta.put(5, 'S');
        mapPalabraSecreta.put(6, 'I');
        mapPalabraSecreta.put(7, 'S');
        return mapPalabraSecreta;
    }
}
