/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Persona;
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
@WebServlet(name = "ControlPersona", urlPatterns = {"/ControlPersona"})
public class ControlPersona extends HttpServlet {

    Persona objPersona = new Persona(); 
    
       
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
                
                String ccPersona = request.getParameter("ccPersona"); 
                String nombrePersona = request.getParameter("nombrePersona"); 
                String apellidoPersona = request.getParameter("apellidoPersona");
                
                
                objPersona.setCcPersona(ccPersona);
                objPersona.setNombrePersona(nombrePersona);
                objPersona.setApellidoPersona(apellidoPersona);
                
                
                objPersona.crearPersona();
                
                String mensaje = "<html> <body>"+
                                 " <script type='text/javaScript'> "+
                                 "      alert('Registro de la Persona creado correctamente!'); "+
                                 "      window.location.href='index.jsp'"+
                                 "</script> </body> </html>"; 
                
                out.println(mensaje);
            }
            else if (accion.equals("Actualizar")){
                
                String ccPersona = request.getParameter("ccPersona"); 
                String nombrePersona = request.getParameter("nombrePersona"); 
                String apellidoPersona = request.getParameter("apellidoPersona");
                
                
                objPersona.setCcPersona(ccPersona);
                objPersona.setNombrePersona(nombrePersona);
                objPersona.setApellidoPersona(apellidoPersona);
                
                
                objPersona.actualizarPersona();
                
                                
                String mensaje = "<html> <body>"+
                                 " <script type='text/javaScript'> "+
                                 "      alert('Registro de la Persona actualizado correctamente!'); "+
                                 "      window.location.href='index.jsp'"+
                                 "</script> </body> </html>"; 
                
                out.println(mensaje);
            }
            
            else if (accion.equals("Eliminar")){
                
                String ccPersona = request.getParameter("ccPersona"); 
                
                
                
                objPersona.setCcPersona(ccPersona);
                             
                             
                           
                String respuesta = objPersona.eliminarPersona();
                
                if (respuesta == null){
                    String mensaje = "<html> <body>"+
                                 " <script type='text/javaScript'> "+
                                 "      alert('Registro de la Persona eliminado correctamente!'); "+
                                 "      window.location.href='index.jsp'"+
                                 "</script> </body> </html>"; 
                
                    out.println(mensaje);
                }
                else {
                    String mensaje = "<html> <body>"+
                                 " <script type='text/javaScript'> "+
                                 "      alert('Error en la eliminación del registro'); "+
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
            ResultSet consulta = objPersona.listarPersona(); 
            ArrayList<Persona> listaPersona = new ArrayList<>(); 
            
            while(consulta.next()){
                objPersona = new Persona(); 
                objPersona.setCcPersona(consulta.getString(1));
                objPersona.setNombrePersona(consulta.getString(2));
                objPersona.setApellidoPersona(consulta.getString(3));
                
                
                listaPersona.add(objPersona); 
            }
            
            return listaPersona; 
            
        } catch (Exception error) {
            System.out.println("Error Controlador:" + error);
        }
 
        return null;
    }
    
    
    public ArrayList consultar(String ccPersona){
        try {
            objPersona.setCcPersona(ccPersona);
            ResultSet consulta = objPersona.consultarPersona(); 
            ArrayList<Persona> listaPersona = new ArrayList<>(); 
            
            while(consulta.next()){
                objPersona = new Persona(); 
                objPersona.setCcPersona(consulta.getString(1));
                objPersona.setNombrePersona(consulta.getString(2));
                objPersona.setApellidoPersona(consulta.getString(3));
                listaPersona.add(objPersona); 
            }
            
            return listaPersona; 
            
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
