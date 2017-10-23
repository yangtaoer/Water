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
		String action = uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));//����uri��β
		res.setCharacterEncoding("utf-8");  //���ñ����ʽ
		res.setContentType("text/html");  //������Ϣͷ
		req.setCharacterEncoding("utf-8");
		Map<String,String> clsMap = new HashMap<String,String>();
		clsMap.put("1", "��ζ����");clsMap.put("2", "˳������");
		clsMap.put("3", "�����Ʒ");clsMap.put("4", "��Ʒţ��");
		clsMap.put("5", "���ʺ���");clsMap.put("6", "������Ʒ");
		clsMap.put("7", "Ұ������");clsMap.put("8", "�����߲�");
		clsMap.put("9", "���ƿ���");		
		String readJson = null;
		List<BuyEmp> lst = null;
		HttpSession session = req.getSession();		
		ObjectMapper om = new ObjectMapper();
		PrintWriter out = res.getWriter();
		UserDAO userdao = new UserDAO();
		/**
		 * ���е�����ǰ׺������:
		 * mwgd��shwz��jdcp��jpny��hxhy
		 * dmzp��ysjg��xxsc��mjky
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
		if("change".equals(action)) {  			//ʹ��ajax��������ҳ��
			String name = req.getParameter("name");
			changed(req,res,name);
			return;
		}
		if("search".equals(action)) {  			//��������
			
			String sname = req.getParameter("sname");
				
			String condition = "yname";			//Ĭ���ǰ������ֲ���
			if(sname.matches(".*[a-zA-z].*")) {
				sname = sname.toLowerCase();	//ת��ΪСд
				condition = "search";			//������д����
			}			
			search(req,res,sname,condition);
			return;
		}
		if("buy".equals(action)) {	//���ҳ�����ύ�����������ݵ�����
			int moneys = 0;
			String jsons = req.getParameter("json");					
			lst = om.readValue(jsons, new TypeReference<List<BuyEmp>>() {});//��json�����ַ���ת��Ϊlist 						
			for(BuyEmp b : lst) {								//�����ݽ��мӹ�
				String no = String.valueOf(String.valueOf(b.getNo()).charAt(0));
				moneys += b.getPrices();
				b.setCls(clsMap.get(no));
			}			
			readJson = om.writeValueAsString(lst);
			out.println(readJson);
			session.setAttribute("msg", readJson);//��json������session��	
			System.out.println("msg:-----"+readJson);
			session.setAttribute("moneys",moneys);//���ܽ����session��
			return;
		}
		if("readJson".equals(action)) {//�����ύҳ�������������			
			String readJs = (String)session.getAttribute("msg");								
			out.println(readJs);//����json�����web��
			return;
		}
        /*if("back".equals(action)) {  //�����ύҳ�������ص������,��Ҫ��һ��״ֵ̬��session��ʾ����
			String state = "back";
			session.setAttribute("back", state);
			String value = "list";		
			String message = om.writeValueAsString(value);			
			out.println(message);
			return;
		}*/
		
		if("load".equals(action)) {  //���ҳ����������ﳵ��Ϣ,����֤�Ƿ��Ƕ����ύҳ��back����	
			if(session.getAttribute("msg")==null){
				System.out.println("-----first----");
				readJson = om.writeValueAsString("first");
				out.println(readJson);
				return;
			}
				String readJs = (String)session.getAttribute("msg");									
				out.println(readJs);//����json�����web��	
				return;
		}
	   /*	
		if("data".equals(action)) {  //ȷ�ϵ��ҳ���Ƿ���,��������ת
			if("back".equals(session.getAttribute("back"))){
				String value = "list";
				
				String message = om.writeValueAsString(value);				
				out.println(message);
			}
			return;
		}*/
		
		if("login".equals(action)){//��¼����,�����洢����֤�û���Ϣ
			String name = req.getParameter("username");
			String pwd = req.getParameter("password");			
			Dao dao = new Dao();
			YdUse user = dao.FindUser(name);
			YdManager manager = dao.FindManager(name);						
			if(name==""||pwd==""){
				return;
			}			
			if(user==null&&manager==null){
           		String json = om.writeValueAsString("û�и��û���������");
           		out.println(json);          		
           		return;           			
			}else if(user==null&&manager!=null&&!manager.getPsd().equals(pwd)){
				
				String json = om.writeValueAsString("�û����������");
				out.println(json);
				return;
			}
			else if(manager==null&&user!=null&&!user.getPsd().equals(pwd)){
				String json = om.writeValueAsString("�����������");
				out.println(json);
				return;
			}else if(manager==null&&user!=null&&user.getPsd().equals(pwd)){				
				session = req.getSession();
				session.setAttribute("user",user);
				session.setAttribute("userId",user.getId());
				String json = om.writeValueAsString("���ŵ�½�ɹ�");
				out.println(json);				
				return;
			}
			else if(user==null&&manager!=null&&manager.getPsd().equals(pwd)){
				session = req.getSession();
				session.setAttribute("manager",manager);
				String json = om.writeValueAsString("�û���½�ɹ�");
				out.println(json);
				return;
			}
			return;
		}
		if("getLoginMsg".equals(action)) {//ÿ��ҳ����û�session��֤
				if(session.getAttribute("user")!=null) {				
					YdUse user = (YdUse)session.getAttribute("user");
					System.out.println("user"+user);
					int id = user.getD_num();					
					String message = om.writeValueAsString(id);				
					out.println(message);
				}
				return;
		}
		if("exit".equals(action)) {             //�Ƴ�session�ϵ�userId��Ϣ
			session.removeAttribute("userId");
		}
		if("getMoney".equals(action)) {        //��ҳ���ȡ�ܽ��
			int moneys = (Integer)session.getAttribute("moneys");
			String json = om.writeValueAsString(moneys);
			out.println(json);
			return;
		}
		if("checkvip".equals(action)) {        //���vip����
			System.out.println("��ʼ��鿨��----");
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
				out.println("ϵͳ��æ���Ժ�����");
			}
		}
		if("checkpwd".equals(action)) {        //�������
			System.out.println("��ʼ�������----");
			int card = (Integer) session.getAttribute("card");
			String pwd = req.getParameter("pwd");						
			System.out.println("pwd:"+pwd);
			try{
				String password = userdao.findPasswordByUsername(card);
				System.out.println("��ѯ������:"+password);
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
				out.println("ϵͳ��æ���Ժ�����");
			}
		}
		if("checkmoney".equals(action)) {       //������
			System.out.println("��ʼ������----");
			String desk = req.getParameter("deskId");
			System.out.println("deskno:"+desk);
			int deskNo = Integer.parseInt(desk.substring(0,1));
			String monet = req.getParameter("money");
			if(monet==null){
				String json = om.writeValueAsString("����û�����κζ���!");
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
				if(balance>=prices){ 		//֧��,���ı����
					int row = userdao.updateMoney(balance-prices, card);
					if(row>0){
						int rows = userdao.insertIndent(deskNo, prices);//���涩����Ϣ
						if(rows>0){
							String json = om.writeValueAsString("֧���ɹ�!��ǰ���:"+(balance-prices));
							out.println(json);
							System.out.println("json-----"+json);
							session.removeAttribute("msg");
							return;
						} else {
							String json = om.writeValueAsString("֧��ʧ��!");
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
				out.println("ϵͳ��æ���Ժ�����");
			}
		}
		if("registcheck".equals(action)){//ע����id
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
		if("registUser".equals(action)) {//ע��VIP
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
		//��ͬҳ�棬֮ǰ��ҳ������������ʹ��
		
		*//**
		 * ����˵��:
		 * tn:���ݿ���� ac:ҳ����ǰ׺
		 *//*
		List<YdEmp> list = new LinkedList<YdEmp>();
		YdDAO yd = new YdDAO();
		list = yd.findByTableName(tn); //���ݿ����
		req.setAttribute(ac+"_list",list);
		req.setAttribute("size", list.size());//����������
		try {
			req.getRequestDispatcher(ac+".jsp").forward(req, res);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//ת��
		
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
		list = yd.findByTableName("yd_"+name); //���ݿ����
		ObjectMapper om = new ObjectMapper(); //��ȡmapper
		String jsonNum = om.writeValueAsString(list);//��json����		
		res.getWriter().println(jsonNum);//����json�����web��
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
		ObjectMapper om = new ObjectMapper(); //��ȡmapper
		String jsonNum = om.writeValueAsString(list);//��json����		
		res.getWriter().println(jsonNum);//����json�����web��
	}
	
	
}
