package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Card;

public class CardDAO {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
		
	public static void create(Card card) {
		sql = "INSERT INTO tb_card VALUES (null, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, card.getNome());
			preparedStatement.setString(2, card.getImgCard());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct insert on database");
			
		} catch(SQLException e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());

		}
	}
	
	public static void delete(int cardId) {
		
		sql = "DELETE FROM tb_card WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, cardId);
			preparedStatement.executeUpdate();
			
			System.out.println("--correct delete on card");
			
		} catch (SQLException e) {
			System.out.println("--incorrect delete on card. " + e.getMessage());
			
		}
		
		
	}
	
	public static List<Card> find(String pesquisa) {
		
		sql = String.format("SELECT * FROM tb_card WHERE nome like '%%%s%%'", pesquisa, pesquisa);
		List<Card> cards = new ArrayList<Card>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				Card card = new Card();
				card.setId(resultSet.getInt("id"));
				card.setNome(resultSet.getString("nome"));
				card.setImgCard(resultSet.getString("img_card"));

				
				cards.add(card);
			
			}
			
			System.out.println("--correct find cards");
			return cards;
			
		} catch (SQLException e) {
			System.out.println("--incorrect find cards. " + e.getMessage());
			return null;
		}
		
	}
	
	public static Card findByPk(int cardId) {
		sql = String.format("SELECT * FROM tb_card WHERE id like %d ", cardId);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Card card = new Card();
			
			while (resultSet.next()) {
				
				card.setId(resultSet.getInt("id"));
				card.setNome(resultSet.getString("nome"));
				card.setImgCard(resultSet.getString("img_card"));
				
			
			}
			
			System.out.println("--correct find by pk card");
			return card;
		
		} catch (SQLException e) {
			System.out.println("--incorrect find by pk card. " + e.getMessage());
			return null;
		}
		
	}
	
	public static void update(Card card) {
		sql = "UPDATE tb_card SET nome=?, img_card=? WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, card.getNome());
			preparedStatement.setString(2, card.getImgCard());
			preparedStatement.setInt(3, card.getId());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct update on database");
			
		} catch(SQLException e) {
			System.out.println("--incorrect update on database. " + e.getMessage());

		}
	}
}
