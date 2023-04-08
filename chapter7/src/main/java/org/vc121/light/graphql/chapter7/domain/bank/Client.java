package org.vc121.light.graphql.chapter7.domain.bank;

import lombok.Builder;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/**
 * @author lxc
 * @date 2023/04/06
 */
@Setter
@Builder
public class Client {

    UUID id;
    String firstName;
    List<String> middleNames;
    String lastName;
    Client client;

}
