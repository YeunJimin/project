package hex.trans.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import hex.trans.model.Trans;
import jdbc.JdbcUtil;

public class TransDao {

    public Trans selectByTrans(Connection conn, String trans_num) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Replace with the actual SQL SELECT query
            pstmt = conn.prepareStatement("SELECT * FROM your_table WHERE trans_num = ?");
            pstmt.setString(1, trans_num);
            rs = pstmt.executeQuery();

            Trans trans = null;
            if (rs.next()) {
                trans = new Trans(rs.getInt("trans_num"), rs.getString("item"), rs.getInt("change_num"),
                        rs.getDate("t_date"));
            }

            return trans;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }

    public Trans insert(Connection conn, Trans tr) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(
                "INSERT INTO trans_list (Trans_num, Item, Change_num, T_date) VALUES (?, ?, ?, ?)")) {
            pstmt.setInt(1, tr.getTrans_num());
            pstmt.setString(2, tr.getItem());
            pstmt.setInt(3, tr.getChange_num());
            pstmt.setDate(4, new Date(tr.getT_date().getTime()));
            pstmt.executeUpdate();
        }

        return tr;
    }

    public void update(Connection conn, Trans tr) throws SQLException {
        try (PreparedStatement pstmt = conn
                .prepareStatement("UPDATE trans_list SET Item = ?, Change_num = ?, T_date = ? WHERE Trans_num = ?")) {
            pstmt.setString(1, tr.getItem());
            pstmt.setInt(2, tr.getChange_num());
            pstmt.setDate(3, new Date(tr.getT_date().getTime()));
            pstmt.setInt(4, tr.getTrans_num());
            pstmt.executeUpdate();
        }
    }
}