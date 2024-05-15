
package com.emergentes.controlador;

import com.emergentes.dao.RegistroDAO;
import com.emergentes.dao.RegistroDAOimpl;
import com.emergentes.modelo.Registro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            RegistroDAO dao = new RegistroDAOimpl();
            int id;
            Registro avi = new Registro();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
          
            switch (action) {
                case "add":
                    request.setAttribute("registro", avi);
                    request.getRequestDispatcher("frmreg.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    avi = dao.getByid(id);
                    System.out.println(avi);
                    request.setAttribute("registro", avi);
                    request.getRequestDispatcher("frmreg.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath()+"/Inicio");
                    break;
                case "view":
                    List <Registro> lista = dao.getAll();
                    request.setAttribute("registro", lista);
                    request.getRequestDispatcher("Index.jsp").forward(request, response);
                default:
                    break;
            }

        } catch (Exception ex) {
            System.out.println("Error"+ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String seminario = request.getParameter("seminario");
        //int confirmado = Integer.parseInt(request.getParameter("confirmado"));
        int confirmado;
        if(request.getParameter("confirmado") == null){
            confirmado = 0;
        }else{
            confirmado = Integer.parseInt(request.getParameter("confirmado"));
        }
        String fecha = request.getParameter("fecha");
        
        Registro avi = new Registro();
        
        avi.setId(id);
        avi.setNombres(nombres);
        avi.setApellidos(apellidos);
        avi.setSeminario(seminario);
        avi.setConfirmado(confirmado);
        avi.setFecha(fecha);
        
        if (id == 0) {
            try {
               RegistroDAO dao = new RegistroDAOimpl();
                dao.insert(avi);
                response.sendRedirect(request.getContextPath()+"/Inicio");
            } catch (Exception ex) {
                System.out.println("Error "+ex.getMessage());
            }
        } else {
            try {
                RegistroDAO dao = new RegistroDAOimpl();
                dao.update(avi);
                response.sendRedirect(request.getContextPath()+"/Inicio");
            } catch (Exception ex) {
                System.out.println("Error "+ex.getMessage());
            }
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
