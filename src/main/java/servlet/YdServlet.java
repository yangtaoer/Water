
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import dao.Dao;
import dao.UserDAO;
import dao.YdDAO;
import emp.BuyEmp;
import emp.User;
import emp.YdEmp;
import emp.YdManager;
import emp.YdUse;

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
		ObjectMapper om = new ObjectMapper();
		PrintWriter out = res.getWriter();
		UserDAO userdao = new UserDAO();
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
			return;
		}
		if("search".equals(action)) {  			//搜索功能
			
			String sname = req.getParameter("sname");
				
			String condition = "yname";			//默认是按照名字查找
			if(sname.matches(".*[a-zA-z].*")) {
				sname = sname.toLowerCase();	//转换为小写
				condition = "search";			//根据缩写查找
			}			
			search(req,res,sname,condition);
			return;
		}
		if("buy".equals(action)) {	//点餐页面点击提交订单保存数据的请求
			int moneys = 0;
			String jsons = req.getParameter("json");					
			lst = om.readValue(jsons, new TypeReference<List<BuyEmp>>() {});//将json数组字符串转换为list 						
			for(BuyEmp b : lst) {								//将数据进行加工
				String no = String.valueOf(String.valueOf(b.getNo()).charAt(0));
				moneys += b.getPrices();
				b.setCls(clsMap.get(no));
			}			
			readJson = om.writeValueAsString(lst);
			out.println(readJson);
			session.setAttribute("msg", readJson);//绑定json数据再session上	
			System.out.println("msg:-----"+readJson);
			session.setAttribute("moneys",moneys);//绑定总金额在session上
			return;
		}
		if("readJson".equals(action)) {//订单提交页面加载数据请求			
			String readJs = (String)session.getAttribute("msg");								
			out.println(readJs);//发送json对象给web端
			return;
		}
        /*if("back".equals(action)) {  //订单提交页面点击返回点餐请求,需要绑定一个状态值在session表示返回
			String state = "back";
			session.setAttribute("back", state);
			String value = "list";		
			String message = om.writeValueAsString(value);			
			out.println(message);
			return;
		}*/
		
		if("load".equals(action)) {  //点餐页面加载请求购物车信息,先验证是否是订单提交页面back回来	
			if(session.getAttribute("msg")==null){
				System.out.println("-----first----");
				readJson = om.writeValueAsString("first");
				out.println(readJson);
				return;
			}
				String readJs = (String)session.getAttribute("msg");									
				out.println(readJs);//发送json对象给web端	
				return;
		}
	   /*	
		if("data".equals(action)) {  //确认点餐页面是返回,而不是跳转
			if("back".equals(session.getAttribute("back"))){
				String value = "list";
				
				String message = om.writeValueAsString(value);				
				out.println(message);
			}
			return;
		}*/
		
		if("login".equals(action)){//登录请求,用来存储和验证用户信息
			String name = req.getParameter("username");
			String pwd = req.getParameter("password");			
			Dao dao = new Dao();
			YdUse user = dao.FindUser(name);
			YdManager manager = dao.FindManager(name);						
			if(name==""||pwd==""){
				return;
			}			
			if(user==null&&manager==null){
           		String json = om.writeValueAsString("没有个用户名或桌号");
           		out.println(json);          		
           		return;           			
			}else if(user==null&&manager!=null&&!manager.getPsd().equals(pwd)){
				
				String json = om.writeValueAsString("用户名密码错误");
				out.println(json);
				return;
			}
			else if(manager==null&&user!=null&&!user.getPsd().equals(pwd)){
				String json = om.writeValueAsString("桌号密码错误");
				out.println(json);
				return;
			}else if(manager==null&&user!=null&&user.getPsd().equals(pwd)){				
				session = req.getSession();
				session.setAttribute("user",user);
				session.setAttribute("userId",user.getId());
				String json = om.writeValueAsString("桌号登陆成功");
				out.println(json);				
				return;
			}
			else if(user==null&&manager!=null&&manager.getPsd().equals(pwd)){
				session = req.getSession();
				session.setAttribute("manager",manager);
				String json = om.writeValueAsString("用户登陆成功");
				out.println(json);
				return;
			}
			return;
		}
		if("getLoginMsg".equals(action)) {//每个页面的用户session验证
				if(session.getAttribute("user")!=null) {				
					YdUse user = (YdUse)session.getAttribute("user");
					System.out.println("user"+user);
					int id = user.getD_num();					
					String message = om.writeValueAsString(id);				
					out.println(message);
				}
				return;
		}
		if("exit".equals(action)) {             //移除session上的userId信息
			session.removeAttribute("userId");
		}
		if("getMoney".equals(action)) {        //买单页面获取总金额
			int moneys = (Integer)session.getAttribute("moneys");
			String json = om.writeValueAsString(moneys);
			out.println(json);
			return;
		}
		if("checkvip".equals(action)) {        //检查vip卡号
			System.out.println("开始检查卡号----");
			String username = req.getParameter("user");	
			int card = Integer.parseInt(username);
			System.out.println("card--------:"+card);
			session.setAttribute("card",card);
			try{
				User user = userdao.findByUsername(card);
				System.out.println("user:"+user);
				if(user==null){
					String json = om.writeValueAsString("notfoundcard");
					out.println(json);
					return;
				}else{
					String json = om.writeValueAsString("foundcard");
					out.println(json);
					return;
				}
				
			}catch(Exception e){
				e.printStackTrace();
				out.println("系统繁忙，稍后重试");
			}
		}
		if("checkpwd".equals(action)) {        //检查密码
			System.out.println("开始检查密码----");
			int card = (Integer) session.getAttribute("card");
			String pwd = req.getParameter("pwd");						
			System.out.println("pwd:"+pwd);
			try{
				String password = userdao.findPasswordByUsername(card);
				System.out.println("查询的密码:"+password);
				if(!pwd.equals(password)) {
					String json = om.writeValueAsString("pwderror");
					out.println(json);
					return;
				}else{
					String json = om.writeValueAsString("pwdright");
					out.println(json);
					return;
				}
				
			}catch(Exception e){
				e.printStackTrace();
				out.println("系统繁忙，稍后重试");
			}
		}
		if("checkmoney".equals(action)) {       //检查余额
			System.out.println("开始检查余额----");
			String desk = req.getParameter("deskId");
			System.out.println("deskno:"+desk);
			int deskNo = Integer.parseInt(desk.substring(0,1));
			String monet = req.getParameter("money");
			if(monet==null){
				String json = om.writeValueAsString("您还没有买任何东西!");
				out.println(json);
				return;
			}
			String money = monet.substring(0, monet.length()-1);
			Double prices = Double.parseDouble(money);	
			int card = Integer.parseInt(req.getParameter("card"));
			System.out.println("cardmongey:---"+card);
			System.out.println("prices:"+prices);
			try{
				Double balance = userdao.findMoneyByOrder(card);
				if(balance==null){
					return;
				}
				if(balance>=prices){ 		//支付,并改变余额
					int row = userdao.updateMoney(balance-prices, card);
					if(row>0){
						int rows = userdao.insertIndent(deskNo, prices);//保存订单信息
						if(rows>0){
							String json = om.writeValueAsString("支付成功!当前余额:"+(balance-prices));
							out.println(json);
							System.out.println("json-----"+json);
							session.removeAttribute("msg");
							return;
						} else {
							String json = om.writeValueAsString("支付失败!");
							out.println(json);
							return;
						}
					}
				} else {
					String json = om.writeValueAsString(balance);
					out.println(json);
					return;
				}
			}catch(Exception e){
				e.printStackTrace();
				out.println("系统繁忙，稍后重试");
			}
		}
		if("registcheck".equals(action)){//注册检查id
			int id = Integer.parseInt(req.getParameter("id"));
			User user = userdao.findByUsername(id);
			if(user!=null){
				String json = om.writeValueAsString("no");
				out.println(json);
				return;
			}else{
				String json = om.writeValueAsString("yes");
				out.println(json);
				return;
			}
		}
		if("registUser".equals(action)) {//注册VIP
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String pwd = req.getParameter("pwd");
			Double money = Double.parseDouble(req.getParameter("money"));
			User user = new User(id, name, pwd, money);
			System.out.println(user);
			int row = userdao.insertUser(user);
			if(row==1){
				String json = om.writeValueAsString("yes");
				out.println(json);
				return;
			}else{
				String json = om.writeValueAsString("no");
				out.println(json);
				return;
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
