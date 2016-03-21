
package com.projet.test.service;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.test.model.Administrateur;

/**
 * Provides processing service to set user authentication session
 * 
 * @author Arthur Vin
 */

@Transactional
public class UserAuthenticationProviderServiceImpl implements UserAuthenticationProviderService{

	private AuthenticationManager authenticationManager;

	@Override
	public boolean processUserAuthentication(Administrateur admin) {
		
			
			try {
				Authentication request = new UsernamePasswordAuthenticationToken(admin.getLogin(),admin.getPassword());
				Authentication result = authenticationManager.authenticate(request);
				SecurityContextHolder.getContext().setAuthentication(result);
				
				return true;
			} catch(AuthenticationException e) {
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Sorry!"));
				
				return false;
			}
		}

		public AuthenticationManager getAuthenticationManager() {
			return authenticationManager;
		}

		public void setAuthenticationManager(AuthenticationManager authenticationManager) {
			this.authenticationManager = authenticationManager;
		}

	}
	
	

	

	


