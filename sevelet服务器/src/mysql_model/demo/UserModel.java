package mysql_model.demo;

public class UserModel {
	private String idt_user;
	private String username;
	private String account;
	private String password;
	private String gender;
	private String birthday;
	private String tel;
	private String type;
 
	// idt_user
	public String getIdt_user() {
		return idt_user;
	}
 
	public void setIdt_user(String idt_user) {
		this.idt_user = idt_user;
	}
	
	// type
	public String getType() {
		return type;
	}
 
	public void setType(String type) {
		this.type = type;
	}
	
	
	// user name
	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	// account
	public String getAccount() {
		return account;
	}
 
	public void setAccount(String account) {
		this.account = account;
	}
	
	
	
	// password
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	// gender
	public String getGender() {
		return gender;
	}
 
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
	// birthday
	public String getBirthday() {
		return birthday;
	}
 
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
	
	
	// t el
	public String getTel() {
		return tel;
	}
 
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
 
	
	// idt_user  user name  account  password  gender  birthday  t el
	 
 
 
	@Override
	public String toString() {
		return "UserModel [idt_user=" + idt_user + ", username=" + username + ", account=" + account + ", password=" + password + ", gender=" + gender + ", birthday=" + birthday + ", tel=" + tel  + ", type=" + type + "]";               
	}
 
	public UserModel(String idt_user, String username, String account , String password , String gender , String birthday , String tel , String type) {
		super();
		this.idt_user = idt_user;
		this.username = username;
		this.account = account;
		this.password = password;
		this.gender = gender;
		this.birthday = birthday;
		this.tel = tel;
		this.type = type;
	}
 
	public UserModel() {
		super();
	}
}
