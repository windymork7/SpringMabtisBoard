package kr.co.ServiceClass.Board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.DAO.BoardIDao;
import kr.co.DTO.BoardDTO;
import kr.co.Service.Board.IBoardReplyService;

@Service
public class BoardReplyService implements IBoardReplyService
{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void reply(BoardDTO boardDTO)
	{
		BoardIDao dao = sqlSession.getMapper(BoardIDao.class);
		
		int re_ref = boardDTO.getBOARD_RE_REF();
		int re_lev = boardDTO.getBOARD_RE_LEV();
		int re_seq = boardDTO.getBOARD_RE_SEQ();
		
		dao.boardLittleModify(re_ref, re_seq);
		
		re_seq = re_seq + 1;
		re_lev = re_lev+1;
		
		boardDTO.setBOARD_RE_SEQ(re_seq);
		boardDTO.setBOARD_RE_LEV(re_lev);
		boardDTO.setBOARD_FILE("");
		
		dao.boardInsert(boardDTO);
	}
}
