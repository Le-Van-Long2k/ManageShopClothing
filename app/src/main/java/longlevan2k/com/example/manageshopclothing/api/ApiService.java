package longlevan2k.com.example.manageshopclothing.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import longlevan2k.com.example.manageshopclothing.model.Schedule;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    // link api http://192.168.0.101:8080/schedule/get-schedule
    // ipv4     192.168.0.101
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.0.101:8080/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("schedule/get-schedule")
    Call<Schedule>  scheduleTest();
}
