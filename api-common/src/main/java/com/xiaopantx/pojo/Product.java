package com.xiaopantx.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Product implements Serializable {

    private Integer id;
    private String productName;
    private Integer productNum;
    private Double productPrice;

}
