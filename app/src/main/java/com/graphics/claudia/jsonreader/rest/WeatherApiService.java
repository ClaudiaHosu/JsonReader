package com.graphics.claudia.jsonreader.rest;

import com.graphics.claudia.jsonreader.model.WeatherStatus;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiService {


    String WEATHER_ENDPOINT = "weather";

    //fields
    String QUERY_PARAM_API_KEY = "appid";
    String QUERY_PARAM = "q";

    @GET(WEATHER_ENDPOINT)
    Call<WeatherStatus> getCurrentWeather(@Query(QUERY_PARAM_API_KEY) String apiKey, @Query(QUERY_PARAM) String location);

}
