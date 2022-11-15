package com.example.CotaeMangementdemo.repository.solve;

import com.example.CotaeMangementdemo.domain.solve.MemberSolveBoj;

import java.util.List;
import java.util.Optional;

public interface BojSolveRepository {
    Optional<MemberSolveBoj> findOne(Long id );
    Optional<List<MemberSolveBoj>> findAllWithMemberId(Long memberId);
    Optional<List<MemberSolveBoj>> findAllWithProblemId(Long problemId);
    boolean save(MemberSolveBoj memberSolve);

}
