package domain;

public class Bicicleta {
	private Long id;
	private Locadora locadora; 
	private String placa;
	private String modelo; 
	private String chassi; 
	private Integer ano;
	private Integer quilometragem;  
	private String descricao;
	private Float valor;  
	private String fotos;
	
	public Bicicleta(Long id) {
		this.id = id;  
	}
	
	public Bicicleta(Locadora locadora, String placa, String modelo, String chassi, Integer ano,
				Integer quilometragem, String descricao, Float valor, String fotos) {
		this.locadora = locadora;
		this.placa = placa;
		this.modelo = modelo;
		this.chassi = chassi;
		this.ano = ano;
		this.quilometragem = quilometragem;
		this.descricao = descricao;
		this.valor = valor;
		this.fotos = fotos;
	}
	
	public Bicicleta(Long id, Locadora locadora, String placa, String modelo, String chassi, Integer ano,
			Integer quilometragem, String descricao, Float valor, String fotos) {
		this(locadora,  placa, modelo, chassi, ano, quilometragem, descricao, valor, fotos);
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public Locadora getLocadora() {
		return locadora;
	}

	public void setLocadora(Locadora locadora) {
		this.locadora = locadora;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Integer quilometragem) {
		this.quilometragem = quilometragem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getFotos() {
		return fotos;
	}

	public void setFotos(String fotos) {
		this.fotos = fotos;
	}
}