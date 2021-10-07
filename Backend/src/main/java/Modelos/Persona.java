
package Modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Persona {
    //ATRIBUTOS
    private String ccPersona;
    private String nombrePersona;
    private String apellidoPersona;
    
    //CONSTRUCTOR
    public Persona() {
    }
    
    //ENCAPSULAR
    public String getCcPersona() {
        return ccPersona;
    }

    public void setCcPersona(String ccPersona) {
        this.ccPersona = ccPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }
    
    //METODOS
    public void crearPersona(){
        
        Conexion objConector = new Conexion(); 
        objConector.conectar();
        
        try {
            
            String sql = "INSERT INTO persona VALUES(?,?,?);";
            PreparedStatement stmt; 
            stmt = objConector.conn.prepareStatement(sql); 
            stmt.setString(1, this.ccPersona);
            stmt.setString(2, this.nombrePersona);
            stmt.setString(3, this.apellidoPersona);
                        
            stmt.execute(); 
            
            objConector.desconectar();
        } catch (Exception error) {
            System.out.println("Error Modelo: "+error);
        }
        
    }
    
    public ResultSet consultarPersona(){
        Conexion objConector = new Conexion(); 
        objConector.conectar();
        
        try {
            
            String sql = "SELECT * FROM persona WHERE codigoProducto = ? ; ";
            PreparedStatement stmt; 
            stmt = objConector.conn.prepareStatement(sql); 
            stmt.setString(1, this.ccPersona);
            ResultSet consulta = stmt.executeQuery(); 
            objConector.desconectar();
            return consulta; 
            
        } catch (Exception error) {
            System.out.println("Error Modelo: "+error);
        }
 
        return null;
    
    }
    
    public ResultSet listarPersona(){
        Conexion objConector = new Conexion(); 
        objConector.conectar();
        
        try {
            
            String sql = "SELECT * FROM persona; ";
            PreparedStatement stmt; 
            stmt = objConector.conn.prepareStatement(sql); 
            ResultSet consulta = stmt.executeQuery(); 
            objConector.desconectar();
            return consulta; 
            
        } catch (Exception error) {
            System.out.println("Error Modelo: "+error);
        }
 
        return null;
        
    }
    
    public void actualizarPersona(){
        Conexion objConector = new Conexion(); 
        objConector.conectar();
        
        try {
            
            String sql = "UPDATE persona SET "+
                         "nombrePersona = ?, "+
                         "apellidoPersona = ?, "+
                         "WHERE ccPersona = ?; "; 
            PreparedStatement stmt; 
            stmt = objConector.conn.prepareStatement(sql); 
            stmt.setString(3, this.ccPersona);
            stmt.setString(1, this.nombrePersona);
            stmt.setString(2, this.apellidoPersona);
                        
            stmt.execute(); 
            
            objConector.desconectar();
        } catch (Exception error) {
            System.out.println("Error Modelo: "+error);
        }
    }
    
    public String eliminarPersona(){
        Conexion objConector = new Conexion(); 
        objConector.conectar();
        
        try {
            
            String sql = "DELETE FROM persona "+
                         "WHERE ccPersona = ?; "; 
            PreparedStatement stmt; 
            stmt = objConector.conn.prepareStatement(sql); 
            stmt.setString(1, this.ccPersona);
            
            stmt.execute(); 
            
            objConector.desconectar();
        } catch (Exception error) {
            System.out.println("Error Modelo: "+error);
            return error.toString(); 
        }
        return null; 
        
    }
}
