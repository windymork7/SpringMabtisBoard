package kr.co.ServiceClass.Board;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.DAO.BoardIDao;
import kr.co.DTO.BoardDTO;
import kr.co.Service.Board.IBoardDeleteService;

@Service
public class BoardDeleteService implements IBoardDeleteService
{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void delete(HttpServletRequest request)
	{
		BoardIDao dao = sqlSession.getMapper(BoardIDao.class);

		int num = Integer.parseInt(request.getParameter("num"));
		String pass = request.getParameter("BOARD_PASS");
		
		BoardDTO boardDTO = dao.getDetail(num);
		
		if (boardDTO.getBOARD_PASS().equals(pass))
		{
			dao.boardDelete(num);
		}
		
		
		
		
		
	}

}
