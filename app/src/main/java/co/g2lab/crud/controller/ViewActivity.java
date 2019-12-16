package co.g2lab.crud.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import co.g2lab.crud.R;

public class ViewActivity extends AppCompatActivity {
    private String id;
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
    }
    void onClickGroup(){
        refreshTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });
    }
}
