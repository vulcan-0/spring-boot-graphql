package org.vc121.light.graphql.chapter27.resolver.bank.query;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.vc121.light.graphql.chapter27.Chapter27GraphqlServerApplication;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * @author lxc
 * @date 2023/04/24
 */
@Configuration
@Import(Chapter27GraphqlServerApplication.class)
public class TestApplication {

    @Bean
    @Primary
    public Clock testClock() {
        return Clock.fixed(LocalDate.of(2023, 4, 24).atStartOfDay(ZoneId.of("UTC"))
                .toInstant(), ZoneId.of("UTC"));
    }

}
