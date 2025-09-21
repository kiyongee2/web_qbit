package product2;

public class Product {
	private String pid;
	private String pname;
	private String maker;
	private int price;
	private String date;
	
	//생성자
	public Product(String pid, String pname, String maker, 
			int price, String date) {
		this.pid = pid;
		this.pname = pname;
		this.maker = maker;
		this.price = price;
		this.date = date;
	}
	
	public String getPid() {
		return pid;
	}
	
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
