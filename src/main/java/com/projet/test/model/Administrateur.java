package com.projet.test.model;

import java.io.Serializable;


import javax.persistence.*;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

@Entity
public class Administrateur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAdministrateur;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	public Long getIdAdministrateur() {
		return idAdministrateur;
	}
	public void setIdAdministrateur(Long idAdministrateur) {
		this.idAdministrateur = idAdministrateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Administrateur() {
		super();
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		PasswordEncoder crypto = new Md5PasswordEncoder();
		this.password = crypto.encodePassword(password, null);

	}
	public Administrateur(String nom, String prenom, String login, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}
	
}
