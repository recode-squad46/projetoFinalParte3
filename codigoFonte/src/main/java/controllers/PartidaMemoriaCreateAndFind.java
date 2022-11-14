package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PartidaMemoriaDAO;
import model.PartidaMemoria;

@WebServlet("/PartidaMemoriaMakeAndSearch")
public class PartidaMemoriaCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PartidaMemoriaCreateAndFind() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pesquisa = request.getParameter("pesquisa");

		if(pesquisa == null) {
			pesquisa="";
		}
		
		List<PartidaMemoria> partidasMemoria = PartidaMemoriaDAO.find(pesquisa);
		
		request.setAttribute("partidasMemoria", partidasMemoria);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaPartidaMemoria.jsp");
		requestDispatcher.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PartidaMemoria partidaMemoria = new PartidaMemoria();
		
		partidaMemoria.setTempoPartida(Integer.parseInt(request.getParameter("tempoPartida")));
		partidaMemoria.setQtdJogadas(Integer.parseInt(request.getParameter("qtdJogadas")));
		//partidaMemoria.setIdAluno(Integer.parseInt(request.getParameter("idAluno")));
		
		PartidaMemoriaDAO.create(partidaMemoria);
		
		PartidaMemoriaCreateAndFind partidaMemoriaCreateAndFind = new PartidaMemoriaCreateAndFind();
		partidaMemoriaCreateAndFind.doGet(request, response);
	}

}


