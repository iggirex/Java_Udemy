package aggregators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;
import client.StockFileApplication;


public class AggregatorProcessor <E>{
	
	// read the file --> import file reader	
//	public static void readFile() throws IOException {
//		StockFileReader myReader = new StockFileReader("stock-analysis/table.csv");
//		List<HashMap<String, Double>> dataResult = StockFileApplication.populateStockFileData(myReader.getHeaders(), myReader.readFileData());
//		System.out.println("HOLY FICK: this is dataResult: " + dataResult);		
//	}
	// split the read file into columns ?? maybe aggregator classes already do this
	// make generic method ?? takes in type of Aggregator, returns read file result
	
	
	
	
	// --------------------- Make constructor object that takes in type of aggregator
	
	public AggregatorProcessor (ArrayList<? extends Aggregator> typeOfAggregator, String stockFile) {
//		typeOfAggregator result = new typeOfAggregator();
		
		
		
	}
	
	public static int runAggregator(int columnNumber) throws IOException {
		
		StockFileReader myReader = new StockFileReader("stock-analysis/table.csv");
		List<HashMap<String, Double>> dataResult = StockFileApplication.populateStockFileData(myReader.getHeaders(), myReader.readFileData());
		
		double[] columnNumbers = new double[251];
		
		
		
		for(HashMap<String, Double> columnNumber1 : dataResult) {
			System.out.println(columnNumber1);
			
		}
		
		int result = 3;
		
		return result;
		
	}
	

	
	
}
