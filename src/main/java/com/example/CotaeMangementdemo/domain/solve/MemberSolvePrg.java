package com.example.CotaeMangementdemo.domain.solve;

import com.example.CotaeMangementdemo.domain.member.Member;
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
}
