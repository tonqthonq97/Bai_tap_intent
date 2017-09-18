package baitap.gameloft.com.bai_tap_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent_nhan = getIntent();
        Bundle bun_nhan = intent_nhan.getBundleExtra("myPackage");

        int a = bun_nhan.getInt("soA");
        int b = bun_nhan.getInt("soB");

        giaiPT(a,b);

    }

    public void giaiPT(int a, int b){
        tv = (TextView)findViewById(R.id.edt_kq);
        if (a == 0){
            if (b == 0) {
                tv.setText(tv.getText().toString() + "Phuong trinh vo so nghiem");
                return;
            } else {
                tv.setText(tv.getText().toString() + "Phuong trinh vo nghiem");
                return;
            }
        } else {
            tv.setText(tv.getText().toString()+"Phuong trinh co nghiem la:" + String.valueOf((float)-b/a));
            return;
        }
    }
}
