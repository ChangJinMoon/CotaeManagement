package com.example.CotaeMangementdemo.service.login;

import com.example.CotaeMangementdemo.dto.login.request.LoginCheckRequestDto;
import com.example.CotaeMangementdemo.dto.login.response.LoginCheckResponseDto;

public interface LoginService {
    LoginCheckResponseDto login(LoginCheckRequestDto dto);
}
