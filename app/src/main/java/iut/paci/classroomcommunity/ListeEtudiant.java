package iut.paci.classroomcommunity;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;

/**
 * Created by AurélienPC on 19/03/2018.
 */

public class ListeEtudiant
{
    public static ArrayList<Etudiant> amis = new ArrayList<Etudiant>();

    public static ArrayList ajout(){
        ArrayList<Etudiant> l = new ArrayList<>();
        Singleton single = Singleton.getInstance();
        String s = "";
        Boolean bool = true;
        for(int i = 0; i<single.etudiant_list.length;i++)
        {
            s=single.etudiant_list[i].getPseudo();
            bool = single.etudiant_list[i].getStatus();
            l.add(new Etudiant(s,bool));
        }
        return l;
    }

    public static Etudiant getEtudiant(int position)
    {
        return  ListeEtudiant.amis.get(position);
    }

    public int taile()
    {
        return ListeEtudiant.amis.size();
    }
}
