package kr.co.DAO;

import java.util.List;

import kr.co.DTO.MemberDTO;

public interface MemberIDao
{
	// 회원가입
	public void JoinProcess(MemberDTO memberDTO);
	// 로그인
	public String login(String userId);
	// 전체 회원조회
	public List<String> memberLookup();
	// 회원 정보 출력
	public MemberDTO memberInfo(String userId);
	// 회원 삭제
	public void memberDelete(String userId);
}
