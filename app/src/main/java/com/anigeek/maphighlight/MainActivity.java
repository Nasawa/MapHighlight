package com.anigeek.maphighlight;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.canvasview).setOnTouchListener(new View.OnTouchListener()
		{
			@Override
			public boolean onTouch(View v, MotionEvent m)
			{
				CanvasView cv = (CanvasView)v;
				Room r = cv.selectRoom((int)m.getX(), (int)m.getY());
				if(r != null)
					Snackbar.make(cv, r.toString(), Snackbar.LENGTH_LONG).show();

				return false;
			}
		});
	}
}
