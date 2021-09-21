package com.dailylesson.springtdd;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat,Long> {
    Cat findByName(String name);

}
