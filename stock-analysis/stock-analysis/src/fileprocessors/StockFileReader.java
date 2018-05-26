package fileprocessors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StockFileReader {
	
	String filePath = null;
	
	public StockFileReader(String filePath){
		this.filePath = filePath;
	}
	
	public List<String> getHeaders() throws IOException{
		String line = readFirstLine(filePath);
		String [] header = line.split(",");
		List<String> values = new ArrayList<String>();
		values = Arrays.asList(header);
		return values;
	}
	
	static String readFirstLine(String path) throws IOException {
	    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	        return br.readLine();
	    }
	}
	/**
	 * Complete the body of this method.
	 * @return List
	 * @throws IOException
	 */
	
	public List<String> readFileData() throws IOException{
		
		List<String> lines = new LinkedList<String>();
				
		// Insert your code here..
		try (FileReader fileReader = new FileReader(this.filePath);
				BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
			
			String line = br.readLine();
			
			while(line != null) {
				line = br.readLine();
				lines.add(line);
			}
			
		}
		
		catch (IOException e) {
			System.out.println("StockReader having trouble reading the csv file");
			throw(e);
		}

	    return lines;
	}
	

}
