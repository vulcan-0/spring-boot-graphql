package org.vc121.light.graphql.chapter4.bank;

import lombok.Builder;
import lombok.Value;

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
    Currency currency;

}
