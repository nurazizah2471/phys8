package com.example.phys8.Retrofit;

import com.example.phys8.Helpers.Const;
import com.example.phys8.Models.Categories;
import com.example.phys8.Models.Register;
import com.example.phys8.Models.TokenResponse;
import com.example.phys8.Models.User;
import com.google.gson.JsonObject;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private final ApiEndPoint api;
    private static ApiService service;
    private static final String TAG = "ApiService";

    public ApiService(String token){
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        //mau ngasih tau isi headernya apa
        //jika tidak butuh bearer (header authorization di postman). Tidak butuh token untuk akses data
        if(token.equals("")){
            //mulai bikin header
            client.addInterceptor(chain -> {
                Request request = chain.request().newBuilder()
                        .addHeader("Accept", "application/json")
                        .build();
                return  chain.proceed(request);
            });
        }else{ //jika butuh bearer (header authorization di postman). Butuh token untuk akses data
            client.addInterceptor(chain -> {
                Request request = chain.request().newBuilder().addHeader("Accept", "application/json")
                        .addHeader("Authorization", token) //token akan otomatis dibuatkan
                        .build();
                return chain.proceed(request);
            });
        }

        api = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build().create(ApiEndPoint.class);
    }

    //agar token yang didapatkan setelah atau sebelum login, dapat diakses di semua kelas
    public static ApiService getInstance(String token){
        if(service == null){
            service = new ApiService(token);
        }else if(!token.equals("")){
            service = new ApiService(token);
        }
        return service;
    }

    //mengakses apiendpoint dengan memasukkan nilai untuk header yang telah diset pada code di atas
    public Call<TokenResponse> login(String email, String password){
        return api.login(email, password);
    }

    public Call<Register> register(String name, String email, String password, String password_confirmation){
        return api.register(name, email, password, password_confirmation);
    }

    public Call<JsonObject> logout(){
        return api.logout();
    }

    public Call<Categories> getCategories(){
        return api.getCategory();
    }
    public Call<User> getUsers(){ return api.getUsers(); }
}
