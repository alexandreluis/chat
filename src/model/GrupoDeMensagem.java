package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author 180900411
 */
public class GrupoDeMensagem 
{
    private Integer idDoGrupo;
    private LocalDateTime dataDeCriacaoDoGrupo;
    private String nomeDoGrupo;
    private String descricaoDoGrupo;
    private ArrayList<Cliente> participantesDoGrupo;
    private LinkedList<Mensagem> mensagensEnviadasNoGrupo;

    
    public GrupoDeMensagem() {
    }

    public GrupoDeMensagem(Integer idDoGrupo, LocalDateTime dataDeCriacaoDoGrupo, String nomeDoGrupo, String descricaoDoGrupo, ArrayList<Cliente> participantesDoGrupo, LinkedList<Mensagem> mensagensEnviadasNoGrupo) {
        this.idDoGrupo = idDoGrupo;
        this.dataDeCriacaoDoGrupo = dataDeCriacaoDoGrupo;
        this.nomeDoGrupo = nomeDoGrupo;
        this.descricaoDoGrupo = descricaoDoGrupo;
        this.participantesDoGrupo = participantesDoGrupo;
        this.mensagensEnviadasNoGrupo = mensagensEnviadasNoGrupo;
    }

    
    public Integer getIdDoGrupo() {
        return idDoGrupo;
    }

    public void setIdDoGrupo(Integer idDoGrupo) {
        this.idDoGrupo = idDoGrupo;
    }

    public LocalDateTime getDataDeCriacaoDoGrupo() {
        return dataDeCriacaoDoGrupo;
    }

    public void setDataDeCriacaoDoGrupo(LocalDateTime dataDeCriacaoDoGrupo) {
        this.dataDeCriacaoDoGrupo = dataDeCriacaoDoGrupo;
    }

    public String getNomeDoGrupo() {
        return nomeDoGrupo;
    }

    public void setNomeDoGrupo(String nomeDoGrupo) {
        this.nomeDoGrupo = nomeDoGrupo;
    }

    public String getDescricaoDoGrupo() {
        return descricaoDoGrupo;
    }

    public void setDescricaoDoGrupo(String descricaoDoGrupo) {
        this.descricaoDoGrupo = descricaoDoGrupo;
    }

    public ArrayList<Cliente> getParticipantesDoGrupo() {
        return participantesDoGrupo;
    }

    public void setParticipantesDoGrupo(ArrayList<Cliente> participantesDoGrupo) {
        this.participantesDoGrupo = participantesDoGrupo;
    }

    public LinkedList<Mensagem> getMensagensEnviadasNoGrupo() {
        return mensagensEnviadasNoGrupo;
    }

    public void setMensagensEnviadasNoGrupo(LinkedList<Mensagem> mensagensEnviadasNoGrupo) {
        this.mensagensEnviadasNoGrupo = mensagensEnviadasNoGrupo;
    }

    @Override
    public String toString() {
        return "GrupoDeMensagem{" + "idDoGrupo=" + idDoGrupo + ", dataDeCriacaoDoGrupo=" + dataDeCriacaoDoGrupo + ", nomeDoGrupo=" + nomeDoGrupo + ", descricaoDoGrupo=" + descricaoDoGrupo + ", participantesDoGrupo=" + participantesDoGrupo + ", mensagensEnviadasNoGrupo=" + mensagensEnviadasNoGrupo + '}';
    }   
}