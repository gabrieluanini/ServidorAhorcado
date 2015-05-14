/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoahorcado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class JuegoAhorcado
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        GestorJuego gestor = new GestorJuego();
        System.out.println("Juego de ahorcado");
        ArrayList<Character> listaLetra = new ArrayList<Character>();
        
        System.out.println("Ingrese la dificultad");
        System.out.println("1-Fácil");
        System.out.println("2-Medio");
        System.out.println("3-Dificil");
        
        
        while (gestor.finJuego() == 0)
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(gestor.controlarLetra('*'));
            System.out.println("--------------------------------------------------");
            System.out.println("Cantidad de vidas" + gestor.getJugador().getCantVidas());
            System.out.println("Cantidad de pistas disponibles" + gestor.getJugador().getCantMonedas());

            System.out.println("Ingrese una letra");
            System.out.println("Ingrese '+' para usar una pista");
            try
            {
                String stringIn = br.readLine();
                char letra = stringIn.charAt(0);

                if (listaLetra.contains(letra))
                {
                    System.out.println("Letra ya elegida, ingrese otra letra");
                }
                else
                {
                    if (letra != '+')
                    {
                        listaLetra.add(letra);
                    }
                    System.out.println(gestor.controlarLetra(letra));
                }
            }
            catch (IOException ex)
            {
                System.out.println(gestor.controlarLetra('*'));
                Logger.getLogger(JuegoAhorcado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (gestor.finJuego() > 0)
        {

            System.out.println("Felicitaciones ha ganado");
        }
        else
        {
            System.out.println("Ha perdido");
        }
    }
}
