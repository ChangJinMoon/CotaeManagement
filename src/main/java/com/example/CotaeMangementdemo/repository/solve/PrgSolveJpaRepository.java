package com.example.CotaeMangementdemo.repository.solve;

import com.example.CotaeMangementdemo.domain.solve.MemberSolveBoj;
import com.example.CotaeMangementdemo.domain.solve.MemberSolvePrg;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PrgSolveJpaRepository implements PrgSolveRepository{

    private final EntityManager entityManager;

    @Override
    public Optional<MemberSolvePrg> findOne(Long id) {
        return Optional.ofNullable(entityManager.find(MemberSolvePrg.class,id));
    }

    @Override
    public Optional<List<MemberSolvePrg>> findAllWithMemberId(Long memberId) {
        return Optional.ofNullable(entityManager
                .createQuery("select s from MemberSolvePrg s where s.member.id = :memberId",MemberSolvePrg.class)
                .setParameter("memberId",memberId)
                .getResultList());
    }

    @Override
    public Optional<List<MemberSolvePrg>> findAllWithProblemId(Long problemId) {
        return Optional.ofNullable(entityManager
                .createQuery("select s from MemberSolvePrg s where s.problem.id = :problemId",MemberSolvePrg.class)
                .setParameter("problemId",problemId)
                .getResultList());
    }

    @Override
    public boolean save(MemberSolvePrg memberSolve) {
        if(findOne(memberSolve.getId()).isPresent())
            return false;
        entityManager.persist(memberSolve);
        return true;
    }
}
