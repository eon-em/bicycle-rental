package br.ufscar.dc.dsw.JEGBicycles.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.ufscar.dc.dsw.JEGBicycles.validation.UniqueCNPJ;

@SuppressWarnings("serial")
@Entity
@Table(name = "Locadora")
public class Locadora extends Usuario{
	
	@NotNull(message = "Campo obrigatório.")
	@Column(nullable = false, length = 19)
	private String nome;
	@NotNull(message = "Campo obrigatório.")
	@Column(nullable = false, length = 64)
	private String descricao;
	@NotNull(message = "Campo obrigatório.")
	@UniqueCNPJ(message = "CNPJ já cadastrado.")
	@Column(nullable = false, length = 19, unique = true)
	private String cnpj;
	@NotNull(message = "Campo obrigatório.")
	@Column(nullable = false, length = 19)
	private String cidade;
	@OneToMany(mappedBy ="locadora", cascade = CascadeType.REMOVE)
	private List<Bicicleta> bicicletas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}