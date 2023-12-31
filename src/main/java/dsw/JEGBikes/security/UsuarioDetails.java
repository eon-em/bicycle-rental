package dsw.JEGBikes.security;

import java.util.Arrays;
import java.util.Collection;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import dsw.JEGBikes.domain.Usuario;
 
@SuppressWarnings("serial")
public class UsuarioDetails implements UserDetails {
 
    private Usuario user;
     
    public UsuarioDetails(Usuario user) {
        this.user = user;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getPapel());
        return Arrays.asList(authority);
    }
 
    @Override
    public String getPassword() {
        return user.getSenha();
    }
    @Override
    public String getUsername() {
        return user.getEmail();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
    
	public Usuario getUsuario() {
		return user;
	}
    
}
