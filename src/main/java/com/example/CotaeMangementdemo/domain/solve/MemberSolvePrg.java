package com.example.CotaeMangementdemo.domain.solve;

import com.example.CotaeMangementdemo.domain.member.Member;
import com.example.CotaeMangementdemo.domain.problem.BojProblem;
import com.example.CotaeMangementdemo.domain.problem.PrgProblem;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "member_solve_prg")
public class MemberSolvePrg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private PrgProblem problem;

    public MemberSolvePrg createSolveProblem(Member member, PrgProblem problem){
        MemberSolvePrg temp = new MemberSolvePrg();
        temp.member = member;
        temp.problem = problem;
        return temp;
    }
}
