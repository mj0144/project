package user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mvc.dao.UserInfoDao;
import mvc.service.MainService;
import mvc.service.MemberService;
import mvc.service.UserInfoService;
import mvc.vo.IdealVO;
import mvc.vo.MemberVO;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserInfoDao userInfoDao;
	
	@Autowired
	private UserInfoService userInfoService;
	

	@RequestMapping(value="/userInfoChange",method=RequestMethod.GET)
	public void infoChangeGet(HttpSession session, Model model) {
		HashMap<String, Object> map = userInfoDao.info((int) session.getAttribute("user_num"));
		System.out.println(map);
		model.addAttribute("vo", map);

	}
	

	@RequestMapping(value="/userInfoChange", method=RequestMethod.POST)
	public String infoChange(HttpSession session, MemberVO vo, HttpServletRequest request, MultipartFile file) {
		userInfoService.userInfoSetting(session, vo, request,file); 	

		return "redirect:/mypage";

	}

	
	@RequestMapping(value="/pwdChange", method=RequestMethod.GET)
	public void pwdChange() {			
	}
	
	@RequestMapping(value="/pwdChange", method=RequestMethod.POST)
	public String login(HttpSession session, MemberVO vo, RedirectAttributes ra) {
		vo.setUser_num((int) session.getAttribute("user_num"));

		try {
			userInfoDao.pwdChange(vo);
			session.invalidate(); //���ǰ� ��� ����

		} catch (Exception e) {
			e.printStackTrace();
		}
		ra.addAttribute("msg", "��й�ȣ ������ �Ǿ����ϴ�");
		return "redirect:/";
	}
	
	@RequestMapping("/pwdchangechk")
	@ResponseBody
	public int pwdChangeChk(HttpSession session,String pwd) {
		
		int user_num = (int)session.getAttribute("user_num");
		String pwd2 = userInfoDao.pwdchk(user_num);
		
		int chk =0;
		if(pwd2.equals(pwd)) {
			chk= 1;
		} else {
			chk=0;
		}
		return chk;
		
	}
	
	

	   @RequestMapping(value = "/joinaction", method = RequestMethod.POST)
	   public String join(MemberVO vo, HttpServletRequest request, MultipartFile file, IdealVO ivo, RedirectAttributes ra) {

	      vo = joinService.yunYeon(vo); 
	      String ilju = joinDao.ilju(vo);
	      vo.setIlju(ilju); 
	      vo.setUser_img(imgUtils.imgSave(request, file, "in", null)); 

	      if (vo.getUser_intro().equals("")) { 
	         vo.setUser_intro("�ڱ�Ұ��� �Է����ּ���");
	      }

	      try {
	         String images = imgUtils.root_path(request, vo.getUser_img());
	         joinService.join(vo, ivo);
	         joinService.gradeInit(vo); 
	         lookLikeService.insertLooklike(images, vo, ivo);
	         ra.addFlashAttribute("msg", "������ �Ϸ�Ǿ����ϴ�");


	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	     
	      return "redirect:/";
	   }


	   @RequestMapping(value = "/imgchk", method = RequestMethod.POST)
	   @ResponseBody
	   public int imgchk(MultipartFile[] uploadFile,HttpServletRequest request, MemberVO vo) {
	      int result=0;
	      for (MultipartFile file : uploadFile) {   
	         vo.setUser_img(imgUtils.imgSave(request, file, "in", null));
	         String images = imgUtils.root_path(request, vo.getUser_img());
	         Map<String, Object> map = apiExamFace.face(images);
	          System.out.println("����MAP:" + map);
	          if (map.containsKey("looklike")) {
	             result=1;
	           }else {
	              result=0;
	           }
	      }
	         return result;
	   }
	   

	   @RequestMapping("/idchk")
	   @ResponseBody
	   public int idChk(String id) {
	      int res = joinDao.idChk(id);
	      return res;

	   }


	   @RequestMapping("/nickchk")
	   @ResponseBody
	   public int nickChk(String nickname) {
	      int res = joinDao.nickChk(nickname);
	      return res;

	   }

	 
	   @RequestMapping("/emailchk")
	   @ResponseBody
	   public int emailchk(String email) {
	      int res = joinDao.emailChk(email);
	      return res;

	   }
	   
	   @Autowired
		private MemberService memberService;

		@Autowired
		MainService mainService;


		@RequestMapping(value = "/logindo")
		public String login(@ModelAttribute MemberVO vo, HttpSession session, RedirectAttributes ra) {
			boolean result = memberService.loginCheck(vo, session);
			String redirect ="";
		
			if (result == true) { // �α��� ����
				redirect = "redirect:/index";
			} else { // �α��� ����
				try {
					session.invalidate(); // �����ص� session�� �����־ ��� ����.
					ra.addAttribute("msg", "failure");
					return "redirect:/";
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
			
			return redirect;
		}
}