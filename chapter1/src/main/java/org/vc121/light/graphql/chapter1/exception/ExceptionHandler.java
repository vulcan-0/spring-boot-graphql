package org.vc121.light.graphql.chapter1.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;

import javax.validation.ConstraintViolationException;

/**
 * @author lxc
 * @date 2023/04/04
 */
@Slf4j
public class ExceptionHandler extends DataFetcherExceptionResolverAdapter {

    @Override
    public GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        log.error("Caught exception", ex);
        if (ex instanceof ConstraintViolationException constraintViolationException) {
            return GraphqlErrorBuilder.newError(env)
                    .errorType(ErrorType.BAD_REQUEST)
                    .message(constraintViolationException.getMessage())
                    .build();
        }
        return super.resolveToSingleError(ex, env);
    }

}
