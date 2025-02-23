package com.zsidek.utils;

import com.zsidek.utils.model.TestUser;

import java.util.List;

public class TestDataProvider {

    public static TestUser provideValidUserDataC1() {
        return TestUser.builder().firstName("John").lastName("Doe").postalCode("12345").build();
    }

    public static List<String> provideCartItemsC1() {
        return List.of("Sauce Labs Backpack", "Sauce Labs Fleece Jacket");
    }

    public static List<String> provideTextC3() {
        return List.of("Automation ", "Test", " Example");
    }

    public static TestUser provideValidUserDataC4() {
        return TestUser.builder().email("john@doe.com").build();
    }

}
