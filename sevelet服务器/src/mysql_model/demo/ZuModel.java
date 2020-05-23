package mysql_model.demo;

public class ZuModel {

	
	private String idt_zu_log;
	private String equip_id;
	private String equip_name;
	private String equip_num;
	private String user_name;
	private String user_id;
	private String caozuo;
	
	
	// idt_zu_log
	public String getIdt_zu_log() {
		return idt_zu_log;
	}
 
	public void setIdt_zu_log(String idt_zu_log) {
		this.idt_zu_log = idt_zu_log;
	}
	
	
	// 操作
	public String getCaozuo() {
		return caozuo;
	}
 
	public void setCaozuo(String caozuo) {
		this.caozuo = caozuo;
	}
	
	
	// equip_id
	public String getEquip_id() {
		return equip_id;
	}
 
	public void setEquip_id(String equip_id) {
		this.equip_id = equip_id;
	}
 
	
	// equip_name
	public String getEquip_name() {
		return equip_name;
	}
 
	public void setEquip_name(String equip_name) {
		this.equip_name = equip_name;
	}
	
	
	// equip_num
	public String getEquip_num() {
		return equip_num;
	}
 
	public void setEquip_num(String equip_num) {
		this.equip_num = equip_num;
	}
	
	
	// user_name
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	
	//user_id
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
	
	
	
	
	//user_id
		// user_name
			// equip_num
				// equip_name
					// equip_id
						// idt_zu_log
 
 
	@Override
	public String toString() {
		return "YueModel [idt_zu_log=" + idt_zu_log + ", equip_id=" + equip_id + ", equip_name=" + equip_name + ", equip_num=" + equip_num + ", user_name=" + user_name  + ", user_id=" + user_id +  ", caozuo=" + caozuo + "]";
	}
 
	public ZuModel(String idt_zu_log, String equip_id, String equip_name, String equip_num, String user_name , String user_id , String caozuo) {
		super();
		this.idt_zu_log = idt_zu_log;
		this.equip_id = equip_id;
		this.equip_name = equip_name;
		this.equip_num = equip_num;
		this.user_name = user_name;
		this.user_id = user_id;
		this.caozuo = caozuo;
	}
 
	public ZuModel() {
		super();
	}
	
	
}
