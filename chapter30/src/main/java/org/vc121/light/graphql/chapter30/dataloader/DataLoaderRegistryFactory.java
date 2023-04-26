package org.vc121.light.graphql.chapter30.dataloader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.BatchLoaderEnvironment;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderOptions;
import org.dataloader.DataLoaderRegistry;
import org.springframework.stereotype.Component;
import org.vc121.light.graphql.chapter30.service.BalanceService;
import org.vc121.light.graphql.chapter30.util.CorrelationIdPropagationExecutor;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author lxc
 * @date 2023/04/20
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DataLoaderRegistryFactory {

    private final BalanceService balanceService;

    public static final String BALANCE_DATA_LOADER = "BALANCE_DATA_LOADER";
    private static final Executor balanceThreadPool = CorrelationIdPropagationExecutor.wrap(
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));

    public DataLoaderRegistry create(String userId) {
        var register = new DataLoaderRegistry();
        register.register(BALANCE_DATA_LOADER, createBalanceDataLoader(userId));
        return register;
    }

    private DataLoader<UUID, BigDecimal> createBalanceDataLoader(String userId) {
        return DataLoader.newMappedDataLoader((Set<UUID> bankAccountIds, BatchLoaderEnvironment environment) -> {
            return CompletableFuture.supplyAsync(() -> {
                var context = environment.getContext();
                log.info("context: {}", context);

                var keyContexts = environment.getKeyContexts();
                log.info("keyContexts: {}", keyContexts);

                return balanceService.getBalanceFor(bankAccountIds, userId);
            }, balanceThreadPool);
        }, DataLoaderOptions.newOptions().setBatchLoaderContextProvider(() -> {
            return "this is the context";
        }));
    }

}
