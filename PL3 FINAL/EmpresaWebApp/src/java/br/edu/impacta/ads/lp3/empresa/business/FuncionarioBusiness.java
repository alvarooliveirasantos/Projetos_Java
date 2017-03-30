/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.impacta.ads.lp3.empresa.business;

import br.edu.impacta.ads.lp3.empresa.dao.jdbc.CargoDAO;
import br.edu.impacta.ads.lp3.empresa.dao.jdbc.DepartamentoDAO;
import br.edu.impacta.ads.lp3.empresa.dao.jdbc.FuncionarioDAO;
import br.edu.impacta.ads.lp3.empresa.model.Cargo;
import br.edu.impacta.ads.lp3.empresa.model.Departamento;
import br.edu.impacta.ads.lp3.empresa.model.Funcionario;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 1146322
 */
@WebServlet(name = "FuncionarioBusiness", urlPatterns = {"/funcionario"})
public class FuncionarioBusiness extends HttpServlet {

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

            if ("Funcionario.listar".equals(request.getParameter("command"))) {
                request.setAttribute("funcionarios", new FuncionarioDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/funcionario/listar.jsp").forward(request, response);
            }
            if ("Funcionario.inserir".equals(request.getParameter("command"))) {
                request.setAttribute("cargos", new CargoDAO().listar());
                request.setAttribute("departamentos", new DepartamentoDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/funcionario/inserir.jsp").forward(request, response);
            }

            if ("Funcionario.confirmar-insercao".equals(request.getParameter("command"))) {
                try {
                    Funcionario funcionario = new Funcionario();
                    funcionario.setNome(request.getParameter("nome"));
                    funcionario.setContratacao(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("contratacao")));
                    funcionario.setCargo(new Cargo(Integer.parseInt(request.getParameter("cargos"))));
                    funcionario.setDepartamento(new Departamento(Integer.parseInt(request.getParameter("departamentos"))));
                    new FuncionarioDAO().inserir(funcionario);
                    request.setAttribute("funcionarios", new FuncionarioDAO().listar());
                    request.getRequestDispatcher("WEB-INF/jsp/funcionario/listar.jsp").forward(request, response);
                } catch (ParseException ex) {
                    Logger.getLogger(FuncionarioBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if ("Funcionario.alterar".equals(request.getParameter("command"))) {
                request.setAttribute("funcionarios", new FuncionarioDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/funcionario/alterar.jsp").forward(request, response);
            }

            if ("Funcionario.alterarPorId".equals(request.getParameter("command"))) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(Integer.parseInt(request.getParameter("funcionarios")));
                request.setAttribute("funcionario", new FuncionarioDAO().listarPorId(funcionario));
                request.setAttribute("cargos", new CargoDAO().listar());
                request.setAttribute("departamentos", new DepartamentoDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/funcionario/confirmar-alteracao.jsp").forward(request, response);
            }

            if ("Funcionario.confirmar-alteracao".equals(request.getParameter("command"))) {
                try {
                    Funcionario funcionario = new Funcionario();
                    funcionario.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                    funcionario.setNome(request.getParameter("nome"));
                    funcionario.setContratacao(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("contratacao")));
                    funcionario.setCargo(new Cargo(Integer.parseInt(request.getParameter("cargos"))));
                    funcionario.setDepartamento(new Departamento(Integer.parseInt(request.getParameter("departamentos"))));
                    new FuncionarioDAO().alterar(funcionario);
                    request.setAttribute("funcionarios", new FuncionarioDAO().listar());
                    request.getRequestDispatcher("WEB-INF/jsp/funcionario/listar.jsp").forward(request, response);
                } catch (ParseException ex) {
                    Logger.getLogger(FuncionarioBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if ("Funcionario.remover".equals(request.getParameter("command"))) {
                request.setAttribute("funcionarios", new FuncionarioDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/funcionario/remover.jsp").forward(request, response);
            }

            if ("Funcionario.removerPorId".equals(request.getParameter("command"))) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(Integer.parseInt(request.getParameter("funcionarios")));
                request.setAttribute("funcionario", new FuncionarioDAO().listarPorId(funcionario));
                request.setAttribute("cargos", new CargoDAO().listar());
                request.setAttribute("departamentos", new DepartamentoDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/funcionario/confirmar-exclusao.jsp").forward(request, response);
            }

            if ("Funcionario.confirmar-exclusao".equals(request.getParameter("command"))) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                new FuncionarioDAO().remover(funcionario);
                request.setAttribute("funcionarios", new FuncionarioDAO().listar());
                request.getRequestDispatcher("WEB-INF/jsp/funcionario/listar.jsp").forward(request, response);
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
