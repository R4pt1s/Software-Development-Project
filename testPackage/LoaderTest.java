package testPackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import dataLoad.IDataLoader;
import dataLoad.LoadFactory;
import dataLoad.MainLoader;
import dataLoad.RatTagLoader;

public class LoaderTest 
{
	private LoadFactory loadFactory;
	
	@Before
	public void setUp() throws Exception 
	{
		loadFactory = new LoadFactory();
	}

	@Test
	public void testParserCreation() 
	{
		IDataLoader parser = LoadFactory.getOutput("mainLoad","sth","sth","sth");
		assertNotNull(parser);
		assertTrue(parser instanceof MainLoader);
		
		parser = LoadFactory.getOutput("tagLoad","sth","sth","sth");
		assertNotNull(parser);
		assertTrue(parser instanceof RatTagLoader);
		
		parser = LoadFactory.getOutput("ratLoad","sth","sth","sth");
		assertNotNull(parser);
		assertTrue(parser instanceof RatTagLoader);
	}

	@Test
	public void testParser() 
	{
		IDataLoader parser = LoadFactory.getOutput("mainLoad","sth","sth","sth");
		ArrayList<String[]> tl = parser.loadData("input_test.txt");
		assertNotNull(tl);
	}
	
}
