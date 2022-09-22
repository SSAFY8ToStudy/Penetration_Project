package com.ssafy.penetration.penetration.login;

import com.ssafy.penetration.penetration.user.DomainUser;
import com.ssafy.penetration.penetration.user.RepositoryUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class serviceLogin {
    private final RepositoryUser repositoryUser;

    public DomainUser login(String loginId, String password) {
        return repositoryUser.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
