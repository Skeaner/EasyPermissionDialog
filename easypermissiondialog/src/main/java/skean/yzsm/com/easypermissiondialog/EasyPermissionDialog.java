package skean.yzsm.com.easypermissiondialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限设置Dialog
 */

public class EasyPermissionDialog {

    public interface Callback {
        void onResult(boolean allow);
    }

    private Context context;
    private FragmentManager fragmentManager;
    private boolean doNotAskAgain;
    private String title;
    private String content;
    private Map<String, String> permissionDesc = new HashMap<>();
    private String positiveText;
    private String negativeText;
    private boolean darkTheme = false;
    private boolean autoGoToSetting = true;
    private boolean cancelable = true;
    private Callback callback;
    private DialogInterface.OnDismissListener dismissListener;

    private List<String> permissions;

    public static EasyPermissionDialog build(FragmentActivity activity) {
        return new EasyPermissionDialog(activity.getSupportFragmentManager(), activity);
    }

    public static EasyPermissionDialog build(Fragment fragment) {
        return new EasyPermissionDialog(fragment.getChildFragmentManager(), fragment.requireContext());
    }

    private EasyPermissionDialog(FragmentManager fragmentManager, Context context) {
        this.fragmentManager = fragmentManager;
        this.context = context;
    }

    public EasyPermissionDialog permissions(String... permissions) {
        this.permissions = Arrays.asList(permissions);
        return this;
    }

    public EasyPermissionDialog permissions(List<String> permissions) {
        this.permissions = permissions;
        return this;
    }

    public EasyPermissionDialog title(String title) {
        this.title = title;
        return this;
    }

    public EasyPermissionDialog title(int titleRes) {
        title = context.getString(titleRes);
        return this;
    }

    public EasyPermissionDialog permissionDesc(Map<String, String> permissionDesc) {
        this.permissionDesc = permissionDesc;
        return this;
    }

    public EasyPermissionDialog positiveText(String text) {
        positiveText = text;
        return this;
    }

    public EasyPermissionDialog positiveText(int textRes) {
        positiveText = context.getString(textRes);
        return this;
    }

    public EasyPermissionDialog negativeText(String text) {
        negativeText = text;
        return this;
    }

    public EasyPermissionDialog negativeText(int textRes) {
        negativeText = context.getString(textRes);
        return this;
    }

    public EasyPermissionDialog darkTheme() {
        darkTheme = true;
        return this;
    }

    public EasyPermissionDialog lightTheme() {
        darkTheme = false;
        return this;
    }

    public EasyPermissionDialog autoGoToSetting(boolean autoGoToSetting) {
        this.autoGoToSetting = autoGoToSetting;
        return this;
    }

    public EasyPermissionDialog cancelable(boolean cancelable) {
        this.cancelable = cancelable;
        return this;
    }

    public EasyPermissionDialog onDismiss(DialogInterface.OnDismissListener dismissListener) {
        this.dismissListener = dismissListener;
        return this;
    }

    public void show(boolean doNotAskAgain, Callback callback) {
        this.doNotAskAgain = doNotAskAgain;
        this.callback = callback;
        init();
        showDialog();
    }

    private void init() {
        if (title == null) title = context.getString(R.string.epdPermissionDenyTitle);
        if (content == null) {
            String desc = PermissionDescriptionConvert.getPermissionDescription(context, permissions, this.permissionDesc);
            if (!doNotAskAgain) content = context.getString(R.string.epdRequestPermissionTips, desc);
            else content = context.getString(R.string.epdPermissionNeverGrantedTips, desc);
        }
        if (positiveText == null) {
            if (!doNotAskAgain) positiveText = context.getString(R.string.epdRequestGive);
            else positiveText = context.getString(R.string.epdGoSetting);
        }
        if (negativeText == null) negativeText = context.getString(R.string.epdRequestDeny);
    }

    private void showDialog() {
        int theme = darkTheme ? R.style.Theme_MaterialComponents_Dialog_Alert : R.style.Theme_MaterialComponents_Light_Dialog_Alert;
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context, theme);
        builder.setTitle(title)
               .setMessage(content)
               .setCancelable(cancelable)
               .setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       if (!doNotAskAgain) {
                           if (callback != null) callback.onResult(true);
                       }
                       else {
                           if (autoGoToSetting) goToSetting();
                           else if (callback != null) callback.onResult(true);
                       }

                   }
               })
               .setNegativeButton(negativeText, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       if (callback != null) {
                           callback.onResult(false);
                       }
                   }
               })
               .setOnDismissListener(dismissListener)
               .show();
    }

    private void goToSetting() {
        if (isMIUI()) {
            try {
                // MIUI 8
                Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
                intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                intent.putExtra("extra_pkgname", context.getPackageName());
                startSettingActivity(intent);
            }
            catch (Exception e) {
                try {
                    // MIUI 5/6/7
                    Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
                    intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                    intent.putExtra("extra_pkgname", context.getPackageName());
                    startSettingActivity(intent);
                }
                catch (Exception e1) {
                    goToNormalSetting();
                }
            }
        }
        else {
            goToNormalSetting();
        }
    }

    private void goToNormalSetting() {
        try {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri = Uri.fromParts("package", context.getPackageName(), null);
            intent.setData(uri);
            startSettingActivity(intent);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断是否是MIUI
     */
    private boolean isMIUI() {
        return "Xiaomi".equalsIgnoreCase(Build.MANUFACTURER);
    }

    private void startSettingActivity(Intent intent) throws Exception {
        try {
            Fragment fragment = new ToSettingFakeFragment(callback, permissions);
            fragmentManager.beginTransaction().add(fragment, fragment.toString()).commitNow();
            fragment.startActivityForResult(intent, 1);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
