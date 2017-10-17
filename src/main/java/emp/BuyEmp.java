package emp;

public class BuyEmp {
	private String name;
	private int price;
	private int prices;
	private int no;
	private String cls;
	

	public BuyEmp(String name, int price, int prices, int no, String cls) {
		super();
		this.name = name;
		this.price = price;
		this.prices = prices;
		this.no = no;
		this.cls = cls;
	}
	public BuyEmp() {
		
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public int getPrices() {
		return prices;
	}
	public void setPrices(int prices) {
		this.prices = prices;
	}
	
	@Override
	public String toString() {
		return "BuyEmp [name=" + name + ", price=" + price + ", prices=" + prices + ", no=" + no + ", cls=" + cls + "]";
	}
	
}
