package org.vc121.light.graphql.chapter24.domain.bank.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author lxc
 * @date 2023/04/10
 */
@Data
public class CreateBankAccountInput {

    @NotBlank
    String firstName;
    int age;

}
