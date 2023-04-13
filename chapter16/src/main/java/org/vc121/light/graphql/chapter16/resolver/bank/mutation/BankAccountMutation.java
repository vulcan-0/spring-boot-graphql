package org.vc121.light.graphql.chapter16.resolver.bank.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.vc121.light.graphql.chapter16.domain.bank.BankAccount;
import org.vc121.light.graphql.chapter16.domain.bank.Client;
import org.vc121.light.graphql.chapter16.domain.bank.Currency;
import org.vc121.light.graphql.chapter16.domain.bank.input.CreateBankAccountInput;

import java.util.UUID;

/**
 * @author lxc
 * @date 2023/04/10
 */
@Slf4j
@Component
public class BankAccountMutation implements GraphQLMutationResolver {

    public BankAccount createBankAccount(CreateBankAccountInput input, DataFetchingEnvironment e) {
        log.info("Creating bank account for {}", input);

        return BankAccount.builder().id(UUID.randomUUID())
                .client(Client.builder().id(UUID.randomUUID())
                        .firstName(input.getFirstName())
                        .build())
                .currency(Currency.USD)
                .build();
    }

}
