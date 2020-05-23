package mysql_model.demo;

public class YueModel {

	private String idt_yue_log;
	private String yue_person;
	private String yue_time;
	private String area_id;
	private String yue_type;
	private String area_name;
	private String area_bianhao;
	
	
	// area_name
	public String getArea_name() {
		return area_name;
	}
 
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	
	
	// area_bianhao
	public String getArea_bianhao() {
		return area_bianhao;
	}
 
	public void setArea_bianhao(String area_bianhao) {
		this.area_bianhao = area_bianhao;
	}
 
	
	// idt_yue_log
	public String getIdt_yue_log() {
		return idt_yue_log;
	}
 
	public void setIdt_yue_log(String idt_yue_log) {
		this.idt_yue_log = idt_yue_log;
	}
	
	
	// yue_person
	public String getYue_person() {
		return yue_person;
	}
 
	public void setYue_person(String yue_person) {
		this.yue_person = yue_person;
	}
	
	
	// yue_time
	public String getYue_time() {
		return yue_time;
	}
	public void setYue_time(String yue_time) {
		this.yue_time = yue_time;
	}
	
	
	//area_id
	public String getArea_id() {
		return area_id;
	}
	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}
	
	
	// yue_type
	public String getYue_type() {
		return yue_type;
	}
	public void setYue_type(String yue_type) {
		this.yue_type = yue_type;
	}
	
	
	
	
	// idt_yue_log yue_person  yue_time  area_id  yue_type;
 
 
	@Override
	public String toString() {
		return "YueModel [idt_yue_log=" + idt_yue_log + ", yue_person=" + yue_person + ", yue_time=" + yue_time + ", area_id=" + area_id + ", yue_type=" + yue_type  + ", area_name=" + area_name + ", area_bianhao=" + area_bianhao+ "]";
	}
 
	public YueModel(String idt_yue_log, String yue_person, String yue_time, String area_id, String yue_type , String area_name , String area_bianhao) {
		super();
		this.idt_yue_log = idt_yue_log;
		this.yue_person = yue_person;
		this.yue_time = yue_time;
		this.area_id = area_id;
		this.yue_type = yue_type;
		this.area_name = area_name;
		this.area_bianhao = area_bianhao;
	}
 
	public YueModel() {
		super();
	}
	
}
