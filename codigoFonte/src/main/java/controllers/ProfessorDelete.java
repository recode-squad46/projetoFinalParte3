package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfessorDAO;

@WebServlet("/ProfessorRemove")
public class ProfessorDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProfessorDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int professorId = Integer.parseInt(request.getParameter("professorId"));
		System.out.println(professorId);
		ProfessorDAO.delete(professorId);
		
		ProfessorCreateAndFind professorCreateAndFind = new ProfessorCreateAndFind();
		professorCreateAndFind.doGet(request, response);
	}

}
