package dominio.carrito;

import java.time.LocalDate;

public class PrecioProducto {
    private LocalDate fehcaInicioVigencia;
    private LocalDate fechaFinVigencia;
    private Double precio;

    public LocalDate getFehcaInicioVigencia() {return fehcaInicioVigencia;}
    public void setFehcaInicioVigencia(LocalDate fehcaInicioVigencia) {
        this.fehcaInicioVigencia = fehcaInicioVigencia;
    }

    public LocalDate getFechaFinVigencia () {return fechaFinVigencia;}
    public void setFechaFinVigencia(LocalDate fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

    public Boolean getCumpleVigencia(LocalDate fecha) {
        return !fecha.isBefore(this.fehcaInicioVigencia) && !fecha.isAfter(this.fechaFinVigencia);
    }

    public Double getPrecio() {return precio;}
    public void setPrecio(Double precio) {this.precio = precio;}
}

