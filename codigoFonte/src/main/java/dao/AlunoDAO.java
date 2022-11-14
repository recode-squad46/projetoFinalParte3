package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Aluno;

public class AlunoDAO {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
		
	public static void create(Aluno aluno) {
		sql = "INSERT INTO tb_aluno (id, nome) VALUES (null, ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, aluno.getNome());
			//preparedStatement.setInt(2, aluno.getIdProfessor());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct insert on database");
			
		} catch(SQLException e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());

		}
	}
	
	public static void delete(int alunoId) {
		
		sql = "DELETE FROM tb_aluno WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, alunoId);
			preparedStatement.executeUpdate();
			
			System.out.println("--correct delete on aluno");
			
		} catch (SQLException e) {
			System.out.println("--incorrect delete on aluno. " + e.getMessage());
			
		}
		
		
	}
	
	public static List<Aluno> find(String pesquisa) {
		
		sql = String.format("SELECT * FROM tb_aluno WHERE nome like '%%%s%%'", pesquisa, pesquisa);
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				Aluno aluno = new Aluno();
				aluno.setId(resultSet.getInt("id"));
				aluno.setNome(resultSet.getString("nome"));
				aluno.setIdProfessor(resultSet.getInt("id_professor"));

				
				alunos.add(aluno);
			
			}
			
			System.out.println("--correct find alunos");
			return alunos;
			
		} catch (SQLException e) {
			System.out.println("--incorrect find alunos. " + e.getMessage());
			return null;
		}
		
	}
	
	public static Aluno findByPk(int alunoId) {
		sql = String.format("SELECT * FROM tb_aluno WHERE id like %d ", alunoId);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Aluno aluno = new Aluno();
			
			while (resultSet.next()) {
				
				aluno.setId(resultSet.getInt("id"));
				aluno.setNome(resultSet.getString("nome"));
				aluno.setIdProfessor(resultSet.getInt("id_professor"));
				
			
			}
			
			System.out.println("--correct find by pk aluno");
			return aluno;
		
		} catch (SQLException e) {
			System.out.println("--incorrect find by pk aluno. " + e.getMessage());
			return null;
		}
		
	}
	
	public static void update(Aluno aluno) {
		sql = "UPDATE tb_aluno SET nome=? WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, aluno.getNome());
			//preparedStatement.setInt(2, aluno.getIdProfessor());
			preparedStatement.setInt(2, aluno.getId());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct update on database");
			
		} catch(SQLException e) {
			System.out.println("--incorrect update on database. " + e.getMessage());

		}
	}
}