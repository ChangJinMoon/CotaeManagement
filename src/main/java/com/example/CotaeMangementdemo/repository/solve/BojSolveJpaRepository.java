package com.example.CotaeMangementdemo.repository.solve;

import com.example.CotaeMangementdemo.domain.solve.MemberSolveBoj;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BojSolveJpaRepository implements BojSolveRepository {
    private final EntityManager entityManager;

    @Override
    public Optional<MemberSolveBoj> findOne(Long id) {
        return Optional.ofNullable(entityManager.find(MemberSolveBoj.class,id));
    }

    @Override
    public Optional<List<MemberSolveBoj>> findAllWithMemberId(Long memberId) {
        return Optional.ofNullable(entityManager
                .createQuery("select s from MemberSolveBoj s where s.member.id = :memberId",MemberSolveBoj.class)
                .setParameter("memberId",memberId)
                .getResultList());
    }

    @Override
    public Optional<List<MemberSolveBoj>> findAllWithProblemId(Long problemId) {
        return Optional.ofNullable(entityManager
                .createQuery("select s from MemberSolveBoj s where s.problem.id = :problemId",MemberSolveBoj.class)
                .setParameter("problemId",problemId)
                .getResultList());
    }

    @Override
    public boolean save(MemberSolveBoj memberSolve) {
        if(findOne(memberSolve.getId()).isPresent())
            return false;
        entityManager.persist(memberSolve);
        return true;
    }
}
