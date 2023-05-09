package org.vc121.light.graphql.chapter31.exceptions;

import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

/**
 * @author lxc
 * @date 2023/04/08
 */
@Component
public class GraphqlExceptionHandler {

    @ExceptionHandler({GraphQLException.class, ConstraintViolationException.class})
    public ThrowableGraphQLError handle(Exception e) {
        return new ThrowableGraphQLError(e);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ThrowableGraphQLError handle(AccessDeniedException e) {
        return new ThrowableGraphQLError(e, HttpStatus.FORBIDDEN.getReasonPhrase());
    }

    @ExceptionHandler(RuntimeException.class)
    public ThrowableGraphQLError handle(RuntimeException e) {
        return new ThrowableGraphQLError(e, "Internal Server Error");
    }

}
