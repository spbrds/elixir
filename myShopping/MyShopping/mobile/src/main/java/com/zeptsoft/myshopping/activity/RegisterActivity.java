package com.zeptsoft.myshopping.activity;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.zeptsoft.myshopping.R;
import com.zeptsoft.myshopping.core.activity.AuthenticationActivity;
import com.zeptsoft.myshopping.database.firebase.UserDatabaseCommunicatorImpl;
import com.zeptsoft.myshopping.datatypes.Group;
import com.zeptsoft.myshopping.datatypes.User;
import com.zeptsoft.myshopping.log.LogUtils;
import com.zeptsoft.myshopping.utils.AuthenticationUtils;

import java.util.ArrayList;
import java.util.Date;


public class RegisterActivity extends AuthenticationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register_layout);

        findViewById(R.id.register_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser(){
        final String username = ((EditText)findViewById(R.id.register_email)).getText().toString();
        final String name = ((EditText)findViewById(R.id.register_name)).getText().toString();
        final String password = ((EditText)findViewById(R.id.register_pwd)).getText().toString();
        final String passwordConfirmation = ((EditText)findViewById(R.id.register_conf_pwd)).getText().toString();

        if(AuthenticationUtils.validateRegister(username, name, password,passwordConfirmation)) {
            firebaseAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    LogUtils.d(String.format("Task Result: %s", task.isSuccessful()));
                    if (!task.isSuccessful()) {
                        ((TextView) findViewById(R.id.register_error_text)).setText(task.getException().getMessage());
                        LogUtils.d("Error Occurred: %s" + task.getException().getMessage());
                    } else {
                        User u = new User();
                        u.setName(name);
                        u.setEmail(username);
                        u.setLastLogin(new Date());
                        u.setGroups(new ArrayList<Group>());

                        UserDatabaseCommunicatorImpl userDatabaseCom = new UserDatabaseCommunicatorImpl();
                        userDatabaseCom.createUser(u);
                    }
                }
            });
        }
    }


    @Override
    protected int getErrorMessageId() {
        return R.string.register_failed;
    }
}
