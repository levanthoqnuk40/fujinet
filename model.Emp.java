package source;

public class Emp {
	private String customer_id;  
	private String customer_name;  
	private String sex;  
	private String birthday; 
	private String address; 
	//getters and setters  
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Emp [customer_id=" + customer_id + ", customer_name=" + customer_name + ", sex=" + sex + ", birthday="
				+ birthday + ", address=" + address + "]";
	}
	
	
	
}

