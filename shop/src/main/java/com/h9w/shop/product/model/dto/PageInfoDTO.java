package com.h9w.shop.product.model.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class PageInfoDTO {

    private int page;
    private int totalItemCount;
    private int pageItemCount;
    private Integer categoryNo;
    private Integer statusNo;
    private String searchValue;

    public PageInfoDTO setValueToObject() {
        if(this.categoryNo == 0) {
            this.categoryNo = null;
        }
        if(this.statusNo == 0) {
            this.statusNo = null;
        }
        if(this.searchValue.equals("")) {
            this.searchValue = null;
        }

        return this;
    }

    public PageInfoDTO setObjectToValue() {
        if(this.categoryNo == null) {
            this.categoryNo = 0;
        }
        if(this.statusNo == null) {
            this.statusNo = 0;
        }
        if(this.searchValue == null) {
            this.searchValue = "";
        }

        return this;
    }
}
