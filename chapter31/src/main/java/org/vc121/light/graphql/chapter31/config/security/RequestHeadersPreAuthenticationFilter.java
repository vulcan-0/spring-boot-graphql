package org.vc121.light.graphql.chapter31.config.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lxc
 * @date 2023/05/08
 */
public class RequestHeadersPreAuthenticationFilter extends AbstractPreAuthenticatedProcessingFilter {

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return request.getHeader("user_id");
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return StringUtils.EMPTY;
    }

}
