package com.example.lab8;

public class City implements Comparable<City> {

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }


    /**
     * Compares two cities by their city names
     * @param city
     * The city being compared to
     * @return
     * The result of the comparison
     */
    @Override
    public int compareTo(City city) {
        return this.city.compareTo(city.getCityName());
    }
    /**
     * Returns a hash value for the city based on its city and
     * province names
     * @return
     * The hashcode
     */
    @Override
    public int hashCode() {
        return this.city.hashCode() * this.province.hashCode();
    }
    /**
     * Returns true if the two objects are the same
     * @param o
     * The object being equated to
     * @return
     * The resulting boolean
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof City))
            return false;
        City c = (City) o;
        return equals(c);
    }
    /**
     * Returns true if two city objects are the same
     * @param c
     * The city being equated to
     * @return
     * Whether two city objects are equal
     */
    public boolean equals(City c) {
        if (c == null)
            return false;

        String cityName = c.getCityName();
        String provinceName = c.getProvinceName();

        if ((this.city == null) || (cityName == null))
            return false;

        if ((this.province == null) || (provinceName == null))
            return false;

        if (!this.city.equals(cityName))
            return false;

        if (!this.province.equals(provinceName))
            return false;

        return true;
    }
}
