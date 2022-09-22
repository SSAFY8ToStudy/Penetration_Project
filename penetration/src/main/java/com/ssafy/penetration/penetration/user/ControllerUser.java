package com.ssafy.penetration.penetration.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class ControllerUser {

// @Slf4j : Simple Logging Facade for Java, 로깅할 때 많이 사용한다.
// @Controller : 사용자의 요청을 처리한 후 지정된 뷰에 모델 객체를 넘겨주는 역할을 한다.

    private final RepositoryUser repositoryUser;




}
