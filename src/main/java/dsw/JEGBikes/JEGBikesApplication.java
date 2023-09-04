package dsw.JEGBikes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import dsw.JEGBikes.dao.BicicletaDAO;
import dsw.JEGBikes.dao.ClienteDAO;
import dsw.JEGBikes.dao.LocadoraDAO;
import dsw.JEGBikes.dao.UsuarioDAO;
import dsw.JEGBikes.domain.Bicicleta;
import dsw.JEGBikes.domain.Cliente;
import dsw.JEGBikes.domain.Locadora;
import dsw.JEGBikes.domain.Usuario;

@SpringBootApplication
public class JEGBikesApplication {

	public static void main(String[] args) {
		SpringApplication.run(JEGBikesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BicicletaDAO bicicletaDAO, LocadoraDAO locadoraDAO, ClienteDAO clienteDAO, UsuarioDAO usuarioDAO, BCryptPasswordEncoder encoder) {
		return (args) -> {
			
			//Usuarios
			Usuario u2 = new Usuario();
			u2.setEmail("admin");
			u2.setPapel("ADMIN");
			u2.setSenha(encoder.encode("admin"));
			usuarioDAO.save(u2);
			
			//Locadoras
			Locadora l1 = new Locadora();
			l1.setEmail("loc1@gmail.com");
			l1.setPapel("LOCADORA");
			l1.setSenha(encoder.encode("123"));
			l1.setNome("locadora1");
			l1.setDescricao("Descrição 1");
			l1.setCnpj("1234589");
			l1.setCidade("Sao Paulo");
			locadoraDAO.save(l1);
			
			Locadora l2 = new Locadora();
			l2.setEmail("loc2@gmail.com");
			l2.setPapel("LOCADORA");
			l2.setSenha(encoder.encode("123"));
			l2.setNome("locadora1");
			l2.setDescricao("Descrição 2");
			l2.setCnpj("1234");
			l2.setCidade("Rio de Janeiro");
			locadoraDAO.save(l2);
			
			Locadora l3 = new Locadora();
			l3.setEmail("loc3@gmail.com");
			l3.setPapel("LOCADORA");
			l3.setSenha(encoder.encode("123"));
			l3.setNome("locadora3");
			l3.setDescricao("Descrição 3");
			l3.setCnpj("1234588");
			l3.setCidade("Sao Paulo");
			locadoraDAO.save(l3);
			
			Locadora l4 = new Locadora();
			l4.setEmail("loc4@gmail.com");
			l4.setPapel("LOCADORA");
			l4.setSenha(encoder.encode("123"));
			l4.setNome("locadora4");
			l4.setDescricao("Descrição 4");
			l4.setCnpj("12344321");
			l4.setCidade("Belem");
			locadoraDAO.save(l4);
			
			//Clientes
			Cliente cl1 = new Cliente();
			cl1.setEmail("cliente1@gmail.com");
			cl1.setPapel("CLIENTE");
			cl1.setSenha(encoder.encode("123"));
			cl1.setCpf("124564564");
			cl1.setDataDeNascimento(LocalDate.parse("2000-02-01"));
			cl1.setNome("Cliente 1");
			cl1.setSexo("M");
			cl1.setTelefone("123-5888");
			clienteDAO.save(cl1);
			
			Cliente cl2 = new Cliente();
			cl2.setEmail("cliente2@gmail.com");
			cl2.setPapel("CLIENTE");
			cl2.setSenha(encoder.encode("123"));
			cl2.setCpf("1245645");
			cl2.setDataDeNascimento(LocalDate.parse("2000-02-02"));
			cl2.setNome("Cliente 2");
			cl2.setSexo("M");
			cl2.setTelefone("123-5998");
			clienteDAO.save(cl2);
			
			Cliente cl3 = new Cliente();
			cl3.setEmail("cliente3@gmail.com");
			cl3.setPapel("CLIENTE");
			cl3.setSenha(encoder.encode("123"));
			cl3.setCpf("1245");
			cl3.setDataDeNascimento(LocalDate.parse("2000-02-03"));
			cl3.setNome("Cliente 3");
			cl3.setSexo("M");
			cl3.setTelefone("123-5778");
			clienteDAO.save(cl3);

			//Bicicletas
			Bicicleta b1 = new Bicicleta();
			b1.setLocadora(l1);
			b1.setCliente(cl1);
			b1.setDataLocacao(LocalDateTime.parse("2023-07-28T14:30:00"));
			
			bicicletaDAO.save(b1);
			
			Bicicleta b2 = new Bicicleta();
			b2.setLocadora(l2);
			b2.setCliente(cl1);
			b2.setDataLocacao(LocalDateTime.parse("2023-07-25T15:30:00"));

			bicicletaDAO.save(b2);
			
			Bicicleta b3 = new Bicicleta();
			b3.setLocadora(l3);
			b3.setCliente(cl2);
			b3.setDataLocacao(LocalDateTime.parse("2023-07-15T15:30:00"));
			bicicletaDAO.save(b3);
	};
	
	}
	
}
