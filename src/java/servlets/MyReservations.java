/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.DbAccess;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.ClientService;
import tables.Client;

/**
 *
 * @author HP
 */
@WebServlet(name = "MyReservations", urlPatterns = {"/MyReservations"})
public class MyReservations extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null){
            RequestDispatcher dispat = request.getRequestDispatcher("LoginServelet");
            dispat.forward(request, response);
        }
        int nbrElement = 3;
        int listNo =0;
	if(request.getParameter("listNo")==null){
            listNo=1;
	}
        else{
            listNo = Integer.parseInt(request.getParameter("listNo"));
        }
        int offset = (listNo-1)*nbrElement;
        Client user = (Client)session.getAttribute("user");
        DbAccess dbConnex = new DbAccess();
        ClientService clientService = new ClientService();
        ArrayList<ArrayList> myReservations = new ArrayList();
        myReservations = clientService.getMyReservations(user.getIdClient(),offset,nbrElement,dbConnex);
        int nombreReservations = clientService.getNombreReservations(user.getIdClient(),dbConnex);
        System.out.println(" blabla="+nombreReservations);
        int nbrlink = (int)(nombreReservations/nbrElement);
        int reste = (int)(nombreReservations%nbrElement);
        if(reste>0){
            nbrlink++;
        }
        request.setAttribute("myReservations",myReservations);
        request.setAttribute("page","mesReservations");
        request.setAttribute("nbrLink",nbrlink);
        RequestDispatcher dispat = request.getRequestDispatcher("GestionPageClient");
        dispat.forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ReservationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ReservationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
