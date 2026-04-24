package dominio.carrito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class CarritoTest {

    private Carrito carrito;

    @BeforeEach
    void setUp() {
        carrito = new Carrito();
    }

    //Debería coincidir el total de los pagos 100 + 50 = 150
    @Test
    void getMontoPagado_deberiaSumarTodosLosPagos() {
        Pago pago1 = new Pago();
        pago1.setMonto(100.0);

        Pago pago2 = new Pago();
        pago2.setMonto(50.0);

        carrito.agregarPago(pago1);
        carrito.agregarPago(pago2);

        assertEquals(150.0, carrito.getMontoPagado());
    }

    //Debería coincidir el total de los precios de los items 200 + 300 = 500
    @Test
    void getMontoCarrito_deberiaSumarTodosLosItems() {
        Item item1 = new Item();
        item1.setPrecioUnitario(200.0);
        item1.setCantidad(1);

        Item item2 = new Item();
        item2.setPrecioUnitario(300.0);
        item2.setCantidad(1);

        carrito.agregarItem(item1);
        carrito.agregarItem(item2);

        assertEquals(500.0, carrito.getMontoCarrito());
    }

    //Monto deuda - monto pagado
    @Test
    void getMontoDeuda_deberiaCalcularMontoPendiente() {
        Item item = new Item();
        item.setPrecioUnitario(400.0);
        item.setCantidad(1);

        Pago pago = new Pago();
        pago.setMonto(150.0);

        carrito.agregarItem(item);
        carrito.agregarPago(pago);

        assertEquals(250.0, carrito.getMontoDeuda());
    }

    //Debería volver a quedar el carrito con precio 0
    @Test
    void agregarYQuitarItem_deberiaModificarMontoCarrito() {
        Item item = new Item();
        item.setPrecioUnitario(100.0);
        item.setCantidad(1);

        carrito.agregarItem(item);
        assertEquals(100.0, carrito.getMontoCarrito());

        carrito.quitarItem(item);
        assertEquals(0.0, carrito.getMontoCarrito());
    }

    //El pago debería volver a quedar en 0
    @Test
    void agregarYQuitarPago_deberiaModificarMontoPagado() {
        Pago pago = new Pago();
        pago.setMonto(80.0);

        carrito.agregarPago(pago);
        assertEquals(80.0, carrito.getMontoPagado());

        carrito.quitarPago(pago);
        assertEquals(0.0, carrito.getMontoPagado());
    }
}