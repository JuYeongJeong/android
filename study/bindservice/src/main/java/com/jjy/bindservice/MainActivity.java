package com.jjy.bindservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    private ServiceConnection mConnection = new ServiceConnection()
    {

        @Override
        public void onServiceConnected( ComponentName name,
                                        IBinder service )
        {
            Log.d( TAG, "onServiceConnected()" );

            //mBinder = ICountService.Stub.asInterface( service );
        }

        @Override
        public void onServiceDisconnected( ComponentName name )
        {
            Log.d( TAG, "onServiceDisconnected()" );
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 카운트 서비스 연결
        // ====================================================================
        Intent serviceIntent =
                new Intent(this, CountService.class);
        bindService( serviceIntent, mConnection, BIND_AUTO_CREATE );
        // ====================================================================
    }

    @Override
    protected void onDestroy() {
        // 카운트 서비스 해제
        // ====================================================================
        unbindService( mConnection );
        // ====================================================================
        super.onDestroy();
    }


    public void onClick( View v )
    {
        switch( v.getId() )
        {
            // 1. 카운트 서비스 시작
            // ================================================================
            case R.id.start_count_btn:
            {
                Intent serviceIntent =
                        new Intent(this, CountService.class);
                startService( serviceIntent );

                break;
            }
            // ================================================================

            // 2. 카운트 서비스 종료
            // ================================================================
            case R.id.stop_count_btn:
            {
                Intent serviceIntent =
                        new Intent(this, CountService.class);
                stopService( serviceIntent );
                break;
            }
            // ================================================================

            // 3. 바인딩된 서비스에 현재까지 증가된 수 얻어오기
            // ================================================================
            case R.id.get_cur_count_number_btn:
            {
               /* int curCountNumber;
                try
                {
                    curCountNumber = mBinder.getCurCountNumber();

                    Toast.makeText( this,
                            "Cur Count : " + curCountNumber,
                            Toast.LENGTH_LONG ).show();
                }
                catch ( RemoteException e )
                {
                    e.printStackTrace();
                }*/


                break;
            }
            // ================================================================
        }
    }
}
