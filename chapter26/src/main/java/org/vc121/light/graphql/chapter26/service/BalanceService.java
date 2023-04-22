package org.vc121.light.graphql.chapter26.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @author lxc
 * @date 2023/04/21
 */
@Slf4j
@Service
public class BalanceService {

    public Map<UUID, BigDecimal> getBalanceFor(Set<UUID> bankAccountIds, String userId) {
        log.info("Requesting bank account ids: {} for user Id: {}", bankAccountIds, userId);
        return Map.of(
                UUID.fromString("5b6d95d9-9404-4c1a-964f-a7b711ae6660"), BigDecimal.ONE,
                UUID.fromString("5b6d95d9-9404-4c1a-964f-a7b711ae6661"), new BigDecimal("23431.22")
        );
    }

}
