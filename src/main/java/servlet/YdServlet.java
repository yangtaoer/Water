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
import dao.YdDAO;
import emp.BuyEmp;
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
			String jsons = req.getParameter("json");			
			ObjectMapper om = new ObjectMapper(); //��ȡmapper
			lst = om.readValue(jsons, new TypeReference<List<BuyEmp>>() {});//��json�����ַ���ת��Ϊlist 						
			for(BuyEmp b : lst) {								//�����ݽ��мӹ�
				String no = String.valueOf(String.valueOf(b.getNo()).charAt(0));
				
				b.setCls(clsMap.get(no));
			}			
			readJson = om.writeValueAsString(lst);
			res.getWriter().println(readJson);
			session.setAttribute("msg", readJson);//��json������session��	
			return;
		}
		if("readJson".equals(action)) {//�����ύҳ�������������			
			String readJs = (String)session.getAttribute("msg");								
			res.getWriter().println(readJs);//����json�����web��
			return;
		}
		if("back".equals(action)) {  //�����ύҳ�������ص������,��Ҫ��һ��״ֵ̬��session��ʾ����
			String state = "back";
			session.setAttribute("back", state);
			String value = "list";
			ObjectMapper om = new ObjectMapper(); //��ȡmapper
			String message = om.writeValueAsString(value);			
			res.getWriter().println(message);
			return;
		}
		
		if("load".equals(action)) {  //���ҳ����������ﳵ��Ϣ,����֤�Ƿ��Ƕ����ύҳ��back����			
				String readJs = (String)session.getAttribute("msg");									
				res.getWriter().println(readJs);//����json�����web��	
				return;
		}
		
		if("data".equals(action)) {  //ȷ�ϵ��ҳ���Ƿ���,��������ת
			if("back".equals(session.getAttribute("back"))){
				String value = "list";
				ObjectMapper om = new ObjectMapper(); //��ȡmapper
				String message = om.writeValueAsString(value);				
				res.getWriter().println(message);
			}
			return;
		}
		
		if("login".equals(action)){//��¼����,�����洢����֤�û���Ϣ
			String name = req.getParameter("username");
			String pwd = req.getParameter("password");			
			Dao dao = new Dao();
			YdUse user = dao.FindUser(name);
			YdManager manager = dao.FindManager(name);
			ObjectMapper om = new ObjectMapper(); 
			PrintWriter out = res.getWriter();
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
				if(session.getAttribute("userId")!=null) {					
					YdUse user = (YdUse)session.getAttribute("user");
					int id = user.getD_num();
					ObjectMapper om = new ObjectMapper(); //��ȡmapper
					String message = om.writeValueAsString(id);				
					res.getWriter().println(message);
				}
				return;
		}
		if("exit".equals(action)) {//�Ƴ�session�ϵ�userId��Ϣ
			session.removeAttribute("userId");
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
