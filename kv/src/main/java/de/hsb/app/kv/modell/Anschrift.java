package de.hsb.app.kv.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Anschrift 
{
	@Id @GeneratedValue
	private Integer id;
	
	@Size(min=3, max=30)
	private String strasse;
	
	private String plz;
	
	@Size(min=3, max=30)
	private String ort;
	
	
	public String getStrasse() {
		return strasse;
	}


	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}


	public String getPlz() {
		return plz;
	}


	public void setPlz(String plz) {
		this.plz = plz;
	}


	public String getOrt() {
		return ort;
	}


	public void setOrt(String ort) {
		this.ort = ort;
	}


	public Anschrift()
	{
		
	}
	
	
	

}
