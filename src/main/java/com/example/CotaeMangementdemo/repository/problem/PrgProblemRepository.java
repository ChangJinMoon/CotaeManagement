package com.example.CotaeMangementdemo.repository.problem;

import com.example.CotaeMangementdemo.domain.problem.PrgProblem;

import java.util.List;
import java.util.Optional;

public interface PrgProblemRepository {
    Optional<PrgProblem> findOneWithId(Long id);

    Optional<PrgProblem> findOneWithProblemId(Long problemId);

    boolean addProblem(PrgProblem problem);

    boolean deleteProblemWithProblemId(Long problemId);

    Optional<List<PrgProblem>> findAllProblem();
}
