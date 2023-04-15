package org.vc121.light.graphql.chapter20.resolver.bank.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.SelectedField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.vc121.light.graphql.chapter20.domain.bank.BankAccount;
import org.vc121.light.graphql.chapter20.domain.bank.Currency;

import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author lxc
 * @date 2023/04/05
 */
@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {

    public BankAccount bankAccount(UUID id, DataFetchingEnvironment environment) {
        log.info("Retrieving bank account id: {}", id);

        var requestedFields = environment.getSelectionSet().getFields().stream()
                .map(SelectedField::getName).collect(Collectors.toUnmodifiableSet());

        if (environment.getSelectionSet().contains("specialField")) {
            // do special stuff
        }

        return BankAccount.builder()
                .id(id)
                .currency(Currency.USD)
                .build();
    }

}
