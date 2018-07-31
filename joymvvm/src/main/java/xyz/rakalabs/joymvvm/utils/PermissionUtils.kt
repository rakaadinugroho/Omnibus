package xyz.rakalabs.joymvvm.utils

import android.app.Activity
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import java.util.ArrayList

object PermissionUtils {
    fun requestPermission(activity: Activity, requestCode: Int, vararg permissions: String): Boolean {
        var granted = true
        val permissionsNeeded = ArrayList<String>()

        for (s in permissions) {
            val permissionCheck = ContextCompat.checkSelfPermission(activity, s)
            val hasPermission = permissionCheck == PackageManager.PERMISSION_GRANTED
            granted = granted and hasPermission
            if (!hasPermission) {
                permissionsNeeded.add(s)
            }
        }
        if (granted) {
            return true
        } else {
            ActivityCompat.requestPermissions(activity,
                    permissionsNeeded.toTypedArray(),
                    requestCode)
            return false
        }
    }

    fun permissionGranted(requestCode: Int, permissionCode: Int, grantResults: IntArray): Boolean {
        return if (requestCode == permissionCode) {
            grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
        } else false
    }
}