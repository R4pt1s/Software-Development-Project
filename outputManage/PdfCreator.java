package outputManage;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Header;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
//import mainPackage.PdfPrinter;

public class PdfCreator implements IOutputManager {
	
	private String out;
	private String path;
	
	public PdfCreator(String out,String path)
	{
		this.out = out;
		this.path = path;
	}

	@Override
	public void createFile()
	{
		try{
			Document document = new Document();
	        PdfWriter.getInstance(document, new FileOutputStream(path));
	        document.open();
	        Font f = new Font(FontFamily.TIMES_ROMAN, 25.0f, Font.BOLD, BaseColor.BLACK);
	        Chunk c = new Chunk("Software Development Assignment", f);
	        document.add(new Paragraph(c));
	        document.add(new Paragraph("The result is :"));
	        document.add(new Paragraph(out));
	        document.close();
		}	
		catch (Exception e){
			System.out.println("Problem writing to file.");
			System.exit(-1);
		}
	}

}
