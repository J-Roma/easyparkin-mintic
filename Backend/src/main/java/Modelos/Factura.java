
package Modelos;

import java.sql.Date;

public class Factura {
    //ATRIBUTOS
    private int idFactura;
    private Date fechaFactura;
    private int tiempoFactura;
    private int valorFactura;
    private String placaVehiculo;
    private int idServicio;
    private String ccPersona;
    
    //CONSTRUCTOR
    public Factura() {
    }
    
    //ENCAPSULAR

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public int getTiempoFactura() {
        return tiempoFactura;
    }

    public void setTiempoFactura(int tiempoFactura) {
        this.tiempoFactura = tiempoFactura;
    }

    public int getValorFactura() {
        return valorFactura;
    }

    public void setValorFactura(int valorFactura) {
        this.valorFactura = valorFactura;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getCcPersona() {
        return ccPersona;
    }

    public void setCcPersona(String ccPersona) {
        this.ccPersona = ccPersona;
    }

    //METODOS
    public void crearFactura() {
        
        
        
    }
    
    public void consultarFactura(){
    
    }
    
    public void listarFactura(){
        
    }
    
    public void actualizarFactura(){
        
    }
    
    public void eliminarFactura(){
        
    }
    
}
