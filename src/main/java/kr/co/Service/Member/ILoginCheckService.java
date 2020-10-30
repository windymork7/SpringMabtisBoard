package kr.co.Service.Member;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public interface ILoginCheckService
{
	public boolean loginCheck(HttpServletRequest request, HttpSession session);
}
