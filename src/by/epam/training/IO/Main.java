package by.epam.training.IO;

import java.util.Map;


public class Main {

	public static void main(String[] args) {
		String inputfile = "resources/input.java";
		String outputfile = "resources/output.txt";
		
		IOReader reader = null;
		IOWriter writer = null;
		IOCounter counter = new IOCounter();
		
		try {
			reader = new IOReader(inputfile);
			String text = reader.read();
			Map <String, Integer> map = counter.count(text);
			writer = new IOWriter(outputfile, map);
			writer.save();
		} catch (FileParseException e) {
			e.printStackTrace();
		}
		

		}

	}


