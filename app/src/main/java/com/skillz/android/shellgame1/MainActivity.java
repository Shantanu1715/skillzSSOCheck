package com.skillz.android.shellgame1;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private AccountManager mAccountManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text);
        mAccountManager = AccountManager.get(this);
        checkAccounAvilable(this);
    }



    public void checkAccounAvilable(Context context){

        final Account availableAccounts[] = mAccountManager.getAccountsByType("com.skillz");
        Log.e("account size==>"," "+availableAccounts.length);
        if (availableAccounts.length == 0) {
            Toast.makeText(this, "No accounts", Toast.LENGTH_SHORT).show();
        }
        else{
            String dataString="";
            for (Account a : availableAccounts) {
                dataString+="Name: "+a.name+"\n"+"Password: "+mAccountManager.getPassword(a)+"\n\n";
            }
            textView.setText(dataString);
        }
    }

    private void createLocalAccount(Context context) {

        try {
            Account account = new Account("shan", String.valueOf(R.string.account_type));
            final Bundle extraData = new Bundle();
            boolean success = mAccountManager.addAccountExplicitly(account, "12345678", extraData);
            Log.e("create account==>", "" + success);
        } catch (Exception e) {
            Log.e("errorrrr===>", e.getMessage());
        }
    }
}