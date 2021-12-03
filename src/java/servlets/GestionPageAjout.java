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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.CompagnieService;
import services.HorraireTrainService;
import services.TrainService;
import services.TrajetService;
import services.VilleService;
import tables.Compagnie;
import tables.HorraireTrain;
import tables.Train;
import tables.Trajet;
import tables.Ville;

/**
 *
 * @author HP
 */
public class GestionPageAjout extends HttpServlet {

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
            String page = request.getParameter("page");
            page=page.concat(".jsp");
            DbAccess dbConnex = new DbAccess();
            VilleService villeService = new VilleService();
            ArrayList<Ville> lesVilles=new ArrayList();
            lesVilles=villeService.listeVille(dbConnex);
            CompagnieService compagnieService = new CompagnieService();
            ArrayList<Compagnie> lesCompagnies = new ArrayList();
            lesCompagnies=compagnieService.listeCompagnie(dbConnex);
            TrainService TrainService = new TrainService();
            ArrayList<Train> lesTrains = new ArrayList();
            lesTrains=TrainService.listeTrain(dbConnex);
            TrajetService TrajetService = new TrajetService();
            ArrayList<Trajet> lesTrajets = new ArrayList();
            lesTrajets=TrajetService.listeTrajet(dbConnex);
            HorraireTrainService HorraireTrainService = new HorraireTrainService();
            ArrayList<HorraireTrain> lesHorraireTrains = new ArrayList();
            lesHorraireTrains=HorraireTrainService.listeHorraireTrain(dbConnex);
            request.setAttribute("listeHorraireTrain", lesHorraireTrains);
            request.setAttribute("listeTrajet", lesTrajets);
            request.setAttribute("listeTrain", lesTrains);
            request.setAttribute("listeCompagnie", lesCompagnies);
            request.setAttribute("listeVille",lesVilles);
            request.setAttribute("content", page);
            RequestDispatcher dispat =request.getRequestDispatcher("admin.jsp");
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
            Logger.getLogger(GestionPageAjout.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GestionPageAjout.class.getName()).log(Level.SEVERE, null, ex);
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
