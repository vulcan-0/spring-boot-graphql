package org.vc121.light.graphql.chapter2.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.vc121.light.graphql.chapter2.domain.bank.BankAccount;
import org.vc121.light.graphql.chapter2.domain.bank.Currency;

import java.util.UUID;

/**
 * @author lxc
 * @date 2023/04/05
 */
@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {

    public BankAccount bankAccount(UUID id) {
        log.info("Retrieving bank account id: {}", id);

        return BankAccount.builder().id(UUID.randomUUID()).currency(Currency.USD).name("Philip").build();
    }

}
