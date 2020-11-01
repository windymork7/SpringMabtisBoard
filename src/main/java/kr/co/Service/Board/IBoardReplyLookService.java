package kr.co.Service.Board;

import javax.servlet.http.HttpServletRequest;

import kr.co.DTO.BoardDTO;

public interface IBoardReplyLookService
{
	public BoardDTO replyLook(HttpServletRequest request);
}
