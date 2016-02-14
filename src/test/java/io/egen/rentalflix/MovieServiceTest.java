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
		Movie m1 = new Movie();
		Movie m2 = new Movie();
		m1.setId(123);
		m1.setLanguage("English");
		m1.setTitle("Antman");
		m1.setYear(2002);
		MovieService ms = new MovieService();
		ms.create(m1);
		m2.setId(123);
		m2.setLanguage("English");
		m2.setTitle("Robocop");
		m2.setYear(2001);
		Assert.assertEquals(m2, ms.update(m2));
	}
	
	@Test	
	public void testDelete()
	{
		Movie m1 = new Movie();
		MovieService ms = new MovieService();
		m1.setId(123);
		m1.setLanguage("English");
		m1.setTitle("Antman");
		m1.setYear(2002);
		ms.create(m1);
		Assert.assertEquals(m1, ms.delete(123));
	}
	
	@Test	
	public void testRentMovie()
	{
		Movie m1 = new Movie();
		MovieService ms = new MovieService();
		m1.setId(123);
		m1.setLanguage("English");
		m1.setTitle("Antman");
		m1.setYear(2002);
		ms.create(m1);
		Assert.assertEquals(true,ms.rentMovie(123, "Steve"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testUpdateFail()
	{
		Movie m1 = new Movie();
		m1.setId(123);
		m1.setLanguage("English");
		m1.setTitle("Antman");
		m1.setYear(2002);
		MovieService ms = new MovieService();
		//no movie inserted in MovieService, hence fails!
		Assert.assertEquals(m1, ms.update(m1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDeleteFail()
	{
		Movie m1 = new Movie();
		m1.setId(123);
		m1.setLanguage("English");
		m1.setTitle("Antman");
		m1.setYear(2002);
		MovieService ms = new MovieService();
		//no movie inserted in MovieService, hence fails!
		Assert.assertEquals(m1, ms.delete(123));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRentFail()
	{
		Movie m1 = new Movie();
		m1.setId(123);
		m1.setLanguage("English");
		m1.setTitle("Antman");
		m1.setYear(2002);
		m1.setRented(true);
		MovieService ms = new MovieService();
		ms.create(m1);
		Assert.assertEquals(true, ms.rentMovie(123, "Jobs"));
	}
}
