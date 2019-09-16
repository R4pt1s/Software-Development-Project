package dataManage;

import java.util.ArrayList;
import java.util.HashMap;
//import mainPackage.Movie;

import mainPackage.Movie;

public class RatTagDataManager implements IDataManager 
{
    private ArrayList<String[]> tags = new ArrayList<String[]>() ; 
    private ArrayList<String[]> ratings ;
    private ArrayList<String[]> movieTags ;
    private ArrayList<String[]> userTagedMovies = new ArrayList<String[]>();
    private HashMap<Integer,ArrayList<Integer>> movieTagsMap = new HashMap<Integer,ArrayList<Integer>>();
    private HashMap<Integer,String> initialTagsMap = new HashMap<Integer,String>();
    private HashMap<Integer,ArrayList<String>> tagsMap = new HashMap<Integer,ArrayList<String>>();
    private HashMap<Integer,ArrayList<String>> ratingsMap = new HashMap<Integer,ArrayList<String>>();
    
    public RatTagDataManager(ArrayList<String[]> tags,ArrayList<String[]> userTagedMovies ,ArrayList<String[]> movieTags, ArrayList<String[]> ratings)
    {
        this.tags = tags;
        this.ratings = ratings;
        this.userTagedMovies = userTagedMovies;
        this.movieTags = movieTags;
    }

   
    private void manageTags()
    {
    	ArrayList<String> finalTagArray = new ArrayList<String>();
    	String tagFinal = "";
    	ArrayList<Integer> tmpArray = new ArrayList<Integer>();
    	int ID=1;
    	int previousID=1;
    
    	for(String[] str : movieTags)
    	{
    		
    		ID = Integer.parseInt(str[0]);
    		
    		if(ID==previousID)
    		{
    			tmpArray.add(Integer.parseInt(str[1]));
    			
    		}
    		
    		else{
    			movieTagsMap.put(previousID, tmpArray);
    			tmpArray = new ArrayList<Integer>();
    			tmpArray.add(Integer.parseInt(str[1]));
    			previousID = ID;
    			
    		}
    	}
    	movieTagsMap.put(ID, tmpArray);
    	
    	for(String[] str : tags)
    	{
    		int tagID = Integer.parseInt(str[0]);
    		initialTagsMap.put(tagID, str[1]);
    	}
    	
    	for(Integer movieID: movieTagsMap.keySet())
    	{
    		finalTagArray = new ArrayList<String>();
			for(int tagID : movieTagsMap.get(movieID))
    		{
    			for(String[] str : userTagedMovies)
    			{
    				int tagID1 = Integer.parseInt(str[2]);
    				if(tagID1 == tagID)
    				{
    					tagFinal = "User ID: " + str[0] + "\t" + initialTagsMap.get(tagID1) + "\t" + str[3] +"/" + str[4] + "/" + str[5] + "\t" + str[6] + ":" + str[7] + ":" + str[8];
    					finalTagArray.add(tagFinal);
    				}
    			}
    		}
			
			tagsMap.put(movieID,finalTagArray);
    	}
    }
    	    
    private void manageRatings()
    {
    	/*ArrayList<String> tmpArray = new ArrayList<String>();
    	int ID=1;
    	int previousID=1;
    
    	for(String[] str : ratings)
    	{
    		
    		ID = Integer.parseInt(str[1]);
    		System.out.println(tmpArray.size());
    		
    
    		if(ID==previousID)
    		{
    			//String ratingString = "User: " + str[0] + "rating: " + str[2] +  "\t" + str[3] +"/" + str[4] + "/" + str[5] + "\t" + str[6] + ":" + str[7] + ":" + str[8] ;
    			tmpArray.add("User: " + str[0] +"\t" + "rating: " + str[2] +  "\t" + str[3] +"/" + str[4] + "/" + str[5] + "\t" + str[6] + ":" + str[7] + ":" + str[8]);
    			
    		}
    		
    		else{
    			ratingsMap.put(previousID, tmpArray);
    			tmpArray = new ArrayList<String>();
    			//String ratingString = "User: " + str[0] +"\t" + "rating: " + str[2] +  "\t" + str[3] +"/" + str[4] + "/" + str[5] + "\t" + str[6] + ":" + str[7] + ":" + str[8] ;
    			tmpArray.add("User: " + str[0] +"\t" + "rating: " + str[2] +  "\t" + str[3] +"/" + str[4] + "/" + str[5] + "\t" + str[6] + ":" + str[7] + ":" + str[8]);
    			previousID = ID;
    			
    		}
    	}
    	ratingsMap.put(ID, tmpArray);*/
    	ArrayList<String> tmpArray = new ArrayList<String>();
    	int ID=1;
    	for(String[] str : ratings)
    	{
    		ID = Integer.parseInt(str[1]);
    		if(ratingsMap.containsKey(ID))
    		{
    			String ratingString = "User: " + str[0] + "rating: " + str[2] +  "\t" + str[3] +"/" + str[4] + "/" + str[5] + "\t" + str[6] + ":" + str[7] + ":" + str[8] ;
    			tmpArray = ratingsMap.get(ID);
    			tmpArray.add(ratingString);
    			ratingsMap.put(ID,tmpArray);
    		}
    		
    		else{
    			String ratingString = "User: " + str[0] + "rating: " + str[2] +  "\t" + str[3] +"/" + str[4] + "/" + str[5] + "\t" + str[6] + ":" + str[7] + ":" + str[8] ;
    			tmpArray.add(ratingString);
    			ratingsMap.put(ID,tmpArray);
    		}
    	}
    	

    }
    
    public HashMap<Integer,ArrayList<String>> getTags()
    {
    	return tagsMap;
    }
    
    public HashMap<Integer,ArrayList<String>> getRatings()
    {
    	return ratingsMap;
    }
    
    
    public void manage()
    {
    	if(ratings== null)
    	{	
    		manageTags() ;
    	}else if(tags== null)
    	{
    		manageRatings() ;
    		 
    	}
    	else{
    		manageTags();
    		manageRatings();
    	}
    }


	@Override
	public ArrayList<Movie> getMovie1() {
		// TODO Auto-generated method stub
		return null;
	}
   
}
