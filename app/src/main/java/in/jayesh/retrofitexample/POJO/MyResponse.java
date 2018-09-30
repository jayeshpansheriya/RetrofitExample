package in.jayesh.retrofitexample.POJO;

import com.google.gson.annotations.SerializedName;

public class MyResponse {

    @SerializedName("status")
   public Integer status;

    @SerializedName("message")
   public String message;

   // child_id  reletionship_id  biodata_file
}
