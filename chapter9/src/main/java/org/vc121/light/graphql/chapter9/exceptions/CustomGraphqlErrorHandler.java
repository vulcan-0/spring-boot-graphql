package org.vc121.light.graphql.chapter9.exceptions;

import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lxc
 * @date 2023/04/08
 */
@Component
public class CustomGraphqlErrorHandler implements GraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {

        return errors;
    }

}
