package skean.yzsm.com.easypermissiondialog;

import android.content.Intent;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;

/**
 * Created by Skean on 22/2/27.
 */
public class ToSettingFakeFragment extends Fragment {

    private EasyPermissionDialog.Callback innerCallback;
    private List<String> permissions;

    public ToSettingFakeFragment(EasyPermissionDialog.Callback innerCallback, List<String> permissions) {
        this.innerCallback = innerCallback;
        this.permissions = permissions;
    }

    public ToSettingFakeFragment() {
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (innerCallback != null) innerCallback.onResult(haveAllPermission());
    }

    private boolean haveAllPermission() {
        boolean haveAll = true;
        for (String permission : permissions) {
            try {
                haveAll = PermissionChecker.checkSelfPermission(requireContext(), permission) == PermissionChecker.PERMISSION_GRANTED;
            }
            catch (RuntimeException t) {
                haveAll = false;
            }
            if (!haveAll) break;
        }
        return haveAll;
    }

}
