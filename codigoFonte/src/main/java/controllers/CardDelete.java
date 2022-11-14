package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CardDAO;

@WebServlet("/CardRemove")
public class CardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CardDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cardId = Integer.parseInt(request.getParameter("cardId"));
		System.out.println(cardId);
		CardDAO.delete(cardId);
		
		CardCreateAndFind cardCreateAndFind = new CardCreateAndFind();
		cardCreateAndFind.doGet(request, response);
	}

}
