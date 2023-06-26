package com.h9w.shop.config;

import org.modelmapper.ModelMapper;

public class CustomModelMapper extends ModelMapper {

    @Override
    public <T> T map(Object source, Class<T> destinationType) {
        Object targetSource = source;

        if(source == null) { targetSource = new Object(); }


        return super.map(targetSource, destinationType);
    }
}
