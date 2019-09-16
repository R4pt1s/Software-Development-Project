package outputManage;

public class OutputFactory {
	
	public IOutputManager getOutput(String desiredMethod,String out,String path)
	{
		if (desiredMethod == null)
		{
			return null;
		}
		
		else if ("txt".equals(desiredMethod))
		{
			return new TxtCreator(out,path);
		}
		
		else if("html".equals(desiredMethod))
		{
			return new HtmlCreator(out,path);
		}
		
		else if("markdown".equals(desiredMethod))
		{
			return new MarkdownCreator(out,path);
		}
		
		else if("pdf".equals(desiredMethod))
		{
			return new PdfCreator(out,path);
		}
		
		return null;
	}

}
