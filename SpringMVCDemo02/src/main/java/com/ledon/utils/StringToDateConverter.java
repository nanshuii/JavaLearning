package com.ledon.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        if (s == null) {
            throw new RuntimeException("参数null");
        }
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dataFormat.parse(s);
        } catch (ParseException e) {
//            e.printStackTrace();
            throw new RuntimeException("出现参数错误");
        }
    }
}
