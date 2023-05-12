package org.vc121.light.graphql.chapter33.util;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.slf4j.MDC;
import org.vc121.light.graphql.chapter33.instrumentation.RequestLoggingInstrumentation;

import java.util.concurrent.Executor;

/**
 * @author lxc
 * @date 2023/04/22
 */
@RequiredArgsConstructor
public class CorrelationIdPropagationExecutor implements Executor {

    private final Executor delegate;

    public static Executor wrap(Executor executor) {
        return new CorrelationIdPropagationExecutor(executor);
    }

    @Override
    public void execute(@NotNull Runnable command) {
        var correlationId = MDC.get(RequestLoggingInstrumentation.CORRELATION_ID);
        delegate.execute(() -> {
            try {
                MDC.put(RequestLoggingInstrumentation.CORRELATION_ID, correlationId);
                command.run();
            } finally {
                MDC.remove(RequestLoggingInstrumentation.CORRELATION_ID);
            }
        });
    }

}
