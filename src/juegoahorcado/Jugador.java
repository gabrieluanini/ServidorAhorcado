package juegoahorcado;


/**
 * Created by Gabriel on 03/04/2015.
 */
public class Jugador
{
    private int cantVidas;
    private int cantMonedas;
    private int puntosPartida;
    private int puntosTotales;
    private Palabra palabra;
    private Partida partida;
    private Usuario usuario;
    private String mensaje;

    public Jugador()
    {
    }


    public boolean crearUsuario(String nomUsuario, String pass)
    {
        this.usuario = new Usuario(nomUsuario, pass);
        if (usuario.crearUsuario())
        {
            mensaje = "Usuario creado correctamente";
            return true;
        }
        else
        {
            mensaje = "El usuario no se pudo crear";
            return false;
        }
    }

    public int getCantVidas()
    {
        return cantVidas;
    }

    public int getCantMonedas()
    {
        return cantMonedas;
    }

    public String getEstadoPalabra()
    {
        return this.palabra.getEstadoPalabraDescubierta();
    }

    public int getAciertosRestantes()
    {
        return palabra.getAciertosRestantes();
    }

    public int finJuego()
    {
        if (getCantVidas() <= 0)
        {
            return -1;
        }
        else if (getAciertosRestantes() <= 0)
        {
            this.puntosPartida = palabra.getPuntos();
            this.puntosTotales += this.puntosPartida;
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public void controlarLetra(char letra)
    {
        if (letra != '+')
        {
            if (palabra.controlarLetra(letra) < 0)
            {
                this.cantVidas--;
            }
        }
        else
        {
            this.usarMoneda();
        }
    }

    public void usarMoneda()
    {
        this.cantMonedas--;
        this.controlarLetra(palabra.descubrirLetra());
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    public Partida getPartida()
    {
        return partida;
    }
    
    public void setPartida(Partida partida)
    {
        this.partida = partida;
    }

    public void nuevaPartida(Partida partida)
    {
        this.partida = partida;
        mensaje = "";
        cantVidas = 6;
        cantMonedas = 2;
        puntosPartida = 0;
        puntosTotales = 100;
        palabra = this.partida.getPalabra();
    }
}
