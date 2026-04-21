package dominio.direccion;

public class Direccion {
    private String calle1;
    private String calle2;
    private Integer altura;
    private Boolean sinAltura;
    private Integer piso;
    private Integer cuerpo;
    private String departamento;
    private Ciudad ciudad;

    public String getDireccion () {
        String base = this.calle1 + " " +  (this.sinAltura ? "S/N" : this.altura);
        if (this.departamento != null && !this.departamento.isEmpty()){
            base += "Dpto: " + this.departamento + this.piso;
        }
        return base;
    }
    public String getLatitud () {return "";} // por API
    public String getLongitud () {return "";} // por API
    public Boolean estaHabilitadaEnvio () {return Boolean.TRUE;}

    public String getCalle1() {return calle1;}
    public void setCalle1(String calle1) {this.calle1 = calle1;}

    public String getCalle2() {
        return calle2;
    }
    public void setCalle2(String calle2) {
        this.calle2 = calle2;
    }

    public Integer getAltura() {
        return altura;
    }
    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Boolean getSinAltura() {
        return sinAltura;
    }
    public void setSinAltura(Boolean sinAltura) {
        this.sinAltura = sinAltura;
    }

    public Integer getPiso() {
        return piso;
    }
    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public Integer getCuerpo() {
        return cuerpo;
    }
    public void setCuerpo(Integer cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}
