package iut.paci.classroomcommunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class QuizzActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        String login = b.getString("J1");
        String j2 = b.getString("J2");
        TextView tv = (TextView) findViewById(R.id.J1);
        TextView tv2 = (TextView) findViewById(R.id.J2);
        tv.setText(login);
        tv2.setText(j2);
    }
}
