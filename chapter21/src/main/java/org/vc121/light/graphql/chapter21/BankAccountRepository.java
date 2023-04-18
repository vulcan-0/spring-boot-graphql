package org.vc121.light.graphql.chapter21;

import org.springframework.stereotype.Component;
import org.vc121.light.graphql.chapter21.domain.bank.BankAccount;
import org.vc121.light.graphql.chapter21.domain.bank.Currency;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author lxc
 * @date 2023/04/18
 */
@Component
public class BankAccountRepository {

    private final List<BankAccount> bankAccounts = List.of(
            BankAccount.builder()
                    .id(UUID.fromString("5b6d95d9-9404-4c1a-964f-a7b711ae6660"))
                    .currency(Currency.USD)
                    .createAt(ZonedDateTime.parse("2023-04-18T08:30:00+00:00"))
                    .build(),
            BankAccount.builder()
                    .id(UUID.fromString("5b6d95d9-9404-4c1a-964f-a7b711ae6661"))
                    .currency(Currency.CHF)
                    .createAt(ZonedDateTime.parse("2023-04-18T08:30:00+00:00"))
                    .build(),
            BankAccount.builder()
                    .id(UUID.fromString("5b6d95d9-9404-4c1a-964f-a7b711ae6662"))
                    .currency(Currency.CHF)
                    .createAt(ZonedDateTime.parse("2023-04-18T08:30:00+00:00"))
                    .build(),
            BankAccount.builder()
                    .id(UUID.fromString("5b6d95d9-9404-4c1a-964f-a7b711ae6663"))
                    .currency(Currency.CHF)
                    .createAt(ZonedDateTime.parse("2023-04-18T08:30:00+00:00"))
                    .build(),
            BankAccount.builder()
                    .id(UUID.fromString("5b6d95d9-9404-4c1a-964f-a7b711ae6664"))
                    .currency(Currency.USD)
                    .createAt(ZonedDateTime.parse("2023-04-18T08:30:00+00:00"))
                    .build()
    );

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public List<BankAccount> getBankAccountsAfter(UUID id) {
        return bankAccounts.stream()
                .dropWhile(bankAccount -> {
                    return bankAccount.getId().compareTo(id) < 0;
                })
                .collect(Collectors.toUnmodifiableList());
    }

}
