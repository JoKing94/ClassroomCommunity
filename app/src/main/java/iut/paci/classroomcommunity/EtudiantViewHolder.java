package iut.paci.classroomcommunity;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by AurélienPC on 19/03/2018.
 */

public class EtudiantViewHolder extends RecyclerView.ViewHolder {

    private final TextView pseudo;
    private final TextView disponible;

    public EtudiantViewHolder(View itemView) {
        super(itemView);
        this.pseudo = (TextView) itemView.findViewById(R.id.etudiant);
        this.disponible = (TextView) itemView.findViewById(R.id.dispo);
    }

    public void remplirCell(Etudiant e)
    {
        this.pseudo.setText(e.getPseudo());
        if (e.getStatut())
        {
            disponible.setBackgroundColor(Color.GREEN);
            disponible.setText("En ligne");
            disponible.setTextColor(Color.GREEN);
        }
        else {
            disponible.setBackgroundColor(Color.RED);
            disponible.setText("Absent");
            disponible.setTextColor(Color.RED);
        }
    }

    public TextView getTextViewPseudo()
    {
        return this.pseudo;
    }

    public TextView getTextViewStatut()
    {
        return this.disponible;
    }
}
