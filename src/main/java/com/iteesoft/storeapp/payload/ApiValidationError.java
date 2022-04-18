package com.iteesoft.storeapp.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class ApiValidationError extends ApiSubError {

    private Map<?,?> errors;
    private String object;
    private String message;

    ApiValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }

}
