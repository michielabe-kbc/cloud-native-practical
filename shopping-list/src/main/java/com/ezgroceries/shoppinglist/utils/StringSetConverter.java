package com.ezgroceries.shoppinglist.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.springframework.util.CollectionUtils;

@Converter
public class StringSetConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> set) {
        if(!CollectionUtils.isEmpty(set)) {
            return "," + String.join(",", set) + ",";
        } else {
            return null;
        }
    }

    @Override
    public List<String> convertToEntityAttribute(String joined) {
        if(joined != null) {
            String values = joined.substring(1, joined.length() - 1); //Removes leading and trailing commas
            return new ArrayList<>(Arrays.asList(values.split(",")));
        }
        return new ArrayList<>();
    }
}
