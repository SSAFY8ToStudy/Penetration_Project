package com.ssafy.penetration.penetration.login;

import com.ssafy.penetration.penetration.session.SessionConst;
import com.ssafy.penetration.penetration.user.DomainUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@Slf4j

@RequiredArgsConstructor
public class ControllerLogin {

    // @Controller : 사용자의 요청을 처리한 후 지정된 뷰에 모델 객체를 넘겨주는 역할을 한다.
    // @RequiredArgsConstructor : 초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성해 줍니다. 주로 의존성 주입(Dependency Injection) 편의성을 위해서 사용되곤 합니다.
    private final serviceLogin serviceLogin;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") formLogin form){

        log.info("실행 테스트");
        return "html/login/loginForm.html";
    }

    @PostMapping("/login")
    public String loginSpring(@Valid @ModelAttribute formLogin loginForm,
                              BindingResult bindingResult,
                              @RequestParam(defaultValue = "/") String redirectURL,
                              HttpServletRequest request) {
        log.info("실행합니다.테스트");
        // 만약 검증 실패 했다면
        if (bindingResult.hasErrors()) {
            log.info("로그인 검증 실패하였습니다.");
            return "html/login/loginForm.html";
        }

        // 로그인 실패 했다면
        // 로그인 아이디, 패스워드 발급
        DomainUser loginUser = serviceLogin.login(loginForm.getEmail(), loginForm.getPassword());
        log.info(loginUser.getUsername());
        if (loginUser == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호를 다시 입력해주세요!");
            return "login/loginForm";
        }


        log.info("로그인 성공");
        // 로그인 성공했다면
        // 세션이 있으면 있는 세션을 반환, 없으면 신규 세션을 반환
        HttpSession session = request.getSession();
        // 세션에 로그인 회원 정보 보관
        session.setAttribute(SessionConst.LOGIN_User, loginUser);

        return "redirect:"+redirectURL;
    }
}


