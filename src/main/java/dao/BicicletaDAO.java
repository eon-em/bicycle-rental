package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import domain.Bicicleta;
import domain.Cliente;
import domain.Locadora;


public class BicicletaDAO extends GenericDAO{
	
	public void insert(Bicicleta bicicleta) {
		String sql = "INSERT INTO Bicicleta (clienteId, locadoraId, dataLocacao) VALUES (?, ?, ?)";

		try {
			Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, bicicleta.getCliente().getId_usuario());
            statement.setLong(2, bicicleta.getLocadora().getId_usuario());
            statement.setString(3, bicicleta.getDataLocacao().toString());
            statement.executeUpdate();
            statement.close();
            conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Bicicleta> getAllByLocadora(Long thisLocadoraId) {		
		List<Bicicleta> listaBicicletas = new ArrayList<>();
			
		String sql = "SELECT * from Bicicleta b, Locadora l, Cliente c where b.locadoraId = l.id and b.clienteId = c.id order by b.locadoraId";
						
		try {
			Connection conn = this.getConnection();
	        Statement statement = conn.createStatement();
	            
	        ResultSet resultSet = statement.executeQuery(sql);
	        while (resultSet.next()){
            	Long id = resultSet.getLong("id");

				Long clienteId = resultSet.getLong("clienteId");
				Long locadoraId = resultSet.getLong("locadoraId");
				LocalDate dataLocacao = LocalDate.parse(resultSet.getString("dataLocacao"));

				// Build cliente object
				String clienteCpf = resultSet.getString("c.cpf");
				String clienteNome = resultSet.getString("c.nome");
				String clienteTelefone = resultSet.getString("c.telefone");
				String clienteSexo = resultSet.getString("c.sexo");
				LocalDate clienteDataDeNascimento = LocalDate.parse(resultSet.getString("c.dataDeNascimento"));
				Cliente cliente = new Cliente(clienteId, clienteCpf, clienteTelefone, clienteNome, clienteSexo, clienteDataDeNascimento);
				
				// Build locadora object
				String locadoraNome = resultSet.getString("l.nome");
				String locadoraDescricao = resultSet.getString("l.descricao");
				String locadoraCnpj = resultSet.getString("l.cnpj");
				String locadoraCidade = resultSet.getString("l.cidade");
	        	Locadora locadora = new Locadora(locadoraId, locadoraNome, locadoraDescricao, locadoraCnpj, locadoraCidade);
	            Bicicleta bicicleta = new Bicicleta(id, cliente, locadora, dataLocacao);
	            
				if (locadoraId == thisLocadoraId) {
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

	public List<Bicicleta> getAllByCliente(Long thisClienteId) {		
		List<Bicicleta> listaBicicletas = new ArrayList<>();
			
		String sql = "SELECT * from Bicicleta b, Locadora l, Cliente c where b.locadoraId = l.id and b.clienteId = c.id order by b.clienteId";
						
		try {
			Connection conn = this.getConnection();
	        Statement statement = conn.createStatement();
	            
	        ResultSet resultSet = statement.executeQuery(sql);
	        while (resultSet.next()){
            	Long id = resultSet.getLong("id");

				Long clienteId = resultSet.getLong("clienteId");
				Long locadoraId = resultSet.getLong("locadoraId");
				LocalDate dataLocacao = LocalDate.parse(resultSet.getString("dataLocacao"));

				// Build cliente object
				String clienteCpf = resultSet.getString("cpf");
				String clienteNome = resultSet.getString("c.nome");
				String clienteTelefone = resultSet.getString("c.telefone");
				String clienteSexo = resultSet.getString("c.sexo");
				LocalDate clienteDataDeNascimento = LocalDate.parse(resultSet.getString("c.dataDeNascimento"));
				Cliente cliente = new Cliente(clienteId, clienteCpf, clienteTelefone, clienteNome, clienteSexo, clienteDataDeNascimento);
				
				// Build locadora object
				String locadoraNome = resultSet.getString("l.nome");
				String locadoraDescricao = resultSet.getString("l.descricao");
				String locadoraCnpj = resultSet.getString("l.cnpj");
				String locadoraCidade = resultSet.getString("l.cidade");
	        	Locadora locadora = new Locadora(locadoraId, locadoraNome, locadoraDescricao, locadoraCnpj, locadoraCidade);

	            Bicicleta bicicleta = new Bicicleta(id, cliente, locadora, dataLocacao);
	            
				if (clienteId == thisClienteId) {
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
        String sql = "UPDATE Bicicleta SET clienteId = ?, locadoraId = ?, dataLocacao = ? WHERE id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, bicicleta.getCliente().getId_usuario());
            statement.setLong(2, bicicleta.getLocadora().getId_usuario());
			statement.setString(3, bicicleta.getDataLocacao().toString());
            statement.setLong(4, bicicleta.getId());
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

				Long clienteId = resultSet.getLong("clienteId");
				Long locadoraId = resultSet.getLong("locadoraId");
				LocalDate dataLocacao = LocalDate.parse(resultSet.getString("dataLocacao"));
    	
				Cliente cliente = new ClienteDAO().get(clienteId);
            	Locadora locadora = new LocadoraDAO().get(locadoraId);

            	bicicleta = new Bicicleta(id, cliente, locadora, dataLocacao);
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
