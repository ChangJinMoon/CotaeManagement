package com.example.CotaeMangementdemo.service.login;

import com.example.CotaeMangementdemo.domain.member.Member;
import com.example.CotaeMangementdemo.dto.login.request.LoginCheckRequestDto;
import com.example.CotaeMangementdemo.dto.login.response.LoginCheckResponseDto;
import com.example.CotaeMangementdemo.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final MemberRepository memberRepository;

    @Override
    public LoginCheckResponseDto login(LoginCheckRequestDto dto) {
        Optional<Member> oneWithId = memberRepository.findOneWithId(dto.getId());

        if(oneWithId.isPresent()){
            if(dto.getPassword().equals(oneWithId.get().getPassword()))
                return new LoginCheckResponseDto().createResponse(oneWithId.get());
            return new LoginCheckResponseDto().createErrorMessage(400L);
        }

        return new LoginCheckResponseDto().createErrorMessage(401L);
    }

}
