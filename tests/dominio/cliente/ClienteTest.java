package dominio.cliente;

import dominio.carrito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    Cliente c;
    Carrito ca;

    Item i;
    Producto p;
    Tarjeta t;

    @BeforeEach
    void setup() {
        c = new Cliente();

        ca = new Carrito();
        i = new Item();
        p = new Producto();

        t = new Tarjeta();
        t.setNombre(c.getNombre());
        t.setUltimosDigitos("2839");

        PrecioProducto precioInicial = new PrecioProducto();
        precioInicial.setPrecio(100.0);
        precioInicial.setFechaInicioVigencia(LocalDate.now().minusDays(10));
        precioInicial.setFechaFinVigencia(LocalDate.now().plusDays(10));
        p.agregarNuevoPrecio(precioInicial);

        i.setProducto(p);
        i.setCantidad(5);
        i.setPrecioUnitario(p.getPrecio(LocalDate.now()));

        ca.agregarItem(i);

        c.agregarCarrito(ca);

        // Settear cliente con carritos y productos
    }

    @Test
    void getMontoDeuda() {
        // Hacer que el monto deuda sea 300.0

        Pago pago = new Pago();
        pago.setMonto(200.0);
        pago.setCarrito(ca);
        pago.setTarjeta(t);

        ca.agregarPago(pago);
        assertEquals(300.0, c.getMontoDeuda());
    }

    @Test
    void estaHabilitado() {
        // Hacer que el monto deuda sea menor al limite deuda

        Cliente.setLimiteDeuda(1000.0);
        assertTrue(c.estaHabilitado());
    }

    @Test
    void noEstaHabilitado() {
        // Hacer que el monto deuda sea mayor al limite deuda

        Cliente.setLimiteDeuda(300.0);
        assertFalse(c.estaHabilitado());
    }
}