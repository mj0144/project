package mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mvc.service.MainService;
import mvc.service.MemberService;
import mvc.vo.MemberVO;

@Controller
public class MemberController {


	

	// �α׾ƿ�ó��
//	@RequestMapping(value = "/logoutdo")
//	public ModelAndView logout(HttpSession session) {
//		memberService.logout(session);
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("login");
//		mav.addObject("msg", "logout");
//		return mav;
//	}


}
