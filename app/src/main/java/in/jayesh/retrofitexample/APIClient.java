package in.jayesh.retrofitexample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static final String URL="https://reqres.in";
    static Retrofit retrofit=null;

    public static Retrofit getClient()
    {

        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(URL)
                                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }


    public static Retrofit getClientforString()
    {
        if (retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(URL).build();
        }
        return retrofit;
    }
}
