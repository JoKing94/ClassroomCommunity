package iut.paci.classroomcommunity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    public String resultat = new String();
    public Singleton singleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.singleton = Singleton.getInstance();
        new FetchTask().execute("http://193.70.22.32/android.php");
        for(long i = 0; i<99999999; i++)
        {
            i++;
        }
        Button b = (Button) (findViewById(R.id.btn_login));
        final TextView tv_log=(TextView) findViewById(R.id.login);
        final TextView tv_pass=(TextView) findViewById(R.id.pass);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_log.getText().toString().equals("root") && tv_pass.getText().toString().equals("root"))
                {
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    Bundle b = new Bundle();
                    b.putString("login",tv_log.getText().toString());
                    i.putExtras(b);
                    startActivity(i);
                    Singleton.getInstance().mon_pseudo = "root";
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Identification Refusée", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    private class FetchTask extends AsyncTask<String, Void, String> {

        public Singleton single = Singleton.getInstance();

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
                this.getQuestion();
                this.getEtudiant();
                return response.body().string();
            } catch (IOException e) {
                return null;
            }
        }

        public void getQuestion()
        {
            OkHttpClient client = new OkHttpClient();
            String stringUrl = "http://193.70.22.32/question.php";
            Request request = new Request.Builder().url(stringUrl).build();
            String rp = null;
            Response response = null;
            try {
                response = client.newCall(request).execute();
                rp = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Singleton.getInstance().json = rp;
            List<Question> list = new Gson().fromJson(rp, new TypeToken<List<Question>>() {}.getType());
            for(int i = 0; i<list.size(); i++)
            {
                Singleton.getInstance().question_list[i] = list.get(i);
            }
        }

        public void getEtudiant()
        {
            OkHttpClient client = new OkHttpClient();
            String stringUrl = "http://193.70.22.32/android_etudiant.php";
            Request request = new Request.Builder().url(stringUrl).build();
            String rp = null;
            Response response = null;
            try {
                response = client.newCall(request).execute();
                rp = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Singleton.getInstance().json = rp;
            List<jtudiant> list = new Gson().fromJson(rp, new TypeToken<List<jtudiant>>() {}.getType());
            Singleton.getInstance().etudiant_list = new jtudiant[list.size()];
            for(int i = 0; i<list.size(); i++)
            {
                Singleton.getInstance().etudiant_list[i] = list.get(i);
            }
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

}
