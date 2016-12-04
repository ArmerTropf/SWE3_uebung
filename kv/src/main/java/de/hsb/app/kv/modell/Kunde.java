package de.hsb.app.kv.modell;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@NamedQuery(name="SelectKunden", query="Select k from Kunde k")
@Entity
public class Kunde implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Anrede anrede;
	
	@Size(min=3, max=30)
	private String vorname;
	@Size(min=3, max=30)
	private String nachname;
	
	@Past
	@Temporal(TemporalType.DATE)
	private Date geburtsdatum;
	
	@OneToOne(cascade = CascadeType.ALL)	
	private Kreditkarte kreditKarte;
	
	public Anrede getAnrede() {
		return anrede;
	}

	public void setAnrede(Anrede anrede) {
		this.anrede = anrede;
	}

	public Kunde()
	{
		super();
		this.kreditKarte = new Kreditkarte();
	}

	public Kunde(Anrede anrede, String vorname, String nachname, Date geburtsdatum, Kreditkarte karte) 
	{
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsdatum = geburtsdatum;
		this.anrede = anrede;
		this.kreditKarte = karte;
		
		
		
	}
	
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public Date getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	
	public Anrede[] getAnredeValues() 
	{
		return Anrede.values();
	}

	public Kreditkarte getKreditkarte() {
		return kreditKarte;
	}

	public void setKreditkarte(Kreditkarte kredit) {
		this.kreditKarte = kredit;
	}
	
	public Kreditkartentyp[] getKreditkartentypValues() 
	{
		return Kreditkartentyp.values();
	}
	
	


}
