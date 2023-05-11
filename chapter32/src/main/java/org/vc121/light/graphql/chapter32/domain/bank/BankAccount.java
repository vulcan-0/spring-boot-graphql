package org.vc121.light.graphql.chapter32.domain.bank;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
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
    Currency currency;
    List<Asset> assets;
    LocalDate createOn;
    ZonedDateTime createAt;
    BigDecimal balance;

}
