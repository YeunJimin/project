package hex.apply.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import hex.trans.dao.TransDao;
import hex.trans.model.Trans;
import jdbc.connection.ConnectionProvider;

public class ApplyService {

    private TransDao transdao = new TransDao();

    public Goods apply(Integer trans_num, String item, Integer change_num, Date t_date) {
        try (Connection conn = ConnectionProvider.getConnection()) {
            Trans tr = new Trans(trans_num, item, change_num, t_date);  // Create a Trans object
            Trans trans = transdao.insert(conn, tr);

            if (trans == null) {
                throw new InputFailException();  // Ensure InputFailException is defined
            }

            // Assuming Goods class has a constructor that takes the necessary parameters
            return new Goods(trans.getTrans_num(), trans.getItem(), trans.getChange_num(), trans.getT_date());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}