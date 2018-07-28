package com.common.user.config;

import lombok.Data;

import java.util.Date;

/**
 * Author：xiongzhan
 * Description：authToken
 * Date: 2018-07-28 15:26
 */
@Data
public class AuthTokenDetailsDTO {

    private String userId;

    private String name;

    private String lenderId;

    private String productCode;

    private Date expirationDate;

}
