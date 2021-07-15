package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    // 2.jdbcMemberRepository, 3.JdbcTemplateMemberRepository
//    DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    // 4. JpaMemberRepository
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }

    // 5.
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        //return new MemberService(memberRepository()); // 1, 2, 3, 4
        return new MemberService(memberRepository); // 5.
    }

//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }

    // 1, 2, 3, 4
//    @Bean
//    public MemberRepository memberRepository() {
//        // return new MemoryMemberRepository(); // 1
//        // return new jdbcMemberRepository(dataSource); // 2
//        //return new JdbcTemplateMemberRepository(dataSource); // 3
//        return new JpaMemberRepository(em); // 4
//    }
}
