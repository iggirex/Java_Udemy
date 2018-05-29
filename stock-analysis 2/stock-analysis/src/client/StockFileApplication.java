package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class StockFileApplication {
	
	public static void main(String args[]) throws IOException{
		StockFileReader fr = new StockFileReader("stock-analysis/table.csv");
		
		List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
		StockFileData fileData = new StockFileData();
		fileData.addData(dataResult);
		fileData.printData();
		System.out.println(dataResult.size());
	}
	/**
	 * Complete the method body so that it returns the given structure needed to 
	 * populate the data field in the StockFileData class. 
	 * @param headers
	 * @param lines
	 * @return List
	 */
public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines){
		
		List<HashMap<String, Double>> dataResult = new ArrayList<>();

		for(String line :  lines) {
			if(line != null) {
				
				HashMap<String, Double> thisDay = new HashMap<String, Double>();
				String [] values = line.split(",");
				
				for(int i = 0; i < headers.size(); i++) {
					double doubleValue = Double.parseDouble(values[i]);
					thisDay.put(headers.get(i), doubleValue);
				}
				dataResult.add(thisDay);
			}
		}
		return dataResult;
	}
	
	
}
