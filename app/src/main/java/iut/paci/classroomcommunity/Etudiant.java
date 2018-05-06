package iut.paci.classroomcommunity;

/**
 * Created by AurélienPC on 19/03/2018.
 */

public class Etudiant {
    private String pseudo;
    boolean statut = true;

    public Etudiant(String name, boolean present)
    {
        this.pseudo = name;
        this.statut = present;
    }

    public Etudiant(String name)
    {
        this.pseudo = name;
    }

    public String getPseudo()
    {
        return this.pseudo;
    }

    public boolean getStatut()
    {
        return this.statut;
    }
}
