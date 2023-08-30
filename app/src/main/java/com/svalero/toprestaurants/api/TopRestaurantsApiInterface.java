package com.svalero.toprestaurants.api;

import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.domain.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TopRestaurantsApiInterface {

    //Customers
    @GET("customers")
    Call<List<Customer>> getCustomers();

    @GET("customers/{customerId}")
    Call<Customer> getCustomer(@Path("customerId") long customerId);

    @POST("customers")
    Call<Customer> addCustomer(@Body Customer customer);

    @DELETE("customers/{customerId}")
    Call<Void> deleteCustomer(@Path("customerId") long customerId);

    @PUT("/customers/{customerId}")
    Call<Customer> modifyCustomer(@Path("customerId") long id, @Body Customer customer);

    //Restaurants
    @GET("restaurants")
    Call<List<Restaurant>> getRestaurants();

    @GET("restaurants/{restaurantId}")
    Call<Restaurant> getRestaurant(@Path("restaurantId") long restaurantId);

    @POST("restaurants")
    Call<Restaurant> addRestaurant(@Body Restaurant restaurant);

    @DELETE("restaurants/{restaurantId}")
    Call<Void> deleteRestaurant(@Path("restaurantId") long restaurantId);

    @PUT("/restaurants/{restaurantId}")
    Call<Restaurant> modifyRestaurant(@Path("restaurantId") long id, @Body Restaurant restaurant);
}
