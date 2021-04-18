package dawish.leet.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import dawish.leet.DLog;
import dawish.leet.R;
import dawish.leet.android.AsyncLayoutInflatePlus;
import dawish.leet.Solution.baseModule.IntHandle;
import dawish.leet.Solution.baseModule.Search;
import dawish.leet.Solution.baseModule.Sort;
import dawish.leet.Solution.baseModule.ArrayHandle;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initPart1();
        initPart2();
    }

    private void initPart1(){
        View view = findViewById(R.id.tv);

        final AsyncLayoutInflatePlus asyncLayoutInflatePlus = new AsyncLayoutInflatePlus(MainActivity.this);

        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View v) {
                Log.d("MainActivity", "onInflateFinished");
                asyncLayoutInflatePlus.inflate(R.layout.activity_async, (ViewGroup) getWindow().getDecorView(), new AsyncLayoutInflatePlus.OnInflateFinishedListener(){
                    @Override
                    public void onInflateFinished(@NonNull View view, int resid, @Nullable ViewGroup parent) {
                        Log.d("MainActivity", "onInflateFinished");
                        parent.addView(view);
                    }
                });

                int[] array ={1,2,3,4,6,7,9,11,20};

                Log.e(TAG, "binSearch rst:"+Search.binSearch(9, array));

                int[] arr = { 11, 3, 29, 49, 30, 7, 50, 63, 46, 1, 99 };
                int[] quickSort = Sort.quickSort(arr, 0, arr.length - 1);
                int quickSortLength= quickSort.length;
                StringBuffer stringBuffer = new StringBuffer();
                for(int  i=0; i <quickSortLength; i++){
                    stringBuffer.append(quickSort[i]).append("  ");
                }

                Log.e(TAG, stringBuffer.toString());


                //Object[] srtings = { "ad", "bd", "aa", "vv", "aa", "xx" };
                Object[] srtings = { 2, 4, 1, 6, 3, 8, 6 };
                Object[] uniqueString = ArrayHandle.unique(srtings);
                stringBuffer.setLength(0);
                stringBuffer.append("StringHandle.unique:");
                for(Object s : uniqueString){
                    stringBuffer.append(s).append(" ");
                }
                Log.e(TAG, stringBuffer.toString());

                Object[] uniqueString2 = ArrayHandle.unique2(srtings);
                stringBuffer.setLength(0);
                stringBuffer.append("StringHandle.unique2:");
                for(Object s : uniqueString2){
                    stringBuffer.append(s).append(" ");
                }
                Log.e(TAG, stringBuffer.toString());

                Log.e(TAG, "one count:"+IntHandle.getOneCount(5));

            }
        });
    }

    protected ServiceConnection mConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            DLog.D(TAG, "onServiceConnected name:"+name.getClassName());
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private void initPart2(){
        findViewById(R.id.bind).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                // 绑定一个不存在的Service
                intent.setClassName(MainActivity.this, "com.dxx.test.NullService");
                bindService(intent, mConn, BIND_AUTO_CREATE);
                DLog.D(TAG, "bindService");

                intent.setClass(MainActivity.this, HookActivity.class);
                startActivity(intent);

            }
        });
    }

    /**
     * 在manifast文件中配置config以后只会调用这个地方
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }
}
