package kr.green.spring.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.MemberDAO;
import kr.green.spring.vo.MemberVO;

//구현클래스
@Service
public class MemberServiceImp implements MemberService {
    @Autowired
    MemberDAO memberDao;
    //암호화 설정해놓고 테스트 한번하기 
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    
	@Override
	public MemberVO signin(MemberVO user) {
		//회원정보가 없거나 아이디가 없으면 null
		if(user == null || user.getId() == null ||
				user.getId().trim().length()==0 || 
				user.getPw().trim().length()==0) {
			return null;
		}
		//다오에게 아이디를 알려주고 회원정보를 가져오라고 함
		MemberVO dbUser = memberDao.getMember(user.getId());
		
		//가져온 회원정보와 비밀번호를 확인 일치하면 회원정보를 아니면 null
		//회원정보가 null이거나 일치하지 않으면 return null
		if(dbUser == null) {
			return null;
		}
		if(passwordEncoder.matches(user.getPw(), dbUser.getPw())) {
			return dbUser;
		}
		return null;
			
	}

	@Override
	public void signup(MemberVO user) {
		if(user == null)
			return;
		//필수항목 체크
		//or연산자는 앞이 true이면 뒷부분을 확인을 안한다. 
		if(user.getId() == null || user.getId().trim().length()== 0 || 
			user.getPw() == null ||user.getPw().trim().length()==0 ||
			user.getName() == null ||user.getName().trim().length()==0 ||
			user.getEmail() == null ||user.getEmail().trim().length()==0 )
			return;
		//정규표현식 체크 => 나중에 : 지금하면 테스트가입 하기가 번거로움
		
		//암호화
		String ePw = passwordEncoder.encode(user.getPw());
		user.setPw(ePw);
		//회원가입 
		memberDao.insertMember(user);
	}

	@Override
	public MemberVO getMember(HttpServletRequest r) {
		if(r== null || r.getSession()== null)
			return null;
		
		return (MemberVO)r.getSession().getAttribute("user");
	}

	@Override
	public MemberVO updateMember(MemberVO user, MemberVO sUser) {
		if(user == null || sUser == null ||user.getId()== null|| !user.getId().equals(sUser.getId()))
			return null;
		if(user.getPw()!= null && user.getPw().trim().length() != 0) {
			String ePw = passwordEncoder.encode(user.getPw());
			sUser.setPw(ePw);
		}
		sUser.setEmail(user.getEmail());
		sUser.setGender(user.getGender());
		sUser.setName(user.getName());
		memberDao.updateMember(sUser);
		return sUser;
	}

	
	}
    
  

	


