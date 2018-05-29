package aggregators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;
import client.StockFileApplication;


public class AggregatorProcessor {
	
	// read the file --> import file reader	
	
	StockFileReader myReader = new StockFileReader("/stock-analysis/table.csv");
	
//	StockFileApplication myStocks = new StockFileApplication();
	
//	HashMap myStockHash = myStocks.populateStockFileData(myStocks.headers, myStocks.lines);
	
	
	
//	StockFileData myStockData = myStocks.fileData;
	
	
	
	public static ArrayList readFile() throws IOException {
		
		System.out.println("readFile is running");
		
//		StockFileApplication myStocks = new StockFileApplication();
		
		ArrayList result = new ArrayList();
		
		StockFileReader myReader = new StockFileReader("stock-analysis/table.csv");
		
		List<HashMap<String, Double>> dataResult = StockFileApplication.populateStockFileData(myReader.getHeaders(), myReader.readFileData());
		
		System.out.println("HOLY FICK: this is dataResult: " + dataResult);
		
		return result;
		
	}
	
	
	List<String> lines = new ArrayList<String>();

	
	// split the read file into columns ?? maybe aggregator classes already do this
	
	// make generic method ?? takes in type of Aggregator, returns read file result
	
	
}
