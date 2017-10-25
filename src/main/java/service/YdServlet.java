package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.CuisineDao;
import dao.Daos;
import dao.UserDAO;
import emp.User;
import entity.Cui;
import service.CuiService;
import web.JsonResult;
import web.PageObject;

public class YdServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		CuisineDao dao = new CuisineDao();
		CuiService cuiService = new CuiService();
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if("/find".equals(action)){
			int pageCurrent=Integer.valueOf(request.getParameter("pageCurrent"));
			String str=request.getParameter("abc");
			List<Cui>  list=Daos.findPageCui(str, pageCurrent);
			int rowCount=Daos.sum(str);
			int pageSize=6;
			int startIndex=(Integer.valueOf(pageCurrent)-1)*pageSize;
			Map<String,Object> map=new HashMap<String,Object>();
			PageObject pageObject=new PageObject();
			pageObject.setPageSize(pageSize);
			pageObject.setStartIndex(startIndex);
			pageObject.setRowCount(rowCount);
			pageObject.setPageCurrent(Integer.valueOf(pageCurrent));
			map.put("list", list);
			map.put("pageObject", pageObject);
			ObjectMapper om=new ObjectMapper();
			String jsstr=om.writeValueAsString(map);
			response.getWriter().println(jsstr);
		}else if("/xg".equals(action)){
			String xg_name=request.getParameter("xg_name");
			String xg_val=request.getParameter("xg_val");
			String xg_vals=request.getParameter("xg_id");
			String[] ids=xg_vals.split(",");
			List<Cui> list= new ArrayList<Cui>();
			if("price".equals(xg_name)){
				Daos.update(xg_vals, xg_name, xg_val);
			}
			if("num".equals(xg_name)){
				Daos.update(xg_vals, xg_name, xg_val);
			}
			for(String s:ids){
				Integer no=Integer.valueOf(s);
				Cui f=Daos.fingByNo(no);
				Daos.update2(f);
				list.add(f);
			}
			ObjectMapper om=new ObjectMapper();
			String jsstr=om.writeValueAsString(list);
			response.getWriter().println(jsstr);
		}else if("/newcp".equals(action)){
			String nos = request.getParameter("nos");
			List<Cui> ls=Daos.findinit(nos);
			request.setAttribute("ls", ls);
			RequestDispatcher rd=request.getRequestDispatcher("buy2.jsp");
			rd.forward(request, response);
		}else if("/manager_id".equals(action)){
			try{
				int id = Integer.parseInt(request.getParameter("username"));
				request.setAttribute("id",id);
				RequestDispatcher rd = request.getRequestDispatcher("cuisine.jsp");
				rd.forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍候重试...");
			}
		}else if("/addCuisine".equals(action)){
			try{
				Cui cui = new Cui();
				String yname = request.getParameter("yname");
				Double price = Double.parseDouble(request.getParameter("price"));
				int num = Integer.parseInt(request.getParameter("num"));
				String path = request.getParameter("path");
				int no = Integer.parseInt(request.getParameter("no"));
				String search = request.getParameter("search");
				cui.setYname(yname);
				cui.setPrice(price);
				cui.setNum(num);
				cui.setPath(path);
				cui.setNo(no);
				cui.setSearch(search);
				dao.saveCuisine(cui);
				response.sendRedirect("addSuccess.jsp");
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍候重试...");
			}
		}else if("/updateCuisine".equals(action)){
			try{
				String nos = request.getParameter("nos");
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));
				Map<String,Object> map = cuiService.findPageObjects_update(nos,po);
				List<Cui> list = dao.update(nos, po.getStartIndex(), po.getPageSize()*po.getPageCurrent());
				request.setAttribute("page", po.getPageCurrent());
				request.setAttribute("ls", map.get(list));
				RequestDispatcher rd=request.getRequestDispatcher("buy2.jsp");
				rd.forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍候重试...");
			}
		}else if("/deleteCuisine".equals(action)){
			try{
				Cui cui = new Cui();
				String c = request.getParameter("nos");
				String[] cs = c.split(",");
				for(String a : cs){
					int cno = Integer.parseInt(a);
					cui.setNo(cno);
					dao.deleteCuisine(cui);
				}
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍候重试...");
			}
		}else if("/di".equals(action)){
			try{
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));////
				Map<String,Object> map = cuiService.findPageObjects_di(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍候重试...");
			}
		}else if("/wi".equals(action)){
			try{
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));////
				Map<String,Object> map = cuiService.findPageObjects_wi(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍候重试...");
			}
		}else if("/mi".equals(action)){
			try{
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));////
				Map<String,Object> map = cuiService.findPageObjects_mi(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍候重试...");
			}
		}else if("/day_cuisine".equals(action)){
			try{
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));////
				Map<String,Object> map = cuiService.findPageObjects_dc(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍候重试...");
			}
		}else if("/day_drinks".equals(action)){
			try{
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));////
				Map<String,Object> map = cuiService.findPageObjects_dd(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍候重试...");
			}
		}else if("/day_pot".equals(action)){
			try{
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));////
				Map<String,Object> map = cuiService.findPageObjects_dp(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍候重试...");
			}
		}else if("/week_cuisine".equals(action)){
			try{
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));////
				Map<String,Object> map = cuiService.findPageObjects_wc(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍候重试...");
			}
		}else if("/week_drinks".equals(action)){
			try{
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));////
				Map<String,Object> map = cuiService.findPageObjects_wd(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍候重试...");
			}
		}else if("/week_pot".equals(action)){
			try{
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));////
				Map<String,Object> map = cuiService.findPageObjects_wp(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍候重试...");
			}
		}else if("/month_cuisine".equals(action)){
			try{
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));////
				Map<String,Object> map = cuiService.findPageObjects_mc(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍候重试...");
			}
		}else if("/month_drinks".equals(action)){
			try{
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));////
				Map<String,Object> map = cuiService.findPageObjects_md(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍候重试...");
			}
		}else if("/month_pot".equals(action)){
			try{
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));////
				Map<String,Object> map = cuiService.findPageObjects_mp(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍候重试...");
			}
		}else if("/ss".equals(action)){
			try{
				PageObject po = new PageObject();
				String name = request.getParameter("sname");
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));////
				Map<String,Object> map = cuiService.findPageObjects_ss(name,po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍候重试...");
			}
		}else if("/sc".equals(action)){
			try{
				PageObject po = new PageObject();
				String name = request.getParameter("sname");
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));////
				Map<String,Object> map = cuiService.findPageObjects_sc(name,po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍候重试...");
			}
		}else if("/si".equals(action)){
			try{
				PageObject po = new PageObject();
				Integer no = Integer.parseInt(request.getParameter("no"));
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));////
				Map<String,Object> map = cuiService.findPageObjects_si(no,po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍候重试...");
			}
		}else if("/ny".equals(action)){
			try{
	
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));////
				Map<String,Object> map = cuiService.findPageObjects_jpny(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍后再试...");
			}
		}else if("/jg".equals(action)){//野锟斤拷锟斤拷锟斤拷
			try{
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));////
				Map<String,Object> map = cuiService.findPageObjects(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍后再试...");
			}
		}else if("/dm".equals(action)){
			try{
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));
				Map<String,Object> map = cuiService.findPageObjects_dmzp(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍后再试...");
			}
		}else if("/hx".equals(action)){
			try{
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));
				Map<String,Object> map = cuiService.findPageObjects_hxhy(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍后再试...");
			}
		}else if("/jd".equals(action)){
			try{
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));
				Map<String,Object> map = cuiService.findPageObjects_jdcp(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍后再试...");
			}
		}else if("/wz".equals(action)){
			try{
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));
				Map<String,Object> map = cuiService.findPageObjects_shwz(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍后再试...");
			}
		}else if("/xxsc".equals(action)){
			try{
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));
				Map<String,Object> map = cuiService.findPageObjects_xxsc(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍后再试...");
			}
		}
		else if("/gd".equals(action)){
			try{
				PageObject po = new PageObject();
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));
			    Map<String,Object> map = cuiService.findPageObjects_mwgd(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍后再试...");
			}
		}else if("/js".equals(action)){
			try{
				PageObject po = new PageObject();
				
				po.setPageCurrent(Integer.parseInt(request.getParameter("pageCurrent")));////
				Map<String,Object> map = cuiService.findPageObjects_mjky(po);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(new JsonResult(map));
				pw.println(jsonStr);
			}catch(Exception e){
				e.printStackTrace();
				pw.println("系统繁忙,请稍后再试...");
			}
		}if("/registcheck".equals(action)){//注册检查id
			ObjectMapper om = new ObjectMapper();
			int id = Integer.parseInt(request.getParameter("id"));
			UserDAO userdao = new UserDAO();
			User user = userdao.findByUsername(id);
			if(user!=null){
				String json = om.writeValueAsString("no");
				pw.println(json);
				return;
			}else{
				String json = om.writeValueAsString("yes");
				pw.println(json);
				return;
			}
		}
		if("/registUser".equals(action)) {//注册VIP
			UserDAO userdao = new UserDAO();
			ObjectMapper om = new ObjectMapper();
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			Double money = Double.parseDouble(request.getParameter("money"));
			User user = new User(id, name, pwd, money);
			int row = userdao.insertUser(user);
			if(row==1){
				String json = om.writeValueAsString("yes");
				pw.println(json);
				return;
			}else{
				String json = om.writeValueAsString("no");
				pw.println(json);
				return;
			}
		}
	}
}
