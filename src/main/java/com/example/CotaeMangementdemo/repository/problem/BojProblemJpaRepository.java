package com.example.CotaeMangementdemo.repository.problem;

import com.example.CotaeMangementdemo.domain.problem.BojProblem;
import com.example.CotaeMangementdemo.domain.problem.PrgProblem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BojProblemJpaRepository implements BojProblemRepository{
    private final EntityManager entityManager;

    @Override
    public Optional<BojProblem> findOneWithId(Long id) {
        return Optional.ofNullable(entityManager.find(BojProblem.class,id));
    }

    @Override
    public Optional<BojProblem> findOneWithProblemId(Long problemId) {
        return Optional.ofNullable(entityManager
                .createQuery("select b from BojProblem b where b.problemId = :problemId",BojProblem.class)
                .setParameter("problemId",problemId)
                .getResultList().get(0));
    }

    @Override
    public boolean addProblem(BojProblem problem) {
        entityManager.persist(problem);
        if(findOneWithId(problem.getId()).isPresent())
            return true;
        return false;
    }

    @Override
    public boolean deleteProblemWithProblemId(Long problemId) {
        Optional<BojProblem> oneWithProblemId = findOneWithProblemId(problemId);
        if(oneWithProblemId.isPresent()) {
            entityManager.remove(oneWithProblemId.get());
            return true;
        }
        return false;
    }

    @Override
    public Optional<List<BojProblem>> findAllProblem() {
        return Optional.ofNullable(entityManager
                .createQuery("select b from BojProblem b", BojProblem.class)
                .getResultList());
    }
}
