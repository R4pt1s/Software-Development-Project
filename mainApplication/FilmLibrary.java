package mainApplication;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import dataLoad.*;
import dataManage.DataManagerFactory;
import dataManage.IDataManager;
import mainEngine.QuestionsManager;
import mainPackage.Movie;
import outputManage.*;


public class FilmLibrary {
	private static ArrayList<Movie> movies;
	
	public static void main(String args[]) throws IOException, URISyntaxException
	{
		String output = "";
	
		String input2 ="";
		String input = "";
		//String outputFileInput="";
		System.out.println("Welcome to film library manager v1.0!");
		//System.out.println("************************************************INSTRUCTIONS***************************************************** \n To access the data loading menu press 1.\n To access the search menu press 2.\n To exit the programm type exit.");
		
		Scanner sc = new Scanner(System.in);
		
		
		outerloop:
		while(true)
		{
			System.out.println("Main Menu\n----------- \n To access the data loading menu press 1.\n To access the search menu press 2. \n To listen to some cool music type music. \n To exit type exit.");
			//System.out.println("Inside while");
			input = sc.nextLine();
			
			if (input.equals("1"))
			{
				while(true)
				{
					
				
					LoadFactory lf = new LoadFactory();
					DataManagerFactory dmf = new DataManagerFactory();
					System.out.println("\nLoading Menu\n-------------- \n To load the only the main movie data press 1.\n To load the movie data with tags press 2.\n To load the movie data with ratings press 3.\n To load the movie data with ratings and tags press 4.\n To go to the previous menu press 0.\n To exit type exit.\n ");
					
					input2 = sc.nextLine();
					if(input2.equals("1"))
					{
						System.out.println("Please type the source files paths in the following order: movies,actors,directors,genres,countries");
						IDataLoader dl = LoadFactory.getOutput("mainLoad","", "", "");
						System.out.println("This action may take some time");
						IDataManager dm = dmf.getOutput(dl.loadData(sc.nextLine()), dl.loadData(sc.nextLine()), dl.loadData(sc.nextLine()), dl.loadData(sc.nextLine()), dl.loadData(sc.nextLine()),null,null,null,null, "mainManager");
						dm.manage();
						movies = dm.getMovie1();
						break;
					}
					
					else if(input2.equals("2"))
					{
						System.out.println("Please type the source files paths in the following order: movies,actors,directors,genres,countries,tags,user_taged_movies,movie_tags");
						IDataLoader dlt = LoadFactory.getOutput("tagLoad","","", "");
						IDataLoader dl = LoadFactory.getOutput("mainLoad","","", "");
						System.out.println("This action may take some time");
						IDataManager dm = dmf.getOutput(dl.loadData(sc.nextLine()), dl.loadData(sc.nextLine()), dl.loadData(sc.nextLine()), dl.loadData(sc.nextLine()), dl.loadData(sc.nextLine()), dlt.loadData(sc.nextLine()), dlt.loadData(sc.nextLine()), dlt.loadData(sc.nextLine()), null, "extendedManager");
						dm.manage();
						movies = dm.getMovie1();
						break;
					}
					
					else if(input2.equals("3"))
					{
						System.out.println("Please type the source files paths in the following order: movies,actors,directors,genres,countries,ratings");
						IDataLoader dlr = LoadFactory.getOutput("ratLoad","","", "");
						IDataLoader dl = LoadFactory.getOutput("mainLoad","","", "");
						System.out.println("This action may take some time");
						IDataManager dm = dmf.getOutput(dl.loadData(sc.nextLine()), dl.loadData(sc.nextLine()), dl.loadData(sc.nextLine()), dl.loadData(sc.nextLine()), dl.loadData(sc.nextLine()), null ,null,null,dlr.loadData(sc.nextLine()), "extendedManager");
						dm.manage();
						movies = dm.getMovie1();
						break;
					}
					
					else if(input2.equals("4"))
					{
						System.out.println("Please type the source files paths in the following order: movies,actors,directors,genres,countries,tags,user_taged_movies,movie_tags,ratings");
						IDataLoader dlr = LoadFactory.getOutput("ratLoad","","", "");
						IDataLoader dlt = LoadFactory.getOutput("tagLoad","","", "");
						IDataLoader dl = LoadFactory.getOutput("mainLoad","","", "");
						System.out.println("This action may take some time");
						IDataManager dm = dmf.getOutput(dl.loadData(sc.nextLine()), dl.loadData(sc.nextLine()), dl.loadData(sc.nextLine()), dl.loadData(sc.nextLine()), dl.loadData(sc.nextLine()), dlt.loadData(sc.nextLine()) , dlt.loadData(sc.nextLine()), dlt.loadData(sc.nextLine()),dlr.loadData(sc.nextLine()), "extendedManager");
						dm.manage();
						movies = dm.getMovie1();
						break;
					}
					
					else if(input2.equals("0"))
					{
						continue outerloop;
					}
					
					else if(input2.equals("exit"))
					{
						System.out.println("Goodbye!");
						System.exit(1);
					}
				}
			}
			
			else if(input.equals("exit")) 
			{
				System.out.println("Goodbye!"); 
				System.exit(2);
			}
			
			else if(input.equals("music"))
			{
				Desktop d = Desktop.getDesktop(); 
				URI u = new URI("https://youtu.be/xy_NKN75Jhw");
			    d.browse(u);
			    continue outerloop;
			}
			
			else if (input.equals("2"))
			{
				boolean flag = false;
				//String output = "";
				//System.out.println("To search the short description of a movie press 1.\n To search for an actor press 2.\n To search for a director press 3.\n To search for a country press 4.\n To search for a specific genre press 5.\n To go to the previous menu press 0.\n To exit type exit.");
				
				while(true)
				{
					
					//boolean flag = false;
					QuestionsManager qm = new QuestionsManager(movies);
					System.out.println("\nSearch Menu\n------------- \n To search the short description of a movie press 1.\n To search for an actor press 2.\n To search for a director press 3.\n To search for a country press 4.\n To search for a specific genre press 5.\n To go to the previous menu press 0.\n To exit type exit.");
					
					input2 = sc.nextLine();
					if(input2.equals("1"))
					{
						System.out.println("Please type the movie title or ID");
						String str = sc.nextLine();
						
						try{
							
							output =  qm.shortDescrSearch(Integer.parseInt(str));
						}
						
						
						catch(NumberFormatException e){
						
							output = qm.shortDescrSearch(str);
						}
						flag = true;
						break;
					
					}
					
					else if(input2.equals("2"))
					{
						System.out.println("Please type the name of the actor");
						output = qm.actorSearch(sc.nextLine());
						flag = true;
						break;
					}
					
					else if(input2.equals("3"))
					{
						System.out.println("Please type the name of the director");
						output = qm.directorSearch(sc.nextLine());
						flag = true;
						break;
					}
					
					else if(input2.equals("4"))
					{
						System.out.println("Please type the country name");
						output = qm.countrySearch(sc.nextLine());
						flag = true;
						break;
					}
					
					else if(input2.equals("5"))
					{
						System.out.println("Please type the genre name");
						output = qm.genreSearch(sc.nextLine());
						flag = true;
						break;
					}
					
					else if(input2.equals("0"))
					{
					
						continue outerloop;
						
					}
					
					else if(input2.equals("exit"))
					{
						System.exit(3);
					}
				}
				
				while(true&& flag==true)
				{
					OutputFactory of = new OutputFactory();
					
					System.out.println(" Please select an output method.\n Press 1 for TXT.\n Press 2 for HTML.\n Press 3 for Markdown.\n Press 4 for PDF.\n Type exit to exit.");
					String method = sc.nextLine();
					
					if(method.equals("1"))
					{
						System.out.println("Please insert the output file path");
						IOutputManager om = of.getOutput("txt",output,sc.nextLine());
						om.createFile();
						break;
					
					}
					
					else if(method.equals("2"))
					{
						System.out.println("Please insert the output file path");
						IOutputManager om = of.getOutput("html",output,sc.nextLine());
						om.createFile();
						break;
					}
					
					else if(method.equals("3"))
					{
						System.out.println("Please insert the output file path");
						IOutputManager om = of.getOutput("markdown",output,sc.nextLine());
						om.createFile();
						break;
					}
					
					else if(method.equals("4"))
					{
						System.out.println("Please insert the output file path");
						IOutputManager om = of.getOutput("pdf",output,sc.nextLine());
						om.createFile();
						break;
					}
					
					else if(method.equals("exit"))
					{
						System.out.println("Goodbye!");
						System.exit(4);
					}
					
				}
				continue outerloop;
				
			}
			
		}
	}
}
