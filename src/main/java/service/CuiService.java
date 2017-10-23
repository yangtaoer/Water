package service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import dao.CuisineDao;
import entity.Cui;
import entity.Cuisine;
import entity.Indent;
import web.PageObject;

public class CuiService {
	private CuisineDao dao;
	/**��ѯ���ղ�Ʒ*/
	public Map<String, Object> findPageObjects_dc(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cuisine> list=
				dao.day_cuisine(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_dc();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	public Map<String, Object> findPageObjects(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cui> list=
				dao.find_YSJG(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_ysjg();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**��ζ����*/
	public Map<String, Object> findPageObjects_mwgd(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cui> list=
				dao.find_MWGD(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_mwgd();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**��������*/
	public Map<String, Object> findPageObjects_hxhy(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cui> list=
				dao.find_HXHY(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_hxhy();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**�����Ʒ*/
	public Map<String, Object> findPageObjects_jdcp(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cui> list=
				dao.find_JDCP(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_jdcp();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**������Ʒ*/
	public Map<String, Object> findPageObjects_dmzp(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cui> list=
				dao.find_DMZP(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_dmzp();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**�����߲�*/
	public Map<String, Object> findPageObjects_xxsc(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cui> list=
				dao.find_XXSC(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_xxsc();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**˳������*/
	public Map<String, Object> findPageObjects_shwz(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cui> list=
				dao.find_SHWZ(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_shwz();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**精品牛羊*/
	public Map<String, Object> findPageObjects_jpny(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cui> list=
				dao.find_JPNY(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_jpny();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**美酒酷饮*/
	public Map<String, Object> findPageObjects_mjky(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cui> list=
				dao.find_MJKY(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_mjky();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**今日酒水*/
	public Map<String, Object> findPageObjects_dd(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cuisine> list=
				dao.day_drink(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_dd();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**今日锅底*/
	public Map<String, Object> findPageObjects_dp(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cuisine> list=
				dao.day_pot(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_dp();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**本周菜品*/
	public Map<String, Object> findPageObjects_wc(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cuisine> list=
				dao.week_cuisine(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_wc();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**本周酒水*/
	public Map<String, Object> findPageObjects_wd(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cuisine> list=
				dao.week_drink(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_wd();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**本周锅底*/
	public Map<String, Object> findPageObjects_wp(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cuisine> list=
				dao.week_pot(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_wp();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**本月菜品*/
	public Map<String, Object> findPageObjects_mc(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cuisine> list=
				dao.month_cuisine(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_mc();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**本月酒水*/
	public Map<String, Object> findPageObjects_md(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cuisine> list=
				dao.month_drink(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_md();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**本月锅底*/
	public Map<String, Object> findPageObjects_mp(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cuisine> list=
				dao.month_pot(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_mp();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**今日订单*/
	public Map<String, Object> findPageObjects_di(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Indent> list=
				dao.di(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_di();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**本周订单*/
	public Map<String, Object> findPageObjects_wi(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Indent> list=
				dao.wi(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_wi();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**本月订单*/
	public Map<String, Object> findPageObjects_mi(PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Indent> list=
				dao.mi(
				startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_mi();
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**模糊查询销量*/
	public Map<String, Object> findPageObjects_ss(String name,PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cuisine> list=
				dao.ss(
				name,startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_ss(name);
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**模糊查询菜品*/
	public Map<String, Object> findPageObjects_sc(String name,PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cui> list=
				dao.sc(
				name,startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_sc(name);
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**模糊查询订单*/
	public Map<String, Object> findPageObjects_si(Integer no,PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Indent> list=
				dao.si(
				no,startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_si(no);
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	/**模糊查询销量*/
	public Map<String, Object> findPageObjects_update(String nos,PageObject po) {
		dao = new CuisineDao();
		int pageSize =po.getPageSize();
		int pageCurrent = po.getPageCurrent();
		int startIndex=(pageCurrent-1)*pageSize;
		List<Cui> list=
				dao.update(
				nos,startIndex,pageSize*pageCurrent);
		int rowCount=
				dao.findRow_update(nos);
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		Map<String,Object>  map=
				new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
}
