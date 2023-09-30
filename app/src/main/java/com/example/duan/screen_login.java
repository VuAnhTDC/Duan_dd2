package com.example.duan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class screen_login extends AppCompatActivity {

    LinearLayout vMain;
    TextInputEditText edt_email, edt_password;
    TextView txtForget_password, txtRegeter_Account;

    private  Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        setControl();
        setEvent();
        context = this;
    }
// hàm bắt sự kiện
    private void setEvent() {
//        lắng nghe sự kiện nhấn vào cửa vMain
        vMain.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
//                Gọi hàm ẩn bàn phím
                hideKeyboard();
                return false;
            }
        });

//        sự kiện khi nhập xong giá trị email

        edt_email.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
//                nếu nhấn vào phím done
                if (i == EditorInfo.IME_ACTION_DONE){
                    boolean emailValidate = Patterns.EMAIL_ADDRESS.matcher(edt_email.getText().toString()).matches();
                    if (!emailValidate){
                        edt_email.setError("Email không hợp lệ");
                        edt_email.requestFocus();
                    }
                    else {
                        edt_password.requestFocus();
                    }
                }
                return false;
            }
        });

//        sự kiện nhập mật khẩu
        edt_password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i == EditorInfo.IME_ACTION_DONE){
                    hideKeyboard();
                }
                return false;
            }
        });

//        sự kiện đăng ký
        txtRegeter_Account.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(context, Screen_regeter.class);
                startActivity(intent);
                return false;
            }
        });

    }

    //    ẩn bàn phím
    private void hideKeyboard() {
//        lấy View đang được focus ===> tức view có suất hiện bàn phím
        View view = this.getCurrentFocus();
//        kiểm tra xem view đó có focus không ---> băng null nếu view không được focus, không bằng null nếu view có focus
        if (view != null) {
//            Tạo đối tượng InputMethodManager
            /*
                InputMethodManager dùng để quản lý bàn phím
            * */
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//           sử dụng thuộc tính ẩn bàn phím của InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    //    Ánh sạ
    private void setControl() {
        vMain = findViewById(R.id.vmain);
        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);
        txtForget_password = findViewById(R.id.txtForgetPassword);
        txtRegeter_Account = findViewById(R.id.txtRegeter_Account);
    }
}
