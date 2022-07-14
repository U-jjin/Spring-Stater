package starter.springbasic.service;

import org.springframework.beans.factory.annotation.Autowired;
import starter.springbasic.domain.Member;
import starter.springbasic.repository.MemberRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //    회원가입
//ctrl +alt +v 단축키 최고 +m은 메소드
    public Long join(Member member ) throws SQLException {
        long start = System.currentTimeMillis();

        try{
            //같은 이름이 있는 중복 회원X
            validateDuplicateMember(member);  //중복 회원 검증
            memberRepository.save(member);

            return member.getId();
        }finally{
            long finish = System.currentTimeMillis();
            long timeMs = finish-start;
            System.out.println("join= "+timeMs+"ms");
        }

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
    /*
     전체 회원 조회
     */
    public List<Member> findMembers(){
        long start = System.currentTimeMillis();
        try {
            return memberRepository.findAll();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findMembers " + timeMs + "ms");
        }
    }


    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
