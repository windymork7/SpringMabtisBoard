package kr.co.Controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.DTO.MemberDTO;
import kr.co.ServiceClass.Member.LoginCheckService;
import kr.co.ServiceClass.Member.MemberDeleteService;
import kr.co.ServiceClass.Member.MemberInformationService;
import kr.co.ServiceClass.Member.MemberInsertService;
import kr.co.ServiceClass.Member.MemberListService;


@Controller
public class MemberController
{
	
	// 로그인 체크
	@Autowired
	LoginCheckService loginCheckService;
	
	// 회원 가입
	@Autowired
	MemberInsertService memberInsertService;
	
	// 회원 리스트
	@Autowired
	MemberListService memberListService;
	
	// 회원 삭제
	@Autowired
	MemberDeleteService memberDeleteService;
	
	// 회원 정보
	@Autowired
	MemberInformationService memberInformationService;
	
	
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
	
	// 로그인 체크
	@RequestMapping("/loginProcess.me")
	public String loginProcess(HttpServletRequest request, HttpSession session, Model model)
	{
		boolean check = loginCheckService.loginCheck(request, session);
		if (check == true)
			return "member/main";
		
		return "member/loginForm";
	}
	
	// 회원가입 폼
	@RequestMapping("/MemberJoin.me")
	public String joinForm()
	{
		return "member/joinForm";
	}
	
	// 회원가입하기
	@RequestMapping("MemberJoinProcess.me")
	public String joinProcess(MemberDTO memberDTO)
	{
		memberInsertService.memberInsert(memberDTO);
		
		return "redirect:loginForm";
	}
	
	// 회원 목록
	@RequestMapping("/Member_list.me")
	public String memberList(Model model)
	{
		List<String> list = memberListService.memberList();
		model.addAttribute("list", list);
		
		return "member/member_list";
	}
	
	// 회원 삭제
	@RequestMapping("/MemberDelete.me")
	public String memberDelete(HttpServletRequest request)
	{
		memberDeleteService.memberDelete(request.getParameter("userId"));
		
		return "redirect:Member_list.me";
	}
	
	// 회원 정보
	@RequestMapping("/MemberInfo.me")
	public String memberInfo(HttpServletRequest request, Model model)
	{
		MemberDTO memberDTO = memberInformationService.memberInfo(request.getParameter("userId"));
		model.addAttribute("Member", memberDTO);
		
		return "member/member_into";
	}
	


}
