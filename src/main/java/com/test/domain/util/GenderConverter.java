package com.test.domain.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<GENDER, String> {

    @Override
    public String convertToDatabaseColumn(GENDER gender) {
        return gender.toString();
    }

    @Override
    public GENDER convertToEntityAttribute(String s) {
        return GENDER.fromString(s);
    }

}
