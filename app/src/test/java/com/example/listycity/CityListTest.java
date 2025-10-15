package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();

        // Test case 1: City exists in the list
        City existingCity = cityList.getCities().get(0); // Get first city from mock list
        assertTrue(cityList.hasCity(existingCity), "Should return true when city exists");

        // Test case 2: City does not exist in the list
        City nonExistingCity = new City("NonExistent", "Country");
        assertFalse(cityList.hasCity(nonExistingCity), "Should return false when city does not exist");
    }

    @Test
    void testDeleteCity() {
        CityList cityList = mockCityList();

        // Test case 1: Successfully delete a city that exists
        City existingCity = cityList.getCities().get(0); // Get a city from the mock list
        int initialSize = cityList.getCities().size();

        cityList.deleteCity(existingCity);

        // Verify the city was removed
        assertFalse(cityList.hasCity(existingCity), "City should no longer be in the list");
        assertEquals(initialSize - 1, cityList.getCities().size(), "List size should decrease by 1");

        // Test case 2: Try to delete a city that doesn't exist - should throw exception
        City nonExistingCity = new City("NonExistent", "Country");

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(nonExistingCity);
        }, "Should throw IllegalArgumentException when city doesn't exist");
    }

    @Test
    void testCountCity() {
        CityList cityList = mockCityList();

        // Test to see if the function returns the correct amount
        assertEquals(cityList.getCities().size(), cityList.countCities(), "List size should be equal");
    }
}
