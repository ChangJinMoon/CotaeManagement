package com.example.CotaeMangementdemo.repository.setting;

import com.example.CotaeMangementdemo.domain.member.MemberSetting;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberSettingJpaRepository implements MemberSettingRepository {

    private final EntityManager entityManager;

    @Override
    public boolean save(MemberSetting memberSetting) {
        if(load(memberSetting.getId()).isPresent())
            return false;
        entityManager.persist(memberSetting);
        return true;
    }

    @Override
    public Optional<MemberSetting> load(Long settingId) {
        return Optional.ofNullable(entityManager.find(MemberSetting.class,settingId));
    }

    @Override
    public boolean delete(MemberSetting memberSetting) {
        return false;
    }
}
