package entity;

import java.util.Date;

public class Cui {
	private int id;
	private String yname;
	private double price;
	private int num;
	private Date update_time;
	private String path;
	private int no;
	private String search;
	/*
	public Cui( int id,String yname,double price,int num,Date update_time, 
			String path,int no,String search){
		this.id=id;
		this.yname=yname;
		this.price=price;
		this.num=num;
		this.update_time=update_time;
		this.path=path;
		this.no=no;
		this.search=search;
	}
	*/
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
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
		return "Cui [id=" + id + ", yname=" + yname + ", price=" + price + ", num=" + num + ", update_time="
				+ update_time + ", path=" + path + ", no=" + no + ", search=" + search + "]";
	}
}
