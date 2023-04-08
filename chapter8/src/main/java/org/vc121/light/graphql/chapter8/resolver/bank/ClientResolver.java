package org.vc121.light.graphql.chapter8.resolver.bank;

import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.vc121.light.graphql.chapter8.domain.bank.BankAccount;
import org.vc121.light.graphql.chapter8.domain.bank.Client;

import java.util.UUID;

/**
 * @author lxc
 * @date 2023/04/08
 */
@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

    public Client client(BankAccount bankAccount) {
        log.info("Requesting client data for bank account id {}", bankAccount.getId());

        throw new RuntimeException("Spring exception cant connect to database: (sql select *)");

//        return Client.builder()
//                .id(UUID.randomUUID())
//                .firstName("Philip")
//                .lastName("Starritt")
//                .build();
    }

}
