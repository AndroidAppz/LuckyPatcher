/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment
 *  java.lang.Object
 *  java.lang.Package
 *  java.lang.String
 */
package com.chelpus;

import android.os.Build;
import com.android.vending.billing.InAppBillingService.LOCK.listAppsFragment;

public class Common {
    public static final String ACTION_BACKUP_APK_FILE = "xinstaller.intent.action.BACKUP_APK_FILE";
    public static final String ACTION_BACKUP_PREFERENCES = "xinstaller.intent.action.BACKUP_PREFERENCES";
    public static final String ACTION_DELETE_APK_FILE = "xinstaller.intent.action.DELETE_APK_FILE";
    public static final String ACTION_RESET_PREFERENCES = "xinstaller.intent.action.RESET_PREFERENCES";
    public static final String ACTION_RESTORE_PREFERENCES = "xinstaller.intent.action.RESTORE_PREFERENCES";
    public static final String ACTION_UNINSTALL_SYSTEM_APP = "xinstaller.intent.action.UNINSTALL_SYSTEM_APP";
    public static final String ANDROID_PKG = "android";
    public static final String BACKUPCONFIRM_PKG = "com.android.backupconfirm";
    public static final String BACKUPRESTORECONFIRMATION = "com.android.backupconfirm.BackupRestoreConfirmation";
    public static final String CANBEONSDCARDCHECKER = "com.android.settings.applications.CanBeOnSdCardChecker";
    public static final int DEBUG_ENABLE_DEBUGGER = 1;
    public static final int DELETE_KEEP_DATA = 1;
    public static final String DEVICEPOLICYMANAGERSERVICE;
    public static final String FDROIDAPPDETAILS = "org.fdroid.fdroid.AppDetails";
    public static final String FDROID_PKG = "org.fdroid.fdroid";
    public static final String FILE = "file";
    public static final String GOOGLEPLAY_PKG = "com.android.vending";
    public static final String INSTALLAPPPROGRESS = "com.android.packageinstaller.InstallAppProgress";
    public static final String INSTALLEDAPPDETAILS = "com.android.settings.applications.InstalledAppDetails";
    public static final int INSTALL_ALLOW_DOWNGRADE = 128;
    public static final int INSTALL_EXTERNAL = 8;
    public static final int INSTALL_FORWARD_LOCK = 1;
    public static final int INSTALL_SUCCEEDED = 1;
    public static final int InAppServ = 0;
    public static final String JARVERIFIER = "java.util.jar.JarVerifier$VerifierEntry";
    public static final boolean JB_MR1_NEWER = false;
    public static final boolean JB_MR2_NEWER = false;
    public static final boolean JB_NEWER = false;
    public static final boolean KITKAT_NEWER = false;
    public static final int LATEST_ANDROID_RELEASE = 21;
    public static final boolean LOLLIPOP_NEWER = false;
    public static final int LicServ = 1;
    public static final String PACKAGE = "package";
    public static final String PACKAGEINSTALLERACTIVITY = "com.android.packageinstaller.PackageInstallerActivity";
    public static final String PACKAGEINSTALLER_PKG = "com.android.packageinstaller";
    public static final String PACKAGEMANAGERREPOSITORY = "com.google.android.finsky.appstate.PackageManagerRepository";
    public static final String PACKAGEMANAGERSERVICE = "com.android.server.pm.PackageManagerService";
    public static final String PACKAGEPARSER = "android.content.pm.PackageParser";
    public static final String PACKAGE_NAME;
    public static final String PACKAGE_PREFERENCES;
    public static final String PACKAGE_TAG = "XInstaller";
    public static final int PMcontext = 2;
    public static final String PREFERENCE = "preference";
    public static final String PREF_DISABLE_CHECK_DUPLICATED_PERMISSION = "disable_check_duplicated_permissions";
    public static final String PREF_DISABLE_CHECK_PERMISSION = "disable_check_permissions";
    public static final String PREF_DISABLE_CHECK_SDK_VERSION = "disable_check_sdk_version";
    public static final String PREF_DISABLE_CHECK_SIGNATURE = "disable_check_signatures";
    public static final String PREF_DISABLE_CHECK_SIGNATURE_FDROID = "disable_check_signatures_fdroid";
    public static final String PREF_DISABLE_FORWARD_LOCK = "disable_forward_lock";
    public static final String PREF_DISABLE_INSTALL_BACKGROUND = "disable_install_background";
    public static final String PREF_DISABLE_UNINSTALL_BACKGROUND = "disable_uninstall_background";
    public static final String PREF_DISABLE_VERIFY_APP = "disable_verify_apps";
    public static final String PREF_DISABLE_VERIFY_JAR = "disable_verify_jar";
    public static final String PREF_DISABLE_VERIFY_SIGNATURE = "disable_verify_signatures";
    public static final String PREF_ENABLED_DOWNGRADE_APP = "enable_downgrade_apps";
    public static final String PREF_ENABLE_AUTO_BACKUP = "enable_auto_backup";
    public static final String PREF_ENABLE_AUTO_CLOSE_INSTALL = "enable_auto_close_install";
    public static final String PREF_ENABLE_AUTO_CLOSE_UNINSTALL = "enable_auto_close_uninstall";
    public static final String PREF_ENABLE_AUTO_ENABLE_CLEAR_BUTTON = "enable_auto_enable_clear_buttons";
    public static final String PREF_ENABLE_AUTO_HIDE_INSTALL = "enable_auto_hide_install";
    public static final String PREF_ENABLE_AUTO_INSTALL = "enable_auto_install";
    public static final String PREF_ENABLE_AUTO_UNINSTALL = "enable_auto_uninstall";
    public static final String PREF_ENABLE_BACKUP_APK_FILE = "enable_backup_apk_files";
    public static final String PREF_ENABLE_BACKUP_APP_PACKAGE = "enable_backup_app_packages";
    public static final String PREF_ENABLE_DEBUG_APP = "enable_debug_apps";
    public static final String PREF_ENABLE_DELETE_APK_FILE_INSTALL = "enable_delete_apk_files_install";
    public static final String PREF_ENABLE_DISABLE_SYSTEM_APP = "enable_disable_system_apps";
    public static final String PREF_ENABLE_EXPERT_MODE = "enable_expert_mode";
    public static final String PREF_ENABLE_EXPORT_APP = "enable_export_apps";
    public static final String PREF_ENABLE_INSTALL_EXTERNAL_STORAGE = "enable_install_external_storage";
    public static final String PREF_ENABLE_INSTALL_UNKNOWN_APP = "enable_install_unknown_apps";
    public static final String PREF_ENABLE_INSTALL_UNSIGNED_APP = "enable_install_unsigned_apps";
    public static final String PREF_ENABLE_KEEP_APP_DATA = "enable_keep_apps_data";
    public static final String PREF_ENABLE_LAUNCH_APP = "enable_launch_apps";
    public static final String PREF_ENABLE_LAUNCH_INSTALL = "enable_auto_launch_install";
    public static final String PREF_ENABLE_MODULE = "enable_module";
    public static final String PREF_ENABLE_MOVE_APP = "enable_move_apps";
    public static final String PREF_ENABLE_OPEN_APP_GOOGLE_PLAY = "enable_open_apps_google_play";
    public static final String PREF_ENABLE_SHOW_BUTTON = "enable_show_buttons";
    public static final String PREF_ENABLE_SHOW_PACKAGE_NAME = "enable_show_package_name";
    public static final String PREF_ENABLE_SHOW_VERSION = "enable_show_version";
    public static final String PREF_ENABLE_UNINSTALL_DEVICE_ADMIN = "enable_uninstall_device_admins";
    public static final String PREF_ENABLE_UNINSTALL_SYSTEM_APP = "enable_uninstall_system_apps";
    public static final int ROOT_UID = 0;
    public static final int SDK = 0;
    public static final String SETTINGS_PKG = "com.android.settings";
    public static final String SIGNATURE = "java.security.Signature";
    public static final String UNINSTALLAPPPROGRESS = "com.android.packageinstaller.UninstallAppProgress";
    public static final String UNINSTALLERACTIVITY = "com.android.packageinstaller.UninstallerActivity";
    public static final String UTILS = "com.android.settings.Utils";
    public static final String VALUE = "value";
    public static final int getPackageManagerF = 1;
    public static final int mBase;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = true;
        PACKAGE_NAME = listAppsFragment.class.getPackage().getName();
        PACKAGE_PREFERENCES = PACKAGE_NAME + "_preferences";
        SDK = Build.VERSION.SDK_INT;
        boolean bl2 = SDK >= 16 ? bl : false;
        JB_NEWER = bl2;
        boolean bl3 = SDK >= 17 ? bl : false;
        JB_MR1_NEWER = bl3;
        boolean bl4 = SDK >= 18 ? bl : false;
        JB_MR2_NEWER = bl4;
        boolean bl5 = SDK >= 19 ? bl : false;
        KITKAT_NEWER = bl5;
        if (SDK < 21) {
            bl = false;
        }
        String string = (Common.LOLLIPOP_NEWER = bl) ? "com.android.server.devicepolicy.DevicePolicyManagerService" : "com.android.server.DevicePolicyManagerService";
        DEVICEPOLICYMANAGERSERVICE = string;
    }
}

