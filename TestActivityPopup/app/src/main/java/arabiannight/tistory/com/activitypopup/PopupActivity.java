package arabiannight.tistory.com.activitypopup;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

public class PopupActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		WindowManager.LayoutParams layoutParams= new WindowManager.LayoutParams();
//팝업 외부 뿌연 효과
		layoutParams.flags= WindowManager.LayoutParams.FLAG_DIM_BEHIND |  WindowManager.LayoutParams.FLAG_FULLSCREEN ;
//뿌연 효과 정도
		layoutParams.dimAmount= 0.7f;
//적용

		layoutParams.gravity = Gravity.CENTER;

		getWindow().setGravity(Gravity.CENTER);
		getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLUE));

		getWindow().setAttributes(layoutParams);


		setContentView(R.layout.popup_activity);
	}
	
}
