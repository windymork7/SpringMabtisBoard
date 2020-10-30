package kr.co.ServiceClass.Member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.DAO.MemberIDao;
import kr.co.DTO.MemberDTO;
import kr.co.Service.Member.IMemberListService;

@Service
public class MemberListService implements IMemberListService
{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<String> memberList()
	{
		MemberIDao dao = sqlSession.getMapper(MemberIDao.class);
		List<String> list = dao.memberLookup();
		
		return list;
	}

}
