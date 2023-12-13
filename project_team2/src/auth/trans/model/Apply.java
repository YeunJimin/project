package auth.trans.model;

import java.sql.Date;

public class Register {
	
	private int trans_num;
	private String item;
	private Integer change_num;
	private Date t_date;
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

}
