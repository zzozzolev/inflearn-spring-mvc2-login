package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String homeLogin(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member member,
            Model model) {

        if (member == null) {
            return "home";
        }

        model.addAttribute("member", member);
        return "loginHome";
    }
}