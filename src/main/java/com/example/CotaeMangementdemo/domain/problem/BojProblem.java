package com.example.CotaeMangementdemo.domain.problem;

import com.example.CotaeMangementdemo.domain.solve.MemberSolveBoj;
import com.example.CotaeMangementdemo.status.BojLevel;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bakjoon_problem")
@Getter
public class BojProblem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "problem_id")
    private Long problemId;

    @Column(name = "problem_name")
    private String problemName;

    @Enumerated(EnumType.STRING)
    private BojLevel bojLevel;

    private String url;

    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL)
    private List<MemberSolveBoj> memberSolveBojList = new ArrayList<>();

    BojProblem createProblem(Long problemId, String problemName, BojLevel bojLevel, String url) {
        BojProblem problem = new BojProblem();
        problem.problemId = problemId;
        problem.problemName = problemName;
        problem.bojLevel = bojLevel;
        problem.url = url;
        return problem;
    }
}
