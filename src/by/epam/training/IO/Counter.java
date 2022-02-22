package by.epam.training.IO;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Counter {
	private static final Pattern p = Pattern.compile("byte|short|int|long|char|float|double|boolean|if|else|switch|case|default|while|do|break|continue|for|try|catch|finally|throw|throws|private|protected|public|import|package|class|interface|extends|implements|static|final|void|abstract|native|new|return|this|super|synchronized|volatile|const|goto|instanceof|enum|assert|transient|strictfp");
	
	
	public Counter() {
		super();
	}
	
	public Map <String, Integer> count(String text) {
		Map <String, Integer> map = new HashMap<>();
		Matcher m = p.matcher(text);
		String buff;
		while (m.find()) {
			buff = m.group(0);
			if (map.containsKey(buff)){
				Integer val = map.get(buff);
				map.replace(buff, val+1);
			}else {
				map.put(buff, 1);
			}
		}
		return map;
	}
	
	
	
	
	


}
