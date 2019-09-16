package dataLoad;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RatTagLoader implements IDataLoader {
	
	private String ratFilename;
	private ArrayList<String[]> myBloodyArrayList;
	
	public RatTagLoader(String ratFilename)
	{
		this.ratFilename = ratFilename;
	}


	public ArrayList<String[]> loadData(String ratFilename) {
		Scanner inputStream = null;
		boolean sth = true;
		while(sth)
		{
			try {
			inputStream = new Scanner(new FileInputStream(ratFilename));
			sth=false;
			} catch (FileNotFoundException e) {
				System.out.println("Problem loading data from files.");
				System.exit(0);
			}		
		}
		ArrayList<String[]> myBloodyArrayList = new ArrayList<String[]>();
		inputStream.nextLine();
		while (inputStream.hasNextLine()) {
			String line = inputStream.nextLine();
			String[] splitedLine = line.split("	");
			myBloodyArrayList.add(splitedLine);
		}
		inputStream.close();
		return myBloodyArrayList;
	}
	
	public ArrayList<String[]> getArray()
	{
		return myBloodyArrayList;
	}

}
