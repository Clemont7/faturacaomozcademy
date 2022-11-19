package model.ValueObject;

public class Estudante {
    private int idEstudante;
    private String nome;
    private String contacto;
    private String status;

    public Estudante(){}

    public Estudante( String nome, String contacto, String status) {
        this.nome = nome;
        this.contacto = contacto;
        this.status = status;
    }


    public int getIdEstudante() {
        return idEstudante;
    }

    public void setIdEstudante(int idEstudante) {
        this.idEstudante = idEstudante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
