package io.egen.rentalflix;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Service implementing IFlix interface
 * You can use any Java collection type to store movies
 */
public class MovieService implements IFlix {
 
	private Queue<Movie> movieList = new ConcurrentLinkedQueue<Movie>();
	@Override
	public List<Movie> findAll() 
	{
		List<Movie> ret = new ArrayList<Movie>();
		Iterator<Movie> iterator = movieList.iterator();
		while(iterator.hasNext())
			ret.add(iterator.next());
		
		return ret;
	}

	@Override
	public List<Movie> findByName(String name) 
	{
		List<Movie> ret = new ArrayList<Movie>();
		Iterator<Movie> iterator = movieList.iterator();
		while(iterator.hasNext())
		{
			Movie tempMovieObj = iterator.next(); 
			if(tempMovieObj.getTitle().toLowerCase().indexOf(name.toLowerCase())!=-1)
				ret.add(tempMovieObj);
		}
		return ret;
	}

	@Override
	public Movie create(Movie movie) {
		movieList.add(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		boolean flag = false;
		Iterator<Movie> iterator = movieList.iterator();
		Movie tempMovieObj = null;
		while(iterator.hasNext())
		{
			tempMovieObj = iterator.next(); 
			if(tempMovieObj.getId() == movie.getId())
			{
				tempMovieObj.setTitle(movie.getTitle());
				tempMovieObj.setYear(movie.getYear());
				tempMovieObj.setLanguage(movie.getLanguage());
				flag = true;
				break;
			}
		}
		if(flag==true)
			return tempMovieObj;
		else
			throw new IllegalArgumentException("Id not found in movieList");
	}

	@Override
	public Movie delete(int id) {
		boolean flag = false;
		Iterator<Movie> iterator = movieList.iterator();
		Movie tempMovieObj = null;
		while(iterator.hasNext())
		{
			 tempMovieObj = iterator.next(); 
			if(tempMovieObj.getId() == id)
			{
				iterator.remove();
				flag = true;
				break;
			}
		}
		if(flag==true)
			return tempMovieObj;
		else
			throw new IllegalArgumentException("Id not found in movieList");
	}

	@Override
	public boolean rentMovie(int movieId, String user) {
		Iterator<Movie> iterator = movieList.iterator();
		Movie tempMovieObj = null;
		while(iterator.hasNext())
		{
			tempMovieObj = iterator.next(); 
			//expecting the user will search for a movie which is already there
			if(tempMovieObj.getId() == movieId)
			{
				if(tempMovieObj.isRented()== false)
				{
					user = Integer.toString(movieId);
					tempMovieObj.setRented(true);
					return true;
				}
				else
					throw new IllegalArgumentException("Movie rented already!");
			}
		}
		return false;
	}

}
