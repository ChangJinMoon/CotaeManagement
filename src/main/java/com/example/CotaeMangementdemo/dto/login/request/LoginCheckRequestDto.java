package com.example.CotaeMangementdemo.dto.login.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor
public class LoginCheckRequestDto {
    private String id;
    private String password;

    public LoginCheckRequestDto(@NonNull String id, String password){
        this.id = id;
        this.password = password;
    }
}
