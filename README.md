# EasyPermissionDialog

#####便利的对话框提示应用的权限请求

1.临时拒绝权限的情况

``` 
          EasyPermissionDialog.build(this)
                            .permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CALL_PHONE)
                            .typeTemporaryDeny(new EasyPermissionDialog.RequestCallback() {
                                @Override
                                public void onDeny() {
                                }

                                @Override
                                public void onAllow() {
                                }
                            })
                            .show();
```
2.永久拒绝权限的情况

```
         EasyPermissionDialog.build(this)
                            .permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CALL_PHONE)
                            .typeNeverAsk(1, new EasyPermissionDialog.GoSettingCallback() {
                                @Override
                                public void onDeny() {
                                }

                            })
                            .show();
```