package kr.co.Controller;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.DAO.MemberIDao;
import kr.co.DTO.MemberDTO;


@Controller
public class MemberController
{
	@Autowired
	SqlSession sqlSession;
	
	
	// 시작페이지를 로그인 폼으로 이동
	@RequestMapping("/")
	public String start()
	{
		return "member/loginForm";
	}

	// 로그인 폼으로 이동
	@RequestMapping("/loginForm")
	public String loginForm()
	{
		return "member/loginForm";
	}
	
	@RequestMapping("/MemberJoin.me")
	public String joinForm()
	{
		return "member/joinForm";
	}
	
	@RequestMapping("MemberJoinProcess.me")
	public String joinProcess(MemberDTO memberDTO)
	{
		MemberIDao dao = sqlSession.getMapper(MemberIDao.class);
		dao.JoinProcess(memberDTO);
		
		return "redirect:loginForm";
	}
	


}
