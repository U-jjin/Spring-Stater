package starter.springbasic.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import starter.springbasic.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //데이터 클리어 메소드
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();

        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();

//        Assertions.assertEquals(member,result);  -> 이방법은 member result 위치가 헷갈림
//        Assertions.assertThat(member).isEqualTo(result); -->Assertions static으로 import하면 작성안해도 됨
        assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

//        한줄씩 선택은 shift + 원하는 단락 화살표 위아래 왼오
//        해당 변수 rename shift+F6
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get(); //Optional 꺼낼려면 .get()

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);


        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }
}
