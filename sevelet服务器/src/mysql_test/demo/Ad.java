package mysql_test.demo;

public class Ad {

	private String adid;
	private String position;
	private String imgs;
 
	public String getId() {
		return adid;
	}
 
	public void setId(String id) {
		this.adid = id;
	}
 
	public String getPosition() {
		return position;
	}
 
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getImgs() {
		return imgs;
	}
 
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
 
	
 
 
	@Override
	public String toString() {
		return "Ad [adid=" + adid + ", imgs=" + imgs + ", position=" + position  + "]";
	}
 
	public Ad(String id, String position, String imgs) {
		super();
		this.adid = id;
		this.position = position;
		this.imgs = imgs;
	}
 
	public Ad() {
		super();
	}

}
