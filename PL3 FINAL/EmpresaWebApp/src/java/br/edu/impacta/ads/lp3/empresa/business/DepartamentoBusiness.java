/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.impacta.ads.lp3.empresa.business;

import br.edu.impacta.ads.lp3.empresa.dao.jdbc.DepartamentoDAO;
import br.edu.impacta.ads.lp3.empresa.model.Departamento;
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
@WebServlet(name = "Departamento", urlPatterns = {"/departamento"})
public class DepartamentoBusiness extends HttpServlet {

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

            if ("Departamento.listar".equals(request.getParameter("command"))) {
                request.setAttribute("departamentos", new br.edu.impacta.ads.lp3.empresa.dao.jpa.DepartamentoDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/departamento/listar.jsp").forward(request, response);
            }

            if ("Departamento.formulario".equals(request.getParameter("command"))) {
                request.getRequestDispatcher("WEB-INF/jsp/departamento/inserir.jsp").forward(request, response);
            }

            if ("Departamento.inserir".equals(request.getParameter("command"))) {
                Departamento departamento = new Departamento();
                departamento.setNome(request.getParameter("nome"));

                new DepartamentoDAO().inserir(departamento);
                request.setAttribute("departamentos", new DepartamentoDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/departamento/listar.jsp").forward(request, response);
            }

            if ("Departamento.alterar".equals(request.getParameter("command"))) {
                request.setAttribute("departamentos", new DepartamentoDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/departamento/alterar.jsp").forward(request, response);
            }

            if ("Departamento.alterarPorId".equals(request.getParameter("command"))) {
                Departamento departamento = new Departamento(Integer.parseInt(request.getParameter("departamentos")));
                request.setAttribute("departamento", new DepartamentoDAO().listarPorId(departamento));
                request.getRequestDispatcher("WEB-INF/jsp/departamento/confirmar-alteracao.jsp").forward(request, response);
            }

            if ("Departamento.confirmar-alteracao".equals(request.getParameter("command"))) {
                Departamento departamento = new Departamento();
                departamento.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                departamento.setNome(request.getParameter("nome"));

                new DepartamentoDAO().alterar(departamento);
                request.setAttribute("departamentos", new DepartamentoDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/departamento/listar.jsp").forward(request, response);
            }

            if ("Departamento.remover".equals(request.getParameter("command"))) {
                request.setAttribute("departamentos", new DepartamentoDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/departamento/remover.jsp").forward(request, response);
            }

            if ("Departamento.removerPorId".equals(request.getParameter("command"))) {
                Departamento departamento = new Departamento(Integer.parseInt(request.getParameter("departamentos")));
                request.setAttribute("departamento", new DepartamentoDAO().listarPorId(departamento));
                request.getRequestDispatcher("WEB-INF/jsp/departamento/confirmar-exclusao.jsp").forward(request, response);
            }

            if ("Departamento.confirmar-exclusao".equals(request.getParameter("command"))) {
                Departamento departamento = new Departamento();
                departamento.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                departamento.setNome(request.getParameter("nome"));

                new DepartamentoDAO().remover(departamento);
                request.setAttribute("departamentos", new DepartamentoDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/departamento/listar.jsp").forward(request, response);
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
