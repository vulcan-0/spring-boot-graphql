package org.vc121.light.graphql.chapter17.resolver.bank.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.vc121.light.graphql.chapter17.domain.bank.BankAccount;
import org.vc121.light.graphql.chapter17.domain.bank.Client;
import org.vc121.light.graphql.chapter17.domain.bank.Currency;
import org.vc121.light.graphql.chapter17.domain.bank.input.CreateBankAccountInput;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * @author lxc
 * @date 2023/04/10
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class BankAccountMutation implements GraphQLMutationResolver {

    private final Clock clock;

    public BankAccount createBankAccount(CreateBankAccountInput input, DataFetchingEnvironment e) {
        log.info("Creating bank account for {}", input);

        return BankAccount.builder().id(UUID.randomUUID())
                .client(Client.builder().id(UUID.randomUUID())
                        .firstName(input.getFirstName())
                        .build())
                .currency(Currency.USD)
                .createOn(LocalDate.now(clock))
                .createAt(ZonedDateTime.now(clock))
                .build();
    }

}
