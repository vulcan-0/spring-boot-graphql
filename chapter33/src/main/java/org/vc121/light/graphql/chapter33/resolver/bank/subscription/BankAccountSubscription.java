package org.vc121.light.graphql.chapter33.resolver.bank.subscription;

import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import org.vc121.light.graphql.chapter33.domain.bank.BankAccount;
import org.vc121.light.graphql.chapter33.publisher.BankAccountPublisher;

import java.util.UUID;

/**
 * @author lxc
 * @date 2023/05/12
 */
@Component
@RequiredArgsConstructor
public class BankAccountSubscription implements GraphQLSubscriptionResolver {

    private final BankAccountPublisher publisher;

    public Publisher<BankAccount> bankAccounts(DataFetchingEnvironment environment) {
        return publisher.getBankAccountPublisher();
    }

    public Publisher<BankAccount> bankAccount(UUID id) {
        return publisher.getBankAccountPublisherFor(id);
    }

}
