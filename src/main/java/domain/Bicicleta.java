package domain;

import java.time.LocalDate;

public class Bicicleta {
	private Long id;
	private Cliente cliente;
	private Locadora locadora;
	private LocalDate dataLocacao;

	public Bicicleta(Long id) {
		this.id = id; 
	}
	
	public Bicicleta(Cliente cliente, Locadora locadora, LocalDate dataLocacao) {
		this.cliente = cliente;
		this.locadora = locadora;
		this.dataLocacao = dataLocacao;
	}
	
	public Bicicleta(Long id, Cliente cliente, Locadora locadora, LocalDate dataLocacao) {
		this(cliente, locadora, dataLocacao);
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Locadora getLocadora() {
		return locadora;
	}

	public void setLocadora(Locadora locadora) {
		this.locadora = locadora;
	}

	public LocalDate getDataLocacao() {
		return dataLocacao;
	}

	public void setLocalDate(LocalDate dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
}