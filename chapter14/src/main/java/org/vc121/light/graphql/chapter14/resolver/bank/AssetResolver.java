package org.vc121.light.graphql.chapter14.resolver.bank;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.vc121.light.graphql.chapter14.domain.bank.Asset;
import org.vc121.light.graphql.chapter14.domain.bank.BankAccount;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lxc
 * @date 2023/04/09
 */
@Slf4j
@Component
public class AssetResolver implements GraphQLResolver<BankAccount> {

    private final ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    public CompletableFuture<List<Asset>> assets(BankAccount bankAccount) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Getting assets for bank account id {}", bankAccount.getId());
            return List.of(
                    Asset.builder().id(UUID.randomUUID()).build(),
                    Asset.builder().id(UUID.randomUUID()).build()
            );
        }, executorService);
    }

}
