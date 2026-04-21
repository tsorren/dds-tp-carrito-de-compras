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
        assertNotEquals(i.getPrecioUnitario(), i.getPrecioOficial());
        assertEquals(p.getPrecio(LocalDate.now()), i.getPrecioOficial());
    }
}