package org.vc121.light.graphql.chapter3.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.vc121.light.graphql.chapter3.domain.bank.BankAccount;
import org.vc121.light.graphql.chapter3.domain.bank.Client;
import org.vc121.light.graphql.chapter3.domain.bank.Currency;

import java.util.List;
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

        return BankAccount.builder().id(UUID.randomUUID())
                .client(Client.builder().id(UUID.randomUUID())
                        .firstName("Jack")
                        .middleNames(List.of("m1", "m2", "m3"))
                        .lastName("Chen")
                        .build())
                .currency(Currency.USD)
                .build();
    }

}
