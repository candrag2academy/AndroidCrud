package co.g2lab.crud.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import co.g2lab.crud.R;
import co.g2lab.crud.model.GetNasabah;
import co.g2lab.crud.model.Nasabah;
import co.g2lab.crud.model.PostPutDelNasabah;
import co.g2lab.crud.rest.ApiClient;
import co.g2lab.crud.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewActivity extends AppCompatActivity {
    private String id;
    private Nasabah nasabah=new Nasabah();
    ApiInterface mApiInterface;

    EditText namaEditText,alamatEditText,emailEditText;
    TextView namaTextView,alamatTextView,emailTextView,saldoTextView,createdDateTextView,updatedDateTextView, refreshTextView;
    Button updateButton,deleteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        findViewById();
        initData();
        onClickGroup();
    }
    void findViewById(){
        namaEditText = (EditText) findViewById(R.id.namaEditText);
        alamatEditText = (EditText) findViewById(R.id.alamatEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);

        namaTextView = (TextView) findViewById(R.id.namaTextView);
        alamatTextView = (TextView) findViewById(R.id.alamatTextView);
        emailTextView = (TextView) findViewById(R.id.emailTextView);
        saldoTextView = (TextView) findViewById(R.id.saldoTextView);
        createdDateTextView = (TextView) findViewById(R.id.createdDateTextView);
        updatedDateTextView = (TextView) findViewById(R.id.updatedDateTextView);
        refreshTextView = (TextView) findViewById(R.id.refreshTextView);

        updateButton = (Button) findViewById(R.id.updateButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);
    }
    void initData(){
        Bundle bundle = getIntent().getExtras();
        id=bundle.getString("id");
        Toast.makeText(getApplicationContext(),id,Toast.LENGTH_LONG).show();
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        refreshTextView.callOnClick();
    }
    void onClickGroup(){
        refreshTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<GetNasabah> nasabahCall = mApiInterface.getNasabah(id);
                nasabahCall.enqueue(new Callback<GetNasabah>() {
                    @Override
                    public void onResponse(Call<GetNasabah> call, Response<GetNasabah>
                            response) {
                        if (response.isSuccessful() ) {
                            nasabah = response.body().getNasabah();
                            namaEditText.setText(nasabah.getNama());
                            alamatEditText.setText(nasabah.getAlamat());
                            emailEditText.setText(nasabah.getEmail());

                            namaTextView.setText("Nama : "+nasabah.getNama());
                            alamatTextView.setText("Alamat :"+nasabah.getAlamat());
                            emailTextView.setText("Email : "+nasabah.getEmail());
                            saldoTextView.setText("Saldo : "+nasabah.getSaldo().toString());
                            createdDateTextView.setText("Created Date : "+nasabah.getCreated_date().toString());
                            updatedDateTextView.setText("Updated Date : "+nasabah.getUpdated_date().toString());

                        } else {
                            Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<GetNasabah> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelNasabah> nasabahCall = mApiInterface.putNasabah(id,namaEditText.getText().toString(),alamatEditText.getText().toString(),emailEditText.getText().toString());
                nasabahCall.enqueue(new Callback<PostPutDelNasabah>() {
                    @Override
                    public void onResponse(Call<PostPutDelNasabah> call, Response<PostPutDelNasabah>
                            response) {
                        if (response.isSuccessful() ) {
                            Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_LONG).show();
                            refreshTextView.callOnClick();

                        } else {
                            Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<PostPutDelNasabah> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelNasabah> nasabahCall = mApiInterface.deleteNasabah(id);
                nasabahCall.enqueue(new Callback<PostPutDelNasabah>() {
                    @Override
                    public void onResponse(Call<PostPutDelNasabah> call, Response<PostPutDelNasabah>
                            response) {
                        if (response.isSuccessful() ) {
                            Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_LONG).show();
                            refreshTextView.callOnClick();
                            finish();

                        } else {
                            Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<PostPutDelNasabah> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
    }
}
