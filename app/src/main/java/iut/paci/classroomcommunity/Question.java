package iut.paci.classroomcommunity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

/*public class Question implements Parcelable
{

    private final int Id_Question;
    private final String text;
    private final int Reponse_Correct;
    private final String Proposition1;
    private final String Proposition2;
    private final String Proposition3;
    private final String Proposition4;

    public Question(JSONObject jObject)
    {
        this.Id_Question = jObject.optInt("Id_Question");
        this.text = jObject.optString("text");
        this.Reponse_Correct = jObject.optInt("Reponse_Correct");
        this.Proposition1 = jObject.optString("Proposition1");
        this.Proposition2 = jObject.optString("Proposition2");
        this.Proposition3 = jObject.optString("Proposition3");
        this.Proposition4 = jObject.optString("Proposition4");
    }

    public String getEnonce()
    {
        return this.text;
    }

    protected Question(Parcel in) {
        Id_Question = in.readInt();
        text = in.readString();
        Reponse_Correct = in.readInt();
        Proposition1 = in.readString();
        Proposition2 = in.readString();
        Proposition3 = in.readString();
        Proposition4 = in.readString();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(Id_Question);
        parcel.writeString(text);
        parcel.writeInt(Reponse_Correct);
        parcel.writeString(Proposition1);
        parcel.writeString(Proposition2);
        parcel.writeString(Proposition3);
        parcel.writeString(Proposition4);
    }
}*/

public class Question{

    private final String Id_Question;
    private final String text;
    private final String Reponse_Correct;
    private final String Proposition1;
    private final String Proposition2;
    private final String Proposition3;
    private final String Proposition4;

    public Question()
    {
        Id_Question  = "";
                text= "";
        Reponse_Correct= "";
        Proposition1= "";
        Proposition2= "";
        Proposition3= "";
        Proposition4= "";
    }
    public String getEnonce()
    {
        return this.text;
    }

    public String getProposition1() {
        return Proposition1;
    }

    public String getProposition2() {
        return Proposition2;
    }

    public String getProposition3() {
        return Proposition3;
    }

    public String getProposition4() {
        return Proposition4;
    }

    public String getReponse_Correct() {
        return Reponse_Correct;
    }
}
