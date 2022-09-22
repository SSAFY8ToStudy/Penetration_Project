package com.ssafy.penetration.penetration.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class RepositoryUser {
    // 저장
    private static Map<Integer, DomainUser> store = new HashMap<>();


    private static int sequence = 0;

    // 사용자 입력 save 메서드
    public DomainUser save(DomainUser user){
        user.setId(++sequence);
        store.put(user.getId(), user);
        return user;
    }

    // id 찾기
    public DomainUser findById(int id){
        return store.get(id);
    }


    // 저장소에서 값들을 모두 꺼내서 ArrayList에 담는다.
    public List<DomainUser> findAll() {
        return new ArrayList<>(store.values());
    }


    // 로그인을 시도한 id가 회원가입한 id인지 확인하기 위해 호출한 메서드
    public Optional<DomainUser> findByLoginId(String loginId){
        return findAll().stream()
                .filter(m -> m.getEmail().equals(loginId))
                .findFirst();
    }

}
