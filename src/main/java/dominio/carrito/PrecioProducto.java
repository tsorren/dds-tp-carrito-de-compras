package dominio.carrito;

import java.time.LocalDate;

public class PrecioProducto {
    private LocalDate fechaInicioVigencia;
    private LocalDate fechaFinVigencia;
    private Double precio;

    public LocalDate getFechaInicioVigencia() {return fechaInicioVigencia;}
    public void setFechaInicioVigencia(LocalDate fehcaInicioVigencia) {
        this.fechaInicioVigencia = fehcaInicioVigencia;
    }

    public LocalDate getFechaFinVigencia () {return fechaFinVigencia;}
    public void setFechaFinVigencia(LocalDate fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

    public Boolean getCumpleVigencia(LocalDate fecha) {
        return !fecha.isBefore(this.fechaInicioVigencia) && !fecha.isAfter(this.fechaFinVigencia);
    }

    public Double getPrecio() {return precio;}
    public void setPrecio(Double precio) {this.precio = precio;}
}

