package skean.yzsm.com.easypermissiondialog;

import android.content.Context;
import android.util.ArrayMap;

import com.hjq.permissions.permission.base.IPermission;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;

/**
 * author : Android 轮子哥
 * github : https://github.com/getActivity/XXPermissions
 * time   : 2023/01/02
 * desc   : 权限描述转换器
 */
public final class PermissionDescriptionConvert {

    /**
     * 获取权限描述
     */
    public static String getPermissionDescription(Context context, List<IPermission> permissions, Map<String, String> permissionDesc) {
        StringBuilder stringBuilder = new StringBuilder();
        LinkedHashMap<String, String> permissionNames = PermissionNameConvert.permissionsToNames(context, permissions);
        for (Map.Entry<String, String> permissionName : permissionNames.entrySet()) {
            stringBuilder.append(permissionName.getValue());
            if (permissionDesc.containsKey(permissionName.getKey())) {
                stringBuilder.append(":").append(permissionDesc.get(permissionName.getKey()));
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString().trim();
    }

}