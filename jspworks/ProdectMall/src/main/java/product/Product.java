 package product;

public class Product {
	private String pid;
	private String pname;
	private String maker;
	private int price;
	private String regdate;
	
	//생성자
	public Product(String pid, String pname, String maker, 
			int price, String regdate) {
		this.pid = pid;
		this.pname = pname;
		this.maker = maker;
		this.price = price;
		this.regdate = regdate;
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}
