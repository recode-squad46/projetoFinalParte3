package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDAO;

@WebServlet("/AlunoRemove")
public class AlunoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlunoDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int alunoId = Integer.parseInt(request.getParameter("alunoId"));
		System.out.println(alunoId);
		AlunoDAO.delete(alunoId);
		
		AlunoCreateAndFind alunoCreateAndFind = new AlunoCreateAndFind();
		alunoCreateAndFind.doGet(request, response);
	}

}
