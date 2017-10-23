package emp;

import java.util.Date;

/**
 * 存放数据的类
 * @author admin
 *
 */
public class YdEmp {
	
	private String name;	//菜品名
	private int price;		//菜品价格
	private int num;		//菜品库存
	private Date update;	//更新日期
	private String path;	//图片路径
	private int no;			//菜品编号
	private String search;  //首字母缩写
	
	public YdEmp() {
		
	}
	
	public YdEmp(String name, int price, int num, Date update, String path, int no, String search) {
		super();
		this.name = name;
		this.price = price;
		this.num = num;
		this.update = update;
		this.path = path;
		this.no = no;
		this.search = search;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	@Override
	public String toString() {
		return "YdEmp [name=" + name + ", price=" + price + ", num=" + num + ", update=" + update + ", path=" + path
				+ ", no=" + no + ", search=" + search + "]";
	}
	
	
}
