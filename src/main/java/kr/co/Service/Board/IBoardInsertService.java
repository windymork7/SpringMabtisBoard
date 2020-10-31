package kr.co.Service.Board;


import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import kr.co.DTO.BoardDTO;
import kr.co.util.FileUpload;

public interface IBoardInsertService
{
	public void boardInsert(HttpSession session, BoardDTO boardDTO, FileUpload file, MultipartFile mf);
}
