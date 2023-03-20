package com.skillz.android.shellgame1.authentication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SkillzAuthenticatorService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        SkillzAuthenticator authenticator = new SkillzAuthenticator(this);
        return authenticator.getIBinder();
    }
}