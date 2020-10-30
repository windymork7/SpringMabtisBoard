package kr.co.ServiceClass.Member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.DAO.MemberIDao;
import kr.co.DTO.MemberDTO;
import kr.co.Service.Member.IMemberInformationService;

@Service
public class MemberInformationService implements IMemberInformationService
{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public MemberDTO memberInfo(String userId)
	{
		MemberIDao dao = sqlSession.getMapper(MemberIDao.class);
		MemberDTO memberDTO = dao.memberInfo(userId);
		return memberDTO;
	}

}
