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


    //private final OkHttpClient client = new OkHttpClient();
    public String resultat = new String();
    private user p;
    public Singleton singleton;
    /*
    public String get(String url) throws IOException {
        // Prepare the request.
        Request request = new Request.Builder().url(url).build();
        // Execute the request.
        Response response = client.newCall(request).execute();
        // Get the result.
        return response.body().string();
    }

    public Etudiant moncall(String json)
    {
        Etudiant a = new Gson().fromJson(json, Etudiant.class);
        return a;
    }

    public String bite() throws IOException {
        Etudiant e = this.moncall(this.get("http://193.70.22.32/android_quiz.php"));
        return e.getPseudo();
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        this.singleton = Singleton.getInstance();
        singleton.setData("jesuisun text");
        new FetchTask().execute("http://193.70.22.32/android.php");
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
                    Toast.makeText(getApplicationContext(), "Va te faire foutre", Toast.LENGTH_LONG).show();
                }

            }
        });
        //Toast.makeText(getApplicationContext(), this.resultat, Toast.LENGTH_LONG).show();


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
            //String stringUrl = "http://193.70.22.32/question1.php";
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
            //String[] enums = new Gson().fromJson(rp, String[].class);
      //      Question q = new Gson().fromJson(rp, Question.class); marche avec q1
           // Singleton.getInstance().question_list[0] = q;
           // Question[] q = new Gson().fromJson(rp, Question[].class);

            List<Question> list = new Gson().fromJson(rp, new TypeToken<List<Question>>() {}.getType());
            for(int i = 0; i<list.size(); i++)
            {
                Singleton.getInstance().question_list[i] = list.get(i);
            }
            Singleton.getInstance().taille = list.size();

        }

        public void getEtudiant()
        {
            OkHttpClient client = new OkHttpClient();
            //String stringUrl = "http://193.70.22.32/question1.php";
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
            //String[] enums = new Gson().fromJson(rp, String[].class);
            //      Question q = new Gson().fromJson(rp, Question.class); marche avec q1
            // Singleton.getInstance().question_list[0] = q;
            // Question[] q = new Gson().fromJson(rp, Question[].class);

            List<jtudiant> list = new Gson().fromJson(rp, new TypeToken<List<jtudiant>>() {}.getType());
            Singleton.getInstance().etudiant_list = new jtudiant[list.size()];
            for(int i = 0; i<list.size(); i++)
            {
                Singleton.getInstance().etudiant_list[i] = list.get(i);
            }
            Singleton.getInstance().taille = list.size();

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            resultat = s;
            //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            user p = new Gson().fromJson(s, user.class);
           // Toast.makeText(getApplicationContext(), p.getPseudo(), Toast.LENGTH_LONG).show();
            //String taille = "taille : " +   Singleton.getInstance().taille;
            Toast.makeText(getApplicationContext(),  Singleton.getInstance().json, Toast.LENGTH_LONG).show();

        }
    }

}
