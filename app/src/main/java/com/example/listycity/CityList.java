package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city*/
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }
    /**
     * This return True or False based on if array cities has the given city
     * @param city
     * @return
     * Return either True or False*/
    public boolean hasCity(City city) {
        if (cities.contains(city)) {
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }

    /**
     * This function checks if the city exists in cities, and deletes if it exists, else it
     * throws an exception
     * @param city
     * */
    public void deleteCity(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        }
        else {
            throw new IllegalArgumentException();
        }
    }
    /**
     * This function returns an integer that gets the number of cities in cities
     * @return
     * integer*/
    public int countCities() {
        return cities.toArray().length;
    }



}

