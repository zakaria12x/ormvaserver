package com.ws.model;
// Generated 9 mai 2016 00:42:42 by Hibernate Tools 4.3.1.Final

/**
 * CommissionInventaire generated by hbm2java
 */
public class CommissionInventaire implements java.io.Serializable {

	private Integer idCommInventaire;
	private int chefCommission;
	private String login;
	private String password;

	public CommissionInventaire() {
	}

	public CommissionInventaire(int chefCommission, String login, String password) {
		this.chefCommission = chefCommission;
		this.login = login;
		this.password = password;
	}

	public Integer getIdCommInventaire() {
		return this.idCommInventaire;
	}

	public void setIdCommInventaire(Integer idCommInventaire) {
		this.idCommInventaire = idCommInventaire;
	}

	public int getChefCommission() {
		return this.chefCommission;
	}

	public void setChefCommission(int chefCommission) {
		this.chefCommission = chefCommission;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
