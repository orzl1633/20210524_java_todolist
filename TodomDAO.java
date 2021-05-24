package todolist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class TodomDAO {
		
	//로그인
	//등록
	int insert(TodomDTO tmdto) {
		int cnt = 0;
		Connection conn = DBconn.getConn();
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MEMBER_TODOLIST (TODOID,TODONAME,TODOPW,TODOEMAIL)VALUES(?,?,?,?)";
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tmdto.getTodoid());
			pstmt.setString(2, tmdto.getTodoname());
			pstmt.setString(3, tmdto.getTodopw());
			pstmt.setString(4, tmdto.getTodoemail());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cnt;		
	}
	
	//수정
	int update(TodomDTO tmdto) {
		Connection conn = DBconn.getConn();
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "UPDATE MEMBER_TODOLIST " + 
				"SET TODONAME =?, " + 
				"TODOPW=?, " + 
				"TODOEMAIL=? " + 
				"WHERE TODOID=? ";
				
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tmdto.getTodoname());
			pstmt.setString(2, tmdto.getTodopw());
			pstmt.setString(3, tmdto.getTodoemail());
			pstmt.setString(4, tmdto.getTodoid());
			cnt = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
	//삭제
	int delete(String string) {
		int cnt = 1;
		Connection conn = DBconn.getConn();
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM MEMBER_TODOLIST " + 
				"WHERE TODOID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,string);
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return cnt;
	}
	
	//한건조회
	TodomDTO selectOne(String string) {
		TodomDTO tmdto = null;
		Connection conn = DBconn.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT*FROM MEMBER_TODOLIST " + 
				"WHERE TODOID =? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,string);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				tmdto = new TodomDTO();
				tmdto.setTodoid(rs.getString("todoid"));
				tmdto.setTodoname(rs.getString("todoname"));
				tmdto.setTodopw(rs.getString("todopw"));
				tmdto.setTodoemail(rs.getString("todoemail"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		return tmdto;
		
	}
	
	
	
	//전체조회
	List<TodomDTO> selectList() {
		List<TodomDTO> tmlist = new ArrayList<>();
		Connection conn = DBconn.getConn();
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		
		String sql = "SELECT*FROM MEMBER_TODOLIST " + 
				"ORDER BY TODOID";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TodomDTO tmdto = new TodomDTO();
				tmdto.setTodoid(rs.getString("todoid"));
				tmdto.setTodoname(rs.getString("todoname"));
				tmdto.setTodopw(rs.getString("todopw"));
				tmdto.setTodoemail(rs.getString("todoemail"));
				tmlist.add(tmdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return tmlist;
		
	}
	
	
	
	
	
}
