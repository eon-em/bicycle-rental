package dsw.JEGBikes.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "Bicicleta")
public class Bicicleta extends AbstractEntity<Long>{
	
	@NotNull(message = "Selecione uma locadora.")
	@ManyToOne
	@JoinColumn(name = "id_locadora")
	private Locadora locadora;
	@NotBlank(message = "Campo obrigatório.")
	@Column(nullable = false, length = 19)
	private String placa;
	@NotBlank(message = "Campo obrigatório.")
	@Column(nullable = false, length = 19)
	private String modelo; 
	@NotBlank(message = "Campo obrigatório.")
	@Column(nullable = false, length = 19)
	private String chassi; 
	@NotNull(message = "Selecione o ano.")
	@Column(nullable = false, length = 19)
	private Integer ano;
	@NotNull(message = "Selecione a quilometragem.")
	@Column(nullable = false, length = 19)
	private Integer quilometragem;  
	@NotBlank(message = "Campo obrigatório.")
	@Column(nullable = false, length = 19)
	private String descricao;
	@NotNull(message = "Campo obrigatório.")
	@Column(columnDefinition = "DECIMAL(8,2) DEFAULT 0.0")
	private BigDecimal valor;  
	@Column(nullable = false, length = 19)
	private String fotos;
	
	

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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getFotos() {
		return fotos;
	}

	public void setFotos(String fotos) {
		this.fotos = fotos;
	}
}