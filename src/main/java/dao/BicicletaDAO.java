package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import domain.Bicicleta;
import domain.Locadora;


public class BicicletaDAO extends GenericDAO{
	
	public void insert(Bicicleta bicicleta) {
		String sql = "INSERT INTO Bicicleta (cnpj_locadora, id_locadora, placa, modelo, chassi, ano, quilometragem,"
				+ "descricao, valor, fotos) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, bicicleta.getLocadora().getCnpj());
            statement.setLong(2, bicicleta.getLocadora().getId_usuario());
            statement.setString(3, bicicleta.getPlaca());
            statement.setString(4, bicicleta.getModelo());
            statement.setString(5, bicicleta.getChassi());
            statement.setInt(6, bicicleta.getAno());
            statement.setInt(7, bicicleta.getQuilometragem());
            statement.setString(8, bicicleta.getDescricao());
            statement.setFloat(9, bicicleta.getValor());
            statement.setString(10, bicicleta.getFotos());
            statement.executeUpdate();
            statement.close();
            conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Bicicleta> getAll(){
		
		List<Bicicleta> listaBicicletas = new ArrayList<>();
		
		String sql = "SELECT b.ID, cnpj_locadora, placa, modelo, chassi, ano, quilometragem, b.descricao, b.valor, fotos, id_locadora, nome, l.descricao from Bicicleta b Left Join Locadora l on b.id_locadora = l.id LEFT JOIN Proposta p ON b.id = p.bicicleta_id WHERE p.statusCompra IS NULL OR p.statusCompra!= \"ACEITO\" GROUP BY b.ID ORDER BY b.id";
					
		try {
			Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
            	Long id = resultSet.getLong("id");
            	String cnpj_locadora = resultSet.getString("cnpj_locadora");
            	String placa = resultSet.getString("placa");
            	String modelo = resultSet.getString("modelo");
            	String chassi = resultSet.getString("chassi");
            	int ano = resultSet.getInt("ano");
            	int quilometragem = resultSet.getInt("quilometragem");
            	String descricao = resultSet.getString("descricao");
            	float valor = resultSet.getFloat("valor");
            	String fotos = resultSet.getString("fotos");
            	
            	Long id_locadora = resultSet.getLong("id_locadora");
            	String nome = resultSet.getString("nome");
            	String descricao_locadora = resultSet.getString("l.descricao");
				String cidade = resultSet.getString("l.cidade");
            	
            	Locadora locadora = new Locadora(id_locadora, nome, descricao_locadora, cnpj_locadora, cidade);
            	Bicicleta bicicleta = new Bicicleta(id, locadora, placa, modelo, chassi, ano, quilometragem, descricao, valor, fotos);
            	listaBicicletas.add(bicicleta);
            }
            resultSet.close();
            statement.close();
            conn.close();
		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
		return listaBicicletas;
	}
	
	public List<Bicicleta> getAll(Long identificador){
			
			List<Bicicleta> listaBicicletas = new ArrayList<>();
			
			String sql = "SELECT * from Bicicleta b, Locadora l where b.id_locadora = l.id order by b.id_locadora";
						
			try {
				Connection conn = this.getConnection();
	            Statement statement = conn.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	            while (resultSet.next()){
	            	Long id = resultSet.getLong("id");
	            	String cpnj_locadora = resultSet.getString("cpnj_locadora");
	            	String placa = resultSet.getString("placa");
	            	String modelo = resultSet.getString("modelo");
	            	String chassi = resultSet.getString("chassi");
	            	int ano = resultSet.getInt("ano");
	            	int quilometragem = resultSet.getInt("quilometragem");
	            	String descricao = resultSet.getString("descricao");
	            	float valor = resultSet.getFloat("valor");
	            	String fotos = resultSet.getString("fotos");
	            	
	            	Long id_locadora = resultSet.getLong("id_locadora");
	            	String nome = resultSet.getString("nome");
	            	String descricao_locadora = resultSet.getString("l.descricao");
					String cidade = resultSet.getString("l.cidade");
	            	
	            	Locadora locadora = new Locadora(id_locadora, nome, descricao_locadora, cpnj_locadora, cidade);
	            	Bicicleta bicicleta = new Bicicleta(id, locadora, placa, modelo, chassi, ano, quilometragem, descricao, valor, fotos);
	            	if( identificador == id_locadora) {
		            	listaBicicletas.add(bicicleta);
	            	}
	            }
	            resultSet.close();
	            statement.close();
	            conn.close();
			} catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
			return listaBicicletas;
		}
	
	public void delete(Bicicleta bicicleta) {
        String sql = "DELETE FROM Bicicleta where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, bicicleta.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void update(Bicicleta bicicleta) {
        String sql = "UPDATE Bicicleta SET cnpj_locadora = ?, id_locadora = ?, placa = ?, modelo = ?, chassi = ?, ano = ?";
        sql += ", quilometragem = ?, descricao = ?, valor = ?, fotos = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, bicicleta.getLocadora().getCnpj());
            statement.setLong(2, bicicleta.getLocadora().getId_usuario());
            statement.setString(3, bicicleta.getPlaca());
            statement.setString(4, bicicleta.getModelo());
            statement.setString(5, bicicleta.getChassi());
            statement.setInt(6, bicicleta.getAno());
            statement.setInt(7, bicicleta.getQuilometragem());
            statement.setString(8, bicicleta.getDescricao());
            statement.setFloat(9, bicicleta.getValor());
            statement.setString(10, bicicleta.getFotos());
            statement.setLong(11, bicicleta.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public Bicicleta get(Long id) {
        Bicicleta bicicleta = null;

        String sql = "SELECT * from Bicicleta b, Locadora l where b.id = ? and b.id_locadora = l.id";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	
            	String placa = resultSet.getString("placa");
            	String modelo = resultSet.getString("modelo");
            	String chassi = resultSet.getString("chassi");
            	int ano = resultSet.getInt("ano");
            	int quilometragem = resultSet.getInt("quilometragem");
            	String descricao = resultSet.getString("descricao");
            	float valor = resultSet.getFloat("valor");
            	String fotos = resultSet.getString("fotos");
            	
            	Long id_locadora = resultSet.getLong("id_locadora");
            	Locadora locadora = new LocadoraDAO().get(id_locadora);

            	bicicleta = new Bicicleta(id, locadora, placa, modelo, chassi, ano, quilometragem, descricao, valor, fotos);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bicicleta;
    }
}
