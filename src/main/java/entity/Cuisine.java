package entity;

public class Cuisine {
	private Integer no;
	private String yname;
	private Double price;
	private Integer s;
	private Double m;
	
	public String getYname() {
		return yname;
	}
	public void setYname(String yname) {
		this.yname = yname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public Integer getS() {
		return s;
	}
	public void setS(Integer s) {
		this.s = s;
	}
	public Double getM() {
		return m;
	}
	public void setM(Double m) {
		this.m = m;
	}
	@Override
	public String toString() {
		return "Cuisine [no=" + no + ", yname=" + yname + ", price=" + price + ", s=" + s + ", m=" + m + "]";
	}
	
	
}
