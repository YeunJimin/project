package auth.trans.service;

import java.sql.Date;
import java.util.Map;

public class ApplyRequest {
	
	private int trans_num;
	private String item;
	private Integer change_num;
	private Date t_date;
	
	public ApplyRequest(int trans_num, String item, int change_num, Date t_date) {
		this.trans_num=trans_num;
		this.item=item;
		this.change_num=change_num;
		this.t_date=t_date;
		
	}

	public int getTrans_num() {
		return trans_num;
	}

	public void setTrans_num(int trans_num) {
		this.trans_num = trans_num;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getChange_num() {
		return change_num;
	}

	public void setChange_num(Integer change_num) {
		this.change_num = change_num;
	}

	public Date getT_date() {
		return t_date;
	}

	public void setT_date(Date t_date) {
		this.t_date = t_date;
	}

	public void validate(Map<String,Boolean> errors) {
		checkEmpty(errors, item, "item");
		checknumbs(errors, change_num, "change_num");
		checkdate(errors, t_date, "t_date");
	}

	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if(value == null || value.isEmpty())
			errors.put(fieldName, Boolean.TRUE);
	}
	
	private void checknumbs(Map<String, Boolean> errors, Integer value, String fieldName) {
		if(value == null)
			errors.put(fieldName, Boolean.TRUE);
	}
	
	private void checkdate(Map<String, Boolean> errors, Date value, String fieldName) {
		if(value == null)
			errors.put(fieldName, Boolean.TRUE);
	}
	

}
