package de.hsb.app.kv.controller;

import java.util.GregorianCalendar;

import de.hsb.app.kv.modell.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@ManagedBean(name = "kundenHandler")
@SessionScoped
public class KundenHandler 
{
	private DataModel<Kunde> kunden;
	public DataModel<Kunde> getKunden() {
		return kunden;
	}

	public void setKunden(DataModel<Kunde> kunden) {
		this.kunden = kunden;
	}
	
	private DataModel<Kreditkarte> karten;
	public DataModel<Kreditkarte> getKreditkarten() {
		return karten;
	}

	public void setKreditkarten(DataModel<Kreditkarte> karten) {
		this.karten = karten;
	}

	private Kunde merkeKunde = new Kunde();
	public Kunde getMerkeKunde() {
		return merkeKunde;
	}
	
	public void setMerkeKunde(Kunde merkeKunde) {
		this.merkeKunde = merkeKunde;
	}
	
	private Kreditkarte merkeKreditkarte;
	public Kreditkarte getMerkeKreditkarte() {
		return merkeKreditkarte;
	}

	public void setMerkeKreditkarte(Kreditkarte merkeKreditkarte) {
		this.merkeKreditkarte = merkeKreditkarte;
	}

	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction utx;

	public KundenHandler()
	{
		
	}

//	public String neu(Kunde k) {
//
//		System.out.println(k.getVorname() + k.getNachname() + k.getGeburtsdatum() );
//		// an dieser Stelle spaeter Kunden hinzufuegen???
//		//new Kunde("Hugo", "Hermannddpokfdsokfpofk", LocalDate.of(1970, 01, 01))
//		return "alleKunden";
//		}
	@PostConstruct
	public void init() 
	{
		try {
			utx.begin();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		em.persist(new Kunde(Anrede.HERR, "Hugo", "Hermann", new GregorianCalendar(2014,05,01).getTime(),new Kreditkarte(Kreditkartentyp.MASTER,"1234",new GregorianCalendar(2014,05,01).getTime(),"Ich")));				// ergaenzen Sie die anderen Kunden ...em.persist(new Kunde("Hugo", "Hermann", new GregorianCalendar(2014,05,01).getTime()));				// ergaenzen Sie die anderen Kunden ...
		em.persist(new Kunde(Anrede.HERR, "Hugo", "Hermann", new GregorianCalendar(2014,05,01).getTime(),new Kreditkarte()));				// ergaenzen Sie die anderen Kunden ...em.persist(new Kunde("Hugo", "Hermann", new GregorianCalendar(2014,05,01).getTime()));				// ergaenzen Sie die anderen Kunden ...	
		em.persist(new Kunde(Anrede.HERR,"Willi", "Meier", new GregorianCalendar(1960, 2, 2).getTime(),new Kreditkarte()));
		em.persist(new Kunde(Anrede.HERR,"Alan", "Turing", new GregorianCalendar(1912, 6, 23).getTime(),new Kreditkarte()));
		em.persist(new Kunde(Anrede.HERR,"Donald", "Knuth", new GregorianCalendar(1938, 01, 10).getTime(),new Kreditkarte()));
		em.persist(new Kunde(Anrede.HERR,"Edsger W.", "Dijkstra", new GregorianCalendar(1930, 5, 11).getTime(),new Kreditkarte()));
		
		kunden = new ListDataModel<Kunde>();
		kunden.setWrappedData(em.createNamedQuery("SelectKunden").getResultList());
		
		karten = new ListDataModel<Kreditkarte>();
		karten.setWrappedData(em.createNamedQuery("SelectKarten").getResultList());
		
		try {
			utx.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("INIT");
	}
	
	public String neu() 
	{
		merkeKunde = new Kunde();
		return "neuerKunde";
	}
	
	public String speichern() 
	{
			
		try {
			utx.begin();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		merkeKunde = em.merge(merkeKunde);
		em.persist(merkeKunde);
		kunden.setWrappedData(em.createNamedQuery("SelectKunden").getResultList());
		
		try {
			utx.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "alleKunden";
	}
	
	public String delete() 
	{
		merkeKunde = kunden.getRowData();
		// -> Transaktionsbeginn
		try {
			utx.begin();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		merkeKunde = em.merge(merkeKunde);
		em.remove(merkeKunde);
		kunden.setWrappedData(em.createNamedQuery("SelectKunden").getResultList());

		// -> Transaktionsende
		try {
			utx.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("dRINNE");
		return "alleKunden";
	}
	

	public String edit() 
	{
		
		merkeKunde = kunden.getRowData();
		return "neuerKunde";
	}
	
	public Anrede[] getAnredeValues() 
	{
		return Anrede.values();
	}

	public String editKreditkarte() 
	{
		merkeKunde = kunden.getRowData();
		merkeKreditkarte = merkeKunde.getKreditkarte();
		//merkeKreditkarte = karten.getRowData();
		return "kreditKarte";
	}
	
	public Kreditkartentyp[] getKreditkarteValues() 
	{
		return Kreditkartentyp.values();
	}
	
	public String abbrechen()
	{
		System.out.println("Abbrechen");
		return "alleKunden";
	}
	
	public String kreditkarteSpeichern() 
	{
		merkeKunde.setKreditkarte(merkeKreditkarte);
		
		try {
			utx.begin();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		merkeKunde = em.merge(merkeKunde);
		merkeKreditkarte = em.merge(merkeKreditkarte);
		
		em.persist(merkeKunde);
		em.persist(merkeKreditkarte);
		
		kunden.setWrappedData(em.createNamedQuery("SelectKunden").getResultList());
		karten.setWrappedData(em.createNamedQuery("SelectKarten").getResultList());
		
		try {
			utx.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Speichern");
		return "alleKunden";
	}
}
