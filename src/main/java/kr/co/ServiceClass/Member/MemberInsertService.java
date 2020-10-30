package kr.co.ServiceClass.Member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.DAO.MemberIDao;
import kr.co.DTO.MemberDTO;
import kr.co.Service.Member.IMemberInsertService;

@Service
public class MemberInsertService implements IMemberInsertService
{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void memberInsert(MemberDTO memberDTO)
	{
		MemberIDao dao = sqlSession.getMapper(MemberIDao.class);
		dao.JoinProcess(memberDTO);
	}
}
