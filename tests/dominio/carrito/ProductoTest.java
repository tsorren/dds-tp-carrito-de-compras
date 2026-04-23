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
    }

    @Test
    void getPrecio() {
        // Hacer que el precio actual del producto sea 100.0
        PrecioProducto precio = new PrecioProducto();
        precio.setPrecio(100.0);
        precio.setFehcaInicioVigencia(fecha.minusDays(10));
        precio.setFechaFinVigencia(fecha.plusDays(10));
        p.agregarNuevoPrecio(precio);

        assertEquals(100.0, p.getPrecio(fecha));
    }

    @Test
    void getPrecioFueraDeVigencia() {
        PrecioProducto precio = new PrecioProducto();
        precio.setPrecio(100.0);
        precio.setFehcaInicioVigencia(fecha.minusDays(10));
        precio.setFechaFinVigencia(fecha.minusDays(1)); // venció antes de la fecha
        p.agregarNuevoPrecio(precio);

        assertNull(p.getPrecio(fecha));
    }

    @Test
    void getPrecioConHistorial() {
        // precio viejo ya vencido
        PrecioProducto precioViejo = new PrecioProducto();
        precioViejo.setPrecio(50.0);
        precioViejo.setFehcaInicioVigencia(fecha.minusDays(20));
        precioViejo.setFechaFinVigencia(fecha.minusDays(1));
        p.agregarNuevoPrecio(precioViejo);

        // precio vigente en la fecha
        PrecioProducto precioNuevo = new PrecioProducto();
        precioNuevo.setPrecio(100.0);
        precioNuevo.setFehcaInicioVigencia(fecha);
        precioNuevo.setFechaFinVigencia(fecha.plusDays(10));
        p.agregarNuevoPrecio(precioNuevo);

        assertEquals(100.0, p.getPrecio(fecha));
    }
}