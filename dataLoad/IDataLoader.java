package dataLoad;

import java.util.ArrayList;

public interface IDataLoader {
	
	public abstract ArrayList<String[]> loadData(String filename);

}
