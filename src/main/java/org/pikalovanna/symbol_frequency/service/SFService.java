package org.pikalovanna.symbol_frequency.service;

import org.pikalovanna.symbol_frequency.dto.Request;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SFService {

    public Object getSF(Request request) {
        Map<String, Integer> result = new HashMap<>();
        for (String symbol : request.getText().split("")) {
            if (result.containsKey(symbol)) {
                result.put(symbol, result.get(symbol) + 1);
            } else {
                result.put(symbol, 1);
            }
        }
        return result.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
    }
}
