package mainPackage;

import java.util.ArrayList;

public class Movie {
	
	private ArrayList<String> genres;
	private ArrayList<String> actors;
	private String director;
	private String country;
	private int year;
	private String shortDescription;
	private String title;
	private int ID;
	
	private ArrayList<String> tags = new ArrayList<String>();
	private ArrayList<String> ratings = new ArrayList<String>();
	
	
	public Movie(int id,String title,String director,ArrayList<String> actors,ArrayList<String> genres,String country,String shortDescription,int year)
	{
		this.ID=id;
		this.genres = genres;
		this.title = title;
		this.director = director;
		this.actors = actors;
		this.country = country;
		this.shortDescription = shortDescription;
		this.year = year;
	}
	
	public Movie(int id,String title,String director,ArrayList<String> actors,ArrayList<String> genres,String country,String shortDescription,int year,ArrayList<String> tags)
	{
		this.ID=id;
		this.genres = genres;
		this.title = title;
		this.director = director;
		this.actors = actors;
		this.country = country;
		this.shortDescription = shortDescription;
		this.year = year;
		this.tags = tags;
	}
	
	public Movie(int id,String title,String director,ArrayList<String> actors,ArrayList<String> genres,String country,String shortDescription,int year,ArrayList<String> tags,ArrayList<String> ratings)
	{
		this.ID=id;
		this.genres = genres;
		this.title = title;
		this.director = director;
		this.actors = actors;
		this.country = country;
		this.shortDescription = shortDescription;
		this.year = year;
		this.tags = tags;
		this.ratings = ratings;
	}
	
	/*public Movie(String title,String director,String[] actors,String country,String shortDescription,int year,String[] ratings)
	{
		title = title;
		director = director;
		actors = actors;
		country = country;
		shortDescription = shortDescription;
		year = year;
		ratings = ratings;
	}*/
	
	public String getTitle()
	{
		return title;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String getDirector()
	{
		return director;
	}
	
	public String getCountry()
	{
		return country;
	}
	
	public ArrayList<String> getActors()
	{
		//System.out.println(actors.get(0));
		return actors;
	}
	
	public ArrayList<String> getGenres()
	{
		return genres;
	}

	
	public String getShortDescription()
	{
		return shortDescription;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public ArrayList<String> getTags()
	{
		return tags;
	}
	
	public ArrayList<String> getRatings()
	{
		return ratings;
	}
	
	public String toString()
	{
		return (ID + "\t" + title +"\t" + actors);
	}

}
