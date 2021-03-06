/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Persona;
import Modelos.Vehiculo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LORENT
 */
@WebServlet(name = "ControlVehiculo", urlPatterns = {"/ControlVehiculo"})
public class ControlVehiculo extends HttpServlet {
    
    Vehiculo objVehiculo = new Vehiculo(); 

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
            
            String accion = request.getParameter("btnAccion"); 
            
            if(accion.equals("Insertar")){
                
                String placaVehiculo = request.getParameter("placaVehiculo"); 
                String modeloVehiculo = request.getParameter("modeloVehiculo"); 
                                             
                objVehiculo.setPlacaVehiculo(placaVehiculo);
                objVehiculo.setModeloVehiculo(modeloVehiculo);
                                              
                objVehiculo.crearVehiculo();
                
                String mensaje = "<html> <body>"+
                                 " <script type='text/javaScript'> "+
                                 "      alert('El Vehiculo fue creado correctamente!'); "+
                                 "      window.location.href='index.jsp'"+
                                 "</script> </body> </html>"; 
                
                out.println(mensaje);
            }
            else if (accion.equals("Actualizar")){
                
                String placaVehiculo = request.getParameter("placaVehiculo"); 
                String modeloVehiculo = request.getParameter("modeloVehiculo"); 
                
                objVehiculo.setPlacaVehiculo(placaVehiculo);
                objVehiculo.setModeloVehiculo(modeloVehiculo);
                
                              
                
                objVehiculo.actualizarVehiculo();
                
                                
                String mensaje = "<html> <body>"+
                                 " <script type='text/javaScript'> "+
                                 "      alert('El Vehiculo fue actualizado correctamente!'); "+
                                 "      window.location.href='index.jsp'"+
                                 "</script> </body> </html>"; 
                
                out.println(mensaje);
            }
            
            else if (accion.equals("Eliminar")){
                
                         
                String placaVehiculo = request.getParameter("placaVehiculo"); 
                                                        
                String respuesta = objVehiculo.eliminarVehiculo();
                
                if (respuesta == null){
                    String mensaje = "<html> <body>"+
                                 " <script type='text/javaScript'> "+
                                 "      alert('El Vehiculo fue eliminado correctamente!'); "+
                                 "      window.location.href='index.jsp'"+
                                 "</script> </body> </html>"; 
                
                    out.println(mensaje);
                }
                else {
                    String mensaje = "<html> <body>"+
                                 " <script type='text/javaScript'> "+
                                 "      alert('Error en la eliminaci??n del Vehiculo'); "+
                                 "      window.location.href='index.jsp'"+
                                 "</script> </body> </html>"; 
                
                    out.println(mensaje);
                }
                
            }
           
        }
        catch(Exception error){
            System.out.println("Error Controlador: "+ error);
        }
    }
        
    public ArrayList listar(){
        try {
            ResultSet consulta = objVehiculo.listarVehiculo(); 
            ArrayList<Vehiculo> listaVehiculo = new ArrayList<>(); 
            
            while(consulta.next()){
                objVehiculo = new Vehiculo(); 
                objVehiculo.setPlacaVehiculo(consulta.getString(1));
                objVehiculo.setModeloVehiculo(consulta.getString(2));
                
                                           
                listaVehiculo.add(objVehiculo); 
            }
            
            return listaVehiculo; 
            
        } catch (Exception error) {
            System.out.println("Error Controlador:" + error);
        }
 
        return null;
    }
    
    
    public ArrayList consultar(String placaVehiculo){
        try {
            objVehiculo.setPlacaVehiculo(placaVehiculo);
            ResultSet consulta = objVehiculo.consultarVehiculo(); 
            ArrayList<Vehiculo> listaVehiculo = new ArrayList<>(); 
                                 
            while(consulta.next()){
                objVehiculo = new Vehiculo(); 
                objVehiculo.setPlacaVehiculo(consulta.getString(1));
                objVehiculo.setModeloVehiculo(consulta.getString(2));
                listaVehiculo.add(objVehiculo); 
            }
            
            return listaVehiculo; 
            
        } catch (Exception error) {
            System.out.println("Error Controlador:" + error);
        }
 
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
