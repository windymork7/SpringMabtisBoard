package kr.co.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.DTO.BoardDTO;
import kr.co.ServiceClass.Board.BoardListService;

@Controller
public class BoardController
{
	// 전체 게시글 조회
	@Autowired
	BoardListService boardListService;
	
	@RequestMapping("/BoardList.bo")
	public String boardList(HttpServletRequest request, Model model)
	{
		List<BoardDTO> list = boardListService.getBoardList(request, model);
		
		return "board/qna_board_list";
	}
}
