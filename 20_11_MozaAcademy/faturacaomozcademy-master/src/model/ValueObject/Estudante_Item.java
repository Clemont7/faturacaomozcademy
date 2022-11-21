package model.ValueObject;

public class Estudante_Item {
    private int idEstudante;
    private int idItem;
    private float valorPago;

    public Estudante_Item(){}

    public Estudante_Item(float valorPago) {
        this.valorPago = valorPago;
    }

    public int getIdEstudante() {
        return idEstudante;
    }

    public void setIdEstudante(int idEstudante) {
        this.idEstudante = idEstudante;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }
}
