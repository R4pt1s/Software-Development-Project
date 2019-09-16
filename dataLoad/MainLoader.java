package dataLoad;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class MainLoader implements IDataLoader {
	
	private ArrayList<String[]> myBloodyArrayList;

	public ArrayList<String[]> loadData(String filename) {
		Scanner inputStream = null;
		int counter = 0;
		int correctLength = 0;
		boolean sth = true;
		while(sth)
		{
			try {
			inputStream = new Scanner(new FileInputStream(filename));
			sth=false;
			} catch (FileNotFoundException e) {
				System.out.println("Problem loading data from files.");
				System.exit(0);
			}		
		}
		myBloodyArrayList = new ArrayList<String[]>();
		while (inputStream.hasNextLine()) {
			if(counter > 0)
			{
				String line = inputStream.nextLine();
				if(line.split("	").length == correctLength)
				{
					myBloodyArrayList.add(line.split("	"));
					for(String i : line.split("	"))
					{
						if(i == "/N")
						{
							myBloodyArrayList.remove(line.split("	"));
						}
					}
				}
			}else
			{
				String line = inputStream.nextLine();
				correctLength = line.split("	").length;
				counter++;
			}
		}
		inputStream.close();
		return myBloodyArrayList;
	}

}
