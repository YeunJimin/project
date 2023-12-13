package hex.apply.service;

import java.sql.Date;

public class Goods {

    private String trans_num;
    private String item;
    private String change_num;
    private Date t_date;

    // Constructor
    public Goods(String trans_num, String item, String change_num, Date t_date) {
        this.trans_num = trans_num;
        this.item = item;
        this.change_num = change_num;
        this.t_date = t_date;
    }

    // Getters and setters (if needed)
}