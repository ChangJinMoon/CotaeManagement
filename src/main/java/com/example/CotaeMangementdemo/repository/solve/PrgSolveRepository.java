package com.example.CotaeMangementdemo.repository.solve;

import com.example.CotaeMangementdemo.domain.solve.MemberSolveBoj;
import com.example.CotaeMangementdemo.domain.solve.MemberSolvePrg;

import java.util.List;
import java.util.Optional;

public interface PrgSolveRepository {

    Optional<MemberSolvePrg> findOne(Long id);
    Optional<List<MemberSolvePrg>> findAllWithMemberId(Long memberId);
    Optional<List<MemberSolvePrg>> findAllWithProblemId(Long problemId);
    boolean save(MemberSolvePrg memberSolve);

}
