package com.example.CotaeMangementdemo.controller;

import com.example.CotaeMangementdemo.dto.login.LoginCheckRequestDto;
import com.example.CotaeMangementdemo.dto.member.request.MemberJoinRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@Controller
public class LoginController {

    @PostMapping("/member/check")
    public ResponseEntity<Boolean> check(@RequestBody LoginCheckRequestDto dto){

        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostMapping("/member/join")
    public ResponseEntity<Boolean> join(@RequestBody MemberJoinRequestDto dto){

        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @GetMapping("/member/findPassword/")
    public ResponseEntity<String> findPassword(HttpServletRequest request){
        request.getParameter("question");
        request.getParameter("answer");

        return ResponseEntity.status(HttpStatus.OK).body("sample");
    }
}
