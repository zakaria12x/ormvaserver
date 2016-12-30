package com.ws.model;
// Generated 9 mai 2016 10:07:28 by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * AffectationId generated by hbm2java
 */
public class AffectationId implements java.io.Serializable {

	private int idImmobilisation;
	private int idBureauSource;
	private int idBureauDestination;
	private Date dateAffectation;

	public AffectationId() {
	}

	public AffectationId(int idImmobilisation, int idBureauSource, int idBureauDestination, Date dateAffectation) {
		this.idImmobilisation = idImmobilisation;
		this.idBureauSource = idBureauSource;
		this.idBureauDestination = idBureauDestination;
		this.dateAffectation = dateAffectation;
	}

	public int getIdImmobilisation() {
		return this.idImmobilisation;
	}

	public void setIdImmobilisation(int idImmobilisation) {
		this.idImmobilisation = idImmobilisation;
	}

	public int getIdBureauSource() {
		return this.idBureauSource;
	}

	public void setIdBureauSource(int idBureauSource) {
		this.idBureauSource = idBureauSource;
	}

	public int getIdBureauDestination() {
		return this.idBureauDestination;
	}

	public void setIdBureauDestination(int idBureauDestination) {
		this.idBureauDestination = idBureauDestination;
	}

	public Date getDateAffectation() {
		return this.dateAffectation;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AffectationId))
			return false;
		AffectationId castOther = (AffectationId) other;

		return (this.getIdImmobilisation() == castOther.getIdImmobilisation())
				&& (this.getIdBureauSource() == castOther.getIdBureauSource())
				&& (this.getIdBureauDestination() == castOther.getIdBureauDestination())
				&& ((this.getDateAffectation() == castOther.getDateAffectation())
						|| (this.getDateAffectation() != null && castOther.getDateAffectation() != null
								&& this.getDateAffectation().equals(castOther.getDateAffectation())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdImmobilisation();
		result = 37 * result + this.getIdBureauSource();
		result = 37 * result + this.getIdBureauDestination();
		result = 37 * result + (getDateAffectation() == null ? 0 : this.getDateAffectation().hashCode());
		return result;
	}

}
