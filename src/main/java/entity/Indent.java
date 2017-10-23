package entity;

import java.util.Date;

public class Indent {
	private int id;
	private int num1;
	private Date consumption;
	private double money;
	private String cp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public Date getConsumption() {
		return consumption;
	}
	public void setConsumption(Date consumption) {
		this.consumption = consumption;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
}
