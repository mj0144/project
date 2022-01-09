package user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import mvc.vo.MemberVO;

public interface UserService {
	public void userInfoSetting(HttpSession session, MemberVO vo, HttpServletRequest request, MultipartFile file);
	
}
