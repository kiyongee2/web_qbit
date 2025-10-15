package member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import member.common.DBUtil;

public class BoardDAO {
	
	//게시글 목록
	public List<Board> getBoardList(){
		List<Board> boardList = new ArrayList<>();
		String sql = "select * from board";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()){
			
			while(rs.next()) {
				Board board = new Board();
				board.setBnum(rs.getInt("bnum"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setMid(rs.getString("mid"));
				board.setRegDate(rs.getTimestamp("regdate"));
				boardList.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return boardList;
	}

}
