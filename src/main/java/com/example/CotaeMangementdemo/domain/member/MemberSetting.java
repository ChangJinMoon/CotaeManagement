package com.example.CotaeMangementdemo.domain.member;

import com.example.CotaeMangementdemo.status.BojLevel;
import com.example.CotaeMangementdemo.status.PrgLevel;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "member_setting")
@Getter
public class MemberSetting {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "setting_id")
    private Long id;

    @OneToOne(mappedBy = "setting")
    private Member member;

    @Column(name = "boj_status")
    private String bojStatus;

    @Column(name = "prg_status")
    private String prgStatus;

    public List<BojLevel> getBojStatus(){
        List<BojLevel> temp = new ArrayList<>();
        Arrays.stream(this.bojStatus.split(",")).forEach(x ->temp.add(BojLevel.valueOf(BojLevel.class,x)));
        return temp;
    }

    public List<PrgLevel> getPrgStatus(){
        List<PrgLevel> temp = new ArrayList<>();
        Arrays.stream(this.prgStatus.split(",")).forEach(x ->temp.add(PrgLevel.valueOf(PrgLevel.class,x)));
        return temp;
    }

    public MemberSetting createMemberSetting(){
        MemberSetting memberSetting = new MemberSetting();
        memberSetting.bojStatus = new String();
        memberSetting.prgStatus = new String();
        return memberSetting;
    }
}
