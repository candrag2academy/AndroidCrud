package co.g2lab.crud.rest;

import java.util.List;

import co.g2lab.crud.model.BaseResponse;
import co.g2lab.crud.model.GetListNasabah;
import co.g2lab.crud.model.GetNasabah;
import co.g2lab.crud.model.Nasabah;
import co.g2lab.crud.model.PostPutDelNasabah;
import retrofit2.Call;
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

    @FormUrlEncoded
    @GET("api/nasabah/{userId}")
    Call<GetNasabah> getNasabah(@Path("userId") String userId);

    @FormUrlEncoded
    @POST("kontak")
    Call<PostPutDelNasabah> postNasabah(@Field("nama") String nama,
                                        @Field("alamat") String alamat,
                                        @Field("email") String email);
    @FormUrlEncoded
    @PUT("kontak")
    Call<PostPutDelNasabah> putNasabah(@Field("id") String id,
                                       @Field("nama") String nama,
                                       @Field("alamat") String alamat,
                                       @Field("email") String email);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "nasabah", hasBody = true)
    Call<PostPutDelNasabah> deleteNasabah(@Field("id") String id);
}
