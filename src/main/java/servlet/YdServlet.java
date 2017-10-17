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
		}
		if("search".equals(action)) {  			//��������
			System.out.println("search");
			String sname = req.getParameter("sname");
			System.out.println(sname);		
			String condition = "yname";			//Ĭ���ǰ������ֲ���
			if(sname.matches(".*[a-zA-z].*")) {
				sname = sname.toLowerCase();	//ת��ΪСд
				condition = "search";			//������д����
			}
			System.out.println("condition:"+condition);
			search(req,res,sname,condition);
		}
		if("buy".equals(action)) {
			String jsons = req.getParameter("json");
			
			ObjectMapper om = new ObjectMapper(); //��ȡmapper
			lst = om.readValue(jsons, new TypeReference<List<BuyEmp>>() {});
			
			System.out.println("lst"+lst);
			for(BuyEmp b : lst) {
				String no = String.valueOf(String.valueOf(b.getNo()).charAt(0));
				System.out.println(no);
				b.setCls(clsMap.get(no));
			}
			System.out.println(lst);
			readJson = om.writeValueAsString(lst);//��json����ת��ΪString	
			System.out.println(readJson);
			res.getWriter().println(readJson);//����json�����web��
			HttpSession session = req.getSession();
			session.setAttribute("msg", readJson);
			//res.getWriter().println(readJson);
			//res.sendRedirect("buy.jsp");
			/*String jsonNum = om.writeValueAsString(jsons);//��json����		
			res.getWriter().println(jsonNum);//����json�����web��
			System.out.println(jsonNum);*/
		}
		if("readJson".equals(action)) {
			HttpSession session = req.getSession();
			String readJs = (String)session.getAttribute("msg");					
			System.out.println(readJs);
			res.getWriter().println(readJs);//����json�����web��

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
