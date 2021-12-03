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
import services.CompagnieService;
import services.TrainService;
import services.VilleService;
import tables.Compagnie;
import tables.Train;
import tables.Ville;

/**
 *
 * @author HP
 */
@WebServlet(name = "ModifyTrain", urlPatterns = {"/admin/ModifyTrain"})
public class ModifyTrain extends HttpServlet {

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
        if(request.getParameter("idCompagnie")==null){
            String idTrain = request.getParameter("idTrain");
            TrainService trainService = new TrainService();
            Train trainToModify = trainService.getTrainById(idTrain, dbConnex);
            request.setAttribute("trainToModify",trainToModify);
            request.setAttribute("page","modifyTrain");
            page="GestionPageAdmin";
        }
        else{
            AdminService adminService = new AdminService();
            String idTrain = request.getParameter("idTrain");
            String idCompagnie = request.getParameter("idCompagnie");
            String numeroTrain = request.getParameter("numeroTrain");
            int nombreDePlaces = Integer.parseInt(request.getParameter("nombreDePlaces"));
            adminService.updateTrain(idTrain,idCompagnie,numeroTrain,nombreDePlaces,dbConnex);
            page="ListeTrain";
        }
        CompagnieService compagnieService = new CompagnieService();
        ArrayList<Compagnie> lesCompagnies = new ArrayList();
        lesCompagnies=compagnieService.listeCompagnie(dbConnex);
        request.setAttribute("listeCompagnie", lesCompagnies);
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
