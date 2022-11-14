package com.example.CotaeMangementdemo.repository.problem;

import com.example.CotaeMangementdemo.domain.problem.BojProblem;
import com.example.CotaeMangementdemo.domain.problem.PrgProblem;

import java.util.List;
import java.util.Optional;

public interface BojProblemRepository {
    Optional<BojProblem> findOneWithId(Long id);

    Optional<BojProblem> findOneWithProblemId(Long problemId);

    boolean addProblem(BojProblem problem);

    boolean deleteProblemWithProblemId(Long problemId);

    Optional<List<BojProblem>> findAllProblem();
}
