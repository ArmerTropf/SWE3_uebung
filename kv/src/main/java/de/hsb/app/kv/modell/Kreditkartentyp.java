package de.hsb.app.kv.modell;

public enum Kreditkartentyp 
{
	MASTER ("MasterCard"), VISA ("Visa"), AMEX ("AMerican Express");
	private final String karte;
	// privater Konstruktor
	private Kreditkartentyp(String karte) 
	{
		this.karte = karte;
	}
	
	public String getKarte() {
		return karte;
	}
	

}
