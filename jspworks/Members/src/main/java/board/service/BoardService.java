package board.service;

import java.util.List;

import board.model.Board;
import board.model.BoardDAO;

public class BoardService {
	BoardDAO dao = new BoardDAO();
	
	//목록 보기
	public List<Board> getBoardList(){
		return dao.getBoardList();
	}
	
	//글 등록
	public void addBoard(Board board) {
		dao.addBoard(board);
	}
	
	//글 상세 보기
	public Board getBoard(int bnum) {
		return dao.getBoard(bnum);
	}
	
	//글 삭제
	public void deleteBoard(int bnum) {
		dao.deleteBoard(bnum);
	}
}

