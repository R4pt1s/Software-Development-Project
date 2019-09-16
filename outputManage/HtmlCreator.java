package outputManage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class HtmlCreator implements IOutputManager {
	
	private String header;
	private String out;
	private String path;
	
	public HtmlCreator(String out,String path)
	{
		this.out = out;
		this.path = path;
		
		header = new String("");
		header = header.concat("<!doctype html>");
		header = header.concat("\n");
		header = header.concat("<html>");
		header = header.concat("<body bgcolor=\"#838383\">");
		header = header.concat("\n");
		header = header.concat("<head>");
		header = header.concat("\n");
		header = header.concat("<meta http-equiv=\"Content-Type\" content\"text/html; charset=windows-1253\">");
		header = header.concat("\n");
		header = header.concat("<title>Result</title>");
		header = header.concat("\n");
		header = header.concat("</head>");
		header = header.concat("\n");
		header = header.concat("<body>");
		header = header.concat("\n");
	}

	@Override
	public void createFile() {
		try{
			PrintWriter outputStream = new PrintWriter(new FileOutputStream(path));
			outputStream.println(header);
			
			outputStream.println("<h1>Software Development Assignment</h1>");
			outputStream.println("<img src=\"C:\\test\\rai.jpg\" alt=\"Fucked2\">");
			outputStream.println("<h2>The result is</h2>");
			String newOut = out.replace("\n","<br>");
			outputStream.println(newOut);
			outputStream.println("</body>\n</html>");
			outputStream.close();
		}
		
		catch (FileNotFoundException e){
			System.out.println("Problem creating files.");
			System.exit(-1);
		}
		

	}

}
