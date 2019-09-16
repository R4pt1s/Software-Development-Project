/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataManage;

import java.util.ArrayList;
import java.util.HashMap;

import mainPackage.Movie;

public class MainDataManager implements IDataManager
{
    private ArrayList<String[]> movies = new ArrayList<String[]>() ;
    private ArrayList<String[]> actors ;
    private ArrayList<String[]> directors ;
    private ArrayList<String[]> genres ;
    private ArrayList<String[]> countries ;
    private HashMap<Integer,ArrayList<String>> genresMap = new HashMap<Integer,ArrayList<String>>();
    private HashMap<Integer,ArrayList<String>> actorsMap = new HashMap<Integer,ArrayList<String>>();
    private HashMap<Integer,String[]> moviesMap = new HashMap<Integer,String[]>() ;
    private HashMap<Integer,String> countriesMap = new HashMap<Integer,String>() ;
    private HashMap<Integer,String> directorsMap = new HashMap<Integer,String>() ;
    private ArrayList<Movie> movies1 = new ArrayList<Movie>();
    
    public MainDataManager(ArrayList<String[]> movies , ArrayList<String[]> actors,ArrayList<String[]> directors , ArrayList<String[]> genres , ArrayList<String[]> countries)
    {
        this.movies = movies;
        this.actors = actors;
        this.directors = directors;
        this.genres = genres;
        this.countries = countries;
    }
    
    private void manageGenres()
    {
    	ArrayList<String> tmpArray = new ArrayList<String>();
    	int ID=1;
    	int previousID=1;
    
    	for(String[] str : genres)
    	{
    		
    		ID = Integer.parseInt(str[0]);
    		//System.out.println(ID);
    		
    		if(ID==previousID)
    		{
    			//System.out.println("Inside If!");
    			tmpArray.add(str[1]);
    			
    		}
    		
    		else{
    			//System.out.println("Inside else!");
    			genresMap.put(previousID, tmpArray);
    			tmpArray = new ArrayList<String>();
    			tmpArray.add(str[1]);
    			previousID = ID;
    			
    		}
    	}
    	genresMap.put(ID, tmpArray);
    }
    
    private void manageActors()
    {
    	ArrayList<String> tmpArray = new ArrayList<String>();
    	int ID=1;
    	int previousID=1;
    	
    	for(String[] str : actors)
    	{
    		ID = Integer.parseInt(str[0]);
    		
    		if(ID==previousID)
    		{
    			tmpArray.add(str[2]);
    			
    		}
    		
    		else{
    			actorsMap.put(previousID, tmpArray);
    			tmpArray = new ArrayList<String>();
    			tmpArray.add(str[2]);
    			previousID = ID;
    			
    		}
    	
    	}
    	actorsMap.put(ID, tmpArray);
    	
    }
    
    private void manageTitlesDates()
    {
    	for(String[] ar : movies)
    	{
    		String[] tmp = { ar[1],ar[5] };
    		moviesMap.put(Integer.parseInt(ar[0]),tmp);
    	}
    }
    
    private void manageCountries()
    {
    	int counter = 0;
    	try{
	    	for(String[] str:countries)
	    	{
	    		counter++;
	    		if(str[1]==null || str[1]=="")
	    		{
	    			countriesMap.put(Integer.parseInt(str[0]),"no country");
	    		}
	    		else{
	    			countriesMap.put(Integer.parseInt(str[0]),str[1]);
	    		}
	    		
	    	}
    	}
    	
    	catch(ArrayIndexOutOfBoundsException e) //If a line in the source file is wrong the exception will be catched here
    	{
    		System.out.println("Problem in line: " + counter);
    		System.exit(-2);
    	}
    }
    
    private void manageDirectors()
    {
    	int counter = 0;
    	
    	try{
    		
    	
	    	for(String[] str:directors)
	    	{
	    		counter++;
	    		if(str[2]==null || str[2]=="")
	    		{
	    			directorsMap.put(Integer.parseInt(str[0]),"no director");
	    		}
	    		else{
	    			directorsMap.put(Integer.parseInt(str[0]),str[2]);
	    		}
	    	}
    	}
    	
    	catch(NumberFormatException e){
    		System.out.println("Problem in line: " + counter);
    		System.exit(-1);
    	}
    }
    
    public HashMap<Integer,String[]> getMovies()
    {
    	return moviesMap;
    }
    
    public HashMap<Integer,ArrayList<String>> getActors()
    {
    	return actorsMap;
    }
    
    public HashMap<Integer,ArrayList<String>> getGenres()
    {
    	return genresMap;
    }
        
    public HashMap<Integer,String> getCountries()
    {
    	return countriesMap;
    }
    
    public HashMap<Integer,String> getDirectors()
    {
    	return directorsMap;
    }
    
    public void manage()
    {
    	manageActors();
        manageDirectors();
        manageCountries();
        manageTitlesDates();
        manageGenres();
        
    	
       for(String[] ar:movies)
        {
        	int key = Integer.parseInt(ar[0]);
        	String title = moviesMap.get(key)[0];
        	String director = directorsMap.get(key);
        	ArrayList<String> actors1 = actorsMap.get(key);
        	ArrayList<String > genres1 = genresMap.get(key);
        	String country = countriesMap.get(key);
        	int year = Integer.parseInt(moviesMap.get(key)[1]);
        	String shortDescription = title + "\t" + director + "\t" + year ;
        	
        	if(title!=null && director!=null && actors1!=null && genres1!=null && country!=null )
        	{
        		Movie tmpMovie = new Movie(key,title,director,actors1,genres1,country,shortDescription,year);
        		movies1.add(tmpMovie);
        	}
        	
        }
        
    }
        

   

  
    
    public ArrayList<Movie> getMovie1()
    {
        return movies1 ;
    }
    
}
