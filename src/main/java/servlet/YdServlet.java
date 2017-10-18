package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.YdDAO;
import emp.BuyEmp;
import emp.YdEmp;

public class YdServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException{
		String uri = req.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));//解析uri结尾
		res.setCharacterEncoding("utf-8");  //设置编码格式
		res.setContentType("text/html");  //设置消息头
		req.setCharacterEncoding("utf-8");
		Map<String,String> clsMap = new HashMap<String,String>();
		clsMap.put("1", "美味锅底");clsMap.put("2", "顺滑丸子");
		clsMap.put("3", "经典菜品");clsMap.put("4", "精品牛羊");
		clsMap.put("5", "海鲜河鱼");clsMap.put("6", "豆面制品");
		clsMap.put("7", "野生菌菇");clsMap.put("8", "新鲜蔬菜");
		clsMap.put("9", "美酒酷饮");		
		String readJson = null;
		List<BuyEmp> lst = null;
		HttpSession session = req.getSession();
		/**
		 * 所有导航的前缀可能性:
		 * mwgd、shwz、jdcp、jpny、hxhy
		 * dmzp、ysjg、xxsc、mjky
		 */
		/*		List<String> actions = new ArrayList<String>();
		actions.add("mwgd");actions.add("shwz");
		actions.add("jdcp");actions.add("jpny");
		actions.add("hxhy");actions.add("dmzp");
		actions.add("ysjg");actions.add("xxsc");
		actions.add("mjky");

		if(actions.contains(action)) {
			fBTN(req, res, "yd_"+action, action);
		}*/
		if("change".equals(action)) {  			//使用ajax技术更新页面
			String name = req.getParameter("name");
			changed(req,res,name);			
		}
		if("search".equals(action)) {  			//搜索功能
			System.out.println("search");
			String sname = req.getParameter("sname");
			System.out.println(sname);		
			String condition = "yname";			//默认是按照名字查找
			if(sname.matches(".*[a-zA-z].*")) {
				sname = sname.toLowerCase();	//转换为小写
				condition = "search";			//根据缩写查找
			}
			System.out.println("condition:"+condition);
			search(req,res,sname,condition);
		}
		if("buy".equals(action)) {	//点餐页面点击提交订单保存数据的请求
			String jsons = req.getParameter("json");
			
			ObjectMapper om = new ObjectMapper(); //获取mapper
			lst = om.readValue(jsons, new TypeReference<List<BuyEmp>>() {});//将json数组字符串转换为list 			
			System.out.println("lst"+lst);
			for(BuyEmp b : lst) {								//将数据进行加工
				String no = String.valueOf(String.valueOf(b.getNo()).charAt(0));
				System.out.println(no);
				b.setCls(clsMap.get(no));
			}			
			readJson = om.writeValueAsString(lst);
			res.getWriter().println(readJson);
			session.setAttribute("msg", readJson);//绑定json数据再session上			
		}
		if("readJson".equals(action)) {//订单提交页面加载数据请求			
			String readJs = (String)session.getAttribute("msg");					
			System.out.println(readJs);
			res.getWriter().println(readJs);//发送json对象给web端

		}
		if("back".equals(action)) {  //订单提交页面点击返回点餐请求,需要绑定一个状态值在session表示返回
			String state = "back";
			session.setAttribute("back", state);
			String value = "list";
			ObjectMapper om = new ObjectMapper(); //获取mapper
			String message = om.writeValueAsString(value);
			System.out.println(message);
			res.getWriter().println(message);
			
		}
		if("load".equals(action)) {  //点餐页面加载请求购物车信息,先验证是否是订单提交页面back回来			
				String readJs = (String)session.getAttribute("msg");					
				System.out.println("load---"+readJs);
				res.getWriter().println(readJs);//发送json对象给web端	
		}
		
		if("data".equals(action)) {
			if("back".equals(session.getAttribute("back"))){
				String value = "list";
				ObjectMapper om = new ObjectMapper(); //获取mapper
				String message = om.writeValueAsString(value);
				System.out.println(message);
				res.getWriter().println(message);
			}
		}
	}
	
/*	private static void fBTN(HttpServletRequest req, HttpServletResponse res,String tn,String ac) {
		//不同页面，之前分页面做法，不再使用
		
		*//**
		 * 参数说明:
		 * tn:数据库表名 ac:页面名前缀
		 *//*
		List<YdEmp> list = new LinkedList<YdEmp>();
		YdDAO yd = new YdDAO();
		list = yd.findByTableName(tn); //数据库表名
		req.setAttribute(ac+"_list",list);
		req.setAttribute("size", list.size());//绑定数据条数
		try {
			req.getRequestDispatcher(ac+".jsp").forward(req, res);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//转发
		
	}*/
	
	/**
	 * 
	 * @param req 
	 * @param res
	 * @param name
	 * @throws IOException
	 */
	private static void changed(HttpServletRequest req, HttpServletResponse res,String name) throws IOException {
		List<YdEmp> list = new LinkedList<YdEmp>();
		YdDAO yd = new YdDAO();
		list = yd.findByTableName("yd_"+name); //数据库表名
		ObjectMapper om = new ObjectMapper(); //获取mapper
		String jsonNum = om.writeValueAsString(list);//绑定json对象		
		res.getWriter().println(jsonNum);//发送json对象给web端
	}
	
	/**
	 * 
	 * @param req
	 * @param res
	 * @param sname
	 * @throws IOException
	 */
	private static void search(HttpServletRequest req, HttpServletResponse res,String sname,String condition) throws IOException {
		List<YdEmp> list = new LinkedList<YdEmp>();
		YdDAO yd = new YdDAO();
		list = yd.findByName(sname,condition);
		ObjectMapper om = new ObjectMapper(); //获取mapper
		String jsonNum = om.writeValueAsString(list);//绑定json对象		
		res.getWriter().println(jsonNum);//发送json对象给web端
	}
	
	
}
