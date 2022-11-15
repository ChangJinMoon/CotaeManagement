package com.example.CotaeMangementdemo.domain.solve;

import com.example.CotaeMangementdemo.domain.member.Member;
import com.example.CotaeMangementdemo.domain.problem.BojProblem;
import com.example.CotaeMangementdemo.domain.problem.PrgProblem;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "member_solve_boj")
public class MemberSolveBoj {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private BojProblem problem;

    public MemberSolveBoj createSolveProblem(Member member, BojProblem problem){
        MemberSolveBoj temp = new MemberSolveBoj();
        temp.member = member;
        temp.problem = problem;
        return temp;
    }
}
