package com.h9w.shop.purchase.model.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class PageInfoDTO {

    private Integer page;
    private Integer totalItemCount;
    private Integer pageItemCount;
    private Integer categoryNo;
    private Integer statusNo;
    private String searchValue;
    private Integer userNo;

    public PageInfoDTO setValueToObject() {
        if(this.categoryNo != null && this.categoryNo == 0) {
            this.categoryNo = null;
        }
        if(this.statusNo != null && this.statusNo == 0) {
            this.statusNo = null;
        }
        if(this.searchValue != null && this.searchValue.equals("")) {
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
