package com.example.library.exception.handling;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IncorrectDataException {
    private String info;
}
