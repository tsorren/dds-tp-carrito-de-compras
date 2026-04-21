package dominio.cliente;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    Cliente c;

    @BeforeEach
    void setup() {
        Cliente.setLimiteDeuda(500.0);

        // Settear cliente con carritos y productos
    }

    @Test
    void getMontoDeuda() {
        // Hacer que el monto deuda sea 300.0

        assertEquals(300.0, c.getMontoDeuda());
    }

    @Test
    void estaHabilitado() {
        // Hacer que el monto deuda sea menor al limite deuda

        assertTrue(c.estaHabilitado());
    }

    @Test
    void noEstaHabilitado() {
        // Hacer que el monto deuda sea mayor al limite deuda

        assertFalse(c.estaHabilitado());
    }
}