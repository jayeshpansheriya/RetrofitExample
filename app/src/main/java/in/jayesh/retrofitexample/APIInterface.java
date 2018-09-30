package in.jayesh.retrofitexample;

import in.jayesh.retrofitexample.POJO.MultipleResource;
import in.jayesh.retrofitexample.POJO.MyResponse;
import in.jayesh.retrofitexample.POJO.User;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface APIInterface {



    @GET("/api/unknown")
    Call<MultipleResource> doGetListResources();

    @POST("/api/users")
    Call<User> createUser(@Body User user);

    @Multipart
    @POST("metrimonial_register.php")
    Call<MyResponse> uploadImage(@Part("biodata_file") RequestBody file, @Part("child_id") RequestBody child_id, @Part("reletionship_id") RequestBody reletionship_id );


}
