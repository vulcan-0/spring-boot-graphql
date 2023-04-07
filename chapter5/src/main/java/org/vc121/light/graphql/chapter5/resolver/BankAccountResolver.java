package org.vc121.light.graphql.chapter5.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.vc121.light.graphql.chapter5.bank.BankAccount;
import org.vc121.light.graphql.chapter5.bank.Client;
import org.vc121.light.graphql.chapter5.bank.Currency;

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
                .client(Client.builder()
                        .id(UUID.randomUUID())
                        .firstName("Philip")
                        .lastName("Starritt")
                        .build())
                .build();
    }

}
