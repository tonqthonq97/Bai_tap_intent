package baitap.gameloft.com.bai_tap_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static int change = 0;

    EditText hs_a, hs_b;
    Button btn_kq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hs_a = (EditText)findViewById(R.id.hs_a);
        hs_b = (EditText)findViewById(R.id.hs_b);
        btn_kq = (Button)findViewById(R.id.btn_kq);
        //-------------------------------------------

        btn_kq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( isNumeric(hs_a.getText().toString()) && isNumeric(hs_b.getText().toString())){
                Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);

                int a = Integer.parseInt(hs_a.getText().toString());
                int b = Integer.parseInt(hs_b.getText().toString());

                Bundle myBun = new Bundle();
                myBun.putInt("soA",a);
                myBun.putInt("soB",b);
                myIntent.putExtra("myPackage",myBun);

                startActivity(myIntent);
            } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                }
            }
        });
       if (change==1)
       {
           hs_a.setText("0");
           hs_b.setText("0");
            Intent intent_nhan = getIntent();
            Bundle bun_nhan = intent_nhan.getBundleExtra("myPackage");
            int a_nhan = bun_nhan.getInt("soA");
            int b_nhan = bun_nhan.getInt("soB");
           Toast.makeText(MainActivity.this, "Chào mừng trở lại Main Activity, số đã nhập là a = "+a_nhan+" b= "+b_nhan, Toast.LENGTH_SHORT).show();

        }
    }
    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
