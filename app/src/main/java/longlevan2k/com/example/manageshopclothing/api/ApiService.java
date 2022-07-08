package longlevan2k.com.example.manageshopclothing.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import longlevan2k.com.example.manageshopclothing.model.entity.Product;
import longlevan2k.com.example.manageshopclothing.model.entity.Schedule;
import longlevan2k.com.example.manageshopclothing.model.object_request.LoginInformation;
import longlevan2k.com.example.manageshopclothing.model.object_request.NewCustomer;
import longlevan2k.com.example.manageshopclothing.model.object_request.NewItem;
import longlevan2k.com.example.manageshopclothing.model.object_request.NewProduct;
import longlevan2k.com.example.manageshopclothing.model.object_request.ProductAddToWareHouse;
import longlevan2k.com.example.manageshopclothing.model.object_request.ProductNameSearching;
import longlevan2k.com.example.manageshopclothing.model.object_request.ScheduleInformation;
import longlevan2k.com.example.manageshopclothing.model.object_request.SupplierAddingInformation;
import longlevan2k.com.example.manageshopclothing.model.object_request.UserAddingInformation;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

  String baseURL = "http://192.168.0.101:8080";

  //***********************************   Add User   ***********************************/
    Gson gsonAddUser = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    ApiService apiServiceAddUser = new Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gsonAddUser))
            .build()
            .create(ApiService.class);

    @POST("/add-user")
    Call<String> addUser(@Body UserAddingInformation userAddingInformation);

    //**********************************    Login    **********************************************/
    Gson gsonLogin = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    ApiService apiServiceLogin= new Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gsonLogin))
            .build()
            .create(ApiService.class);

    @POST("/login")
    Call<String> login(@Body LoginInformation loginInformation);

//    ****************************    Add Customer    **************************************//
  Gson gsonAddCustomer = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
  ApiService apiServiceAddCustomer = new Retrofit.Builder()
          .baseUrl(baseURL)
          .addConverterFactory(ScalarsConverterFactory.create())
          .addConverterFactory(GsonConverterFactory.create(gsonAddCustomer))
          .build()
          .create(ApiService.class);

  @POST("/customer/add-customer")
  Call<String> addCustomer(@Body NewCustomer newCustomer);

  //    ****************************    Add Supplier    **************************************//
  Gson gsonAddSupplier = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
  ApiService apiServiceAddSupplier = new Retrofit.Builder()
          .baseUrl(baseURL)
          .addConverterFactory(ScalarsConverterFactory.create())
          .addConverterFactory(GsonConverterFactory.create(gsonAddSupplier))
          .build()
          .create(ApiService.class);

  @POST("/supplier/add-supplier")
  Call<String> addSupplier(@Body SupplierAddingInformation supplierAddingInformation);

  //    ****************************    Add Product    **************************************//
  Gson gsonAddProduct= new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
  ApiService apiServiceAddProduct = new Retrofit.Builder()
          .baseUrl(baseURL)
          .addConverterFactory(ScalarsConverterFactory.create())
          .addConverterFactory(GsonConverterFactory.create(gsonAddProduct))
          .build()
          .create(ApiService.class);

  @POST("product/add-product")
  Call<String> addProduct(@Body NewProduct newProduct);


  // ************************ AddWarehouse ***********************************/
  Gson gsonAddWarehouse= new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
  ApiService apiServiceAddWarehouse = new Retrofit.Builder()
          .baseUrl(baseURL)
          .addConverterFactory(ScalarsConverterFactory.create())
          .addConverterFactory(GsonConverterFactory.create(gsonAddWarehouse))
          .build()
          .create(ApiService.class);

  @POST("/product/add-warehouse")
  Call<String> addWarehouse(@Body ProductAddToWareHouse productAddToWareHouse);

  //    ****************************    Add Item   **************************************//
  Gson gsonAddItem= new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
  ApiService apiServiceAddItem = new Retrofit.Builder()
          .baseUrl(baseURL)
          .addConverterFactory(ScalarsConverterFactory.create())
          .addConverterFactory(GsonConverterFactory.create(gsonAddItem))
          .build()
          .create(ApiService.class);

  @POST("/item/add-item")
  Call<String> addItem(@Body NewItem newItem);


  //    ****************************    Get schedule   **************************************//
    Gson gsonSchedule = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.0.101:8080")
            .addConverterFactory(GsonConverterFactory.create(gsonSchedule))
            .build()
            .create(ApiService.class);

    @GET("/schedule/get-schedule")
    Call<Schedule>  getSchedule();

  //    ****************************    Add shedule user   **************************************//
  Gson gsonAddScheduleUser= new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
  ApiService apiServiceAddScheduleUser = new Retrofit.Builder()
          .baseUrl(baseURL)
          .addConverterFactory(ScalarsConverterFactory.create())
          .addConverterFactory(GsonConverterFactory.create(gsonAddScheduleUser))
          .build()
          .create(ApiService.class);

  @POST("/add-schedule-user")
  Call<String> addScheduleUser(@Body ScheduleInformation scheduleInformation);


  // ******************************* ProductNameSearching ***********************************//
  Gson gsonProductNameSearching = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
  ApiService apiServiceProductNameSearching = new Retrofit.Builder()
          .baseUrl(baseURL)
          .addConverterFactory(GsonConverterFactory.create(gsonProductNameSearching))
          .build()
          .create(ApiService.class);

  @POST("/product/test-search-prefix")
  Call<List<Product>> productNameSearching(@Body ProductNameSearching productNameSearching);



}
