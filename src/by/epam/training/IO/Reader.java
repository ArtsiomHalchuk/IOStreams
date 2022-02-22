package by.epam.training.IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class Reader {
	private String path;
	private Counter counter = new Counter();

	
	public Reader(String path, Counter counter) {

		this.path = path;
		this.counter = counter;
	}

	public Reader(String path) {

		this.path = path;
	}

	@Override
	public String toString() {
		return "Reader [path=" + path + ", counter=" + counter + "]";
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Counter getCounter() {
		return counter;
	}

	public void setCounter(Counter counter) {
		this.counter = counter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((counter == null) ? 0 : counter.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reader other = (Reader) obj;
		if (counter == null) {
			if (other.counter != null)
				return false;
		} else if (!counter.equals(other.counter))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}
	
	
	
	public Map <String, Integer> read() throws FileParseException{
		BufferedReader fr = null;
		Map <String, Integer> map = new HashMap<>();
		
		
		try {
			fr = new BufferedReader(new FileReader(path));
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			while((line=fr.readLine()) != null) {
				stringBuffer.append(line);
			}
			String text = stringBuffer.toString();
//			System.out.println(text);
			map = counter.count(text);
			
		}catch(FileNotFoundException e) {
			throw new FileParseException(e);
		}catch(IOException e) {
			throw new FileParseException(e);
		}finally {
			if(fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					throw new FileParseException(e);
				}
			}			
		}
		return map;
				

	}
	
	

}
