package kr.home.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.home.project.dao.MemberDAO;
@Service
public class MemberServiceImp implements MemberService {

	 @Autowired
	 MemberDAO memberDao;

	
	@Override
	public String getEmail(String id) {
		return memberDao.getEmail(id);
	}

}
	