package com.example.CotaeMangementdemo.repository.member;

import com.example.CotaeMangementdemo.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Optional<Member> findOneWithId(String id);
    boolean addOne(Member member);
    boolean deleteOneWithId(String id);
    Optional<List<Member>> findAll();
}
