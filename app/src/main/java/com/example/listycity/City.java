package com.example.listycity;


/**
 * This is a City class which has a city and province variable
 * This is a class that defines a city
 * */
public class City implements Comparable {
    private String city;
    private String province;

    /**
     * This is the constructor of the city class
     * @param city
     * @param province
     * */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * This is getter get the city name and return it has a string
     * @return city
     * */
    public String getCityName() {
        return this.city;
    }

    /**
     * This is a getter get the city name, and returns it as a string
     * @return province
     * */
    public String getProvinceName() {
        return this.province;
    }


    /**
     * This method compares cities based on city name field
     * @return -1 if the caller is greater than the called city name field*/
    @Override
    public int compareTo(Object o) {
        City city = (City)o;
        return this.city.compareTo(city.getCityName());
    }
}
