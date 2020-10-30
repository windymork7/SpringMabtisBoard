package kr.co.ServiceClass.Member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.DAO.MemberIDao;
import kr.co.Service.Member.IMemberDeleteService;

public class MemberDeleteService implements IMemberDeleteService
{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void memberDelete(String userId)
	{
		MemberIDao dao = sqlSession.getMapper(MemberIDao.class);
		dao.memberDelete(userId);
	}

}
