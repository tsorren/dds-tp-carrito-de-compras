package dominio.carrito;

import dominio.cliente.Tarjeta;

public class Pago {
    private Carrito carrito;
    private Tarjeta tarjeta;
    private Double monto;

    public Double getMonto(){return monto;}
    public void setMonto(Double monto){this.monto = monto;}

    public Carrito getCarrito() {return carrito;}
    public void setCarrito(Carrito carrito) {this.carrito = carrito;}

    public Tarjeta getTarjeta() {return tarjeta;}
    public void setTarjeta(Tarjeta tarjeta) {this.tarjeta = tarjeta;}

    public Boolean verificarTarjeta() {
        return true;
    }
}
