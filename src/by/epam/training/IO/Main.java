package by.epam.training.IO;

import java.util.Map;


public class Main {

	public static void main(String[] args) {
		String inputfile = "resources/input.java";
		String outputfile = "resources/output.txt";
		
		Reader reader = null;
		Writer writer = null;
		
		try {
			reader = new Reader(inputfile);
			Map <String, Integer> map = reader.read();
//			System.out.println(map);
			writer = new Writer(outputfile, map);
			writer.save();
		} catch (FileParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		}

	}


