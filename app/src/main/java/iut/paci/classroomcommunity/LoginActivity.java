package iut.paci.classroomcommunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button b = (Button) (findViewById(R.id.btn_login));
        final TextView tv_log=(TextView) findViewById(R.id.login);
        final TextView tv_pass=(TextView) findViewById(R.id.pass);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_log.getText().toString().equals("root") && tv_pass.getText().toString().equals("root"))
                {
                    Intent i = new Intent(getApplicationContext(),AmisActivityList.class);
                    Bundle b = new Bundle();
                    b.putString("login",tv_log.getText().toString());
                    i.putExtras(b);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Va te faire foutre", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
