package org.vc121.light.graphql.chapter33.resolver.bank.query;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.DataLoader;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.vc121.light.graphql.chapter33.dataloader.DataLoaderRegistryFactory;
import org.vc121.light.graphql.chapter33.domain.bank.BankAccount;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * @author lxc
 * @date 2023/04/20
 */
@Slf4j
@Component
public class BankAccountResolver implements GraphQLResolver<BankAccount> {

    @PreAuthorize("hasAuthority('get:bank_account_balance')")
    public CompletableFuture<BigDecimal> balance(BankAccount bankAccount, DataFetchingEnvironment environment) {
        DataLoader<UUID, BigDecimal> dataLoader = environment.getDataLoader(
                DataLoaderRegistryFactory.BALANCE_DATA_LOADER);
        return dataLoader.load(bankAccount.getId(), bankAccount);
    }

}
