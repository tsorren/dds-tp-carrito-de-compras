package dominio.carrito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    Item i;
    Producto p;

    @BeforeEach
    void setup() {
        i = new Item();
        p = new Producto();

        // Settear producto y añadirlo al item con una cantidad mayor a 1
        PrecioProducto precioInicial = new PrecioProducto();
        precioInicial.setPrecio(20.0);
        precioInicial.setFechaInicioVigencia(LocalDate.now().minusDays(10));
        precioInicial.setFechaFinVigencia(LocalDate.now().plusDays(10));
        p.agregarNuevoPrecio(precioInicial);

        i.setProducto(p);
        i.setCantidad(5);
        i.setPrecioUnitario(20.0);
    }

    @Test
    void getPrecio() {
        // Hacer que el total del item sea 100
        assertEquals(100.0, i.getPrecio());
    }

    @Test
    void getPrecioOficial() {
        // Añadir el producto al item con el precio unitario
        // luego actualizar el precio del producto a otro distinto
        // el precio unitario del item tiene que mantenerse constante
        // mientras que el precio oficial se actualiza
        p = new Producto();

        PrecioProducto precioViejo = new PrecioProducto();
        precioViejo.setPrecio(20.0);
        precioViejo.setFechaInicioVigencia(LocalDate.now().minusDays(10));
        precioViejo.setFechaFinVigencia(LocalDate.now().minusDays(1)); // venció ayer
        p.agregarNuevoPrecio(precioViejo);

        PrecioProducto precioNuevo = new PrecioProducto();
        precioNuevo.setPrecio(30.0);
        precioNuevo.setFechaInicioVigencia(LocalDate.now());
        precioNuevo.setFechaFinVigencia(LocalDate.now().plusDays(30));
        p.agregarNuevoPrecio(precioNuevo);

        i.setProducto(p);
        i.setPrecioUnitario(20.0);

        assertNotEquals(i.getPrecioUnitario(), i.getPrecioOficial());
        assertEquals(p.getPrecio(LocalDate.now()), i.getPrecioOficial());
    }

    @Test
    void getDescuento() {
        i.setCantidad(1);
        i.setPrecioUnitario(15.0);
        assertEquals(5.0, i.getDescuento());
    }
}