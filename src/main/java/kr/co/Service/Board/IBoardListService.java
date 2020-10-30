package kr.co.Service.Board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.co.DTO.BoardDTO;

public interface IBoardListService
{
	public List<BoardDTO> getBoardList(HttpServletRequest request, Model model);
}
