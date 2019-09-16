/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataManage;

import java.util.ArrayList;
import java.util.HashMap;
//import mainPackage.Movie;

import mainPackage.Movie;

/**
 *
 * @author leoni
 */
public class ExtendedDataManager implements IDataManager
{
    private ArrayList<String[]> tags = new ArrayList<String[]>() ; // tags.dat the filename 
    private ArrayList<String[]> ratings ;
    private HashMap<Integer,ArrayList<String>> tagsMap = new HashMap<Integer,ArrayList<String>>();;
    private HashMap<Integer,ArrayList<String>> ratingsMap = new HashMap<Integer,ArrayList<String>>();;
    
    private ArrayList<String[]> movies = new ArrayList<String[]>() ;
    private ArrayList<String[]> actors ;
    private ArrayList<String[]> directors ;
    private ArrayList<String[]> genres ;
    private ArrayList<String[]> countries ;
    private ArrayList<String[]> userTagedMovies;
    private ArrayList<String[]> movieTags;
    private HashMap<Integer,ArrayList<String>> genresMap = new HashMap<Integer,ArrayList<String>>();
    private HashMap<Integer,ArrayList<String>> actorsMap = new HashMap<Integer,ArrayList<String>>();
    private HashMap<Integer,String[]> moviesMap = new HashMap<Integer,String[]>() ;
    private HashMap<Integer,String> countriesMap = new HashMap<Integer,String>() ;
    private HashMap<Integer,String> directorsMap = new HashMap<Integer,String>() ;
    private ArrayList<Movie> movies1 = new ArrayList<Movie>();
    
    
    public ExtendedDataManager(ArrayList<String[]> movies , ArrayList<String[]> actors , ArrayList<String[]> directors , ArrayList<String[]> genres , ArrayList<String[]> countries,ArrayList<String[]> tags,ArrayList<String[]> userTagedMovies ,ArrayList<String[]> movieTags, ArrayList<String[]> ratings)
    {
        this.movies = movies ;
        this.actors = actors ;
        this.directors = directors ;
        this.genres = genres ;
        this.countries = countries ;
        this.tags = tags ;
        this.ratings = ratings ;
        this.userTagedMovies = userTagedMovies;
        this.movieTags = movieTags;
    }
 
  public void manage()
    {
         MainDataManager mdm = new MainDataManager(movies,actors,directors,genres,countries);
         mdm.manage();
         moviesMap = mdm.getMovies();
         actorsMap = mdm.getActors();
         genresMap = mdm.getGenres();
         countriesMap = mdm.getCountries();
         directorsMap = mdm.getDirectors();
         RatTagDataManager rtdm = new RatTagDataManager(tags,userTagedMovies,movieTags,ratings);
         rtdm.manage();
         tagsMap = rtdm.getTags();
         ratingsMap = rtdm.getRatings();
     	
         for(String[] ar:movies)
         {
         	int key = Integer.parseInt(ar[0]);
         	String title = moviesMap.get(key)[0];
         	String director = directorsMap.get(key);
         	ArrayList<String> actors1 = actorsMap.get(key);
         	ArrayList<String > genres1 = genresMap.get(key);
         	String country = countriesMap.get(key);
         	int year = Integer.parseInt(moviesMap.get(key)[1]);
         	ArrayList<String> tags = tagsMap.get(key);
         	ArrayList<String> ratings = ratingsMap.get(key);
         	String shortDescription = title + "\t" + director + "\t" + year ;
         	
         	
         	if(title!=null && director!=null && actors1!=null && genres1!=null && country!=null)
         	{
         		Movie tmpMovie = new Movie(key,title,director,actors1,genres1,country,title + shortDescription + year ,year,tags,ratings);
         		movies1.add(tmpMovie);
         	}
         	
         }
    }

@Override
public ArrayList<Movie> getMovie1() {
	// TODO Auto-generated method stub
	return movies1;
}
}
