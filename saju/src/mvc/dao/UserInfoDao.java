package mvc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mvc.vo.IdealVO;
import mvc.vo.MemberVO;

@Repository
public class UserInfoDao {

	@Autowired
	SqlSessionTemplate ss;
	
	public HashMap<String, Object> info(int user_num) {
		return ss.selectOne("userinfo.info", user_num);
	}
	
	@Transactional
	public void infoUpdate(MemberVO vo) {
		ss.update("userinfo.infoUpdate", vo); 
		IdealVO idealvo = vo.getIdealvo();
		System.out.println(idealvo.getIdeal_height());
		ss.update("userinfo.idealInfoUpdate", vo.getIdealvo()); 
	}
	
	public void pwdChange(MemberVO vo) {
		ss.update("userinfo.pwdChange", vo);
	}
	
	public String pwdchk(int user_num) {
		return ss.selectOne("userinfo.pwdchk", user_num);
	}
	
	
	public void looklike(Map<String, Object> params) {
		ss.update("userinfo.looklike", params);
	}
	
	
}
