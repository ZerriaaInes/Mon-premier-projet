package com.projet.test.service;

import com.projet.test.model.Administrateur;

public interface IAdminstrateurService {
	public boolean ajouterAdministrateur(Administrateur admin);
	public Administrateur loadAdminByUsername(String login);

}
