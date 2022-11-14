package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PartidaMemoriaDAO;
import model.PartidaMemoria;

@WebServlet("/PartidaMemoriaUpdate")
public class PartidaMemoriaFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PartidaMemoriaFindAndUpdate() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int partidaMemoriaId = Integer.parseInt(request.getParameter("partidaMemoriaId"));
		PartidaMemoria partidaMemoria = PartidaMemoriaDAO.findByPk(partidaMemoriaId);
		
		request.setAttribute("partidaMemoria", partidaMemoria);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdatePartidaMemoria.jsp");
		requestDispatcher.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PartidaMemoria partidaMemoria = new PartidaMemoria();
		partidaMemoria.setId(Integer.parseInt(request.getParameter("id")));
		partidaMemoria.setTempoPartida(Integer.parseInt(request.getParameter("tempoPartida")));
		partidaMemoria.setQtdJogadas(Integer.parseInt(request.getParameter("qtdJogadas")));
		//partidaMemoria.setIdAluno(Integer.parseInt(request.getParameter("idAluno")));

		
		PartidaMemoriaDAO.update(partidaMemoria);
		
		PartidaMemoriaCreateAndFind partidaMemoriaCreateAndFind = new PartidaMemoriaCreateAndFind();
		partidaMemoriaCreateAndFind.doGet(request, response);
	}

}

