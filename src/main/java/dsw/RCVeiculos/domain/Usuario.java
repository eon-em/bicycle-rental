package dsw.RCVeiculos.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import dsw.RCVeiculos.validation.UniqueEMAIL;
import dsw.RCVeiculos.validation.UniqueEMAILUS;

@SuppressWarnings("serial")
@Entity
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends AbstractEntity<Long> {
	
	@NotNull(message = "Campo obrigatório.")
	@UniqueEMAILUS(message = "E-mail já cadastrado.")
	@Column(nullable = false, unique = true, length = 80)
	private String email;
	
	@NotNull(message = "Campo obrigatório.")
	@Column(nullable = false, length = 64)
	private String senha;
	
	@NotNull(message = "Campo obrigatório.")
	@Column(nullable = false, length = 19)
	private String papel;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String password) {
		this.senha = password;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}
}
