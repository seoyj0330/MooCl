package kr.co.moocl.dao;


import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.moocl.vo.UsersVo;

@Repository
public class UsersDao {

	private static final Logger logger = LoggerFactory.getLogger(UsersDao.class);
	
	@Autowired
	SqlSession sqlSession;
	
	public UsersVo getUserInfoByEmail(String userEmail) {
		
		UsersVo userInfo;
		
		userInfo = sqlSession.selectOne("users.selectOneUserByEmail", userEmail);
		
		
		return userInfo;
	}

	public int insertUserInfo(Map<String, Object> userVo) {
		
		logger.info("UsersDao.insertUserInfo 진입 userVo: "+ userVo);
		
		int cnt = sqlSession.insert("users.insertUserInfoByMap", userVo);
		
		return cnt;
	}


}
