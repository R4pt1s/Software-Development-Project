package testPackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import dataManage.DataManagerFactory;
import dataManage.ExtendedDataManager;
import dataManage.IDataManager;
import dataManage.MainDataManager;
import dataManage.RatTagDataManager;
import java.util.ArrayList;


public class ManagerTest 
{
	private DataManagerFactory analyserFactory;
	
	@Before
	public void setUp() throws Exception {
		analyserFactory = new DataManagerFactory();
	}

	@Test
	public void testAnalyserCreation() {
		IDataManager analyser = DataManagerFactory.getOutput(movies,actors,directors,genres,countries);
		assertNotNull(analyser);
		assertTrue(analyser instanceof MainDataManager);
		
		analyser = DataManagerFactory.getOutput(movies,actors,directors,genres,countries);
		assertNotNull(analyser);
		assertTrue(analyser instanceof ExtendedDataManager);
		
		analyser = DataManagerFactory.getOutput(tags,ratings);
		assertNotNull(analyser);
		assertTrue(analyser instanceof ExtendedDataManager);		
		
		analyser = DataManagerFactory.getOutput(tags,ratings);
		assertNotNull(analyser);
		assertTrue(analyser instanceof RatTagDataManager);		
	}

	@Test
	public void testAnalyser() {
		IDataManager analyser = DataManagerFactory.getOutput(movies,actors,directors,genres,countries,tags,ratings,desiredMethod);
		ArrayList<String[]> m1 = analyser.getMovie1();
		assertNotNull(m1);

		
		/*IAnalyser analyser = analyserFactory.createAnalyser("NaiveAnalyser");
		ParserFactory parserFactory = new ParserFactory();
		IParser parser = parserFactory.createParser("TestParser");
		assertNotNull(parser);
		
		TimeLine tl = parser.parse("input_test.txt");
		
		assertEquals(7,analyser.producePhasesFromTimeLine(tl).size());
		*/
	}

}
