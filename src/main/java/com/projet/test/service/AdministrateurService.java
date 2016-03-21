package com.projet.test.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.projet.test.dao.IAdministrateurDAO;
import com.projet.test.model.Administrateur;

@Transactional
public class AdministrateurService implements IAdminstrateurService, UserDetailsService {
	private IAdministrateurDAO admindao;
	@Override
	public boolean ajouterAdministrateur(Administrateur admin) {
		
		if (!admindao.checkAvailable(admin.getLogin())) {

			return false;
		}
		 admindao.ajouterAdministrateur(admin);
		
		return true;

	}
	public void setAdmindao(IAdministrateurDAO admindao) {
		this.admindao = admindao;
	}
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
     Administrateur admin = admindao.loadUserByUserName(login);
		
		if (admin == null) {
			throw new UsernameNotFoundException(String.format(getMessageBundle().getString("badCredentials"), login));
		}
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		User userDetails=new User(admin.getLogin(), admin.getPassword(), authorities);

		
		return userDetails;

	}
	protected ResourceBundle getMessageBundle() {
		return ResourceBundle.getBundle("message-labels");
	}
	@Override
	public Administrateur loadAdminByUsername(String login) {
		// TODO Auto-generated method stub
		return admindao.loadUserByUserName(login);

	}

	
	
	

}
