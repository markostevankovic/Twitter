package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterPorukaTest 
{
	TwitterPoruka status;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		status = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		status = null;
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	 	public void testSetKorisnikNULL() 
		{
	 		status.setKorisnik(null);
	 		
	 	}
	 	
	 	@Test (expected = java.lang.RuntimeException.class)
	 	public void testSetKorisnikEmptyString()
	 	{
	 		status.setKorisnik("");
	 	}
	 	
	 	@Test
	 	public void testSetKorisnikSveOK()
	 	{
	 		status.setKorisnik("Rape Ricpe");
	 		assertEquals("Rape Ricpe", status.getKorisnik());
	 	}
	 
	 	@Test (expected = java.lang.RuntimeException.class)
	 	public void testSetPorukaNull() 
	 	{
	 		status.setPoruka(null);	
	 	}
	 	
	 	@Test
	 	public void testSetPorukaToAnEmptyString() 
	 	{
	 		status.setPoruka("");
	 	}
	 	
	 	@Test (expected = java.lang.RuntimeException.class)
	 	public void testSetPorukaCharacters() 
	 	{
	 		String s = "";
	 		
	 		for (int i = 0; i < 13; i++)
	 			s += "Adriana Lima ";
	 		
	 		status.setPoruka(s);
	 	}
	 	
	 	@Test
	 	public void testSetPorukaSveOK() 
	 	{
	 		status.setPoruka("Marko Stevankovic je najveci kralj na FONu");
	 		assertEquals("Marko Stevankovic je najveci kralj na FONu", status.getPoruka());
	 	}
	 
	 	@Test
	 	public void testToString() 
	 	{
	 		status.setKorisnik("adrianalima");
	 		status.setPoruka("Marko volim te #markostevankovic");
	 		assertEquals("User: " + "adrianalima" + ", message: " + "Marko volim te #markostevankovic", status.toString());
	 	}
}
