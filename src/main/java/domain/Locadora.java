package domain;

public class Locadora {
	private Long id_usuario;
	private String nome;
	private String descricao;
	private String cnpj;
	private String cidade;
	
	
	public Locadora(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public Locadora(Long id_usuario, String nome, String descricao, String cnpj, String cidade) {
		this.nome = nome;
		this.id_usuario = id_usuario;
		this.descricao = descricao;
		this.cnpj = cnpj;
		this.cidade = cidade;
	}
	
	public Locadora( String nome, String descricao, String cnpj, String cidade) {
		this.nome = nome;
		this.descricao = descricao;
		this.cnpj = cnpj;
		this.cidade = cidade;
	}


	public Long getId_usuario() {
		return id_usuario;
	}

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
