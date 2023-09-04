package dsw.JEGBikes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import dsw.JEGBikes.dao.UsuarioDAO;
import dsw.JEGBikes.domain.Usuario;
 
public class UsuarioDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UsuarioDAO dao;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Usuario user = dao.getUserByUsername(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new UsuarioDetails(user);
    }
 
}