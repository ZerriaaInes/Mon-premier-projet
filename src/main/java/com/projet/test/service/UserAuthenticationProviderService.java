
package com.projet.test.service;
import com.projet.test.model.Administrateur;

/**
 * Provides processing service to set user authentication session
 * 
 * @author Arthur Vin
 */
public interface UserAuthenticationProviderService {

	/**
	 * Process user authentication
	 * 
	 * @param user
	 * @return
	 */
	boolean processUserAuthentication(Administrateur admin);
}
