/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegoahorcado;

import EntidadesDAO.UsuarioDAO;

/**
 *
 * @author Gabriel
 */
public class Usuario
{
    private String nomUsuario;
    private UsuarioDAO usuarioDAO;

    public String getNomUsuario()
    {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario)
    {
        this.nomUsuario = nomUsuario;
    }

    public String getPass()
    {
        return pass;
    }

    public void setPass(String pass)
    {
        this.pass = pass;
    }
    private String pass;

    public Usuario(String nomUsuario, String pass)
    {
        this.nomUsuario = nomUsuario;
        this.pass = pass;
    }

    public boolean crearUsuario()
    {
        return usuarioDAO.crearUsuario(nomUsuario, pass);
    }
}
