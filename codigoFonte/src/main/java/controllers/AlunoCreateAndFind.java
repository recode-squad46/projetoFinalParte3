package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDAO;
import model.Aluno;

@WebServlet("/AlunoMakeAndSearch")
public class AlunoCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlunoCreateAndFind() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pesquisa = request.getParameter("pesquisa");

		if(pesquisa == null) {
			pesquisa="";
		}
		
		List<Aluno> alunos = AlunoDAO.find(pesquisa);
		
		request.setAttribute("alunos", alunos);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaAluno.jsp");
		requestDispatcher.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Aluno aluno = new Aluno();
		
		aluno.setNome(request.getParameter("nome"));
		//aluno.setIdProfessor(Integer.parseInt(request.getParameter("idProfessor")));
		
		AlunoDAO.create(aluno);
		
		AlunoCreateAndFind alunoCreateAndFind = new AlunoCreateAndFind();
		alunoCreateAndFind.doGet(request, response);
	}

}
