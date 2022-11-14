package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDAO;
import model.Aluno;

@WebServlet("/AlunoUpdate")
public class AlunoFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlunoFindAndUpdate() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int alunoId = Integer.parseInt(request.getParameter("alunoId"));
		Aluno aluno = AlunoDAO.findByPk(alunoId);
		
		request.setAttribute("aluno", aluno);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdateAluno.jsp");
		requestDispatcher.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Aluno aluno = new Aluno();
		aluno.setId(Integer.parseInt(request.getParameter("id")));
		aluno.setNome(request.getParameter("nome"));
		//aluno.setIdProfessor(Integer.parseInt(request.getParameter("idProfessor")));
		
		AlunoDAO.update(aluno);
		
		AlunoCreateAndFind alunoCreateAndFind = new AlunoCreateAndFind();
		alunoCreateAndFind.doGet(request, response);
	}

}
