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
public class Dificil extends Dificultad
{

    public Dificil()
    {
        super("Dificil");
    }

    @Override
    public HashMap<Integer, Character> getNuevaPalabra()
    {
        HashMap<Integer, Character> mapPalabraSecreta = new HashMap<Integer, Character>();
        mapPalabraSecreta.put(0, 'A');
        mapPalabraSecreta.put(1, 'R');
        mapPalabraSecreta.put(2, 'Q');
        mapPalabraSecreta.put(3, 'U');
        mapPalabraSecreta.put(4, 'I');
        mapPalabraSecreta.put(5, 'T');
        mapPalabraSecreta.put(6, 'E');
        mapPalabraSecreta.put(7, 'C');
        mapPalabraSecreta.put(8, 'T');
        mapPalabraSecreta.put(9, 'U');
        mapPalabraSecreta.put(10, 'R');
        mapPalabraSecreta.put(11, 'A');
        return mapPalabraSecreta;
    }
}
