package com.example.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class Twitter extends AppCompatActivity {

    TwitterLoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.twitter.sdk.android.core.Twitter.initialize(this);
        setContentView(R.layout.activity_twitter);
        loginButton=findViewById(R.id.login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
             TwitterSession session= TwitterCore.getInstance().getSessionManager().getActiveSession();
             TwitterAuthToken authToken= session.getAuthToken();
             String token=authToken.token;
             String secret=authToken.secret;
             login(session);
            }

            @Override
            public void failure(TwitterException exception) {
                Toast.makeText(Twitter.this,"Authentication Failed",Toast.LENGTH_LONG).show();
            }
        });
    }

    private static void initialize(Twitter twitter) {

    }

    public void login(TwitterSession session){
        String username=session.getUserName();
        Intent intent=new Intent(Twitter.this,homepage.class);
        intent.putExtra("username", username);
        startActivity(intent);
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        loginButton.onActivityResult(requestCode,resultCode,data);
    }
}
