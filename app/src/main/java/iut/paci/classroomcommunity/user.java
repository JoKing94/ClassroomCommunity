package iut.paci.classroomcommunity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class user implements Parcelable
{

    private final String pseudo;


    public user(JSONObject jObject)
    {
        this.pseudo = jObject.optString("pseudo");
    }

    public String getPseudo()
    {
        return this.pseudo();
    }

    protected user(Parcel in) {
        pseudo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pseudo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<user> CREATOR = new Creator<user>() {
        @Override
        public user createFromParcel(Parcel in) {
            return new user(in);
        }

        @Override
        public user[] newArray(int size) {
            return new user[size];
        }
    };

    public String pseudo() { return pseudo; }


}