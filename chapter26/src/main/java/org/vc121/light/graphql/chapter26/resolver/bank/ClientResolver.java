package org.vc121.light.graphql.chapter26.resolver.bank;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.vc121.light.graphql.chapter26.domain.bank.BankAccount;
import org.vc121.light.graphql.chapter26.domain.bank.Client;
import org.vc121.light.graphql.chapter26.util.CorrelationIdPropagationExecutor;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author lxc
 * @date 2023/04/08
 */
@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {

    private static final Executor executor = CorrelationIdPropagationExecutor.wrap(
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));

    public CompletableFuture<Client> client(BankAccount bankAccount) {
        log.info("Stop me debugging");

        return CompletableFuture.supplyAsync(() -> {
            log.info("Requesting client data for bank account id {}", bankAccount.getId());
            return Client.builder()
                    .id(UUID.randomUUID())
                    .firstName("Philip")
                    .lastName("Starritt")
                    .build();
        }, executor);
    }

}
