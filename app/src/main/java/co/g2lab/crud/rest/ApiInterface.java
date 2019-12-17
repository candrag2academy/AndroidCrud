package co.g2lab.crud.rest;

import java.util.List;

import co.g2lab.crud.model.BaseResponse;
import co.g2lab.crud.model.GetListNasabah;
import co.g2lab.crud.model.GetNasabah;
import co.g2lab.crud.model.Nasabah;
import co.g2lab.crud.model.PostPutDelNasabah;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;



public interface ApiInterface {
    @GET("/api/nasabah/list")
    Call<GetListNasabah>  getListNasabah();

    @GET("api/nasabah/{userId}")
    Call<GetNasabah> getNasabah(@Path("userId") String userId);

    @FormUrlEncoded
    @POST("api/nasabah")
    Call<PostPutDelNasabah> postNasabah(@Field("nama") String nama,
                                        @Field("alamat") String alamat,
                                        @Field("email") String email);
    @FormUrlEncoded
    @PUT("api/nasabah/{userId}")
    Call<PostPutDelNasabah> putNasabah(@Path("userId") String userId,
                                       @Field("nama") String nama,
                                       @Field("alamat") String alamat,
                                       @Field("email") String email);
    @FormUrlEncoded
    @DELETE("api/nasabah/{userId}")
    Call<PostPutDelNasabah> deleteNasabah(@Path("userId") String userId);
}
