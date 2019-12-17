package co.g2lab.crud.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.g2lab.crud.R;
import co.g2lab.crud.adapter.NasabahAdapter;
import co.g2lab.crud.model.GetListNasabah;
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
                Call<GetListNasabah> nasabahCall = mApiInterface.getListNasabah();
                nasabahCall.enqueue(new Callback<GetListNasabah>() {
                    @Override
                    public void onResponse(Call<GetListNasabah> call, Response<GetListNasabah>
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
                    public void onFailure(Call<GetListNasabah> call, Throwable t) {
                        Log.e("Error : ", t.toString());
                    }
                });
            }
        });
        nasabahListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Toast.makeText(MainActivity.this, listNasabah.get(position).getNama(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", listNasabah.get(position).getId());
                intent.putExtras(bundle);
                startActivity(intent);

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
