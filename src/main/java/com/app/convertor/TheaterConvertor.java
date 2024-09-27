package com.app.convertor;

import com.app.entity.Theater;
import com.app.request.TheaterRequest;

public class TheaterConvertor {
    public static Theater theaterDtoToTheater(TheaterRequest theaterRequest){
        Theater theater = Theater.builder()
                .name(theaterRequest.getName())
                .address(theaterRequest.getAddress())
                .build();
        return theater;
    }
}
