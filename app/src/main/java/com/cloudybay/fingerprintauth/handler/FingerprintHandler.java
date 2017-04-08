package com.cloudybay.fingerprintauth.handler;


import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.support.annotation.RequiresApi;
import android.widget.TextView;

@RequiresApi(api = Build.VERSION_CODES.M)
public class FingerprintHandler extends FingerprintManager.AuthenticationCallback {
    private TextView tv;
    public FingerprintHandler(TextView tv) {
        this.tv = tv;
    }
    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {
        super.onAuthenticationError(errorCode, errString);
        tv.setText("Auth error");
    }
    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
        super.onAuthenticationHelp(helpCode, helpString);
    }
    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        super.onAuthenticationSucceeded(result);
        tv.setText("auth ok");
        tv.setTextColor(tv.getContext().getResources().
                getColor(android.R.color.holo_green_light));
    }
    @Override
    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();
    }
    public void doAuth(FingerprintManager manager,
                       FingerprintManager.CryptoObject obj) {
        CancellationSignal signal = new CancellationSignal();
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                manager.authenticate(obj, signal, 0, this, null);
            }
        }
        catch(SecurityException sce) {}
    }
}