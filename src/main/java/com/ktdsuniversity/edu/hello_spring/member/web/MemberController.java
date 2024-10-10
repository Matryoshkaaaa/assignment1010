package com.ktdsuniversity.edu.hello_spring.member.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ktdsuniversity.edu.hello_spring.member.service.MemberService;
import com.ktdsuniversity.edu.hello_spring.member.vo.LoginMemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.RegistMemberVO;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("/member/regist")
	public String viewRegistMemberPage() {
		return "member/memberregist";
	}

	@PostMapping("/member/regist")
	public String doViewRegistMemberPage(@Valid RegistMemberVO registMemberVO,BindingResult bindingResult ,Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("registMemberVO",registMemberVO);
			return "member/memberregist";
		}

		boolean isSuccess = memberService.insertNewMember(registMemberVO);

		if (isSuccess) {
			model.addAttribute("registMemberVO", registMemberVO);
			return "redirect:/board/list";
		} else {
			return "member/memberregist";
		}
	}

	@GetMapping("/member/login")
	public String viewLoginPate() {
		return "member/memberlogin";
	}

	@PostMapping("/member/login")
	public String doLogin(@Valid LoginMemberVO loginMemberVO, BindingResult bindingResult, HttpSession session, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("loginMemberVO",loginMemberVO);
			return "member/memberlogin";
		}
		
		try {
			MemberVO memberVO = this.memberService.readMember(loginMemberVO); // loginMemberVO줄테니 올바른 MemeberVO 내놔라

			session.setAttribute("_LOGIN_USER_", memberVO); // 로그인 상태를 서버에 저장시킨다.
		} catch (IllegalArgumentException iae) {
			model.addAttribute("loginMemberVO", loginMemberVO); // 로그인할때 정보
			model.addAttribute("message", iae.getMessage());
			return "member/memberlogin";
		}

		return "redirect:/board/list";
	}

	@ResponseBody
	@GetMapping("/member/regist/available")
	public Map<String, Object> checkAvailableEmail(@RequestParam String email) {
		boolean isAvilableEmail = memberService.checkAvailableEmail(email);
		Map<String, Object> response = new HashMap<>();
		response.put("email", email);
		response.put("available", isAvilableEmail);

		return response;
	}
	
	@GetMapping("/member/logout")
	public String doLogout(HttpSession session) {
		session.invalidate(); // 세션 종료
		return "redirect:/board/list";
		}

	@GetMapping("/member/delete-me")
	public String doDeleteMe(@SessionAttribute(value = "_LOGIN_USER_", required = false) MemberVO memberVO, HttpSession session) {
		boolean isSuccess = memberService.deleteMe(memberVO.getEmail());
		if(!isSuccess) {
			return "redirect:/member/fail-delete-me";
		}
		session.invalidate();
		return "redirect:/member/success-delete-me";
	}
	
	@GetMapping("/member/{result}-delete-me")
	public String viewDeleteMePage(@PathVariable String result) {
		result = result.toLowerCase();
		if (!result.equals("fail") && !result.equals("success")) {
			return "error/404";
		}
		
		return "member/" + result + "deleteme";
	}
}
