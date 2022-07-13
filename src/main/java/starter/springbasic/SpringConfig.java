package starter.springbasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import starter.springbasic.repository.JdbcMemberRepository;
import starter.springbasic.repository.MemberRepository;
import starter.springbasic.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //스프링빈에 등록하면서 하나의 인스턴스를 생성함
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }


    @Bean
    public MemberRepository memberRepository(){

        return new JdbcMemberRepository(dataSource);
//        Memory 구현
//        return new MemoryMemberRepository();
    }

}
