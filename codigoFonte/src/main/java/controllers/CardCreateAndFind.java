package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CardDAO;
import model.Card;

@WebServlet("/CardMakeAndSearch")
public class CardCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CardCreateAndFind() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pesquisa = request.getParameter("pesquisa");

		if(pesquisa == null) {
			pesquisa="";
		}
		
		List<Card> cards = CardDAO.find(pesquisa);
		
		request.setAttribute("cards", cards);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaCard.jsp");
		requestDispatcher.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Card card = new Card();
		
		card.setNome(request.getParameter("nome"));
		card.setImgCard(request.getParameter("imgCard"));
		
		CardDAO.create(card);
		
		CardCreateAndFind cardCreateAndFind = new CardCreateAndFind();
		cardCreateAndFind.doGet(request, response);
	}

}

