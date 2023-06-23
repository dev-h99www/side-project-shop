package com.shop.admin.members.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ResponseDTO<D> {
    private boolean result;
    private String message;
    private D data;

    public static <D> ResponseDTO<D> setSuccess(String message, D data) {

        return new ResponseDTO<D>(true, message, data);
    }

    public static <D> ResponseDTO<D> setFailed(String message) {

        return new ResponseDTO<D>(false, message, null);
    }
}
