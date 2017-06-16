package skean.yzsm.com.epdexample;

import android.Manifest;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;

import skean.yzsm.com.easypermissiondialog.EasyPermissionDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeEN();
    }

    private void changeEN() {
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.setLocale(Locale.ENGLISH); // API 17+ only.
        res.updateConfiguration(conf, dm);
    }

    public void tempClick(View view) {
        EasyPermissionDialog.build(this)
                            .permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CALL_PHONE)
                            .typeTemporaryDeny(new EasyPermissionDialog.RequestCallback() {
                                @Override
                                public void onDeny() {
                                    Toast.makeText(getApplicationContext(), "拒绝", Toast.LENGTH_SHORT)
                                         .show();
                                }

                                @Override
                                public void onAllow() {
                                    Toast.makeText(getApplicationContext(), "允许", Toast.LENGTH_SHORT)
                                         .show();
                                }
                            })
                            .show();
    }

    public void neverClick(View view) {
        EasyPermissionDialog.build(this)
                            .permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CALL_PHONE)
                            .typeNeverAsk(1, new EasyPermissionDialog.GoSettingCallback() {
                                @Override
                                public void onDeny() {
                                    Toast.makeText(getApplicationContext(), "拒绝", Toast.LENGTH_SHORT)
                                         .show();
                                }

                            })
                            .show();

    }

}
