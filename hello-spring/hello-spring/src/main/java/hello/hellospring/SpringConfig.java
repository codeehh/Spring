package hello.hellospring;

import hello.hellospring.repository.MemberReposiroty;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.RecursiveTask;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberReposiroty());
    }

    @Bean
    public MemberReposiroty memberReposiroty() {
        return new MemoryMemberRepository();
    }

}
