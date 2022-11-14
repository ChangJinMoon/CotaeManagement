package com.example.CotaeMangementdemo.domain.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "hint")
@NoArgsConstructor
public class MemberPasswordHintSet {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hint_id")
    private Long hintId;

    private String question;

    private String answer;

    @OneToOne(mappedBy = "hint")
    private Member member;


    public MemberPasswordHintSet(String question, String answer){
        this.question = question;
        this.answer = answer;
    }
}
