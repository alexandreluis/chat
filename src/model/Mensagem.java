package model;

import java.util.Date;

/**
 * https://www.devmedia.com.br/guia/jsf-javaserver-faces/38322
 * @author 180900411
 */
public class Mensagem 
{
    private int idMensagem;
    private Date dataDaMensagem;
    private String textoDaMensagem;

    
    public Mensagem() {
    }

    public Mensagem(int idMensagem, Date dataDaMensagem, String textoDaMensagem) {
        this.idMensagem = idMensagem;
        this.dataDaMensagem = dataDaMensagem;
        this.textoDaMensagem = textoDaMensagem;
    }
    
    
    public int getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(int idMensagem) {
        this.idMensagem = idMensagem;
    }

    public Date getDataDaMensagem() {
        return dataDaMensagem;
    }

    public void setDataDaMensagem(Date dataDaMensagem) {
        this.dataDaMensagem = dataDaMensagem;
    }

    public String getTextoDaMensagem() {
        return textoDaMensagem;
    }

    public void setTextoDaMensagem(String textoDaMensagem) {
        this.textoDaMensagem = textoDaMensagem;
    }

    @Override
    public String toString() {
        return "Mensagem{" + "idMensagem=" + idMensagem + ", dataDaMensagem=" + dataDaMensagem + ", textoDaMensagem=" + textoDaMensagem + '}';
    }
}