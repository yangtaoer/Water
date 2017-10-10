package test;

import java.util.List;

import org.junit.Test;

import dao.YdDAO;
import emp.YdEmp;

/**
 * 测试类
 * @author admin
 *
 */
public class TestCase {

	
	@Test
	public void test1() {//测试依据表名查找
		YdDAO yd = new YdDAO();
		List<YdEmp> list = yd.findByTableName("yd_jd");
		for(YdEmp e : list) {
			System.out.println(e.toString());
		}
	}
}
