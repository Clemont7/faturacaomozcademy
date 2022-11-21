package model.ValueObject;

import java.sql.Time;
import java.util.Date;

public class Estudante {
    private int idEst;
    private String nome, nomeItem, status, nivel, contacto;
    private float valorPago;
    private Date dtInscricao;
    private Time hora;

    public Estudante() {
    }

    public Time getHora() {
        return this.hora;
    }

    
    public void setHora(Time hora) {
        this.hora=hora;
    }

    public String getNivel() {
        return this.nivel;
    }

    public float getValorPago() {
        return this.valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    

    public String getContacto() {
        return this.contacto;
    }

    public void setContacto(String contacto) {
        this.contacto=contacto;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getIdEst() {
        return idEst;
    }

    public void setIdEst(int idEst) {
        this.idEst = idEst;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getnomeItem() {
        return nomeItem;
    }

    public void setnomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDtInscricao() {
        return dtInscricao;
    }

    public void setDtInscricao(Date dtInscricao) {
        this.dtInscricao = dtInscricao;
    }
}
