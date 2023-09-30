package com.example.duan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Screen_regeter extends AppCompatActivity {

    LinearLayout vMain_regeter;
    //    editText
    TextInputEditText edtUsername_regeter, edtEmail_regeter, edtAddress_regeter, edtNumberphone_regeter,
            edtPassword_regeter, edtConfirmpassword_regeter;
    Button btnContinue_regeter;
    Toolbar toolbar;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_regeter);

        setControl();
        setEvent();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.toolbar){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    //    hàm bắt sự kiện
    private void setEvent() {
        vMain_regeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard();
            }
        });

//        sự kiện editUsername
        edtUsername_regeter.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE) {
                    String strPattern = "[a-zA-Z]+";
                    Pattern pattern = Pattern.compile(strPattern);
                    Matcher matcher = pattern.matcher(edtUsername_regeter.getText().toString());
                    if (!matcher.find()) {
                        edtUsername_regeter.setError("Tên nhập vào không hơp lệ ");
                    }
                }
                return false;
            }
        });

//        sự kiến tap on continue button
        btnContinue_regeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    //    hàm ẩn bàn phím
    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

//    hàm kiếm tên người dùng

    //    hàm ánh xạ
    private void setControl() {
        vMain_regeter = findViewById(R.id.vMain_regeter);
        edtUsername_regeter = findViewById(R.id.edtUsername_regeter);
        edtEmail_regeter = findViewById(R.id.edtEmail_regeter);
        edtNumberphone_regeter = findViewById(R.id.edtNumberphone_regeter);
        edtAddress_regeter = findViewById(R.id.edtAddress_regeter);
        edtPassword_regeter = findViewById(R.id.edtPassword_regeter);
        edtConfirmpassword_regeter = findViewById(R.id.edtConfirmpassword_regeter);
        btnContinue_regeter = findViewById(R.id.btnContinue_resgeter);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}