package org.pikalovanna.symbol_frequency.controller;

import lombok.RequiredArgsConstructor;
import org.pikalovanna.symbol_frequency.dto.Request;
import org.pikalovanna.symbol_frequency.service.SFService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sf")
@RequiredArgsConstructor
public class SFController {

    private final SFService service;

    @PostMapping
    Object getSF(@RequestBody Request request) {
        return service.getSF(request);
    }
}
