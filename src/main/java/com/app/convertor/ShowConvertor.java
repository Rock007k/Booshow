package com.app.convertor;

import com.app.entity.Show;
import com.app.request.ShowRequest;

public class ShowConvertor {
    public static Show showDtroToShow(ShowRequest showRequest){
        Show show = Show.builder()
                .date(showRequest.getDate())
                .time(showRequest.getTime())
                .build();
        return show;
    }
}
