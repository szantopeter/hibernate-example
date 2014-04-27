package com.test.domain.util;

public enum GENDER {

    MALE("M"), FEMALE("F");

    private final String value;

    private GENDER(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value;
    }

    public static GENDER fromString(String value) {

        for (GENDER gender : GENDER.values()) {
            if (value.equals(gender.toString())) {
                return gender;
            }
        }

        return null;

    }


}
