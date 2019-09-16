/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataManage;

import java.util.ArrayList;


/**
 *
 * @author leoni
 */
public class DataManagerFactory
{
	public IDataManager getOutput(ArrayList<String[]> movies , ArrayList<String[]> actors , ArrayList<String[]> directors , ArrayList<String[]> genres , ArrayList<String[]> countries,ArrayList<String[]> tags,ArrayList<String[]> userTagedMovies,ArrayList<String[]> movieTags,ArrayList<String[]> ratings, String desiredMethod)
	{
		if (desiredMethod == null)
		{
			return null;
		}
		
		else if ("mainManager".equals(desiredMethod))
		{
			return new MainDataManager(movies,actors,directors,genres,countries);
		}
		
		else if("tagManager".equals(desiredMethod))
		{
			return new RatTagDataManager(tags,userTagedMovies,movieTags,null);
		}
		
		else if("ratManager".equals(desiredMethod))
		{
			return new RatTagDataManager(null,userTagedMovies,movieTags,ratings);
		}
		
		else if("extendedManager".equals(desiredMethod))
		{
			return new ExtendedDataManager(movies,actors,directors,genres,countries,tags,userTagedMovies,movieTags,ratings);
		}
		
		return null;
	}

    
         
    
   // public getOutput(String , String[] ,String[] , String[] )
}

