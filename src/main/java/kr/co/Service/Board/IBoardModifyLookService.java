package kr.co.Service.Board;

import javax.servlet.http.HttpServletRequest;

import kr.co.DTO.BoardDTO;

public interface IBoardModifyLookService
{
	public BoardDTO boardModifyLook(HttpServletRequest request);
}
