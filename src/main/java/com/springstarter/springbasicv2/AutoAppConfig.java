package com.springstarter.springbasicv2;

import com.springstarter.springbasicv2.member.MemberRepository;
import com.springstarter.springbasicv2.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes=Configuration.class))
public class AutoAppConfig {

    @Bean(name ="memoryMemberRepository")
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
