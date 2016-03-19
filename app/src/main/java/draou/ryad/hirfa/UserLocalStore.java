package draou.ryad.hirfa;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ryad Ismail on 29/02/2016.
 */
public class UserLocalStore {
    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;
    public UserLocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(User user){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("username", user.username);
        spEditor.putString("password", user.password);
        spEditor.putString("mail", user.mail);
        spEditor.commit();
    }
    public User getLoggedInUser(){
        String username = userLocalDatabase.getString("username", "");
        String password = userLocalDatabase.getString("password", "");
        String mail = userLocalDatabase.getString("mail", "");

        User storeUser = new User(username, password, mail);
        return storeUser;

    }
public void setuserLoggedIn(boolean loggedIn){
    SharedPreferences.Editor spEditor = userLocalDatabase.edit();
    spEditor.putBoolean("loggedIn", loggedIn);
    spEditor.commit();
}
    public boolean getUserLoggedIn(){

        if (userLocalDatabase.getBoolean("loggedIn", false) == true){
            return true;
        }
        else {
            return false;
        }
    }

public void clearUserData(){
    SharedPreferences.Editor spEditor = userLocalDatabase.edit();
    spEditor.clear();
    spEditor.commit();
}


}

