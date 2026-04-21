package dominio.carrito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProductoTest {

    Producto p;
    LocalDate fecha = LocalDate.of(2026, 1, 1);

    @BeforeEach
    void setup() {
        p = new Producto();

        // Definir historial de precios
    }

    @Test
    void getPrecio() {
        // Hacer que el precio actual del producto sea 100.0
        assertEquals(100.0, p.getPrecio(fecha));
    }
}