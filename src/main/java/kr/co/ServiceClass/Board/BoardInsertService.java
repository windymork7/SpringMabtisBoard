package kr.co.ServiceClass.Board;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import kr.co.DAO.BoardIDao;
import kr.co.DTO.BoardDTO;
import kr.co.util.FileUpload;


@Service
public class BoardInsertService implements kr.co.Service.Board.IBoardInsertService
{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void boardInsert(HttpSession session, BoardDTO boardDTO, FileUpload file, MultipartFile mf)
	{
		BoardIDao dao = sqlSession.getMapper(BoardIDao.class);
		
		long time = System.currentTimeMillis();// 시스템시간 선언
		
		String orgName = "";
		final String path = "C:/BigData/SpringMabtisBoard/src/main/webapp/resources/upload";
		mf = file.getBOARD_FILE2();// 화면에서 넘어온 파일 정보
		if (!mf.isEmpty()) // 업로드된 파일이 존재한다면
		{
			orgName = mf.getOriginalFilename();// 파일 진짜 이름
			String newName = time+mf.getSize()+orgName;
			File file2 = new File(path + File.separator + newName);
			try
			{
				mf.transferTo(file2);// 파일생성
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			boardDTO.setBOARD_FILE(newName);
		}
		else 
			boardDTO.setBOARD_FILE(orgName);
		
		dao.boardInsert(boardDTO);
		
		
	}
}
