package org.vc121.light.graphql.chapter1.fitness.domain;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author lxc
 * @date 2023/04/04
 */
@Builder
public record FitnessClass(
        UUID id,
        Coach coach,
        LocalDateTime startsAt,
        LocalDateTime endsAt,
        Difficulty difficulty
) {
}
