package br.ufscar.dc.dsw.JEGBicycles.domain;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.ufscar.dc.dsw.JEGBicycles.validation.UniqueDateTime;

@SuppressWarnings("serial")
@Entity
@Table(name = "Bicicleta")
public class Bicicleta extends AbstractEntity<Long>{
	
	@NotNull(message = "Selecione uma locadora.")
	@ManyToOne
	@JoinColumn(name = "id_locadora")
	private Locadora locadora;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	@NotNull(message = "Campo obrigatório.")
	@Column(nullable = false, length = 80)
	@UniqueDateTime(message = "Data de locação já em uso.")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dataLocacao;

	public Locadora getLocadora() {
		return locadora;
	}

	public void setLocadora(Locadora locadora) {
		this.locadora = locadora;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(LocalDateTime dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
}