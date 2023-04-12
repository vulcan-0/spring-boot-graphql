package org.vc121.light.graphql.chapter15.domain.bank;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

/**
 * @author lxc
 * @date 2023/04/05
 */
@Builder
@Value
public class BankAccount {

    UUID id;
    Client client;
    List<Asset> assets;
    Currency currency;

}
