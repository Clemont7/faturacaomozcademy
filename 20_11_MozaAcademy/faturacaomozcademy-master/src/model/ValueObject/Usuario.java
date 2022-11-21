package model.ValueObject;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String senha;

    public Usuario(){}

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
