package model.ValueObject;

import java.util.Date;

public class Estudante_Inscricao {
    private int idEstudante;
    private Date dataInscricao;

    public Estudante_Inscricao(){}

    public Estudante_Inscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public int getIdEstudante() {
        return idEstudante;
    }

    public void setIdEstudante(int idEstudante) {
        this.idEstudante = idEstudante;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }
}
