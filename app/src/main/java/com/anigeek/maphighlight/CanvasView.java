package com.anigeek.maphighlight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class CanvasView extends View
{
	private Paint p;
	ArrayList<Room> rooms;
	Context context;

	public CanvasView(Context context, AttributeSet att)
	{
		super(context, att);
		this.context = context;

		p = new Paint();
		addRooms();
	}

	public void addRooms()
	{
		rooms = new ArrayList<>();
		Rect bedroom = new Rect(50,180,260,395);//left,top,right,bottom
		Rect utility = new Rect(600,180,682,230);
		rooms.add(new Room("Bedroom", bedroom, false));
		rooms.add(new Room("Utility", utility, true));
	}

	public Room selectRoom(int x, int y)
	{
		for(Room r : rooms)
		{
			if(r.getRect().contains(x, y))
				return r;
		}
		return null;
	}

	@Override
	synchronized public void onDraw(Canvas c)
	{
		p.setStyle(Paint.Style.FILL_AND_STROKE);
		p.setAlpha(100);
		p.setStrokeWidth(5);

		for(Room r : rooms)
		{
			if(r.isReserved())
				p.setColor(Color.argb(100, 255, 0, 0));
			else
				p.setColor(Color.argb(100, 0, 255, 0));

			c.drawRect(r.getRect(), p);
		}
	}
}
