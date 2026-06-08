package skean.yzsm.com.easypermissiondialog;

import android.content.Context;

import com.hjq.permissions.permission.PermissionNames;
import com.hjq.permissions.permission.base.IPermission;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import androidx.annotation.NonNull;

public final class PermissionNameConvert {

    public static String getPermissionNames(Context context, List<IPermission> permissions) {
        return listToString(context, permissionsToNames(context, permissions).values());
    }

    public static String listToString(Context context, Collection<String> hints) {
        if (hints == null || hints.isEmpty()) {
            return context.getString(R.string.common_permission_unknown);
        }
        StringBuilder builder = new StringBuilder();
        for (String text : hints) {
            if (builder.length() > 0) builder.append("、");
            builder.append(text);
        }
        return builder.toString();
    }

    @NonNull
    public static LinkedHashMap<String, String> permissionsToNames(Context context, List<IPermission> permissions) {
        LinkedHashMap<String, String> permissionNames = new LinkedHashMap<>();
        if (context == null || permissions == null) return permissionNames;

        for (IPermission p : permissions) {
            String hint = null;
            switch (p.getPermissionName()) {
                // 基础权限
                case PermissionNames.CAMERA:
                    hint = context.getString(R.string.common_permission_camera);
                    break;
                case PermissionNames.RECORD_AUDIO:
                    hint = context.getString(R.string.common_permission_microphone);
                    break;
                case PermissionNames.READ_EXTERNAL_STORAGE:
                case PermissionNames.WRITE_EXTERNAL_STORAGE:
                    hint = context.getString(R.string.common_permission_storage);
                    break;
                case PermissionNames.ACCESS_FINE_LOCATION:
                case PermissionNames.ACCESS_COARSE_LOCATION:
                case PermissionNames.ACCESS_BACKGROUND_LOCATION:
                    hint = context.getString(R.string.common_permission_location);
                    break;

                // 通信权限
                case PermissionNames.READ_PHONE_STATE:
                case PermissionNames.CALL_PHONE:
                case PermissionNames.READ_PHONE_NUMBERS:
                case PermissionNames.ANSWER_PHONE_CALLS:
                    hint = context.getString(R.string.common_permission_phone);
                    break;
                case PermissionNames.SEND_SMS:
                case PermissionNames.READ_SMS:
                case PermissionNames.RECEIVE_SMS:
                    hint = context.getString(R.string.common_permission_sms);
                    break;

                // 蓝牙 & WIFI
                case PermissionNames.BLUETOOTH_SCAN:
                case PermissionNames.BLUETOOTH_CONNECT:
                case PermissionNames.BLUETOOTH_ADVERTISE:
                case PermissionNames.NEARBY_WIFI_DEVICES:
                    hint = context.getString(R.string.common_permission_nearby_devices);
                    break;

                // 特殊权限
                case PermissionNames.MANAGE_EXTERNAL_STORAGE:
                    hint = context.getString(R.string.common_permission_all_file_access);
                    break;
                case PermissionNames.REQUEST_INSTALL_PACKAGES:
                    hint = context.getString(R.string.common_permission_install_unknown_apps);
                    break;
                case PermissionNames.SYSTEM_ALERT_WINDOW:
                    hint = context.getString(R.string.common_permission_display_over_other_apps);
                    break;
                case PermissionNames.POST_NOTIFICATIONS:
                    hint = context.getString(R.string.common_permission_post_notifications);
                    break;

                // 健康数据相关 (聚合处理)
                case PermissionNames.READ_STEPS:
                case PermissionNames.WRITE_STEPS:
                case PermissionNames.READ_DISTANCE:
                    hint = context.getString(R.string.common_permission_health_steps);
                    break;
                case PermissionNames.READ_HEART_RATE:
                case PermissionNames.WRITE_HEART_RATE:
                case PermissionNames.READ_HEART_RATE_VARIABILITY:
                    hint = context.getString(R.string.common_permission_health_heart_rate);
                    break;
                case PermissionNames.READ_SLEEP:
                case PermissionNames.WRITE_SLEEP:
                    hint = context.getString(R.string.common_permission_health_sleep);
                    break;
                case PermissionNames.READ_BLOOD_GLUCOSE:
                case PermissionNames.WRITE_BLOOD_GLUCOSE:
                case PermissionNames.READ_BLOOD_PRESSURE:
                case PermissionNames.WRITE_BLOOD_PRESSURE:
                    hint = context.getString(R.string.common_permission_health_blood_glucose);
                    break;
                case PermissionNames.READ_BODY_FAT:
                case PermissionNames.WRITE_BODY_FAT:
                case PermissionNames.READ_WEIGHT:
                case PermissionNames.WRITE_WEIGHT:
                    hint = context.getString(R.string.common_permission_health_weight);
                    break;

                // 医疗记录
                case PermissionNames.READ_MEDICAL_DATA_ALLERGIES_INTOLERANCES:
                case PermissionNames.READ_MEDICAL_DATA_CONDITIONS:
                case PermissionNames.WRITE_MEDICAL_DATA:
                    hint = context.getString(R.string.common_permission_medical_records);
                    break;

                // 应用列表
                case PermissionNames.GET_INSTALLED_APPS:
                    hint = context.getString(R.string.common_permission_installed_apps);
                    break;
            }

            if (hint != null && !permissionNames.containsValue(hint)) {
                permissionNames.put(p.getPermissionName(), hint);
            }
        }
        return permissionNames;
    }
}