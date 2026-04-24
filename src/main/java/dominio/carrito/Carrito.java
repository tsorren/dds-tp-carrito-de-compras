package dominio.carrito;

import dominio.cliente.Cliente;
import dominio.direccion.Direccion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private Cliente cliente;
    private Direccion direccionEnvio;
    private Direccion direccionCobro;
    private Estado estado;
    private final List<Item> items = new ArrayList<>();
    private final List<Pago> pagos = new ArrayList<>();
    private LocalDate fechaCompra;

    public Double getMontoPagado(){
        double montoAbonado = 0.0;
        for(Pago pago: this.pagos){
            montoAbonado += pago.getMonto();
        }
        return montoAbonado;
    }

    public Double getMontoCarrito(){
        double montoTotal = 0.0;
        for (Item item : this.items){
            montoTotal += item.getPrecio();
        }
        return  montoTotal;
    }

    public Double getMontoDeuda(){
        return this.getMontoCarrito() - this.getMontoPagado();
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Direccion getDireccionEnvio() {
        return direccionEnvio;
    }
    public void setDireccionEnvio(Direccion direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public Direccion getDireccionCobro() {
        return direccionCobro;
    }
    public void setDireccionCobro(Direccion direccionCobro) {
        this.direccionCobro = direccionCobro;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void agregarItem(Item item) {
        this.items.add(item);
    }

    public void quitarItem(Item item) {
        this.items.remove(item);
    }

    public void agregarPago(Pago pago) {
        this.pagos.add(pago);
    }

    public void quitarPago(Pago pago) {
        this.pagos.remove(pago);
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
