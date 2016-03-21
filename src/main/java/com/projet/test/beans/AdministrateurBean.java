package com.projet.test.beans;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.projet.test.model.Administrateur;
import com.projet.test.service.IAdminstrateurService;
import com.projet.test.service.UserAuthenticationProviderService;

@ManagedBean(name="adminMB")
@SessionScoped
public class AdministrateurBean {

    @Autowired
    UserAuthenticationProviderService authenticationProviderService;

	@Autowired
	private transient IAdminstrateurService adminService;
	
	private transient Administrateur administrateur=new Administrateur();

	public Administrateur getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	public IAdminstrateurService getAdminService() {
		return adminService;
	}

	public void setAdminService(IAdminstrateurService adminService) {
		this.adminService = adminService;
	}
	
	public void doAjoutAdministrateur()
	{
		adminService.ajouterAdministrateur(administrateur);
	}
	
	public void doAuthentificate()throws IOException
	{
		if(!authenticationProviderService.processUserAuthentication(administrateur))
	{
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password incorrect!!!", "Sorry"));

		}
		else
		FacesContext.getCurrentInstance().getExternalContext().redirect("home.jsf");	}

	{
		
	}

}
