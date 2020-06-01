package com.pluralsight.speldemo.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("order")
public class Order {

    @Value("#{110.5 + 124.6 + 120.2}")
    private double amount;

    @Value("#{order.amount >= 1000 ? order.ammount * 5 / 100 : 0}")
    private double discount;

    @Value("#{user.country == 'US' and user.timeZone == 'Americal/NewYork' ? 3 : 14}")
    private int daysToDeliver;

    @Value("#{user.country}")
    private String origin;

    @Value("#{T(java.text.NumberFormat).getCurrencyInstance(T(java.util.Locale).getDefault()).format(order.amount)}")
    private String formattedAmount;

    @Value("#{shipping.locationsByCountry[user.country]}")
    private List<City> shippingLocations;

    @Value("#{order.shippingLocations.?[isCapital != true]}")
    private List<City> nonCapitalshippingLocations;

    @Value("#{(shipping.locationsByCountry.?[key == 'US' || key == 'UK'])}")
    private Map<String, List<City>> westernShippingLocation;

    @Value("#{(shipping.locationsByCountry.?[shipping < 10].size())}")
    private Integer cheapShippingLocations;


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getDaysToDeliver() {
        return daysToDeliver;
    }

    public void setDaysToDeliver(int daysToDeliver) {
        this.daysToDeliver = daysToDeliver;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getFormattedAmount() {
        return formattedAmount;
    }

    public void setFormattedAmount(String formattedAmount) {
        this.formattedAmount = formattedAmount;
    }

    public List<City> getShippingLocations() {
        return shippingLocations;
    }

    public void setShippingLocations(List<City> shippingLocations) {
        this.shippingLocations = shippingLocations;
    }

    public List<City> getNonCapitalshippingLocations() {
        return nonCapitalshippingLocations;
    }

    public void setNonCapitalshippingLocations(List<City> nonCapitalshippingLocations) {
        this.nonCapitalshippingLocations = nonCapitalshippingLocations;
    }

    public Map<String, List<City>> getWesternShippingLocation() {
        return westernShippingLocation;
    }

    public void setWesternShippingLocation(Map<String, List<City>> westernShippingLocation) {
        this.westernShippingLocation = westernShippingLocation;
    }

    public Integer getCheapShippingLocations() {
        return cheapShippingLocations;
    }

    public void setCheapShippingLocations(Integer cheapShippingLocations) {
        this.cheapShippingLocations = cheapShippingLocations;
    }
}
