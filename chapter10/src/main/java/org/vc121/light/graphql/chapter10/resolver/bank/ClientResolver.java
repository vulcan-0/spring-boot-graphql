package org.vc121.light.graphql.chapter10.resolver.bank;

import graphql.GraphqlErrorException;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.vc121.light.graphql.chapter10.domain.bank.BankAccount;
import org.vc121.light.graphql.chapter10.domain.bank.Client;

import java.util.UUID;

/**
 * @author lxc
 * @date 2023/04/08
 */
@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

    public DataFetcherResult<Client> client(BankAccount bankAccount) {
        log.info("Requesting client data for bank account id {}", bankAccount.getId());

        /**
         * 1. Call multiple services
         * 2. Call another graphql server
         * 3. Call services that returns partial responses
         */

        return DataFetcherResult.<Client>newResult().data(Client.builder()
                        .id(UUID.randomUUID())
                        .firstName("Philip")
                        .lastName("Starritt")
                        .build())
                .error(new GenericGraphQLError("Could not get sub-client id"))
                .build();
    }

}
