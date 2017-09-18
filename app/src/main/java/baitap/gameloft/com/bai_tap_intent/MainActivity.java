package baitap.gameloft.com.bai_tap_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText hs_a, hs_b;
    Button btn_kq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hs_a = (EditText)findViewById(R.id.hs_a);
        hs_b = (EditText)findViewById(R.id.hs_b);
        btn_kq = (Button)findViewById(R.id.btn_kq);
        btn_kq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);

                int a = Integer.parseInt(hs_a.getText().toString());
                int b = Integer.parseInt(hs_b.getText().toString());

                Bundle myBun = new Bundle();
                myBun.putInt("soA",a);
                myBun.putInt("soB",b);
                myIntent.putExtra("myPackage",myBun);

                startActivity(myIntent);
            }
        });
    }
}
