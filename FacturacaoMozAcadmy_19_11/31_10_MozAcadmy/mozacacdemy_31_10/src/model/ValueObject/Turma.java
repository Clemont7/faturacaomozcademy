package model.ValueObject;

import org.jfree.data.time.Hour;

public class Turma {
    private int idTurma;
    private Hour hora;
    private int quant_estudantes;

    public Turma(){}

    public Turma(Hour hora, int quant_estudantes) {
        this.hora = hora;
        this.quant_estudantes = quant_estudantes;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public Hour getHora() {
        return hora;
    }

    public void setHora(Hour hora) {
        this.hora = hora;
    }

    public int getQuant_estudantes() {
        return quant_estudantes;
    }

    public void setQuant_estudantes(int quant_estudantes) {
        this.quant_estudantes = quant_estudantes;
    }
}
