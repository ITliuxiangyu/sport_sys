package mysql_model.demo;

public class NewsModel {

	private String idt_news;
	private String title;
	private String detail;
	private String news_time;
 
	// idt_news
	public String getIdt_news() {
		return idt_news;
	}
 
	public void setIdt_news(String idt_news) {
		this.idt_news = idt_news;
	}
	
	
	
	
	
	// news_time
	public String getNews_time() {
		return news_time;
	}
 
	public void setNews_time(String news_time) {
		this.news_time = news_time;
	}
	
	// title
	public String getTitle() {
		return title;
	}
 
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
	// detail
	public String getDetail() {
		return detail;
	}
 
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
	
 
	
	// idt_news  title  detail  
	 
 
 
	@Override
	public String toString() {
		return "NewsModel [idt_news=" + idt_news + ", title=" + title + ", detail=" + detail   + "news_time=" + news_time + "]";                
	}
 
	public NewsModel(String idt_news, String title, String detail , String news_time) {
		super();
		this.idt_news = idt_news;
		this.title = title;
		this.detail = detail;
		this.news_time = news_time;
	}
 
	public NewsModel() {
		super();
	}
	
}
