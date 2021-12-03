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
import services.AdminService;
import services.TrajetService;
import services.VilleService;
import tables.Trajet;
import tables.Ville;

/**
 *
 * @author HP
 */
@WebServlet(name = "ModifyTrajet", urlPatterns = {"/admin/ModifyTrajet"})
public class ModifyTrajet extends HttpServlet {

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
        DbAccess dbConnex = new DbAccess();
        String page =null;
        if(request.getParameter("idVilleDepart")==null){
            String idTrajet = request.getParameter("idTrajet");
            TrajetService trajetService = new TrajetService();
            Trajet trajetToModify = trajetService.getTrajetById(idTrajet, dbConnex);
            request.setAttribute("trajetToModify",trajetToModify);
            request.setAttribute("page","modifyTrajet");
            page="GestionPageAdmin";
        }
        else{
            AdminService adminService = new AdminService();
            String idTrajet = request.getParameter("idTrajet");
            String idVilleDepart = request.getParameter("idVilleDepart");
            String idVilleDestination = request.getParameter("idVilleDestination");
            double distance = Double.parseDouble(request.getParameter("distance"));
            adminService.updateTrajet(idTrajet,idVilleDepart,idVilleDestination,distance,dbConnex);
            page="ListeTrajet";
        }
        VilleService villeService = new VilleService();
        ArrayList<Ville> lesVilles=new ArrayList();
        lesVilles=villeService.listeVille(dbConnex);
        request.setAttribute("listeVille", lesVilles);
        RequestDispatcher dispat = request.getRequestDispatcher(page);
        dispat.forward(request,response);
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
            Logger.getLogger(DeleteVille.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DeleteVille.class.getName()).log(Level.SEVERE, null, ex);
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
