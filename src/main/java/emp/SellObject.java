package emp;

import java.util.Date;

public class SellObject {
	private int id;
	private String yname;
	private double price;
	private int sums;
	private double money;
	private Date day;
	private int Moth;
	private int no;
	private String path;
	
	public SellObject(){
		
	}
	public SellObject(int id, String yname, double price, int sums, double money, Date day, int moth, int no,
			String path) {
		
		this.id = id;
		this.yname = yname;
		this.price = price;
		this.sums = sums;
		this.money = money;
		this.day = day;
		Moth = moth;
		this.no = no;
		this.path = path;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYname() {
		return yname;
	}
	public void setYname(String yname) {
		this.yname = yname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSums() {
		return sums;
	}
	public void setSums(int sums) {
		this.sums = sums;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public int getMoth() {
		return Moth;
	}
	public void setMoth(int moth) {
		Moth = moth;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "SellObject [id=" + id + ", yname=" + yname + ", price=" + price + ", sums=" + sums + ", money=" + money
				+ ", day=" + day + ", Moth=" + Moth + ", no=" + no + ", path=" + path + "]";
	}
	
	
}
