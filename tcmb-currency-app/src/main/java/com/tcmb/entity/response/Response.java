package com.tcmb.entity.response;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
public class Response {

    private Object result;
    private String resultMessage;
    private String errorMessage;


}
