package com.projet.test.dao;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.util.Assert;

import com.projet.test.model.Administrateur;

public class AdministrateurDaoImpl implements IAdministrateurDAO{

	@PersistenceContext
	private EntityManager em;

	@Override
	public void ajouterAdministrateur(Administrateur admin) {
		
		 em.persist(admin);
	}

	@Override
	public boolean checkAvailable(String login) {
		Assert.notNull(login);
		Query req = em.createQuery("select count(*) from Administrateur u where u.login = :x");
		req.setParameter("x", login);
		Long count = (Long) req.getSingleResult();
		
		return count < 1;


	}

	@Override
	public Administrateur loadUserByUserName(String login) {
		Administrateur admin=null;
		Query req=em.createQuery("select a from Administrateur a where a.login = :x");
		req.setParameter("x", login);
		try {
			admin=(Administrateur) req.getSingleResult();
		} catch(NoResultException e) {
			
		}

		
		return admin;

	}

}
