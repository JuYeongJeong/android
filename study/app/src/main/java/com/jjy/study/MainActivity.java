package com.jjy.study;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick( View v )
    {
        switch( v.getId() )
        {
            // 1. 카운트 시작
            // ================================================================
            case R.id.start_count_btn:
            {
                Intent serviceIntent =
                        new Intent(this,CountService.class);

                startService( serviceIntent );

                break;
            }
            // ================================================================

            // 2. 카운트 종료
            // ================================================================
            case R.id.stop_count_btn:
            {
                Intent serviceIntent =
                        new Intent(this,CountService.class);

                stopService( serviceIntent );
                break;
            }
            // ================================================================

            // 3. 현재까지 카운트 된 수치 보기
            // ================================================================
            case R.id.show_cur_number_btn:
            {
                break;
            }
            // ================================================================
        }
    }
}
