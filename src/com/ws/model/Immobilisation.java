package com.ws.model;
// Generated 9 mai 2016 10:07:28 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Immobilisation generated by hbm2java
 */
public class Immobilisation implements java.io.Serializable {

	public Integer idImmobilisation;
	private SousFamille sousFamille;
	private String designation;
	private String reference;
	private Date dateAcquisition;
	private Date dateMiseEnService;
	private String codeABarre;
	private String etat;
	private String commentaire;
	private Set<Affectation> affectations = new HashSet<Affectation>(0);

	public Immobilisation() {
	}

	public Immobilisation(SousFamille sousFamille, String designation, String reference, Date dateAcquisition,
			Date dateMiseEnService, String codeABarre, String etat) {
		this.sousFamille = sousFamille;
		this.designation = designation;
		this.reference = reference;
		this.dateAcquisition = dateAcquisition;
		this.dateMiseEnService = dateMiseEnService;
		this.codeABarre = codeABarre;
		this.etat = etat;
	}

	public Immobilisation(SousFamille sousFamille, String designation, String reference, Date dateAcquisition,
			Date dateMiseEnService, String codeABarre, String etat, Set<Affectation> affectations) {
		this.sousFamille = sousFamille;
		this.designation = designation;
		this.reference = reference;
		this.dateAcquisition = dateAcquisition;
		this.dateMiseEnService = dateMiseEnService;
		this.codeABarre = codeABarre;
		this.etat = etat;
		this.affectations = affectations;
	}

	public Integer getIdImmobilisation() {
		return this.idImmobilisation;
	}

	public void setIdImmobilisation(Integer idImmobilisation) {
		this.idImmobilisation = idImmobilisation;
	}

	public SousFamille getSousFamille() {
		return this.sousFamille;
	}

	public void setSousFamille(SousFamille sousFamille) {
		this.sousFamille = sousFamille;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getDateAcquisition() {
		return this.dateAcquisition;
	}

	public void setDateAcquisition(Date dateAcquisition) {
		this.dateAcquisition = dateAcquisition;
	}

	public Date getDateMiseEnService() {
		return this.dateMiseEnService;
	}

	public void setDateMiseEnService(Date dateMiseEnService) {
		this.dateMiseEnService = dateMiseEnService;
	}

	public String getCodeABarre() {
		return this.codeABarre;
	}

	public void setCodeABarre(String codeABarre) {
		this.codeABarre = codeABarre;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Set<Affectation> getAffectations() {
		return this.affectations;
	}

	public void setAffectations(Set<Affectation> affectations) {
		this.affectations = affectations;
	}
	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

}