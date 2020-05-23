package mysql_model.demo;

public class EquipModel {

	private String idt_equip;
	private String name;
	private String num;
 
	
	// idt_equip
	public String getIdt_equip() {
		return idt_equip;
	}
 
	public void setIdt_equip(String idt_equip) {
		this.idt_equip = idt_equip;
	}

		
	
	// num
	public String getNum() {
		return num;
	}
 
	public void setNum(String num) {
		this.num = num;
	}
	
	
	
	
	// name
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	
	// idt_equip  name  num  
	 
 
 
	@Override
	public String toString() {
		return "EquipModel [idt_equip=" + idt_equip + ", name=" + name + ", num="  + "]";
	}
 
	public EquipModel(String idt_equip, String name, String num) {
		super();
		this.idt_equip = idt_equip;
		this.name = name;
		this.num = num;
	}
 
	public EquipModel() {
		super();
	}
	
}
