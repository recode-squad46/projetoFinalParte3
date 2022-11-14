package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfessorDAO;
import model.Professor;

@WebServlet("/ProfessorMakeAndSearch")
public class ProfessorCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProfessorCreateAndFind() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pesquisa = request.getParameter("pesquisa");

		if(pesquisa == null) {
			pesquisa="";
		}
		
		List<Professor> professores = ProfessorDAO.find(pesquisa);
		
		request.setAttribute("professores", professores);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaProfessor.jsp");
		requestDispatcher.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Professor professor = new Professor();
		
		professor.setNome(request.getParameter("nome"));
		professor.setEmail(request.getParameter("email"));
		professor.setSenha(request.getParameter("senha"));
		
		ProfessorDAO.create(professor);
		
		ProfessorCreateAndFind professorCreateAndFind = new ProfessorCreateAndFind();
		professorCreateAndFind.doGet(request, response);
	}

}
