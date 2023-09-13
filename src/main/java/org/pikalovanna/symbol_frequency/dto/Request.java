package org.pikalovanna.symbol_frequency.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class Request {
    @NotBlank
    @Pattern(regexp = "^[a-z]{1,2147483647}+$")
    public String text;
}
