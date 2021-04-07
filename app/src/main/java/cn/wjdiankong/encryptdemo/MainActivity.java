package cn.wjdiankong.encryptdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean cmp = isEquals("0195639014");    /*0123456789==>ssVpPCqinB(测试)  0195639014==>ssBCqpBssP(正确*/
                Toast.makeText(MainActivity.this, "isEquals Success...", Toast.LENGTH_SHORT).show();
                Log.i("jw", "cmp: " + cmp);
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    private native boolean isEquals(String str);
}