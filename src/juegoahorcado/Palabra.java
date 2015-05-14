package juegoahorcado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Gabriel on 03/04/2015.
 */
public class Palabra
{

    private HashMap<Integer, Character> mapPalabraSecreta;
    private HashMap<Integer, String> mapPalabraDescubierta;
    private int aciertosRestantes;
    private ArrayList<Character> listaLetra;

    public Palabra(HashMap<Integer, Character> mapPalabra)
    {
        listaLetra = new ArrayList<Character>();
        mapPalabraSecreta = mapPalabra;
        this.aciertosRestantes = mapPalabraSecreta.size();
        this.mapPalabraDescubierta = new HashMap<Integer, String>();

        for (Map.Entry<Integer, Character> entry : mapPalabraSecreta.entrySet())
        {
            mapPalabraDescubierta.put(entry.getKey(), " __ ");
        }
    }

    public String getEstadoPalabraDescubierta()
    {
        String cad = "";
        for (int i = 0; i < mapPalabraDescubierta.size(); i++)
        {
            cad += mapPalabraDescubierta.get(i);
        }
        return cad;
    }

    public int getAciertosRestantes()
    {
        return aciertosRestantes;
    }

    public int getPuntos()
    {
        return this.mapPalabraSecreta.size();
    }

    public int controlarLetra(char letra)
    {
        int respuesta = -1;

        Iterator it = mapPalabraSecreta.entrySet().iterator();
        if (!listaLetra.contains(letra))
        {
            while (it.hasNext())
            {
                Map.Entry<Integer, Character> entry = (Map.Entry<Integer, Character>) it.next();

                if (String.valueOf(entry.getValue()).equalsIgnoreCase(String.valueOf(letra)))
                {
                    respuesta = 1;
                    this.listaLetra.add(letra);
                    this.aciertosRestantes--;
                    mapPalabraDescubierta.put(entry.getKey(), " " + entry.getValue().toString() + " ");
                    it.remove();
                }
            }
        }
        else
        {
            return 0;
        }

        return respuesta;
    }

    public char descubrirLetra()
    {
        return mapPalabraSecreta.values().iterator().next();
    }
}
