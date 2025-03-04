package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * create a populated mocklist for my citylist
     * @return
     */
    public CustomList MockCityListPopulated(){
        list = new CustomList(null , new ArrayList<>(
                Arrays.asList(new City ("Edmonton", "Alberta"))));
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void hasCityTest() {
        list = MockCityListPopulated();
        City diffCity = new City("Regina", "Saskatchewan");
        City sameCity = new City("Edmonton", "Alberta");
        assertFalse(list.hasCity(diffCity));
        assertTrue(list.hasCity(sameCity));
    }

    @Test
    void deleteCityTest() {
        list = MockCityListPopulated();
        assertEquals(1, list.getCount());
        City diffCity = new City("Regina", "Saskatchewan");
        City sameCity = new City("Edmonton", "Alberta");
        list.deleteCity(diffCity);
        assertEquals(1, list.getCount());
        list.deleteCity(sameCity);
        assertEquals(0, list.getCount());
    }

    @Test
    void countCitiesTest() {
        list = MockCityList();
        int listSize = list.countCities();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.countCities(), listSize + 1);
        list.deleteCity(new City("Estevan", "SK"));
        assertEquals(list.countCities(), listSize);
    }

}
