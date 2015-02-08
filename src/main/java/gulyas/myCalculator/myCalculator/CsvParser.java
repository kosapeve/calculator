package gulyas.myCalculator.myCalculator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public final class CsvParser {

	public List<String[]> parse(String inputFileName) {

		CSVReader reader;

		try {
			reader = new CSVReader(new FileReader(inputFileName), ';');
			String[] header = reader.readNext();
			List<String[]> myEntries = reader.readAll();
			return myEntries;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
