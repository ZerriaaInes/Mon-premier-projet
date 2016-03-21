package com.projet.test.dao;


import com.projet.test.model.Administrateur;


public interface IAdministrateurDAO {

	public void ajouterAdministrateur(Administrateur admin);
	boolean checkAvailable(String userName);
	Administrateur loadUserByUserName(String login);

}
