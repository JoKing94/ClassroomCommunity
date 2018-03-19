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

        l.add(new Etudiant("Aurel",true));
        l.add(new Etudiant("Arond",false));
        l.add(new Etudiant("Nicolas",true));
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
