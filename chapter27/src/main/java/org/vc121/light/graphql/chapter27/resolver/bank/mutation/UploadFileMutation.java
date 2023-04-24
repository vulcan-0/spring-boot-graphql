package org.vc121.light.graphql.chapter27.resolver.bank.mutation;

import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author lxc
 * @date 2023/04/11
 */
@Slf4j
@Component
public class UploadFileMutation implements GraphQLMutationResolver {

    public UUID uploadFile(DataFetchingEnvironment environment) {
        log.info("Uploading file");

        DefaultGraphQLServletContext context = environment.getContext();
        context.getFileParts().forEach(part -> {
            log.info("uploading {}, size: {}", part.getSubmittedFileName(), part.getSize());
        });

        return UUID.randomUUID();
    }

}
