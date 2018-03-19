package iut.paci.classroomcommunity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by AurélienPC on 19/03/2018.
 */

public class EtudiantAdapter extends RecyclerView.Adapter<EtudiantViewHolder> {
    private Context context;
    private ArrayList<Etudiant> listeEtudiant;

    public EtudiantAdapter(Context c, ArrayList<Etudiant> l)
    {
        this.context = c;
        this.listeEtudiant = l;
        notifyDataSetChanged();
    }

    @Override
    public EtudiantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View cell = LayoutInflater.from(this.context).inflate(R.layout.content_cell,parent,false);
        EtudiantViewHolder etudiantViewHolder = new EtudiantViewHolder(cell);
        cell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) v.findViewById(R.id.etudiant);
                TextView tv2 = (TextView) v.findViewById(R.id.dispo);
                if(tv2.getText().equals("Absent"))
                {
                    Toast.makeText(context,"Ami indisponible",Toast.LENGTH_LONG).show();
                }
                else {
                    String j = AmisActivityList.getLogin();
                    Toast.makeText(context,j,Toast.LENGTH_LONG).show();
                    Intent quizz = new Intent(context, QuizzActivity.class);
                    Bundle b = new Bundle();
                    b.putString("J2", tv.getText().toString());
                    b.putString("J1",j);
                    quizz.putExtras(b);
                    context.startActivity(quizz);
                }
            }
        });
        return etudiantViewHolder;
    }

    @Override
    public void onBindViewHolder(EtudiantViewHolder holder, int position) {
        holder.remplirCell(this.listeEtudiant.get(position));

    }

    @Override
    public int getItemCount() {
        int item = 0;
        if(this.listeEtudiant !=null)
        {
            item = listeEtudiant.size();
        }
        return item;
    }
}
