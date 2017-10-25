package test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import dao.YdDAO;
import emp.SellObject;

/**
 * 测试类
 * @author admin
 *
 */
public class TestCase {

	
	/*@Test
	public void test1() {//测试依据表名查找
		YdDAO yd = new YdDAO();
		List<YdEmp> list = yd.findByTableName("yd_jd");
		for(YdEmp e : list) {
			System.out.println(e.toString());
		}
	}
	@Test
	public void testJson() throws JsonParseException, JsonMappingException, IOException {
		String jsr = "[{'name':'番茄火锅','price':11,'prices':11},{'name':'牛油麻辣火锅','price':35,'prices':35},{'name':'三鲜火锅','price':32,'prices':32}]";
		//String jsr = jsons.substring(1, jsons.length()-1);
		//System.out.println(jsr);
		jsr = jsr.replace("\\'","");
		ObjectMapper mapper = new ObjectMapper();
		//JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, BuyEmp.class);  
		//Map类型    
		mapper.getTypeFactory().constructParametricType(HashMap.class,String.class, BuyEmp.class);  
		List<BuyEmp> lst =  (List<BuyEmp>)mapper.readValue(jsr, javaType);  
	
		List<BuyEmp> lst = mapper.readValue(jsr, new TypeReference<List<BuyEmp>>() {});
		System.out.println(lst);
		String []js = jsr.split("\\*");
		System.out.println(Arrays.toString(js));
	}*/
	@Test
	public void test(){
		String str = "abcd";
		System.out.println(str.substring(0,str.length()-1));
	}
	@Test
	public void test1(){
		byte c=(byte)211;
		// 1 2 4 8 16 32 64 128
		//                   1  
		//				  1	
		//		    1
		// 1 1
		//11001011
		//11010011
		//10101101  1+4+8+32
		
		
		System.out.println(c);
	}
	@Test
	public void test2(){
		YdDAO yd = new YdDAO();
		List<SellObject> ranklist = yd.rank();//查询到的菜品销售信息
		SellObject []rankjson = new SellObject[ranklist.size()];//保存发送的数据
		HashMap<String,Integer> map = new HashMap<String, Integer>();//存放菜品名称,保证重复
		for(int i=0;i<ranklist.size();i++){
			SellObject so = ranklist.get(i);
			if(map.containsKey(so.getYname())){//查看是否已存在于rankjson中
				System.out.println("----重----");
				SellObject soj = rankjson[map.get(so.getYname())];//元素拿出来
				soj.setSums(soj.getSums()+so.getSums());//把元素的数量相加				
				rankjson[map.get(so.getYname())] = soj;//重新添加
			} else {					
				rankjson[i] = so;//添加元素
				map.put(so.getYname(), i);//保存元素名,以及存储位置
			}
		}			
		
		/*Collections.sort(rankjsons,new Comparator<SellObject>() {
			public int compare(SellObject o1, SellObject o2) {
				return o1.getSums()-o2.getSums();
			}
		});*/
		System.out.println("---map---"+map);
		for(SellObject o : ranklist){
			System.out.println("---o---"+o);
		}
	}
	
	@Test
	public void test3(){
		YdDAO yd = new YdDAO();
		List<SellObject> ranklist = yd.rank();//查询到的菜品销售信息
		HashMap<String,SellObject> map = new HashMap<String,SellObject>();
		Iterator<SellObject> it = ranklist.iterator();
		while(it.hasNext()) {
		  SellObject so = it.next();
		   if(map.containsKey(so.getYname())){
			   // System.out.println("重复!");
			    SellObject soj = map.get(so.getYname());
			    soj.setSums(soj.getSums()+so.getSums());
			    soj.setMoney(soj.getMoney()+so.getMoney());
			    map.put(soj.getYname(),soj);
		   }else{
			  // System.out.println("---不重复---");
			   	map.put(so.getYname(), so);
		   }
		}
		ranklist.clear();
		Iterator<Map.Entry<String, SellObject>> itmap = map.entrySet().iterator();
		  while (itmap.hasNext()) {
		   Entry<String, SellObject> entry = itmap.next();
		   ranklist.add(entry.getValue());
		  }
		 Collections.sort(ranklist,new Comparator<SellObject>() {
				public int compare(SellObject o1, SellObject o2) {
					return o2.getSums()-o1.getSums();
				}
		});
		 
		 for(SellObject s : ranklist){
			 System.out.println(s.getYname()+"\t\t"+s.getSums()+"\t\t"+s.getMoney());
		 }
		
	}
}
