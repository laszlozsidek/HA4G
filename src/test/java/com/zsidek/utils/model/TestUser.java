package com.zsidek.utils.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TestUser {

    private String firstName;
    private String lastName;
    private String postalCode;
    private String email;

}
