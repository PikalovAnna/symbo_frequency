package org.pikalovanna.symbol_frequency.controller;

import lombok.RequiredArgsConstructor;
import org.pikalovanna.symbol_frequency.dto.Request;
import org.pikalovanna.symbol_frequency.service.SFService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class SFController {

    private final SFService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    Object getHtmlForm(Model model) {
        model.addAttribute("request", new Request());
        return "form";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    Object getSF(@ModelAttribute @Valid @RequestBody Request request, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", result.getAllErrors());
            return "error";
        }
        model.addAttribute("request", request);
        model.addAttribute("result", service.getSF(request));
        return "result";
    }
}