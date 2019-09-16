package outputManage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class TxtCreator implements IOutputManager {
	
	private String header;
	private String out;
	private String path;
	
	public TxtCreator(String out,String path)
	{
		System.out.println(path);
		this.out = out;
		this.path = path;
		header = new String("");
		header = header.concat("Software Development Assignment \n");
		header = header.concat("The result is:");
		
	}
	

	@Override
	public void createFile() {
		try{
			PrintWriter outputStream = new PrintWriter(new FileOutputStream(path));
			outputStream.println(header);
			outputStream.println(out);
			outputStream.close();
		}
		
		catch (FileNotFoundException e){
			System.out.println("Problem opening files.");
			System.exit(-3);
		}

	}

}
