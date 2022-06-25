package longlevan2k.com.example.manageshopclothing.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import longlevan2k.com.example.manageshopclothing.model.LoginInformation;
import longlevan2k.com.example.manageshopclothing.model.UserAddingInformation;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    // link api http://192.168.0.101:8080/schedule/get-schedule
    // ipv4     192.168.0.101
//    Gson gsonSchedule = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//    ApiService apiService = new Retrofit.Builder()
//            .baseUrl("http://192.168.0.101:8080")
//            .addConverterFactory(GsonConverterFactory.create(gsonSchedule))
//            .build()
//            .create(ApiService.class);
//
//    @GET("/schedule/get-schedule")
//    Call<Schedule>  scheduleTest();

  //***********************************************************************************/
    Gson gsonAddUser = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    ApiService apiServiceAddUser = new Retrofit.Builder()
            .baseUrl("http://192.168.0.101:8080")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gsonAddUser))
            .build()
            .create(ApiService.class);

    @POST("/add-user")
    Call<String> addUser(@Body UserAddingInformation userAddingInformation);

    //***********************************************************************************/
    Gson gsonLogin = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    ApiService apiServiceLogin= new Retrofit.Builder()
            .baseUrl("http://192.168.0.101:8080")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gsonLogin))
            .build()
            .create(ApiService.class);

    @POST("/login")
    Call<String> login(@Body LoginInformation loginInformation);


}
