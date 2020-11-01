package kr.co.ServiceClass.Board;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.DAO.BoardIDao;
import kr.co.DTO.BoardDTO;
import kr.co.Service.Board.IBoardModifyLookService;

@Service
public class BoardModifyLookService implements IBoardModifyLookService
{
	@Autowired
	SqlSession sqlSession;

	@Override
	public BoardDTO boardModifyLook(HttpServletRequest request)
	{
		BoardIDao dao = sqlSession.getMapper(BoardIDao.class);
		
		BoardDTO boardDTO = dao.getDetail(Integer.parseInt(request.getParameter("num")));
		
		return boardDTO;
	}

}
