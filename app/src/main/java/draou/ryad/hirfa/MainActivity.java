package draou.ryad.hirfa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bLogout;
    EditText etUsername, etMail;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etUsername = (EditText) findViewById(R.id.etUsername);

        etMail = (EditText) findViewById(R.id.etMail);
        bLogout = (Button) findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);

        userLocalStore= new UserLocalStore(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (authenticate() == true) {
            displayUserDetails();
        }else{
            startActivity(new Intent(MainActivity.this, Login.class) );
        }
    }
    private boolean authenticate(){
        return userLocalStore.getUserLoggedIn();

    }
    public void displayUserDetails(){
        User user = userLocalStore.getLoggedInUser();

        etUsername.setText(user.username);
        etMail.setText(user.mail);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogout:
                userLocalStore.clearUserData();
                userLocalStore.setuserLoggedIn(false);


                startActivity(new Intent(this, Login.class));

            break;
        }
    }
}
