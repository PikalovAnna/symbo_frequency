package org.pikalovanna.symbol_frequency.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class Request {
    @NotBlank(message = "Поле не может быть пустым")
    @NotNull(message = "Поле не может быть пустым")
    @Pattern(regexp = "^[a-z]{1,2147483647}+$", message = "Поле содержит недопустимые символы")
    public String text;
}
