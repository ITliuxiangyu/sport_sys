package mysql_model.demo;

public class AreaModel {

	private String idt_area;
	private String img;
	private String is_yue;
	private String yue_person;
	private String yue_time;
	private String title;
	private String bianhao;
 
	// idt_area
	public String getIdt_area() {
		return idt_area;
	}
 
	public void setIdt_area(String idt_area) {
		this.idt_area = idt_area;
	}
	
	
	// bianhao
	public String getBianhao() {
		return bianhao;
	}
 
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	
	
	
	// title
	public String getTitle() {
		return title;
	}
 
	public void setTitle(String title) {
		this.title = title;
	}

	
	
	
	// img
	public String getImg() {
		return img;
	}
 
	public void setImg(String img) {
		this.img = img;
	}
	
	
	
	
	
	// is_yue
	public String getIs_yue() {
		return is_yue;
	}
 
	public void setIs_yue(String is_yue) {
		this.is_yue = is_yue;
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
	
	
	
 
	
	// idt_area  img   is_yue  yue_person  yue_time 
	 
 
 
	@Override
	public String toString() {
		return "AreaModel [idt_area=" + idt_area + ", img=" + img + ", is_yue=" + is_yue + ", yue_person=" + yue_person + ", yue_time=" + yue_time  + ", title=" + title + ",bianhao=" + bianhao + "]";
	}
 
	public AreaModel(String idt_area, String img, String is_yue , String yue_person , String yue_time , String title , String bianhao) {
		super();
		this.idt_area = idt_area;
		this.img = img;
		this.is_yue = is_yue;
		this.yue_person = yue_person;
		this.yue_time = yue_time;
		this.title = title;
		this.bianhao = bianhao;
	}
 
	public AreaModel() {
		super();
	}
	
}
