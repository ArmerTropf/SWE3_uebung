package de.hsb.app.kv.modell;

public enum Anrede {
	
	HERR ("Herr"), FRAU ("Frau"), FIRMA ("Firma");
	private final String label;
	// privater Konstruktor
	private Anrede(String label) 
	{
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
}
