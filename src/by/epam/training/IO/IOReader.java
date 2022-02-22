package by.epam.training.IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;




public class IOReader {
	private String path;


	
	public IOReader(String path, IOCounter counter) {

		this.path = path;
	}

	public IOReader(String path) {

		this.path = path;
	}



	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}


	
	public String read() throws FileParseException{
		BufferedReader fr = null;

		String text;
		
		try {
			fr = new BufferedReader(new FileReader(path));
			StringBuilder stringBuilder = new StringBuilder();
			String line;
						
			while((line=fr.readLine()) != null) {
				stringBuilder.append(line);
			}
			text = stringBuilder.toString();

			
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
		
		return text;		

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		IOReader other = (IOReader) obj;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IOReader [path=" + path + "]";
	}
	
	
	
	

}
