package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;


public class MemberService {
    private final MemberRepository memberReposiroty;


    public MemberService(MemberRepository memberReposiroty) {
        this.memberReposiroty = memberReposiroty;
    }


    /**
     * 회원 가입
     */
    public Long join(Member member) {
        //같은 이름 있는 중복 회원X
        validateDuplicateMember(member);
        memberReposiroty.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberReposiroty.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberReposiroty.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberReposiroty.findById(memberId);
    }
}
