package com.dailylesson.springtdd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatRestController {
    private final CatService service;

    public CatRestController(CatService catService) {
        this.service = catService;
    }


    @GetMapping("/cats/{name}")
    Cat byName(@PathVariable String name){
        return this.service.getCat(name);
    }
}
