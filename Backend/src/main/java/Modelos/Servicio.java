
package Modelos;

import java.sql.Date;
import java.sql.Time;

public class Servicio {
    //ATRIBUTOS
    private int idServicios;
    private Date fechaServicio;
    private Time horaEntradaServicio;
    private Time horaSalidaServicio;
    private int valorMinutoServicio;
    
    //CONSTRUCTOR
    public Servicio() {
    }
    
    //ENCAPSULAR
    public int getIdServicios() {
        return idServicios;
    }

    public void setIdServicios(int idServicios) {
        this.idServicios = idServicios;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public Time getHoraEntradaServicio() {
        return horaEntradaServicio;
    }

    public void setHoraEntradaServicio(Time horaEntradaServicio) {
        this.horaEntradaServicio = horaEntradaServicio;
    }

    public Time getHoraSalidaServicio() {
        return horaSalidaServicio;
    }

    public void setHoraSalidaServicio(Time horaSalidaServicio) {
        this.horaSalidaServicio = horaSalidaServicio;
    }

    public int getValorMinutoServicio() {
        return valorMinutoServicio;
    }

    public void setValorMinutoServicio(int valorMinutoServicio) {
        this.valorMinutoServicio = valorMinutoServicio;
    }
    
    
    //METODOS
    public void crearServicio(){
        
    }
    
    public void consultarServicio(){
    
    }
    
    public void listarServicio(){
        
    }
    
    public void actualizarServicio(){
        
    }
    
    public void eliminarServicio(){
        
    }
}
