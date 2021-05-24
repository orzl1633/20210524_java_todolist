package todolist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodosDAO {
	
	
	//일정
	//등록
	int insert(TodosDTO tsdto) {
	int cnt = 0;
	Connection conn = DBconn.getConn();
	PreparedStatement pstmt = null;
	
	String sql = "INSERT INTO SETUP_TODOLIST (SEQ,TODOID,TODODATE,TODOTIME,TODOLIST) VALUES(?,?,?,?,?)";
			
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, tsdto.getSeq());
		pstmt.setString(2, tsdto.getTodoid());
		pstmt.setString(3, tsdto.getTododate());
		pstmt.setString(4, tsdto.getTodotime());
		pstmt.setString(5, tsdto.getTodolist());
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
	int update(TodosDTO tsdto) {
		Connection conn = DBconn.getConn();
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		String sql = "UPDATE SETUP_TODOLIST " + 
				"SET TODODATE =?, " + 
				"TODOTIME=?, " + 
				"TODOLIST=? " + 
				"WHERE SEQ=? ";
		
	
		
		try {
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, tsdto.getTodoid());
			pstmt.setString(1, tsdto.getTododate());
			pstmt.setString(2, tsdto.getTodotime());
			pstmt.setString(3, tsdto.getTodolist());
			pstmt.setInt(4, tsdto.getSeq());
			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "건 추가");
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

	
	
	//	//삭제
	int delete(int seq) {
		int cnt = 1;
		Connection conn = DBconn.getConn();
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM SETUP_TODOLIST " + 
				"WHERE SEQ=? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,seq);
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

	
//	//한건조회
	TodosDTO selectOne(String string) {
		TodosDTO tsdto = null;
		Connection conn = DBconn.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT*FROM SETUP_TODOLIST " + 
				"WHERE TODOID =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,string);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				tsdto = new TodosDTO();
				tsdto.setTodoid(rs.getString("todoid"));
				tsdto.setTododate(rs.getString("tododate"));
				tsdto.setTodotime(rs.getString("todotime"));
				tsdto.setTodolist(rs.getString("todolist"));
			
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
		
	
		return tsdto;
		
	}

	
//	//전체조회
	List<TodosDTO> selectList() {
		List<TodosDTO> tslist = new ArrayList<>();
		Connection conn = DBconn.getConn();
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		
		String sql = "SELECT*FROM SETUP_TODOLIST " + 
				"ORDER BY TODODATE ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TodosDTO tsdto = new TodosDTO();
				tsdto.setTodoid(rs.getString("todoid"));
				tsdto.setTododate(rs.getString("tododate"));
				tsdto.setTodotime(rs.getString("todotime"));
				tsdto.setTodolist(rs.getString("todolist"));
				tsdto.setRegdate(rs.getDate("regdate"));
				tslist.add(tsdto);
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
		
		return tslist;
		
	}

	

}
