package iut.paci.classroomcommunity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private ActionBarDrawerToggle toggle;
    private FragmentManager fm;
    private DrawerLayout drawer;
    private NavigationView nav;
    String login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        login = b.getString("login");
        fm = getSupportFragmentManager();
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        nav = (NavigationView) findViewById(R.id.nav_view);
        nav.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this, drawer, R.string.ouverture, R.string.fermeture);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item))
            return true;
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.nav_first:
                Intent i = new Intent(getApplicationContext(),AmisActivityList.class);
                Bundle b = new Bundle();
                b.putString("login",login);
                i.putExtras(b);
                startActivity(i);
                break;
            case R.id.nav_second:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Exit Application?");
                builder.setMessage("Click yes to exit!");
                builder.setPositiveButton("Yes",new DialogInterface.OnClickListener()
                    {public void onClick(DialogInterface dialog,int id)
                    {
                        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                        homeIntent.addCategory( Intent.CATEGORY_HOME );
                        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(homeIntent);
                    }});

                builder.setNegativeButton("No", new DialogInterface.OnClickListener()
                    {public void onClick(DialogInterface dialog, int id) {
                        System.out.println("non");
                    }});
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
