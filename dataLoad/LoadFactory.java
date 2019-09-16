package dataLoad;

public class LoadFactory {
	
	public static IDataLoader getOutput(String desiredMethod,String mainFilename,String tagFilename,String ratFilename)
	{
		if (desiredMethod == null)
		{
			return null;
		}
		
		else if ("mainLoad".equals(desiredMethod))
		{
			return new MainLoader();
		}
		
		else if("tagLoad".equals(desiredMethod))
		{
			return new RatTagLoader(tagFilename);
		}
		
		else if("ratLoad".equals(desiredMethod))
		{
			return new RatTagLoader(ratFilename);
		}
		return null;
	}


}
