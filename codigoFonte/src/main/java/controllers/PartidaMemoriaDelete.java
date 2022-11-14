package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PartidaMemoriaDAO;

@WebServlet("/PartidaMemoriaRemove")
public class PartidaMemoriaDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PartidaMemoriaDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int partidaMemoriaId = Integer.parseInt(request.getParameter("partidaMemoriaId"));
		System.out.println(partidaMemoriaId);
		PartidaMemoriaDAO.delete(partidaMemoriaId);
		
		PartidaMemoriaCreateAndFind partidaMemoriaCreateAndFind = new PartidaMemoriaCreateAndFind();
		partidaMemoriaCreateAndFind.doGet(request, response);
	}

}
