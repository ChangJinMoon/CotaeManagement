package com.example.CotaeMangementdemo.domain.member;

import com.example.CotaeMangementdemo.domain.solve.MemberSolveBoj;
import com.example.CotaeMangementdemo.domain.solve.MemberSolvePrg;
import com.example.CotaeMangementdemo.status.StatusMember;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "member")
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberId;

    private String password;

    private String name;

    private LocalDateTime joinDate;

    @Column(name="user_role")
    @Enumerated(EnumType.STRING)
    private StatusMember role;

    @OneToOne
    @JoinColumn(name = "hint_id")
    private MemberPasswordHintSet hint;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberSolveBoj> memberSolveBoj = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberSolvePrg> memberSolvePrg = new ArrayList<>();

    public Member createMember(String memberId, String password, String name, StatusMember role, MemberPasswordHintSet hintSet){
        Member temp = new Member();
        temp.memberId = memberId;
        temp.password = password;
        temp.name = name;
        temp.role = role;
        temp.hint = hintSet;
        temp.joinDate = LocalDateTime.now();
        return temp;
    }
}
