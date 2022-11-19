package model.ValueObject;

public class Item {
    private int idItem;
    private String nome;
    private float preco;
    private String nivel;
    private String tipo;

    public Item(){}

    public Item( String nome, float preco, String tipo, String nivel) {
        this.nome = nome;
        this.preco = preco;
        this.nivel = nivel;
        this.tipo = tipo;

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
