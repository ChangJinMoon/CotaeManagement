package com.example.CotaeMangementdemo.repository.problem;

import com.example.CotaeMangementdemo.domain.problem.PrgProblem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PrgProblemJpaRepository implements PrgProblemRepository{
    private final EntityManager entityManager;

    @Override
    public Optional<PrgProblem> findOneWithId(Long id) {
        return Optional.ofNullable(entityManager.find(PrgProblem.class,id));
    }

    @Override
    public Optional<PrgProblem> findOneWithProblemId(Long problemId) {
        return Optional.ofNullable(entityManager
                .createQuery("select p from PrgProblem p where p.problemId = :problemId",PrgProblem.class)
                .setParameter("problemId",problemId)
                .getResultList().get(0));
    }

    @Override
    public boolean addProblem(PrgProblem problem) {
        entityManager.persist(problem);
        if(findOneWithId(problem.getId()).isPresent())
            return true;
        return false;
    }

    @Override
    public boolean deleteProblemWithProblemId(Long problemId) {
        Optional<PrgProblem> oneWithProblemId = findOneWithProblemId(problemId);
        if(oneWithProblemId.isPresent()) {
            entityManager.remove(oneWithProblemId.get());
            return true;
        }
        return false;
    }

    @Override
    public Optional<List<PrgProblem>> findAllProblem() {
        return Optional.ofNullable(entityManager
                .createQuery("select p from PrgProblem p", PrgProblem.class)
                .getResultList());
    }
}
