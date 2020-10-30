package kr.co.ServiceClass.Board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.co.DAO.BoardIDao;
import kr.co.DAO.MemberIDao;
import kr.co.DTO.BoardDTO;
import kr.co.DTO.MemberDTO;
import kr.co.Service.Board.IBoardListService;

@Service
public class BoardListService implements IBoardListService
{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<BoardDTO> getBoardList(HttpServletRequest request, Model model)
	{
		BoardIDao dao = sqlSession.getMapper(BoardIDao.class);
		
		int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null)
		{
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int listcount = dao.getListCount();
		int startrow = (page-1)*10+1;
		int endrow = startrow+limit-1;
		List<BoardDTO> boardList = dao.getBoardList(startrow, endrow);
		
		int maxpage=(int)((double)listcount/limit+0.95); 
   		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		int endpage = maxpage;
   		
   		if (endpage>startpage+10-1) endpage=startpage+10-1;
		
   		model.addAttribute("page", page);		  
   		model.addAttribute("maxpage", maxpage); 
   		model.addAttribute("startpage", startpage); 
   		model.addAttribute("endpage", endpage);     
   		model.addAttribute("listcount",listcount); 
   		model.addAttribute("boardlist", boardList);
		
		return boardList;
	}

}
