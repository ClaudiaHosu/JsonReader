package com.graphics.claudia.jsonreader.activity;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Callback;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.graphics.claudia.jsonreader.BuildConfig;
import com.graphics.claudia.jsonreader.R;
import com.graphics.claudia.jsonreader.model.WeatherStatus;
import com.graphics.claudia.jsonreader.rest.WeatherApiService;


public class MainActivity extends AppCompatActivity {

    public static final String WEATHER_API_BASE_URL = "https://api.openweathermap.org/data/2.5/";

    private static Retrofit retrofit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectApi();
    }

    public void displayWeather(View view) {
        EditText editText = findViewById(R.id.cityText);
        String city = editText.getText().toString();
        getWeather(city);

        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    // This method create an instance of Retrofit
    // set the base url
    public void connectApi() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(WEATHER_API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }

    public void getWeather(String cityName) {
        WeatherApiService weatherApiService = retrofit.create(WeatherApiService.class);
        Call<WeatherStatus> call = weatherApiService.getCurrentWeather(BuildConfig.WEATHER_API_KEY, cityName);
        call.enqueue(new Callback<WeatherStatus>() {
            @Override
            public void onResponse(Call<WeatherStatus> call, Response<WeatherStatus> response) {
                Log.i("weather", "Success!");
                TextView weatherTextView = findViewById(R.id.weatherTextView);
                WeatherStatus weatherStatus = response.body();
                weatherTextView.setText(weatherStatus == null ? "No data" :response.body().toString());
            }

            @Override
            public void onFailure(Call<WeatherStatus> call, Throwable t) {
                Log.e("weather", "Error getting the list" + t.getMessage());
            }
        });
    }

}