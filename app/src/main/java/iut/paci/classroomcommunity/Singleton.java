package iut.paci.classroomcommunity;

public class Singleton  {

    private static Singleton INSTANCE = null;
    public String transfert = "";
    public int Actual_Question = 0; //stock la question en cours pour l'utilisateur 0 veut dire qu'il n'a pas encore commencé de partie
    public String mon_pseudo = "";
    public Question[] question_list = new Question[4];
    public int taille = 0;
    public String json = "";
    public int question_actuelle =  0;
    public int[] reponse = new int[4];
    public int id_partie = 0;
    public jtudiant[] etudiant_list;
    public String adversaire = "";
    // other instance variables can be here

    private Singleton() {};

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return(INSTANCE);
    }

    public void setData(String s)
    {
        this.transfert = s;
    }

    public String getData()
    {
        return this.transfert;
    }
    // other instance methods can follow
    public int compare_result()
    {
        int score = 0;
        for(int i = 0; i<this.question_list.length;i++)
        {
            int rep_correct = Integer.parseInt(this.question_list[i].getReponse_Correct());
            if(rep_correct == this.reponse[i]) {
                score++;
            }
        }
        return score;
    }

    public int getid(String pseudo)
    {
        int retour = 0;
        for(int i = 0; i<this.etudiant_list.length;i++)
        {
            if(this.etudiant_list[i].getPseudo() == pseudo) {
                retour = this.etudiant_list[i].getId_e();
            }
    }
        return retour;
    }
}