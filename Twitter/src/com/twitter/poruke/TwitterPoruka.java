package com.twitter.poruke;

/**
 * Klasa TwitterPoruka predstavlja status korisnika na drustvenoj mrezi Twitter.
 * Svaki twit se sastoji od korisnickog imena i poruke tj statusa koja/koji
 * je objavljen.
 * 
 * @author Marko Stevankovic
 *
 */

public class TwitterPoruka 
{
	/*
	 * Atribut koji predstavlja korisnicko ime, tj korisnika
	 * koji objavljuje status/poruku.
	 */
	private String korisnik;
	
	/*
	 * Atribut koji predstavlja samu poruku, tj. sadrzaj poruke/statusa
	 * koji se objavljuje.
	 */
	private String poruka;
	
	/*
	 * Metoda koja vraca naziv korisnickog naloga sa kog se objavljuje status/poruka
	 * 
	 * @return String
	 */
	public String getKorisnik() 
	{
		return korisnik;
	}
	
	/*
	 * Metoda koja postavlja naziv korisnickog naloga.
	 * 
	 * @param korisnik predstavlja naziv na koji se treba postaviti korisnicki nalog.
	 * 
	 * @throws RuntimeException ako je uneti parametar null ili prazan string
	 * 
	 */
	public void setKorisnik(String korisnik)
	{
		if (korisnik==null || korisnik == "")
			throw new RuntimeException("Ime korisnika mora biti uneto");
		
		this.korisnik = korisnik;
	}
	
	/*
	 * Metoda koja vraca sadrzaj objavljenje poruke/statusa
	 * 
	 * @return String
	 */
	public String getPoruka() 
	{
		return poruka;
	}
	
	/*
	 * Metoda koja postavlja sadrzaj statusa/poruke na zeljeni tekst.
	 * 
	 * @param poruka sadrzaj same poruke/statusa.
	 * 
	 * @throws RuntimeException ako je sadrzaj parametra null ili string duzine vece od 140 karaktera
	 */
	public void setPoruka(String poruka) 
	{
		if (poruka == null || poruka.length()>140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		
		this.poruka = poruka;
	}
	
	/*
	 * Redefinisana metoda toString() klase Object
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return "User: " + this.getKorisnik() + ", message: " + this.getPoruka();
	}
}
