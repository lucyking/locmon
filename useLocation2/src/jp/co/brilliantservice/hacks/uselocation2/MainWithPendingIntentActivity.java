package jp.co.brilliantservice.hacks.uselocation2;

import jp.co.brilliantservice.hacks.uselocation.R;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainWithPendingIntentActivity extends Activity {

//    private static final String LOG_TAG = "UseLocation";
	
	

	

    // LocationManagerの取得
    LocationManager mLocationManager = null;

    PendingIntent pendingIntent = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
         

        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        int requestCode = 0x432f;

        Intent intent = new Intent(this, Receiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, requestCode, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        // LocationListenerを登録
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5*60*1000, 0.0F,
                pendingIntent);


       /* 
    	Button button = (Button)findViewById(R.id.button1);      //add_button
    	button.setOnClickListener(new View.OnClickListener() {   //set button_methon
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				//Receiver.myPhone = (String)findViewById(R.id.editText1);
			    //((TextView) findViewById(R.id.textView1)).setText(Receiver.myPhone);
			}
		});
     */
    }

    public boolean onCreateOptionsMenu(Menu menu){             //menu
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.mainmenu,menu);
    	return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item){
    	switch (item.getItemId()){
    	case R.id.item1:
    		setContentView(R.layout.main);
    		return true;
    		
    	case R.id.item2:
    		setContentView(R.layout.add);
    		return true;
    
    		
    	case R.id.item3:
    		//EditText lat=(EditText)findViewById(R.id.editText1);
    	 	//String _lat=lat.getText().toString();
    	 	
    	 	
    		
    		//((TextView) findViewById(R.id.textView1)).setText(_lat); //assign the display PhNumber
    	
    		
    		return true;
    	default:
    		return true;
    	}
    }
    
    
 

    
    @Override
    public void onPause() {
        super.onPause();
        mLocationManager.removeUpdates(pendingIntent);
        // mLocationManager.removeProximityAlert(pendingIntent);
    }
    
    
    
}
