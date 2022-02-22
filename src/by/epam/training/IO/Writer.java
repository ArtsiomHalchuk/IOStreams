package by.epam.training.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


public class Writer {
	private String path;
	Map <String, Integer> map;
	
	
	public Writer(String path, Map<String, Integer> map) {
		super();
		this.path = path;
		this.map = map;
	}
	
	
	public Writer() {
		super();
	}

	public Writer(Map<String, Integer> map) {
		super();
		this.map = map;
	}

	public Writer(String path) {
		super();
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}
	
	public boolean save() throws FileParseException {
		File outputFile = new File(path);
		FileWriter fw = null;
		try {
			fw = new FileWriter(outputFile, true);
			for(Map.Entry<String, Integer> entry: map.entrySet()) {
				String key = entry.getKey();
				Integer value = entry.getValue();
				fw.write(key + " : " + value + System.lineSeparator() );
				fw.flush();
			}
			
		}catch(IOException e) {
			throw new FileParseException(e);
			
		}finally {
			try {
				fw.close();
			}catch(IOException e) {
				throw new FileParseException(e);
			}
		}
		
		return true;
	}
	
	
//	public boolean save() throws FileParseException{
//		File outputFile = new File(path);
//		FileWriter fw = null;
//		try {
//			fw = new FileWriter(outputFile, true);
//            map.forEach((key, value) -> {
//                try {
//                    fw.write(key + " : " + value + System.lineSeparator());
//                    fw.flush();
//                } catch(IOException e) {
//                	e.printStackTrace();
//        			
//        		}
//            });
//        } catch (IOException e) {
//        	throw new FileParseException(e);
//        }finally {
//			try {
//				fw.close();
//			}catch(IOException e) {
//				throw new FileParseException(e);
//			}
//		}
//        return true;
//		
//		
//	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((map == null) ? 0 : map.hashCode());
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
		Writer other = (Writer) obj;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Writer [path=" + path + ", map=" + map + "]";
	}
	
	


	
	
	
	

}
