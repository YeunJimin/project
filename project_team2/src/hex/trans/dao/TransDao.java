package hex.trans.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Date;

import hex.trans.model.Trans;
import jdbc.JdbcUtil;

public class TransDao {

	public Trans selectByTrans(Connection conn, String trans_num) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try { // 데이터베이스에 쿼리를 보내는

			// prepareStatement생성(원하는 쿼리)
			pstmt = conn.prepareStatement("");
			pstmt.setString(1, trans_num); // 쿼리 실행 및 결과를 ResultSet에 저장
			rs = pstmt.executeQuery();
			// 조회된 데이터가 있는지 확인
			Trans trans = null;
			if (rs.next()) {
				// 조회된 데이터로 Trans 객체 생성
				trans = new Trans(rs.getInt("trans_num"), rs.getString("item"), rs.getInt("change_num"),
						rs.getDate("t_date"));

			} // 조회된 Trans 객체 반환

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

	        // Return the Trans object after insertion
	        return tr;
	    }

	    // ... (existing code)
	

	public void update(Connection conn, Trans tr) throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("update member set name = ?, password = ? where memberid = ?")) {
			pstmt.setDate(1, new Date(tr.getT_date().getTime()));
			pstmt.setString(2, tr.getItem());
			pstmt.setInt(3, tr.getChange_num());
			pstmt.setInt(4, tr.getTrans_num());
			pstmt.executeUpdate();
		}
		// 업데이트 순서에 따라 다르기때문에 넘버를 기준으로 제일 늦게 적어야함

	}

}
