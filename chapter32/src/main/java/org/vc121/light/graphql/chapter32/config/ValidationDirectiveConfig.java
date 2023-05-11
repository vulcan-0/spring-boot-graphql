package org.vc121.light.graphql.chapter32.config;

import graphql.validation.rules.OnValidationErrorStrategy;
import graphql.validation.rules.ValidationRules;
import graphql.validation.schemawiring.ValidationSchemaWiring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lxc
 * @date 2023/05/11
 */
@Configuration
public class ValidationDirectiveConfig {

    @Bean
    public ValidationSchemaWiring validationSchemaWiring() {
        // This contains by default the standard library provided @Directive constraints
        var validationRules = ValidationRules.newValidationRules()
                .onValidationErrorStrategy(OnValidationErrorStrategy.RETURN_NULL)
                .build();

        // This will rewrite your data fetchers when rules apply to them so that validation
        return new ValidationSchemaWiring(validationRules);
    }

}
