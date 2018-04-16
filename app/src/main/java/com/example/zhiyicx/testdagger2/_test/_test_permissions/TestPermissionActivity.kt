package com.example.zhiyicx.testdagger2._test._test_permissions

import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.zhiyicx.testdagger2.R
import kotlinx.android.synthetic.main.activity_test_permission.*

class TestPermissionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_permission)

        btn.setOnClickListener {

            if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission_group.STORAGE) == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "todp !", Toast.LENGTH_SHORT).show()
//                TODO()
            }else{
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), 0)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        for (granted in grantResults){
            if (granted == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "todp !", Toast.LENGTH_SHORT).show()
//                TODO()
            }else{
                Toast.makeText(this, " not todp !", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
