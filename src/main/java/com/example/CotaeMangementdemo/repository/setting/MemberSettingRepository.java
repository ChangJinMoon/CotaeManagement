package com.example.CotaeMangementdemo.repository.setting;

import com.example.CotaeMangementdemo.domain.member.MemberSetting;

import java.util.Optional;

public interface MemberSettingRepository {
    boolean save(MemberSetting memberSetting);
    Optional<MemberSetting> load(Long settingId);
    boolean delete(MemberSetting memberSetting);
}
