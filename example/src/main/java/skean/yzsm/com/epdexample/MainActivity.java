package skean.yzsm.com.epdexample;

import android.Manifest;
import android.content.res.Resources;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

import skean.yzsm.com.easypermissiondialog.EasyPermissionDialog;

public class MainActivity extends AppCompatActivity {

    private HashMap<String, String> permissionDesc = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeEN();
        permissionDesc.put(Manifest.permission.WRITE_EXTERNAL_STORAGE, "为了存储图片");
        permissionDesc.put(Manifest.permission.CALL_PHONE, "为了打电话");
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
                            .darkTheme()
                            .permissionDesc(permissionDesc)
                            .permissions(Arrays.asList(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CALL_PHONE))
                            .show(false, new EasyPermissionDialog.Callback() {
                                @Override
                                public void onResult(boolean allow) {
                                    if (allow) Toast.makeText(getApplicationContext(), "允许", Toast.LENGTH_SHORT).show();
                                    else Toast.makeText(getApplicationContext(), "拒绝", Toast.LENGTH_SHORT).show();
                                }
                            });
    }

    public void neverClick(View view) {
        EasyPermissionDialog.build(this)
                            .lightTheme()
                            .permissionDesc(permissionDesc)
                            .permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CALL_PHONE)
                            .show(true, new EasyPermissionDialog.Callback() {
                                @Override
                                public void onResult(boolean allow) {
                                    if (allow) Toast.makeText(getApplicationContext(), "允许", Toast.LENGTH_SHORT).show();
                                    else Toast.makeText(getApplicationContext(), "拒绝", Toast.LENGTH_SHORT).show();
                                }
                            });

    }

}
