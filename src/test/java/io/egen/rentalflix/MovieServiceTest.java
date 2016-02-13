package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test cases for MovieService
 */
public class MovieServiceTest {
	
	@Test
	public void testFindAll()
	{
		Movie m1 = new Movie();
		MovieService ms = new MovieService();
		m1.setId(123);
		m1.setLanguage("English");
		m1.setTitle("Antman");
		m1.setYear(2002);
		List<Movie> expected = new ArrayList<Movie>();
		expected.add(m1);
		ms.create(m1);
		Assert.assertEquals(expected, ms.findAll());
	}
	
	@Test	
	public void testFindByName()
	{
		Movie m1 = new Movie();
		MovieService ms = new MovieService();
		m1.setId(123);
		m1.setLanguage("English");
		m1.setTitle("Antman");
		m1.setYear(2002);
		ms.create(m1);
		List<Movie> expected = new ArrayList<Movie>();
		expected.add(m1);
		Assert.assertEquals(expected, ms.findByName("antman"));
	}
	
	@Test	
	public void testCreate()
	{
		Movie m1 = new Movie();
		MovieService ms = new MovieService();
		m1.setId(123);
		m1.setLanguage("English");
		m1.setTitle("Antman");
		m1.setYear(2002);
		Assert.assertEquals(m1, ms.create(m1));
	}
	
	@Test	
	public void testUpdate()
	{
		
	}
	
	@Test	
	public void testDelete()
	{
		
	}
	
	@Test	
	public void testRentMovie()
	{
		
	}
}
