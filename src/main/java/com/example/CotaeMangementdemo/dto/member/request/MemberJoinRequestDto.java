package com.example.CotaeMangementdemo.dto.member.request;

import com.example.CotaeMangementdemo.domain.member.MemberPasswordHintSet;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor
public class MemberJoinRequestDto {
    private String id;
    private String name;
    private String password;
    private MemberPasswordHintSet hint;

    public MemberJoinRequestDto(@NonNull String id, @NonNull String name, @NonNull String password, @NonNull String question, @NonNull String answer) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.hint = new MemberPasswordHintSet(question,answer);
    }
}
