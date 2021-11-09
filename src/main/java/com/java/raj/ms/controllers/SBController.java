package com.java.raj.ms.controllers;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.java.raj.ms.model.DynamicFilterModel;
import com.java.raj.ms.model.StaticModel;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.util.Optional;


@RestController
public class SBController {
    @GetMapping("/static")
    public StaticModel staticModel() {
        StaticModel model = new StaticModel("Raj", "IT", 20000, "S");
        return model;
    }

    @GetMapping("/dynamic")
    public MappingJacksonValue dynamicModel(@RequestParam(name="fields") Optional<String> filter, @RequestParam(value = "test", defaultValue = "" ) String queryParam) {
        String[] properties = filter.orElseGet(() -> "").split(",");
        if (properties.length == 1 && properties[0] == "") {
            properties = new String[] { "firstName", "lastName", "salary", "department" };
        }
        DynamicFilterModel model = new DynamicFilterModel("Raj", "S", "IT", 20000);
        SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept(properties);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("DynamicFilter", propertyFilter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(model);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }
}
