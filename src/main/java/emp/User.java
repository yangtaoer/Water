package emp;

public class User {
	public User(){
		
	}
	public User(int id, String username, String password, Double money) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.money = money;
	}
	private int id;
	private String username;
	private String password;
	private Double money;
	
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", money=" + money + "]";
	}
	
	
}
