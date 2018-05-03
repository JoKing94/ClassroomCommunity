package iut.paci.classroomcommunity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class QuizzActivity extends AppCompatActivity {
    public Question question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        //String url = "http://193.70.22.32/android_question.php?";
        //new QuestionTask().execute(url);
        Singleton g = Singleton.getInstance();
        Toast.makeText(getApplicationContext(), g.getData(), Toast.LENGTH_LONG).show();
        Intent i = getIntent();
        Bundle b = i.getExtras();
        String login = b.getString("J1");
        String j2 = b.getString("J2");
        TextView tv = (TextView) findViewById(R.id.J1);
        TextView tv2 = (TextView) findViewById(R.id.J2);
        tv.setText(login);
        tv2.setText(j2);
        this.refresh();
        Button rp1 = (Button) (findViewById(R.id.Réponse1));
        rp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizzActivity.this.reponse(1);
            }
        });

        Button rp2 = (Button) (findViewById(R.id.Réponse2));
        rp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizzActivity.this.reponse(2);
            }});

                Button rp3 = (Button) (findViewById(R.id.Réponse3));
        rp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizzActivity.this.reponse(3);
            }});

                Button rp4 = (Button) (findViewById(R.id.Réponse4));
        rp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizzActivity.this.reponse(4);
            }});

    }


    private class QuestionTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String... strings) {
            OkHttpClient client = new OkHttpClient();
            String stringUrl = strings[0];
            Request request = new Request.Builder().url(stringUrl).build();
            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                return null;
            }
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            question = new Gson().fromJson(s, Question.class);
        }
    }

    public void reponse(int rep_user)
    {
    Singleton single = Singleton.getInstance();
    single.reponse[single.question_actuelle] = rep_user;
    single.question_actuelle++;
    if(single.question_actuelle == single.question_list.length)
    {
        String ss = "Votre Score est de " + single.compare_result() + "/" + single.question_actuelle;
        Toast.makeText(getApplicationContext(), ss, Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        Bundle b = new Bundle();
        b.putString("login", single.mon_pseudo);
        i.putExtras(b);
        startActivity(i);

    }
    else
    {
        this.refresh();
    }
/*
        Intent quizz = new Intent(getApplicationContext(), QuizzActivity.class);
        Bundle b = new Bundle();
        TextView tv = (TextView) findViewById(R.id.J1);
        TextView tv2 = (TextView) findViewById(R.id.J2);
        b.putString("J2", tv.getText().toString());
        b.putString("J1", tv2.getText().toString());
        quizz.putExtras(b);
        Singleton
        startActivity(quizz);
*/
    }

    public void refresh()
    {
        Singleton single = Singleton.getInstance();
        TextView Question = (TextView) findViewById(R.id.question);
        Question.setText(Singleton.getInstance().question_list[single.question_actuelle].getEnonce());
        TextView rep1 = (TextView) findViewById(R.id.Réponse1);
        rep1.setText(Singleton.getInstance().question_list[single.question_actuelle].getProposition1());
        TextView rep2 = (TextView) findViewById(R.id.Réponse2);
        rep2.setText(Singleton.getInstance().question_list[single.question_actuelle].getProposition2());
        TextView rep3 = (TextView) findViewById(R.id.Réponse3);
        rep3.setText(Singleton.getInstance().question_list[single.question_actuelle].getProposition3());
        TextView rep4 = (TextView) findViewById(R.id.Réponse4);
        rep4.setText(Singleton.getInstance().question_list[single.question_actuelle].getProposition4());
    }
}
