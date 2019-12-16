package co.g2lab.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.g2lab.crud.adapter.NasabahAdapter;
import co.g2lab.crud.model.GetNasabah;
import co.g2lab.crud.model.Nasabah;
import co.g2lab.crud.rest.ApiClient;
import co.g2lab.crud.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView nasabahListView;
    TextView refreshTextView;
    NasabahAdapter nasabahAdapter;
    private List<Nasabah> listNasabah;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        onClickGroup();
        initData();

    }
    void findViewById(){
        nasabahListView = (ListView) findViewById(R.id.nasabahListView);
        refreshTextView = (TextView) findViewById(R.id.refreshTextView);
    }
    void onClickGroup(){
        refreshTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<GetNasabah> nasabahCall = mApiInterface.getNasabah();
                nasabahCall.enqueue(new Callback<GetNasabah>() {
                    @Override
                    public void onResponse(Call<GetNasabah> call, Response<GetNasabah>
                            response) {
                        if (response.isSuccessful() ) {
                            List<Nasabah> listNasabahTemp = response.body().getListNasabah();
                            listNasabah.clear();
                            listNasabah.addAll(listNasabahTemp);
                            nasabahAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<GetNasabah> call, Throwable t) {
                        Log.e("Error : ", t.toString());
                    }
                });
            }
        });
    }
    void initData(){
        listNasabah = new ArrayList();
        listNasabah.clear();
        nasabahAdapter = new NasabahAdapter(getApplicationContext(), listNasabah);
        nasabahListView.setAdapter(nasabahAdapter);
        nasabahAdapter.notifyDataSetChanged();
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);


    }
}
