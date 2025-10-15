package member.service;

import java.util.List;

import member.model.Board;
import member.model.BoardDAO;

public class BoardService {
	BoardDAO dao = new BoardDAO();
	
	//목록 보기
	public List<Board> getBoardList(){
		return dao.getBoardList();
	}
}
