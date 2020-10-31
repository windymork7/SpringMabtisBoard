package kr.co.Controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.co.DTO.BoardDTO;
import kr.co.ServiceClass.Board.BoardInsertService;
import kr.co.ServiceClass.Board.BoardListService;
import kr.co.util.FileUpload;

@Controller
public class BoardController
{
	// 전체 게시글 조회
	@Autowired
	BoardListService boardListService;
	
	// 게시판 글쓰기
	@Autowired
	BoardInsertService boardInsertService;
	
	// 전체 게시글 조회
	@RequestMapping("/BoardList.bo")
	public String boardList(HttpServletRequest request, Model model)
	{
		boardListService.getBoardList(request, model);
		
		return "board/qna_board_list";
	}
	
	// 글쓰기 페이지
	@RequestMapping("/BoardWrite.bo")
	public String boardWriteForm()
	{
		return "board/qna_board_write";
	}
	
	// 게시판 글쓰기
	@RequestMapping("/BoardAddAction.bo")
	public String boardWrite(HttpSession session, BoardDTO boardDTO, FileUpload file, MultipartFile mf) throws Exception
	{
		boardInsertService.boardInsert(session, boardDTO, file, mf);
		
		return "redirect:BoardList.bo";
	}
		
}
