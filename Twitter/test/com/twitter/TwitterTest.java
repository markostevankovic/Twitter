package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest 
{
	Twitter tnjiter;

	@Before
	public void setUp() throws Exception 
	{
		tnjiter = new Twitter();
	}

	@After
	public void tearDown() throws Exception 
	{
		tnjiter = null;
	}

	@Test
	public void testVratiSvePoruke() 
	{
		tnjiter.vratiSvePoruke();
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiNULL() 
	{
		String korisnik = null;
		String poruka = null;
		
		tnjiter.unesi(korisnik, poruka);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiEmptyString()
	{
		String korisnik = "";
		String poruka = "";
		
		tnjiter.unesi(korisnik, poruka);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiGolemuPoruku()
	{
		String mesaz = "";
		for(int i = 0; i < 13; i++)
			mesaz += "Jessica Alba ";
		
		String korisnik = "raPe ricPe";
		
		tnjiter.unesi(korisnik, mesaz);
	}
	
	@Test
	public void testUnesiSveOk()
	{
		String korisnik = "Jessica Alba";
		String poruka = "Marko je najveci smeker na FONu.";
		
		tnjiter.unesi(korisnik, poruka);
		
		TwitterPoruka twitterMessage = new TwitterPoruka();
		
		twitterMessage.setKorisnik("Jessica Alba");
		twitterMessage.setPoruka("Marko je najveci smeker na FONu.");
		
		assertEquals(twitterMessage.toString(), tnjiter.vratiSvePoruke().getLast().toString());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull() 
	{
		String tag = null;
		tnjiter.vratiPoruke(5, tag);
	}
	 
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazanString() 
	{
		String tag = "";
		tnjiter.vratiPoruke(5, tag);
	}
	
	@Test 
	public void testVratiPorukeMaxBrojManjiIliJednakOdNule()
	{
		String korisnik = "Pera Ricpe";
		String poruka = "Marko kersme";
		for (int i = 0; i < 20; i++)
			tnjiter.unesi(korisnik, poruka);
	
		tnjiter.vratiPoruke(0, poruka);
	}
	 
	@Test
	public void testVratiPorukeSveOk()
	{
		String tag = "kersme";
		tnjiter.vratiPoruke(15, tag);
	}
}
