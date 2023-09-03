package dsw.RCVeiculos.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import dsw.RCVeiculos.validation.UniqueCPF;
import dsw.RCVeiculos.validation.UniqueEMAIL;

@SuppressWarnings("serial")
@Entity
@Table(name = "Cliente")
public class Cliente extends Usuario{
	
	@NotNull(message = "Campo obrigatório.")
	@Column(nullable = false, length = 19)
	private String nome;
	@NotNull(message = "Campo obrigatório.")
	@UniqueCPF(message = "CPF já cadastrado.")
	@Column(nullable = false, length = 19,unique = true)
	private String cpf;
	@NotNull(message = "Campo obrigatório.")
	@Column(nullable = false, length = 19)
	private String telefone;
	@NotNull(message = "Campo obrigatório.")
	@Column(nullable = false, length = 19)
	private String sexo;
	@NotNull(message = "Campo obrigatório.")
	@Column(nullable = false, length = 30)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDeNascimento;
	@OneToMany(mappedBy ="cliente", cascade = CascadeType.REMOVE)

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
}
