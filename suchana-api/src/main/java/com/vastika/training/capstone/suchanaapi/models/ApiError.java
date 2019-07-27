package com.vastika.training.capstone.suchanaapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiError {
    private String message;
    private int code;

}
