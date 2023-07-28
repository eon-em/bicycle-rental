package br.ufscar.dc.dsw.JEGBicycles;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.JEGBicycles.dao.BicicletaDAO;
import br.ufscar.dc.dsw.JEGBicycles.dao.ClienteDAO;
import br.ufscar.dc.dsw.JEGBicycles.dao.LocadoraDAO;
import br.ufscar.dc.dsw.JEGBicycles.dao.UsuarioDAO;
import br.ufscar.dc.dsw.JEGBicycles.domain.Bicicleta;
import br.ufscar.dc.dsw.JEGBicycles.domain.Cliente;
import br.ufscar.dc.dsw.JEGBicycles.domain.Locadora;
import br.ufscar.dc.dsw.JEGBicycles.domain.Usuario;

@SpringBootApplication
public class JegBicyclesApplication {

	public static void main(String[] args) {
		SpringApplication.run(JegBicyclesApplication.class, args);
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
			l1.setEmail("loja 1");
			l1.setPapel("LOJA");
			l1.setSenha(encoder.encode("123"));
			l1.setNome("loja1");
			l1.setDescricao("Descrição 1");
			l1.setCnpj("1234589");
			locadoraDAO.save(l1);
			
			Locadora l2 = new Locadora();
			l2.setEmail("loja 2");
			l2.setPapel("LOJA");
			l2.setSenha(encoder.encode("123"));
			l2.setNome("loja2");
			l2.setDescricao("Descrição 2");
			l2.setCnpj("1234");
			locadoraDAO.save(l2);
			
			Locadora l3 = new Locadora();
			l3.setEmail("loja 3");
			l3.setPapel("LOJA");
			l3.setSenha(encoder.encode("123"));
			l3.setNome("loja3");
			l3.setDescricao("Descrição 3");
			l3.setCnpj("1234588");
			locadoraDAO.save(l3);
			
			Locadora l4 = new Locadora();
			l4.setEmail("loja 4");
			l4.setPapel("LOJA");
			l4.setSenha(encoder.encode("123"));
			l4.setNome("loja4");
			l4.setDescricao("Descrição 4");
			l4.setCnpj("1234588");
			locadoraDAO.save(l3);
			
			//Bicicletas
			Bicicleta c1 = new Bicicleta();
			c1.setLocadora(l1);
			c1.setPlaca("Placa 1");
			c1.setModelo("Modelo 1");
			c1.setChassi("asdasda");
			c1.setAno(2020);
			c1.setQuilometragem(200);
			c1.setDescricao("Descrição 1");
			c1.setValor(BigDecimal.valueOf(200000));
			c1.setFotos("-");
			bicicletaDAO.save(c1);
			
			Bicicleta c2 = new Bicicleta();
			c2.setLocadora(l2);
			c2.setPlaca("Placa 2");
			c2.setModelo("Modelo 2");
			c2.setChassi("asdasd");
			c2.setAno(2000);
			c2.setQuilometragem(200);
			c2.setDescricao("Descrição 2");
			c2.setValor(BigDecimal.valueOf(200000));
			c2.setFotos("-");
			bicicletaDAO.save(c2);
			
			Bicicleta c3 = new Bicicleta();
			c3.setLocadora(l3);
			c3.setPlaca("Placa 3");
			c3.setModelo("Modelo 3");
			c3.setChassi("asdddddddd");
			c3.setAno(2355);
			c3.setQuilometragem(200);
			c3.setDescricao("Descrição 3");
			c3.setValor(BigDecimal.valueOf(20));
			c3.setFotos("-");
			bicicletaDAO.save(c3);
			
			//Clientes
			Cliente cl1 = new Cliente();
			cl1.setEmail("cliente1");
			cl1.setPapel("CLIENTE");
			cl1.setSenha(encoder.encode("123"));
			cl1.setCpf("124564564");
			cl1.setDataDeNascimento(LocalDate.parse("2000-02-01"));
			cl1.setNome("Cliente 1");
			cl1.setSexo("M");
			cl1.setTelefone("123-5888");
			clienteDAO.save(cl1);
			
			Cliente cl2 = new Cliente();
			cl2.setEmail("cliente2");
			cl2.setPapel("CLIENTE");
			cl2.setSenha(encoder.encode("123"));
			cl2.setCpf("1245645");
			cl2.setDataDeNascimento(LocalDate.parse("2000-02-02"));
			cl2.setNome("Cliente 2");
			cl2.setSexo("M");
			cl2.setTelefone("123-5998");
			clienteDAO.save(cl2);
			
			Cliente cl3 = new Cliente();
			cl3.setEmail("cliente3");
			cl3.setPapel("CLIENTE");
			cl3.setSenha(encoder.encode("123"));
			cl3.setCpf("1245");
			cl3.setDataDeNascimento(LocalDate.parse("2000-02-03"));
			cl3.setNome("Cliente 3");
			cl3.setSexo("M");
			cl3.setTelefone("123-5778");
			clienteDAO.save(cl3);
	};
	
	}
	
}

