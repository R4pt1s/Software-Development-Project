package mainEngine;

import java.util.ArrayList;
import java.util.Scanner;

import dataLoad.LoadFactory;
import dataManage.DataManagerFactory;
import mainPackage.Movie;
import outputManage.OutputFactory;

public class QuestionsManager {

	//This class manages the user's questions by calling the system classes
	String output;
	ArrayList<Movie> movieList = new ArrayList<Movie>();
	
	public QuestionsManager(ArrayList<Movie> ar)
	{
		movieList = ar;
	}
	
	public String shortDescrSearch(String title)
	{
		try{
			String tags="";
			String ratings="";
			for(Movie movie:movieList)
			{
				if(movie.getTitle().equals(title))
				{
					
				
					if(movie.getTags()==null)
					{
						tags = "No tags associated with the movie perhaps they have not been loaded";
					}
					
					if(movie.getRatings()==null)
					{
						ratings = "No ratings associated with the movie perhaps they have not been loaded";
					}
					
					return (movie.getShortDescription() +"\n Total number of tags associated with the movie: " + movie.getTags().size() +"\n The following tags are associated with the movie: \n" + movie.getTags() + tags + "\n Total number of ratings associated with movie: " + movie.getRatings().size()+"\n The following ratings are associated with the movie: \n" + movie.getRatings() + ratings);
				}
				
			}
			
			return"Movie not found!";
		}
		
		catch(NullPointerException e)
		{
			System.out.println("The data has not been loaded or is currupt!");
			System.exit(-2);
		}
		return output;
	}
	
	public String shortDescrSearch(int id )
	{
		try{
		
			String tags="";
			String ratings="";
			for(Movie movie:movieList)
			{
				if(movie.getID()==id)
				{
					if(movie.getTags()==null)
					{
						tags = "No tags associated with the movie perhaps they have not been loaded";
					}
					
					if(movie.getRatings()==null)
					{
						ratings = "No ratings associated with the movie perhaps they have not been loaded";
					}
					return (movie.getShortDescription() +"\n Total number of tags associated with the movie: " + movie.getTags().size() +"\n The following tags are associated with the movie: \n" + movie.getTags() + tags + "\n Total number of ratings associated with movie: " + movie.getRatings().size()+"\n The following ratings are associated with the movie: \n" + movie.getRatings() + ratings);
				}
			}
			
			return"Movie not found!";
		}
		
		catch(NullPointerException e)
		{
			System.out.println("The data has not been loaded or is currupt!");
			System.exit(-2);
		}
		return output;
	}
	
	public String genreSearch(String genre)
	{
		try{
			//int counter = 0;
			ArrayList<Movie> tmpArray = new ArrayList<Movie>();
		
			for(Movie movie:movieList)
			{
			
				for(String genre1:movie.getGenres())
				{
					
					if(genre1.equals(genre))
					{
						tmpArray.add(movie);
					}
				}
			}
			
			String output = "Number of recalled movies: "+tmpArray.size() + "\n";
			
			for(Movie movie:tmpArray)
			{
				output = output + movie.getTitle() + "\t" + movie.getYear() + "\t" + movie.getDirector() + "\n";
			}
			
			return output;
		}
		
		catch(NullPointerException e)
		{
			System.out.println("The data has not been loaded or is currupt!");
			System.exit(-2);
		}
		return output;
		
	}
	
	public String directorSearch(String director)
	{
		try{
			
		
			ArrayList<Movie> tmpArray = new ArrayList<Movie>();
			
			for(Movie movie:movieList)
			{
			
				if(movie.getDirector().equals(director))
				{
					tmpArray.add(movie);
				}
			}
			
			String output = "Number of recalled movies: "+tmpArray.size() + "\n";
			
			for(Movie movie:tmpArray)
			{
				output = output + movie.getTitle() + "\t" + movie.getYear() + "\t" + movie.getDirector() + "\n";
			}
			
			return output;
		}
		
		catch(NullPointerException e)
		{
			System.out.println("The data has not been loaded or is currupt!");
			System.exit(-2);
		}
		return output;
		
	}
	
	public String actorSearch(String actor)
	{
		try{
			ArrayList<Movie> tmpArray = new ArrayList<Movie>();
			
			for(Movie movie:movieList)
			{
			
				for(String actor1:movie.getActors())
				{
					
					if(actor1.equals(actor))
					{
						tmpArray.add(movie);
					}
				}
			}
			
			String output = "Number of recalled movies: "+tmpArray.size() + "\n";
			
			for(Movie movie:tmpArray)
			{
				output = output + movie.getTitle() + "\t" + movie.getYear() + "\t" + movie.getDirector() + "\n";
			}
			
			return output;
		}
		
		catch(NullPointerException e)
		{
			System.out.println("The data has not been loaded or is currupt!");
			System.exit(-2);
		}
		return output;
	}
	
	public String countrySearch(String country)
	{
		try{
			ArrayList<Movie> tmpArray = new ArrayList<Movie>();
			
			for(Movie movie:movieList)
			{
				//System.out.println(movie);
			
				if(movie.getCountry().equals(country))
				{
					tmpArray.add(movie);
				}
			}
			
			String output = "Number of recalled movies: "+tmpArray.size() + "\n";
			
			for(Movie movie:tmpArray)
			{
				output = (output + movie.getTitle() + "\t" + movie.getYear() + "\t" + movie.getDirector() + "\n");
			}
			
			return output;
		}
		
		catch(NullPointerException e)
		{
			System.out.println("The data has not been loaded or is currupt!");
			System.exit(-2);
		}
		return output;
	}


	
	
}
