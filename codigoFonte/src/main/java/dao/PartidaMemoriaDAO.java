package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.PartidaMemoria;

public class PartidaMemoriaDAO {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
		
	public static void create(PartidaMemoria partidaMemoria) {
		sql = "INSERT INTO tb_partida_memoria (id, tempo_partida, qtd_jogadas) VALUES (null, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, partidaMemoria.getTempoPartida());
			preparedStatement.setInt(2, partidaMemoria.getQtdJogadas());
			//preparedStatement.setInt(3, partidaMemoria.getIdAluno());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct insert on database");
			
		} catch(SQLException e) {
			System.out.println("--incorrect insert on database. " + e.getMessage());

		}
	}
	
	public static void delete(int partidaMemoriaId) {
		
		sql = "DELETE FROM tb_partida_memoria WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, partidaMemoriaId);
			preparedStatement.executeUpdate();
			
			System.out.println("--correct delete on partidaMemoria");
			
		} catch (SQLException e) {
			System.out.println("--incorrect delete on partidaMemoria. " + e.getMessage());
			
		}
		
		
	}
	
	public static List<PartidaMemoria> find(String pesquisa) {
		
		sql = String.format("SELECT * FROM tb_partida_memoria WHERE tempo_partida like '%%%s%%' OR qtd_jogadas like '%%%s%%'", pesquisa, pesquisa);
		List<PartidaMemoria> partidasMemoria = new ArrayList<PartidaMemoria>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				PartidaMemoria partidaMemoria = new PartidaMemoria();
				partidaMemoria.setId(resultSet.getInt("id"));
				partidaMemoria.setTempoPartida(resultSet.getInt("tempo_partida"));
				partidaMemoria.setQtdJogadas(resultSet.getInt("qtd_jogadas"));
				partidaMemoria.setIdAluno(resultSet.getInt("id_aluno"));

				
				partidasMemoria.add(partidaMemoria);
			
			}
			
			System.out.println("--correct find partidasMemoria");
			return partidasMemoria;
			
		} catch (SQLException e) {
			System.out.println("--incorrect find partidasMemoria. " + e.getMessage());
			return null;
		}
		
	}
	
	public static PartidaMemoria findByPk(int partidaMemoriaId) {
		sql = String.format("SELECT * FROM tb_partida_memoria WHERE id like %d ", partidaMemoriaId);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			PartidaMemoria partidaMemoria = new PartidaMemoria();
			
			while (resultSet.next()) {
				
				partidaMemoria.setId(resultSet.getInt("id"));
				partidaMemoria.setTempoPartida(resultSet.getInt("tempo_partida"));
				partidaMemoria.setQtdJogadas(resultSet.getInt("qtd_jogadas"));
				partidaMemoria.setIdAluno(resultSet.getInt("id_aluno"));
				
			
			}
			
			System.out.println("--correct find by pk partidaMemoria");
			return partidaMemoria;
		
		} catch (SQLException e) {
			System.out.println("--incorrect find by pk partidaMemoria. " + e.getMessage());
			return null;
		}
		
	}
	
	public static void update(PartidaMemoria partidaMemoria) {
		sql = "UPDATE tb_partida_memoria SET tempo_partida=?, qtd_jogadas=? WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, partidaMemoria.getTempoPartida());
			preparedStatement.setInt(2, partidaMemoria.getQtdJogadas());
			//preparedStatement.setInt(3, partidaMemoria.getIdAluno());
			preparedStatement.setInt(3, partidaMemoria.getId());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct update on database");
			
		} catch(SQLException e) {
			System.out.println("--incorrect update on database. " + e.getMessage());

		}
	}
	
}
