package json;

public class JsonReader {  
	 public static String[] acceptJSON(String jsons){
		 jsons = jsons.substring(1, jsons.length()-1);
			String jsr = jsons.replace("},{","}*{");
			String []js = jsr.split("\\*");
			return js;
	 }
}
