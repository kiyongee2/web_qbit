package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DBUtil;

public class BoardDAO {
	
	//게시글 목록
	public List<Board> getBoardList(){
		List<Board> boardList = new ArrayList<>();
		String sql = "select * from board order by bnum desc";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()){
			
			while(rs.next()) {
				Board board = new Board();
				board.setBnum(rs.getInt("bnum"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setMid(rs.getString("mid"));
				board.setHit(rs.getInt("hit"));
				board.setRegDate(rs.getTimestamp("regdate"));
				
				boardList.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return boardList;
	}
	
	//글 등록
	public void addBoard(Board board) {
		String sql = "insert into board(title, content, hit, mid, regdate) "
				+ "values (?, ?, 0, ?, now())";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContent());
			ps.setString(3, board.getMid());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//글 상세 보기
	public Board getBoard(int bnum) {
		Board board = new Board();
		String sql = "select * from board where bnum = ?";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, bnum);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				board.setBnum(rs.getInt("bnum"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setHit(rs.getInt("hit"));
				board.setMid(rs.getString("mid"));
				board.setRegDate(rs.getTimestamp("regdate"));
				
				//조회수 증가
				int hit = rs.getInt("hit") + 1;
				
				sql = "update board set hit = ? where bnum = ?";
				PreparedStatement ps2 = conn.prepareStatement(sql);
				ps2.setInt(1, hit);
				ps2.setInt(2, bnum);
				ps2.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return board;
	}
	
	//게시글 삭제
	public void deleteBoard(int bnum) {
		String sql = "delete from board where bnum = ?";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1, bnum);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}









