package org.vc121.light.graphql.chapter7.resolver.bank.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.vc121.light.graphql.chapter7.bank.BankAccount;
import org.vc121.light.graphql.chapter7.bank.Client;
import org.vc121.light.graphql.chapter7.bank.Currency;

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

        return BankAccount.builder()
                .id(id)
                .currency(Currency.USD)
                .build();
    }

}