package kr.co.Service.Board;

import javax.servlet.http.HttpServletRequest;

import kr.co.DTO.BoardDTO;

public interface IBoardDetailService
{
	public BoardDTO boardDetail(HttpServletRequest request);
}
