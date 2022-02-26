package skean.yzsm.com.easypermissiondialog;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.PermissionChecker;

/**
 * Created by Skean on 22/2/27.
 */
public class EasyPermissionDialogFragment extends Fragment {

    private EasyPermissionDialog.Callback innerCallback;
    private String[] permissions;

    @SuppressLint("ValidFragment")
    public EasyPermissionDialogFragment(EasyPermissionDialog.Callback innerCallback, String[] permissions) {
        this.innerCallback = innerCallback;
        this.permissions = permissions;
    }

    public EasyPermissionDialogFragment() {
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
