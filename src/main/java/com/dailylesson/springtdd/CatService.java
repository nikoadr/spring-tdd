package com.dailylesson.springtdd;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CatService {

    private final CatRepository catRepository;

    CatService(CatRepository catRepository){
        this.catRepository = catRepository;

    }

    public Cat getCat(String name){
        Cat cat =  this.catRepository.findByName(name);
        System.out.println("should be cat name :"+cat.getName());
        System.out.println("should be cat age :"+cat.getAgeInMoths());
        return cat;
    }

}
