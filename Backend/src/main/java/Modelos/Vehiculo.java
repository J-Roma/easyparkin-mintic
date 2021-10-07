
package Modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Vehiculo {
    //ATRIBUTOS
    private String placaVehiculo;
    private String modeloVehiculo;
    
    //CONSTRUCTOR
    public Vehiculo() {
    }
    
    //ENCAPSULAR
    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public String getModeloVehiculo() {
        return modeloVehiculo;
    }

    public void setModeloVehiculo(String modeloVehiculo) {
        this.modeloVehiculo = modeloVehiculo;
    }
    
    //METODOS
    public void crearVehiculo(){
        Conexion objConector = new Conexion(); 
        objConector.conectar();
        
        try {
            
            String sql = "INSERT INTO vehiculo VALUES(?,?,);";
            PreparedStatement stmt; 
            stmt = objConector.conn.prepareStatement(sql); 
            stmt.setString(1, this.placaVehiculo);
            stmt.setString(2, this.modeloVehiculo);
                                    
            stmt.execute(); 
            
            objConector.desconectar();
        } catch (Exception error) {
            System.out.println("Error Modelo: "+error);
        }
    }
    
    public ResultSet consultarVehiculo(){
    Conexion objConector = new Conexion(); 
        objConector.conectar();
        
        try {
            
            String sql = "SELECT * FROM vehiculo WHERE placaVehiculo = ? ; ";
            PreparedStatement stmt; 
            stmt = objConector.conn.prepareStatement(sql); 
            stmt.setString(1, this.placaVehiculo);
            ResultSet consulta = stmt.executeQuery(); 
            objConector.desconectar();
            return consulta; 
            
        } catch (Exception error) {
            System.out.println("Error Modelo: "+error);
        }
 
        return null;
    }
    
    public ResultSet listarVehiculo(){
        Conexion objConector = new Conexion(); 
        objConector.conectar();
        
        try {
            
            String sql = "SELECT * FROM vehiculo; ";
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
    
    public void actualizarVehiculo(){
        Conexion objConector = new Conexion(); 
        objConector.conectar();
        
        try {
            
            String sql = "UPDATE vehiculo SET "+
                         "modeloVehiculo = ?, "+
                         "WHERE placaVehiculo = ?; "; 
            PreparedStatement stmt; 
            stmt = objConector.conn.prepareStatement(sql); 
            stmt.setString(2, this.placaVehiculo);
            stmt.setString(1, this.modeloVehiculo);
                                    
            stmt.execute(); 
            
            objConector.desconectar();
        } catch (Exception error) {
            System.out.println("Error Modelo: "+error);
        }
    }
    
    public String eliminarVehiculo(){
        Conexion objConector = new Conexion(); 
        objConector.conectar();
        
        try {
            
            String sql = "DELETE FROM vehiculo "+
                         "WHERE placaVehiculo = ?; "; 
            PreparedStatement stmt; 
            stmt = objConector.conn.prepareStatement(sql); 
            stmt.setString(1, this.placaVehiculo);
            
            stmt.execute(); 
            
            objConector.desconectar();
        } catch (Exception error) {
            System.out.println("Error Modelo: "+error);
            return error.toString(); 
        }
        return null;
    }
}
