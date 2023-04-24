package org.vc121.light.graphql.chapter27.listener;

import graphql.kickstart.servlet.core.GraphQLServletListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Clock;
import java.time.Instant;

/**
 * @author lxc
 * @date 2023/04/15
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class LoggingListener implements GraphQLServletListener {

    private final Clock clock;

    @Override
    public RequestCallback onRequest(HttpServletRequest request, HttpServletResponse response) {
        var startTime = Instant.now(clock);
        // log.info("Recived graphql request");
        return new RequestCallback() {

            @Override
            public void onSuccess(HttpServletRequest request, HttpServletResponse response) {
                // no-op
            }

            @Override
            public void onError(HttpServletRequest request, HttpServletResponse response, Throwable throwable) {
                // no-op
            }

            @Override
            public void onFinally(HttpServletRequest request, HttpServletResponse response) {
                // log.info("Completed Request. Time taken: {}", Duration.between(startTime, Instant.now(clock)));
            }

        };
    }

}
