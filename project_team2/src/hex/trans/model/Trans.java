package hex.trans.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Trans {

	private Integer trans_num;
	private String item;
	private Integer change_num;
	private Date t_date;
	// 여기서 지점을 등록뷰에서 보려면 지점도 넣어줘야 함

	public Trans(Integer trans_num, String item, Integer change_num, Date t_date) {
		this.trans_num = trans_num;
		this.item = item;
		this.change_num = change_num;
		this.t_date = t_date;
	}

	public Integer getTrans_num() {
		return trans_num;
	}

	public String getItem() {
		return item;
	}

	public Integer getChange_num() {
		return change_num;
	}

	public Date getT_date() {
		return t_date;
	}

	
	
	public String getFormattedT_date() {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		return sdf.format(this.t_date);
	}

	public void setFormattedT_date(String formattedDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		this.t_date = sdf.parse(formattedDate);
	}

	
	
}
