package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CardDAO;
import model.Card;

@WebServlet("/CardUpdate")
public class CardFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CardFindAndUpdate() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cardId = Integer.parseInt(request.getParameter("cardId"));
		Card card = CardDAO.findByPk(cardId);
		
		request.setAttribute("card", card);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdateCard.jsp");
		requestDispatcher.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Card card = new Card();
		card.setId(Integer.parseInt(request.getParameter("id")));
		card.setNome(request.getParameter("nome"));
		card.setImgCard(request.getParameter("imgCard"));

		
		CardDAO.update(card);
		
		CardCreateAndFind cardCreateAndFind = new CardCreateAndFind();
		cardCreateAndFind.doGet(request, response);
	}

}

