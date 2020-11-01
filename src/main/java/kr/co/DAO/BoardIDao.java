package kr.co.DAO;

import java.util.List;

import kr.co.DTO.BoardDTO;

public interface BoardIDao
{
	// 게시판 조회
	public List<BoardDTO> getBoardList(int page,int limit);
	// 게시판 갯수
	public int getListCount();
	// 게시판 글쓰기
	public void boardInsert(BoardDTO boardDTO);
	// 게시글 열기
	public BoardDTO getDetail(int num);
	// 게시글 삭제
	public void boardDelete(int num);
	// 게시글 수정
	public void boardModify(BoardDTO boardDTO);
	// 부분 수정
	public void boardLittleModify(int re_ref, int re_seq);
	// 게시글 조회수
	public void setReadCountUpdate(int num);
	
	
}
