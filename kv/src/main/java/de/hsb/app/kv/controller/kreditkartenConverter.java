package de.hsb.app.kv.controller;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "kreditkartenConverter")
public class kreditkartenConverter implements javax.faces.convert.Converter
{
	
	public Object getAsObject(FacesContext context,	UIComponent component, String value) 
	{
		if (value == null) return null;
			String s = value;
		
		if (value.contains(" "))
			s = value.replace(" ",""); 	// Leerzeichen entfernen
		if (value.contains("-"))
			s = value.replace("-", ""); // Trennstrich entfernen
		
		return s;
	}
			
	public String getAsString(FacesContext context, UIComponent component, Object value) 
	{
		return (String)value;
	}

}
