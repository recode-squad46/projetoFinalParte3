package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfessorDAO;
import model.Professor;

@WebServlet("/ProfessorUpdate")
public class ProfessorFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProfessorFindAndUpdate() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int professorId = Integer.parseInt(request.getParameter("professorId"));
		Professor professor = ProfessorDAO.findByPk(professorId);
		
		request.setAttribute("professor", professor);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdateProfessor.jsp");
		requestDispatcher.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Professor professor = new Professor();
		professor.setId(Integer.parseInt(request.getParameter("id")));
		professor.setNome(request.getParameter("nome"));
		professor.setEmail(request.getParameter("email"));
		professor.setSenha(request.getParameter("senha"));

		
		ProfessorDAO.update(professor);
		
		ProfessorCreateAndFind professorCreateAndFind = new ProfessorCreateAndFind();
		professorCreateAndFind.doGet(request, response);
	}

}
