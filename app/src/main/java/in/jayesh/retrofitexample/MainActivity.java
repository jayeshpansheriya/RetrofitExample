package in.jayesh.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import java.util.List;

import in.jayesh.retrofitexample.POJO.MultipleResource;
import in.jayesh.retrofitexample.POJO.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface=APIClient.getClient().create(APIInterface.class);


        // Get method
        retrofit2.Call<MultipleResource> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<MultipleResource>() {
            @Override
            public void onResponse(Call<MultipleResource> call, Response<MultipleResource> response) {

                MultipleResource resource=response.body();
                Log.d("response", String.valueOf(response));
                Log.d("page", String.valueOf(resource.page));
                List<MultipleResource.Datum> datumList = resource.data;
                Log.d("data", String.valueOf(datumList.get(2).name));

            }

            @Override
            public void onFailure(Call<MultipleResource> call, Throwable t) {

            }
        });


        //Post Method
        User user=new User("Jayesh","Android Developer");
        Call<User> userCall=apiInterface.createUser(user);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user1=response.body();
                Toast.makeText(getApplicationContext(), user1.name + " " + user1.job + " " + user1.id + " " + user1.createdAt, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });




    }
}
