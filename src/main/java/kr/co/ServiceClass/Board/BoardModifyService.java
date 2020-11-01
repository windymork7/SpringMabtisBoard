package kr.co.ServiceClass.Board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.DAO.BoardIDao;
import kr.co.DTO.BoardDTO;
import kr.co.Service.Board.IBoardModifyService;

@Service
public class BoardModifyService implements IBoardModifyService
{
	@Autowired
	SqlSession sqlSession;

	@Override
	public void boardModify(BoardDTO boardDTO)
	{
		BoardIDao dao = sqlSession.getMapper(BoardIDao.class);
		
		BoardDTO boardDB = dao.getDetail(boardDTO.getBOARD_NUM());
		
		if (boardDTO.getBOARD_PASS().equals(boardDB.getBOARD_PASS()))
			dao.boardModify(boardDTO);
	}

}
