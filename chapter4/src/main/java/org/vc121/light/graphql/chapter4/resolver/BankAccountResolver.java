package org.vc121.light.graphql.chapter4.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.vc121.light.graphql.chapter4.bank.BankAccount;
import org.vc121.light.graphql.chapter4.bank.Client;
import org.vc121.light.graphql.chapter4.bank.Currency;

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

        var clientA = Client.builder().id(UUID.randomUUID())
                .firstName("Philip")
                .lastName("Starritt1")
                .build();

        var clientB = Client.builder().id(UUID.randomUUID())
                .firstName("Philip")
                .lastName("Starritt2")
                .build();

        clientA.setClient(clientB);
        clientB.setClient(clientA);

        return BankAccount.builder().id(UUID.randomUUID())
                .client(clientA)
                .currency(Currency.USD)
                .build();
    }

}
