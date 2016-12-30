package com.ws.model;
// Generated 9 mai 2016 10:07:28 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Bureau generated by hbm2java
 */
public class Bureau implements java.io.Serializable {

	private Integer idBureau;
	private Service service;
	private Set<Affectation> affectationsForIdBureauDestination = new HashSet<Affectation>(0);
	private Set<Affectation> affectationsForIdBureauSource = new HashSet<Affectation>(0);

	public Bureau() {
	}

	public Bureau(Service service) {
		this.service = service;
	}

	public Bureau(Service service, Set<Affectation> affectationsForIdBureauDestination,
			Set<Affectation> affectationsForIdBureauSource) {
		this.service = service;
		this.affectationsForIdBureauDestination = affectationsForIdBureauDestination;
		this.affectationsForIdBureauSource = affectationsForIdBureauSource;
	}

	public Integer getIdBureau() {
		return this.idBureau;
	}

	public void setIdBureau(Integer idBureau) {
		this.idBureau = idBureau;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Set<Affectation> getAffectationsForIdBureauDestination() {
		return this.affectationsForIdBureauDestination;
	}

	public void setAffectationsForIdBureauDestination(Set<Affectation> affectationsForIdBureauDestination) {
		this.affectationsForIdBureauDestination = affectationsForIdBureauDestination;
	}

	public Set<Affectation> getAffectationsForIdBureauSource() {
		return this.affectationsForIdBureauSource;
	}

	public void setAffectationsForIdBureauSource(Set<Affectation> affectationsForIdBureauSource) {
		this.affectationsForIdBureauSource = affectationsForIdBureauSource;
	}

}
