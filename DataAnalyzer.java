import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataAnalyzer {

	/**
	 * The symbol of the stock we are interested in, for ex: AAPL stands for Apple,
	 * GE stands for General Electric, etc..
	 * 
	 */
	private String symbol;

	/**
	 * A list to hold all dates read from the market data file
	 */
	private ArrayList<Date> dates;

	/**
	 * A list to hold all closing prices from the market data file
	 */
	private ArrayList<Double> closePrices;
	
	
	/**
	 * A hashmap which will hold the stock market data, mapping the value of the stock with its current day.
	 */
	private TreeMap<Date, Double> data = new TreeMap<>();
	
	private final String COMMMA_DELIMETER = ",";

	private final int DATE_POSITION = 0;

	private final int CLOSE_PRICES_POSITION = 1;

	private final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("MM/dd/yyyy");

	private String symbolDesired;
	/**
	 * Constructor which takes in the symbol of interest in order to parse the
	 * correct data file. For example if we receive AAPL, we need to call loadData
	 * with the following string <APPL.csv> Consider searching for resources on
	 * modifying strings to concatenate <.csv>
	 * 
	 * @param symbol
	 * @throws IOException
	 * @throws ParseException 
	 */

	public DataAnalyzer(String symbolDesired) throws IOException, ParseException {
		
			//TODO
		this.symbolDesired = symbolDesired;
		
	}
	/**
	 * This method will take care of parsing the market data of the specified symbol. 
	 * Using a BufferedReader and FileReader load the <symbol> i.e the file name into it to prepare for reading the file.
	 * Until the file is not null, read in the date and closePrice data. My suggestion is to use an an array of some sort to hold the current line values
	 * split by a comma. So if we were looking at the line 3/25/13, 12.00, split these values into an array and then pick the positions of the 
	 * date and stock value to store into the TreeMap. 
	 * The TreeMap will map the date to the value of the stock on that day.
	 * Also, store the Close prices and Date into their respective ArrayLists.
	 * 
	 * 
	 * 
	 * @param symbol
	 * @throws IOException
	 * @throws ParseException 
	 */
	private TreeMap<Date, Double> loadData(String symbol) throws IOException, ParseException {
		//TODO
		
		String fileName = symbol + ".csv";
		
		Scanner line = new Scanner( new FileReader(fileName));
		ArrayList<String[]> stringArray = new ArrayList<String[]>();
		
		line.nextLine();
		
		while(line.hasNext()) {
			stringArray.add(line.nextLine().split(COMMMA_DELIMETER));
		}
	
		line.close();
		
		
		
		for(int x =0;x<stringArray.size();x++) {
			Date date = parseDate(stringArray.get(x)[DATE_POSITION]);
			double closeDoub = formattedClosePrices(stringArray.get(x)[CLOSE_PRICES_POSITION]);
			data.put(date,closeDoub);
		}
		
		this.dates = new ArrayList<Date>(data.keySet());
		this.closePrices = new ArrayList<Double>(data.values());
		return data;
			 
			 }
	
	/**
	 * Given a string representation of a date, parse it into Date object.
	 * @param date
	 * @return the string representation converted into a date object.
	 * @throws ParseException
	 */
	public Date parseDate(String date) throws ParseException {
		//TODO:
		
		Date dater = DATE_FORMATTER.parse(date);
		return dater;
	}
	/**
	 * Given a String representation of the closePrice, round it to two decimal places and then convert it into a double.
	 * @param closePrice 
	 * @return the string representation of close price converted into a double.
	 */
	public Double formattedClosePrices(String closePrice){
		//TODO:
		DecimalFormat df2 = new DecimalFormat("#.##");
		String close = df2.format(closePrice);
		
		double parsedClose = Double.parseDouble(close);
		return parsedClose;
		
		
	}
	
	//TODO: Generate getters and setters
	public  TreeMap<Date, Double> getData() {
		return data;
	}
	
	public ArrayList<Date> getDates(){
		return dates;
	}

	
}
