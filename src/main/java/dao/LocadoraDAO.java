package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Locadora;


public class LocadoraDAO extends GenericDAO{
	
	public void insert(Locadora locadora) {

        String sql = "INSERT INTO Locadora (id, nome, descricao, cnpj, cidade) VALUES (?,?,?,?,?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, locadora.getId_usuario());
            statement.setString(2, locadora.getNome());
            statement.setString(3, locadora.getDescricao());
            statement.setString(4, locadora.getCnpj());
            statement.setString(5, locadora.getCidade());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public List<Locadora> getAll() {

        List<Locadora> listaLocadoras = new ArrayList<>();

        String sql = "SELECT * from Locadora";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String descricao = resultSet.getString("descricao");
                String cnpj = resultSet.getString("cnpj");
                String cidade = resultSet.getString("cidade");
                
                Locadora locadora = new Locadora(id, nome, descricao, cnpj, cidade);
                listaLocadoras.add(locadora);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocadoras;
    }
	
	public void delete(Locadora locadora) {
        String sql = "DELETE FROM Locadora where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, locadora.getId_usuario());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void update(Locadora locadora) {
        String sql = "UPDATE Locadora SET nome = ?, descricao = ?";
        sql += ", cnpj = ?, cidade = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, locadora.getNome());
            statement.setString(2, locadora.getDescricao());
            statement.setString(3, locadora.getCnpj());
            statement.setString(4, locadora.getCidade());
            statement.setLong(5, locadora.getId_usuario());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public Locadora get(Long id) {
        Locadora locadora = null;
        
        String sql = "SELECT * from Locadora where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	String nome = resultSet.getString("nome");
                String descricao = resultSet.getString("descricao");
                String cnpj = resultSet.getString("cnpj");
                String cidade = resultSet.getString("cidade");
                locadora = new Locadora(id, nome, descricao, cnpj, cidade);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locadora;
    }
}
