package com.example.CotaeMangementdemo.dto.member.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor
public class MemberFindPasswordRequestDto {
    private String question;
    private String answer;

    public MemberFindPasswordRequestDto(@NonNull String question,@NonNull String answer) {
        this.question = question;
        this.answer = answer;
    }
}
