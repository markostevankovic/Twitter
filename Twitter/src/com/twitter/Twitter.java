package com.twitter;

import java.util.LinkedList;

import com.twitter.poruke.TwitterPoruka;

/**
 * Klasa Twitter predstavlja skup twitova, tacnije skup TwitterPoruka.
 * Omogucava dodavanje novog twitta ili citanje postojecih twittova.
 * 
 * @author Marko Stevankovic
 *
 */

public class Twitter 
{
		/*
		 *  Atribut poruke predstavlja listu twittova tj TwitterPoruka
		 */
		private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
		
		/*
		 *  Metod koji vraca sve poruke tj sve do sada unesene twittove
		 * 
		 *  @return LinkedList<TwitterPoruka>
		 * 									lista dosadasnjih twittova
		 */
		public LinkedList<TwitterPoruka> vratiSvePoruke()
		{
			return poruke;
		}
		
		/*
		 * Metod koji na osnovu unetih parameta kreira novu TwitterPoruku
		 * i unosi je u listu i to tako da je unosi na kraj liste.
		 * 
		 * @param korisnik
		 * 				Naziv korisnika tj. njegov username
		 * @param poruka
		 * 				Zeljena sadrzina poruke tj. twitta tj. statusa
		 */
		public void unesi(String korisnik, String poruka) 
		{
			// Pravi se nova poruka i puni podacima.
			TwitterPoruka tp = new TwitterPoruka();
			
			tp.setKorisnik("korisnik");
			tp.setPoruka(poruka);
			
			// Poruka se unosi u listu na kraj
			poruke.addLast(tp);
		}
		
		/*
		 *  Metod koji na osnovu unetih parametara vraca niz twittova sacinjen od zeljenog
		 *  broja twitova koji sadrze zeljeni tj. preko parametara uneti tag
		 *  
		 *  @param maxBroj
		 *  			Broj poruka koje se vracaju.
		 *  
		 *  @param tag
		 *  		tag tj. niz karaktera u poruci na osnovu kojih se vrsi pretraga
		 *  		poruka i vracaju se poruke koje sadrze taj tag tj. niz karaktera.
		 *  
		 *  @return TwitterPoruka[]
		 *  					Niz kapacite maxBroj koji sadrze poruke sa zeljenim tagom.
		 */
		public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) 
		{
			if (tag == null || tag == "")
				throw new RuntimeException("Morate uneti tag");
			
			// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
			if (maxBroj <= 0)
				maxBroj = 100;
			
			// Pomocna promenljiva koja predstavlja brojac upisanih poruka
			int brojac = 0; 
			
			// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
			// sve poruke koje u sebi imaju zadati tag
			TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
			
			// Pretrazuju se poruke i traze se one koje sadrze tag.
			// Ako se nadje neka takva, i ako nije prekoracen maxBroj
			// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
			// se prekida.
			for (int i = 0; i < poruke.size(); i++)
				if (poruke.get(i).getPoruka().indexOf(tag) != -1)
						if (brojac < maxBroj)
						{
								rezultat[brojac+1] = poruke.get(i);
								brojac++;
						}
						else break;
			
			return rezultat;
		} 
}
