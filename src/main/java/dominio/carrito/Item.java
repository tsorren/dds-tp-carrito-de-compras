package dominio.carrito;

import java.time.LocalDate;

public class Item {
    private Carrito carrito;
    private Producto producto;
    private Integer cantidad;
    private Double precioUnitario;

    public Carrito getCarrito() {return carrito;}
    public void serCliente(Carrito carrito) {this.carrito = carrito;}

    public Producto getProducto(){return producto;}
    public void setProducto(Producto producto){this.producto = producto;}

    public Integer getCantidad() {return cantidad;}
    public void setCantidad(Integer cantidad) {this.cantidad = cantidad;}

    public Double getPrecioUnitario() {return precioUnitario;}
    public void setPrecioUnitario(Double precioUnitario) {this.precioUnitario = precioUnitario;}

    public Double getPrecio() {
        return (this.cantidad * this.precioUnitario);
    }
    public Double getPrecioOficial() {
        return producto.getPrecio(LocalDate.now());
    }

    public Double getDescuento(){
        return this.getPrecioOficial() - this.getPrecio();
    }
}

