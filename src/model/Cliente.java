/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;


/**
 *
 * @author alexandreluisrigotti
 */
public class Cliente
{
    private Integer idCliente;
    private String Nome;
    private String email;
    private boolean tipoDeCliente; //free ou pagante?
    private boolean situacaoFinanceira; //pagou?
    
    private ArrayList<Cliente> listaDeAmigos = new ArrayList<>();
    private ArrayList<GrupoDeMensagem> listaDeGruposCriados = new ArrayList<>();

    
    public Cliente() {}

    public Cliente(Integer idCliente, String Nome, String email, boolean tipoDeCliente, boolean situacaoFinanceira) {
        this.idCliente = idCliente;
        this.Nome = Nome;
        this.email = email;
        this.tipoDeCliente = tipoDeCliente;
        this.situacaoFinanceira = situacaoFinanceira;
    }

    public Integer getIdCliente()
    {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente)
    {
        this.idCliente = idCliente;
    }

    public String getNome()
    {
        return Nome;
    }

    public void setNome(String Nome)
    {
        this.Nome = Nome;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public boolean isTipoDeCliente()
    {
        return tipoDeCliente;
    }

    public void setTipoDeCliente(boolean tipoDeCliente)
    {
        this.tipoDeCliente = tipoDeCliente;
    }

    public boolean isSituacaoFinanceira()
    {
        return situacaoFinanceira;
    }

    public void setSituacaoFinanceira(boolean situacaoFinanceira)
    {
        this.situacaoFinanceira = situacaoFinanceira;
    }

    public ArrayList<Cliente> getListaDeAmigos()
    {
        return listaDeAmigos;
    }

    public void setListaDeAmigos(ArrayList<Cliente> listaDeAmigos)
    {
        this.listaDeAmigos = listaDeAmigos;
    }

    public ArrayList<GrupoDeMensagem> getListaDeGruposCriados()
    {
        return listaDeGruposCriados;
    }

    public void setListaDeGruposCriados(ArrayList<GrupoDeMensagem> listaDeGruposCriados)
    {
        this.listaDeGruposCriados = listaDeGruposCriados;
    }
    

}