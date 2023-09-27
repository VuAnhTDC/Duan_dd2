package com.example.duan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
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
    TextInputEditText txtInputEmail,txtInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        setControl();
        setEvent();
    }
// hàm bắt sự kiện
    private void setEvent() {
//        lắng nghe sự kiện nhấn vào cửa vMain
        vMain.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
//                Gọi hàm ẩn bàn phím
                hideKeyboard_touchonout();
                return false;
            }
        });

//        sự kiện khi nhập xong giá trị email

        txtInputEmail.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE){
                    txtInputPassword.requestFocus();
                }
                return false;
            }
        });
    }

    //    ẩn bàn phím
    private void hideKeyboard_touchonout() {
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
        txtInputEmail = findViewById(R.id.txtinput_email);
        txtInputPassword = findViewById(R.id.txtinput_password);
    }
}
