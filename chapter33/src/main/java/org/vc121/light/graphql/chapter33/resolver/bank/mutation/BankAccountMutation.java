package org.vc121.light.graphql.chapter33.resolver.bank.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.vc121.light.graphql.chapter33.domain.bank.BankAccount;
import org.vc121.light.graphql.chapter33.domain.bank.Client;
import org.vc121.light.graphql.chapter33.domain.bank.Currency;
import org.vc121.light.graphql.chapter33.domain.bank.input.CreateBankAccountInput;
import org.vc121.light.graphql.chapter33.publisher.BankAccountPublisher;

import javax.validation.Valid;
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
@Validated
public class BankAccountMutation implements GraphQLMutationResolver {

    private final Clock clock;
    private final BankAccountPublisher publisher;

    public BankAccount createBankAccount(@Valid CreateBankAccountInput input, DataFetchingEnvironment e) {
        log.info("Creating bank account for {}", input);

        var bankAccount = BankAccount.builder().id(UUID.randomUUID())
                .client(Client.builder().id(UUID.randomUUID())
                        .firstName(input.getFirstName())
                        .build())
                .currency(Currency.USD)
                .createOn(LocalDate.now(clock))
                .createAt(ZonedDateTime.now(clock))
                .build();

        publisher.publish(bankAccount);
        return bankAccount;
    }

    public BankAccount createBankAccountWith(UUID id) {
        log.info("Creating bank account with id: {}", id);

        var bankAccount = BankAccount.builder().id(id)
                .currency(Currency.USD)
                .createOn(LocalDate.now(clock))
                .createAt(ZonedDateTime.now(clock))
                .build();

        publisher.publish(bankAccount);
        return bankAccount;
    }

    public BankAccount updateBankAccount(UUID id, String name, int age) {
        log.info("Updating bank account for {}. name: {}, age: {}", id, name, age);

        var bankAccount = BankAccount.builder().id(UUID.randomUUID())
                .currency(Currency.USD)
                .createOn(LocalDate.now(clock))
                .createAt(ZonedDateTime.now(clock))
                .build();

        publisher.publish(bankAccount);
        return bankAccount;
    }

}
