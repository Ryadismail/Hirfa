package draou.ryad.hirfa;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button bLogin;
    EditText etUsername, etPassword;
    TextView tvRegisterLink;
    UserLocalStore userLocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);

        bLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);
        userLocalStore= new UserLocalStore(this);
        //Api api = new Api();
        //api.execute("moi");
        //Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(R.id.image_id);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogin:
                User user = new User(null, null, null);
                userLocalStore.storeUserData(user);
                userLocalStore.setuserLoggedIn(true);




                break;
            case R.id.tvRegisterLink:
                startActivity(new Intent(this, Register.class));
                break;

        }

    }
}
