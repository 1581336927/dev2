package com.hcy.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {


    @Override
    public Date convert(String source) {
String pattern="yyyy/MM/dd";
if (source.contains("-")){
    pattern="yyyy-mm-dd";
}
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();

        }
        System.out.println(parse);
        return parse;
    }
}
