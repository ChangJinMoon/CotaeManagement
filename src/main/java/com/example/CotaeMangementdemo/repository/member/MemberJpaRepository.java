package com.example.CotaeMangementdemo.repository.member;

import com.example.CotaeMangementdemo.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberJpaRepository implements MemberRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Optional<Member> findOneWithId(String id) {
        return Optional.ofNullable(entityManager
                .createQuery("select m from Member m where m.memberId = :id",Member.class)
                .setParameter("id",id)
                .getResultList().get(0));
    }

    @Override
    public boolean addOne(Member member) {
        if(findOneWithId(member.getMemberId()).isPresent())
            return false;

        entityManager.persist(member);
        return true;
    }

    @Override
    public boolean deleteOneWithId(String id) {
        Optional<Member> oneWithId = findOneWithId(id);
        if(oneWithId.isPresent()) {
            entityManager.remove(oneWithId.get().getId());
            return true;
        }
        return false;
    }

    @Override
    public Optional<List<Member>> findAll() {
        return Optional.ofNullable(entityManager
                .createQuery("select m from Member m").getResultList());
    }
}
