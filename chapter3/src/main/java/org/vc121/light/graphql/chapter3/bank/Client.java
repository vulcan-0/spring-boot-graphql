package org.vc121.light.graphql.chapter3.bank;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

/**
 * @author lxc
 * @date 2023/04/06
 */
@Builder
@Value
public class Client {

    UUID id;
    String firstName;
    List<String> middleNames;
    String lastName;

}
