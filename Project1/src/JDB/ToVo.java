package JDB;

public class ToVo {
	private String td_year;
	private String td_month;
	private String td_day;
	private String td_hour;
	private String td_list;
	
	public ToVo() {
		
	}
	public ToVo(String td_year, String td_month, String td_day, String td_hour, String td_list) {
		this.td_year = td_year;
		this.td_month = td_month;
		this.td_day = td_day;
		this.td_hour = td_hour;
		this.td_list = td_list;
	}
	public String getTd_year() {
		return td_year;
	}
	public String getTd_month() {
		return td_month;
	}
	public String getTd_day() {
		return td_day;
	}
	public String getTd_hour() {
		return td_hour;
	}
	public String getTd_list() {
		return td_list;
	}
}
