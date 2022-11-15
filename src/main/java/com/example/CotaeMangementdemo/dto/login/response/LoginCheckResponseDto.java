package com.example.CotaeMangementdemo.dto.login.response;

import com.example.CotaeMangementdemo.domain.member.Member;
import com.example.CotaeMangementdemo.domain.member.MemberSetting;
import com.example.CotaeMangementdemo.domain.solve.MemberSolveBoj;
import com.example.CotaeMangementdemo.domain.solve.MemberSolvePrg;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class LoginCheckResponseDto {
    private Long status;
    private Long id;
    private String memberId;
    private String name;
    private MemberSetting memberSetting;
    private List<MemberSolveBoj> memberSolveBoj;
    private List<MemberSolvePrg> memberSolvePrg;

    public LoginCheckResponseDto createResponse(Member member){
        LoginCheckResponseDto temp = new LoginCheckResponseDto();
        temp.id = member.getId();
        temp.memberId = member.getMemberId();
        temp.memberSetting= member.getSetting();
        temp.memberSolveBoj = member.getMemberSolveBoj();
        temp.memberSolvePrg = member.getMemberSolvePrg();
        temp.name = member.getName();
        temp.status = 200L;
        return temp;
    }

    public LoginCheckResponseDto createErrorMessage(Long status){
        LoginCheckResponseDto temp = new LoginCheckResponseDto();
        temp.status = status;
        return temp;
    }
}
