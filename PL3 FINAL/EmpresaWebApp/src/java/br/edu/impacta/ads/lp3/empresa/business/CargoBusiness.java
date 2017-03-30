/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.impacta.ads.lp3.empresa.business;

import br.edu.impacta.ads.lp3.empresa.dao.jdbc.CargoDAO;
import br.edu.impacta.ads.lp3.empresa.model.Cargo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Israel
 */
@WebServlet(name = "CargoBusiness", urlPatterns = {"/cargo"})
public class CargoBusiness extends HttpServlet {

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

        if (request != null && request.getParameter("command") != null) {

            if ("Cargo.listar".equals(request.getParameter("command"))) {
                request.setAttribute("cargos", new br.edu.impacta.ads.lp3.empresa.dao.jpa.CargoDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/cargo/listar.jsp").forward(request, response);
            }

            if ("Cargo.formulario".equals(request.getParameter("command"))) {
                request.getRequestDispatcher("WEB-INF/jsp/cargo/inserir.jsp").forward(request, response);
            }

            if ("Cargo.inserir".equals(request.getParameter("command"))) {
                Cargo cargo = new Cargo();
                cargo.setNome(request.getParameter("nome"));

                new CargoDAO().inserir(cargo);
                request.setAttribute("cargos", new CargoDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/cargo/listar.jsp").forward(request, response);
            }

            if ("Cargo.alterar".equals(request.getParameter("command"))) {
                request.setAttribute("cargos", new CargoDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/cargo/alterar.jsp").forward(request, response);
            }

            if ("Cargo.alterarPorId".equals(request.getParameter("command"))) {
                Cargo cargo = new Cargo(Integer.parseInt(request.getParameter("cargos")));
                request.setAttribute("cargo", new CargoDAO().listarPorId(cargo));
                request.getRequestDispatcher("WEB-INF/jsp/cargo/confirmar-alteracao.jsp").forward(request, response);
            }

            if ("Cargo.confirmar-alteracao".equals(request.getParameter("command"))) {
                Cargo cargo = new Cargo();
                cargo.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                cargo.setNome(request.getParameter("nome"));

                new CargoDAO().alterar(cargo);
                request.setAttribute("cargos", new CargoDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/cargo/listar.jsp").forward(request, response);
            }

            if ("Cargo.remover".equals(request.getParameter("command"))) {
                request.setAttribute("cargos", new CargoDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/cargo/remover.jsp").forward(request, response);
            }

            if ("Cargo.removerPorId".equals(request.getParameter("command"))) {
                Cargo cargo = new Cargo(Integer.parseInt(request.getParameter("cargos")));
                request.setAttribute("cargo", new CargoDAO().listarPorId(cargo));
                request.getRequestDispatcher("WEB-INF/jsp/cargo/confirmar-exclusao.jsp").forward(request, response);
            }

            if ("Cargo.confirmar-exclusao".equals(request.getParameter("command"))) {
                Cargo cargo = new Cargo();
                cargo.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                cargo.setNome(request.getParameter("nome"));

                new CargoDAO().remover(cargo);
                request.setAttribute("cargos", new CargoDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/cargo/listar.jsp").forward(request, response);
            }
        }
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
