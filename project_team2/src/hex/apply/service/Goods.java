package hex.apply.service;

import java.sql.Date;

public class Goods {

    private Integer trans_num;
    private String item;
    private Integer change_num;
    private Date t_date;

    // Constructor
    public Goods(Integer trans_num, String item, Integer change_num, java.util.Date date) {
        this.trans_num = trans_num;
        this.item = item;
        this.change_num = change_num;
        this.t_date = (Date) date;
    }

    // Getters and setters (if needed)
}