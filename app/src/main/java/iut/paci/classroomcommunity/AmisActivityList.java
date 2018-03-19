package iut.paci.classroomcommunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class AmisActivityList extends AppCompatActivity {

    private RecyclerView rvListAmis;
    private static String login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amis_list);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        login = b.getString("login");
        this.rvListAmis = (RecyclerView) findViewById(R.id.rvEtudiant);
        LinearLayoutManager l = new LinearLayoutManager(this);
        this.rvListAmis.setLayoutManager(l);
        EtudiantAdapter adapter = new EtudiantAdapter(this, ListeEtudiant.ajout());
        this.rvListAmis.setAdapter(adapter);
    }

    public static String getLogin()
    {
        return login;
    }
}
