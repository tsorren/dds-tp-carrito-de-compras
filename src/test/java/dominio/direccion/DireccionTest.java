package dominio.direccion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DireccionTest {

    Direccion d;

    private String base(Direccion dir) {
        return dir.getCalle1() + " " + dir.getAltura();
    }

    private String dpto(Direccion dir) {
        return "Dpto: " + dir.getDepartamento() + dir.getPiso();
    }

    @BeforeEach
    void crearClase() {
        d = new Direccion();
        d.setCalle1("Cabildo");
        d.setAltura(100);
        d.setSinAltura(false);
    }
    @Test
    void sinDepartamento() {
        assertEquals(base(d), d.getDireccion());
    }
    @Test
    void conDepartamento() {
        d.setDepartamento("A");
        d.setPiso(2);
        assertEquals(base(d) + dpto(d), d.getDireccion());
    }
}