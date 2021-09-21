package com.dailylesson.springtdd;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

/**
@author Niko Andrian
**/
public class CatTests {

    @Test
    void createCatWithValidNameShouldSucceed() {
        assertThatNoException().isThrownBy(() -> new Cat("Ginger"));
    }

    @Test
    void createCatWithLowerCaseNameShouldThrowException(){
        assertThatIllegalArgumentException().isThrownBy(()-> new Cat("tom"));
    }

    @Test
    void getNameShouldReturnName() {
        Cat cat  =  new Cat("Ginger");
        assertThat(cat.getName()).isEqualTo("Ginger");
    }

    @Test
    void getAgeInMonths() {
        Cat cat = new Cat("Kitty", LocalDate.now().minusMonths(9));
        assertThat(cat.getAgeInMoths()).isEqualTo(9);
    }
}
