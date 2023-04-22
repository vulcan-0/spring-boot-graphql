package org.vc121.light.graphql.chapter25.resolver.bank.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.relay.*;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.SelectedField;
import io.micrometer.core.lang.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.vc121.light.graphql.chapter25.BankAccountRepository;
import org.vc121.light.graphql.chapter25.connection.CursorUtil;
import org.vc121.light.graphql.chapter25.context.CustomGraphQLContext;
import org.vc121.light.graphql.chapter25.domain.bank.BankAccount;
import org.vc121.light.graphql.chapter25.domain.bank.Currency;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author lxc
 * @date 2023/04/05
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class BankAccountQueryResolver implements GraphQLQueryResolver {

    private final BankAccountRepository bankAccountRepository;
    private final CursorUtil cursorUtil;

    public BankAccount bankAccount(UUID id, DataFetchingEnvironment environment) {
        log.info("Retrieving bank account id: {}", id);

        CustomGraphQLContext context = environment.getContext();
        log.info("User ID: {}", context.getUserId());

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

    public Connection<BankAccount> bankAccounts(int first, @Nullable String cursor) {
        List<Edge<BankAccount>> edges = getBankAccounts(cursor)
                .stream()
                .map(bankAccount -> new DefaultEdge<BankAccount>(bankAccount,
                        cursorUtil.createCursorWith(bankAccount.getId())))
                .limit(first)
                .collect(Collectors.toUnmodifiableList());

        var pageInfo = new DefaultPageInfo(
                cursorUtil.getFirstCursorFrom(edges),
                cursorUtil.getLastCursorFrom(edges),
                cursor != null && !"".equals(cursor),
                edges.size() >= first);

        return new DefaultConnection<>(edges, pageInfo);
    }

    public List<BankAccount> getBankAccounts(String cursor) {
        if (cursor == null || "".equals(cursor)) {
            return bankAccountRepository.getBankAccounts();
        }
        return bankAccountRepository.getBankAccountsAfter(cursorUtil.decode(cursor));
    }

}
