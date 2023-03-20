package com.skillz.android.shellgame1.authentication;

import static android.accounts.AccountManager.KEY_BOOLEAN_RESULT;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

public class SkillzAuthenticator extends AbstractAccountAuthenticator {

    private String TAG = "ShanAuthenticator";
    private final Context mContext;

    public SkillzAuthenticator(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    public Bundle addAccount(AccountAuthenticatorResponse response, String accountType, String authTokenType,
                             String[] requiredFeatures, Bundle options) throws NetworkErrorException {
        Log.d("" + TAG, " > addAccount");

//        final Intent intent = new Intent(mContext, SignInAuthenticatorActivity.class);
//        intent.putExtra(SignInAuthenticatorActivity.ARG_ACCOUNT_TYPE, accountType);
//        intent.putExtra(SignInAuthenticatorActivity.ARG_AUTH_TYPE, authTokenType);
//        intent.putExtra(SignInAuthenticatorActivity.ARG_IS_ADDING_NEW_ACCOUNT, true);
//        intent.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response);
//
//        final Bundle bundle = new Bundle();
//        bundle.putParcelable(AccountManager.KEY_INTENT, intent);
        return null;
    }

    @Override
    public Bundle getAuthToken(AccountAuthenticatorResponse response, Account account, String authTokenType,
                               Bundle options) throws NetworkErrorException {

//        Log.d("" + TAG, " > getAuthToken");
//
//        // If the caller requested an authToken type we don't support, then
//        // return an error
//        if (!authTokenType.equals(AccountGeneral.AUTHTOKEN_TYPE_READ_ONLY) &&
//                !authTokenType.equals(AccountGeneral.AUTHTOKEN_TYPE_FULL_ACCESS)) {
//            final Bundle result = new Bundle();
//            result.putString(AccountManager.KEY_ERROR_MESSAGE, "invalid authTokenType");
//            return result;
//        }
//
//        // Extract the username and password from the Account Manager, and ask
//        // the server for an appropriate AuthToken.
//        final AccountManager am = AccountManager.get(mContext);
//
//        String authToken = am.peekAuthToken(account, authTokenType);
//
//        Log.d("" + TAG, " > peekAuthToken returned - " + authToken);
//
//        // Lets give another try to authenticate the user
//        if (TextUtils.isEmpty(authToken)) {
//            final String password = am.getPassword(account);
//            if (password != null) {
//                try {
//                    Log.d("" + TAG, " > re-authenticating with the existing password");
//                    authToken="abchdmb1342342323";
//                    //authToken = AccountGeneral.sServerAuthenticate.userSignIn(account.name, password, authTokenType);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        // If we get an authToken - we return it
//        if (!TextUtils.isEmpty(authToken)) {
//            final Bundle result = new Bundle();
//            result.putString(AccountManager.KEY_ACCOUNT_NAME, account.name);
//            result.putString(AccountManager.KEY_ACCOUNT_TYPE, account.type);
//            result.putString(AccountManager.KEY_AUTHTOKEN, authToken);
//            return result;
//        }
//
//        // If we get here, then we couldn't access the user's password - so we
//        // need to re-prompt them for their credentials. We do that by creating
//        // an intent to display our SignInAuthenticatorActivity.
//        final Intent intent = new Intent(mContext, SignInAuthenticatorActivity.class);
//        intent.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response);
//        intent.putExtra(SignInAuthenticatorActivity.ARG_ACCOUNT_TYPE, account.type);
//        intent.putExtra(SignInAuthenticatorActivity.ARG_AUTH_TYPE, authTokenType);
//        intent.putExtra(SignInAuthenticatorActivity.ARG_ACCOUNT_NAME, account.name);
//        final Bundle bundle = new Bundle();
//        bundle.putParcelable(AccountManager.KEY_INTENT, intent);
        return null;
    }


    @Override
    public String getAuthTokenLabel(String authTokenType) {
        if (AccountGeneral.AUTHTOKEN_TYPE_FULL_ACCESS.equals(authTokenType))
            return AccountGeneral.AUTHTOKEN_TYPE_FULL_ACCESS_LABEL;
        else if (AccountGeneral.AUTHTOKEN_TYPE_READ_ONLY.equals(authTokenType))
            return AccountGeneral.AUTHTOKEN_TYPE_READ_ONLY_LABEL;
        else
            return authTokenType + " (Label)";
    }

    @Override
    public Bundle hasFeatures(AccountAuthenticatorResponse response, Account account, String[] features)
            throws NetworkErrorException {
        final Bundle result = new Bundle();
        result.putBoolean(KEY_BOOLEAN_RESULT, true);
        return result;
    }

    @Override
    public Bundle editProperties(AccountAuthenticatorResponse response, String accountType) {
        return null;
    }

    @Override
    public Bundle confirmCredentials(AccountAuthenticatorResponse response, Account account, Bundle options)
            throws NetworkErrorException {
        return null;
    }

    @Override
    public Bundle updateCredentials(AccountAuthenticatorResponse response, Account account,
                                    String authTokenType, Bundle options)
            throws NetworkErrorException {
        return null;
    }
}
