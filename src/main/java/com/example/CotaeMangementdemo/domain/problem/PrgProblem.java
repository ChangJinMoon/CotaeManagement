package com.example.CotaeMangementdemo.domain.problem;

import com.example.CotaeMangementdemo.domain.solve.MemberSolvePrg;
import com.example.CotaeMangementdemo.status.BojLevel;
import com.example.CotaeMangementdemo.status.PrgLevel;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "programmers_problem")
@Getter
public class PrgProblem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "problem_id")
    private Long problemId;

    @Column(name = "problem_name")
    private String problemName;

    @Enumerated(EnumType.STRING)
    private PrgLevel prgLevel;

    private String url;

    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL)
    private List<MemberSolvePrg> memberSolveBojList = new ArrayList<>();

    public PrgProblem createProblem(Long problemId, String problemName, PrgLevel prgLevel, String url) {
        PrgProblem problem = new PrgProblem();
        problem.problemId = problemId;
        problem.problemName = problemName;
        problem.prgLevel = prgLevel;
        problem.url = url;
        return problem;
    }

}
