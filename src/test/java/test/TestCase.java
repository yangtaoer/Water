package test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.YdDAO;
import emp.BuyEmp;
import emp.YdEmp;

/**
 * ≤‚ ‘¿‡
 * @author admin
 *
 */
public class TestCase {

	
	@Test
	public void test1() {//≤‚ ‘“¿æ›±Ì√˚≤È’“
		YdDAO yd = new YdDAO();
		List<YdEmp> list = yd.findByTableName("yd_jd");
		for(YdEmp e : list) {
			System.out.println(e.toString());
		}
	}
	@Test
	public void testJson() throws JsonParseException, JsonMappingException, IOException {
		String jsr = "[{'name':'∑¨«—ªπ¯','price':11,'prices':11},{'name':'≈£”Õ¬È¿±ªπ¯','price':35,'prices':35},{'name':'»˝œ ªπ¯','price':32,'prices':32}]";
		//String jsr = jsons.substring(1, jsons.length()-1);
		//System.out.println(jsr);
		jsr = jsr.replace("\\'","");
		ObjectMapper mapper = new ObjectMapper();
		//JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, BuyEmp.class);  
		//Map¿‡–Õ    
		/*mapper.getTypeFactory().constructParametricType(HashMap.class,String.class, BuyEmp.class);  
		List<BuyEmp> lst =  (List<BuyEmp>)mapper.readValue(jsr, javaType); */ 
	
		List<BuyEmp> lst = mapper.readValue(jsr, new TypeReference<List<BuyEmp>>() {});
		System.out.println(lst);
		String []js = jsr.split("\\*");
		System.out.println(Arrays.toString(js));
	}
}
