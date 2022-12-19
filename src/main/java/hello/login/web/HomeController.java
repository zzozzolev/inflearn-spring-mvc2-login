package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String homeLogin(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            return "home";
        }

        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);

        if (member == null) {
            return "home";
        }

        model.addAttribute("member", member);
        return "loginHome";
    }
}