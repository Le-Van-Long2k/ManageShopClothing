package longlevan2k.com.example.manageshopclothing.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import longlevan2k.com.example.manageshopclothing.model.ResponseEntity;
import longlevan2k.com.example.manageshopclothing.model.Schedule;
import longlevan2k.com.example.manageshopclothing.model.User;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    // link api http://192.168.0.101:8080/schedule/get-schedule
    // ipv4     192.168.0.101
    Gson gsonSchedule = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.0.101:8080")
            .addConverterFactory(GsonConverterFactory.create(gsonSchedule))
            .build()
            .create(ApiService.class);

    @GET("/schedule/get-schedule")
    Call<Schedule>  scheduleTest();

    // link api http://192.168.0.101:8080/user/get-user
//
//    Gson gsonUser = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//    ApiService apiServiceUser = new Retrofit.Builder()
//            .baseUrl("http://192.168.0.101:8080/")
//            .addConverterFactory(GsonConverterFactory.create(gsonUser))
//            .build()
//            .create(ApiService.class);
//
//    @GET("user/get-user")
//    Call<List<User>> getListUser();
//
    //************************* add user ********************************************//
    Gson gsonAddUser = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    ApiService apiServiceAddUser = new Retrofit.Builder()
            .baseUrl("http://192.168.0.101:8080")
            .addConverterFactory(GsonConverterFactory.create(gsonAddUser))
            .build()
            .create(ApiService.class);

    @POST("/add-user")
    Call<User> addUser(@Body User user);

    //*****************************************************************************//


}
