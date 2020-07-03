package dawish.leet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import dawish.leet.Solution.android.AsyncLayoutInflatePlus;
import dawish.leet.Solution.baseModule.Search;
import dawish.leet.Solution.baseModule.Sort;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.tv);
        view.getWidth();
        view.getHeight();



        final long mLastFrameTime;
        final int mFrameCount;
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
            @Override
            public void doFrame(long frameTimeNanos) {
            }
        });

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
                Log.e(TAG, "quickSort :"+stringBuffer.toString());

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
