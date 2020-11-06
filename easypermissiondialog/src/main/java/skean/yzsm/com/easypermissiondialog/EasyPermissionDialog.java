package skean.yzsm.com.easypermissiondialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static skean.yzsm.com.easypermissiondialog.EasyPermissionDialog.DenyType.*;
import static skean.yzsm.com.easypermissiondialog.EasyPermissionDialog.ContainerType.*;

/**
 * 权限设置Dialog
 */

public class EasyPermissionDialog {

    @IntDef({NEVER, TEMP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DenyType {
        int NEVER = 1;
        int TEMP = 2;
    }

    @IntDef({ACTIVITY, FRAGMENT, ANDROIDX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ContainerType {
        int ACTIVITY = 1;
        int FRAGMENT = 2;
        int ANDROIDX = 3;
    }

    public interface Callback {
        void onResult(boolean allow);
    }

    private Context context;
    private Object container;
    @ContainerType
    private int containerType;
    private int requestCode;
    private int denyType;
    private String title;
    private String content;
    private String positiveText;
    private String negativeText;
    private boolean darkTheme = false;
    private Callback callback;
    private String[] permissions;

    public static EasyPermissionDialog build(Activity activity) {
        return new EasyPermissionDialog(activity, ACTIVITY, activity);
    }

    public static EasyPermissionDialog build(Fragment fragment) {
        return new EasyPermissionDialog(fragment, ANDROIDX, fragment.getActivity());
    }

    public static EasyPermissionDialog build(android.app.Fragment fragment) {
        return new EasyPermissionDialog(fragment, FRAGMENT, fragment.getActivity());
    }

    private EasyPermissionDialog(Object container, @ContainerType int containerType, Context context) {
        this.container = container;
        this.containerType = containerType;
        this.context = context;
    }

    public EasyPermissionDialog permissions(String... permissions) {
        this.permissions = permissions;
        return this;
    }

    public EasyPermissionDialog typeTemporaryDeny(Callback callback) {
        denyType = TEMP;
        this.callback = callback;
        return this;
    }

    public EasyPermissionDialog typeNeverAsk(int requestCode, Callback callback) {
        denyType = NEVER;
        this.requestCode = requestCode;
        this.callback = callback;
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

    public EasyPermissionDialog content(String content) {
        this.title = content;
        return this;
    }

    public EasyPermissionDialog content(int contentRes) {
        content = context.getString(contentRes);
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

    public void show() {
        if (denyType == 0) throw new RuntimeException("请指定权限的拒绝类型");
        init();
        showDialog();
    }

    private void init() {
        if (title == null) title = context.getString(R.string.epdPermissionDenyTitle);
        if (content == null) {
            if (denyType == TEMP) content = context.getString(R.string.epdRequestPermissionTips, permissionText());
            else content = context.getString(R.string.epdPermissionNeverGrantedTips, permissionText());
        }
        if (positiveText == null) {
            if (denyType == TEMP) positiveText = context.getString(R.string.epdRequestGive);
            else positiveText = context.getString(R.string.epdGoSetting);
        }
        if (negativeText == null) negativeText = context.getString(R.string.epdRequestDeny);
    }

    private String permissionText() {
        if (permissions == null || permissions.length == 0) return "";
        else {
            StringBuilder sb = new StringBuilder(": ");
            for (String permission : permissions) {
                sb.append(PermissionTextUtil.getDescription(permission)).append("/");
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
    }

    private void showDialog() {
        int theme = darkTheme ? R.style.Theme_MaterialComponents_Dialog_Alert : R.style.Theme_MaterialComponents_Light_Dialog_Alert;
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context, theme);
        builder.setTitle(title)
               .setMessage(content)
               .setCancelable(false)
               .setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       if (denyType == TEMP) {
                           if (callback != null) callback.onResult(true);
                       }
                       else {
                           if (callback != null) callback.onResult(true);
                           goToSetting();
                       }
                   }
               })
               .setNegativeButton(negativeText, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       if (denyType == TEMP) {
                           if (callback != null) callback.onResult(false);
                       }
                       else {
                           if (callback != null) callback.onResult(false);
                       }
                   }
               })
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
            switch (containerType) {
                case ContainerType.ACTIVITY:
                    ((Activity) container).startActivityForResult(intent, requestCode);
                    break;
                case ContainerType.ANDROIDX:
                    ((Fragment) container).startActivityForResult(intent, requestCode);
                    break;
                case ContainerType.FRAGMENT:
                    ((android.app.Fragment) container).startActivityForResult(intent, requestCode);
                    break;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
