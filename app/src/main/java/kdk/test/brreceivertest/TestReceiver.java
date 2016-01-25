package kdk.test.brreceivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by mypc on 2015-12-01.
 */
public class TestReceiver extends BroadcastReceiver {

  public OnGazeReceivedListener listener = null;

  public interface OnGazeReceivedListener {
    public void onGazeReceived(int x, int y);
  }

  public void setOnGazeReceivedListener(Context context) {
    this.listener = (OnGazeReceivedListener) context;
  }

  @Override
  public void onReceive(Context context, Intent intent) {
    int x = intent.getIntExtra("gazePoint_x", 0);
    int y = intent.getIntExtra("gazePoint_y",0);
    long stampTime = intent.getLongExtra("timeStamp",0);

    if(x !=0 && y != 0)
      Log.d("gazePoint","GazePoint (X,Y):("+ x+" , "+y+")");

    if(listener != null) {
      listener.onGazeReceived(x,y);
    }

  }
}
