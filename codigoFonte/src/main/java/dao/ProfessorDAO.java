package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Professor;

public class ProfessorDAO {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
		
	public static void create(Professor professor) {
		sql = "INSERT INTO tb_professor VALUES (null, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, professor.getNome());
			preparedStatement.setString(2, professor.getEmail());
			preparedStatement.setString(3, professor.getSenha());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct insert on database");
			
		} catch(SQLException e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());

		}
	}
	
	public static void delete(int professorId) {
		
		sql = "DELETE FROM tb_professor WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, professorId);
			preparedStatement.executeUpdate();
			
			System.out.println("--correct delete on professor");
			
		} catch (SQLException e) {
			System.out.println("--incorrect delete on professor. " + e.getMessage());
			
		}
		
		
	}
	
	public static List<Professor> find(String pesquisa) {
		
		sql = String.format("SELECT * FROM tb_professor WHERE nome like '%%%s%%'", pesquisa, pesquisa);
		List<Professor> professores = new ArrayList<Professor>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				Professor professor = new Professor();
				professor.setId(resultSet.getInt("id"));
				professor.setNome(resultSet.getString("nome"));
				professor.setEmail(resultSet.getString("email"));
				professor.setSenha(resultSet.getString("senha"));

				
				professores.add(professor);
			
			}
			
			System.out.println("--correct find professores");
			return professores;
			
		} catch (SQLException e) {
			System.out.println("--incorrect find professores. " + e.getMessage());
			return null;
		}
		
	}
	
	public static Professor findByPk(int professorId) {
		sql = String.format("SELECT * FROM tb_professor WHERE id like %d ", professorId);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Professor professor = new Professor();
			
			while (resultSet.next()) {
				
				professor.setId(resultSet.getInt("id"));
				professor.setNome(resultSet.getString("nome"));
				professor.setEmail(resultSet.getString("email"));
				professor.setSenha(resultSet.getString("senha"));
				
			
			}
			
			System.out.println("--correct find by pk professor");
			return professor;
		
		} catch (SQLException e) {
			System.out.println("--incorrect find by pk professor. " + e.getMessage());
			return null;
		}
		
	}
	
	public static void update(Professor professor) {
		sql = "UPDATE tb_professor SET nome=?, email=?, senha=? WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, professor.getNome());
			preparedStatement.setString(2, professor.getEmail());
			preparedStatement.setString(3, professor.getSenha());
			preparedStatement.setInt(4, professor.getId());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct update on database");
			
		} catch(SQLException e) {
			System.out.println("--incorrect update on database. " + e.getMessage());

		}
	}
	
}
