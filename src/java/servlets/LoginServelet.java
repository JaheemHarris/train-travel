/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.DbAccess;
import services.ClientService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tables.Client;

/**
 *
 * @author HP
 */
public class LoginServelet extends HttpServlet {

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
        String mail=request.getParameter("mail");
        String passwd=request.getParameter("passwd");
        try{
            DbAccess databaseConnection = new DbAccess();
            if(!"".equals(mail) && !"".equals(passwd)){
                ClientService servCl = new ClientService();
                Client user = servCl.connexionClient(mail, passwd,databaseConnection);
                System.out.println(user);
                if(user!=null){
                    HttpSession session = request.getSession();
                    session.setAttribute("user",user);
                    request.setAttribute("page","home");
                    RequestDispatcher dispat = request.getRequestDispatcher("GestionPageClient");
                    dispat.forward(request, response);
                }else{
                    response.sendRedirect("login.jsp?error=2");
                }
            }else{
                response.sendRedirect("login.jsp?error=1");
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginServelet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
        response.setContentType("text/html;charset=UTF-8");
        String mail=request.getParameter("mail");
        String passwd=request.getParameter("password");
        if(!"".equals(mail) && !"".equals(passwd)){
            ClientService servCl = new ClientService();
            try (PrintWriter out = response.getWriter()){
                if(!servCl.connexionClient(mail, passwd)){
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet LoginServelet</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>ERROR</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }else{
                    TODO output your page here. You may use following sample code.
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet LoginServelet</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Servlet LoginServelet at " + request.getContextPath() + "</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        }else{
            response.sendRedirect("login.jsp");
        }
    */
    
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
