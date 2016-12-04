package de.hsb.app.kv.modell;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@NamedQuery(name="SelectKarten", query="Select k from Kreditkarte k")
@Entity
public class Kreditkarte implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private Kreditkartentyp typ;
	private String nummer;
	
	@Temporal(TemporalType.DATE)
	private Date gueltigBis;
	private String inhaber;

	public Kreditkarte()
	{
		super();
	}

	public Kreditkarte(Kreditkartentyp kartenTyp, String nummer, Date gueltigBis, String inhaber) 
	{
		super();
		this.typ = kartenTyp;
		this.nummer = nummer;
		this.gueltigBis = gueltigBis;
		this.inhaber = inhaber;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Kreditkartentyp getTyp() {
		return typ;
	}

	public void setTyp(Kreditkartentyp typ) {
		this.typ = typ;
	}

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	public Date getGueltigBis() {
		return gueltigBis;
	}

	public void setGueltigBis(Date gueltigBis) {
		this.gueltigBis = gueltigBis;
	}

	public String getInhaber() {
		return inhaber;
	}

	public void setInhaber(String inhaber) {
		this.inhaber = inhaber;
	}
	
	
	
}
