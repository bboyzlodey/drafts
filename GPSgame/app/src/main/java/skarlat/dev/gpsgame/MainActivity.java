package skarlat.dev.gpsgame;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKit;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.layers.ObjectEvent;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.CompositeIcon;
import com.yandex.mapkit.map.IconStyle;
import com.yandex.mapkit.map.RotationType;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.mapkit.user_location.UserLocationLayer;
import com.yandex.mapkit.user_location.UserLocationObjectListener;
import com.yandex.mapkit.user_location.UserLocationView;
import com.yandex.runtime.image.ImageProvider;

public class MainActivity extends AppCompatActivity implements UserLocationObjectListener {
	private final static String TAG = "MainActivity";
	public  static class MyLocationListener implements android.location.LocationListener {
		
		static android.location.Location imHere; // здесь будет всегда доступна самая последняя информация о местоположении пользователя.
		
		public static void SetUpLocationListener(Context context) // это нужно запустить в самом начале работы программы
		{
			android.location.LocationManager locationManager = (LocationManager)
					                                  context.getSystemService(Context.LOCATION_SERVICE);
			
			android.location.LocationListener locationListener = new MyLocationListener();
			
			locationManager.requestLocationUpdates(
					LocationManager.GPS_PROVIDER,
					5000,
					10,
					locationListener); // здесь можно указать другие более подходящие вам параметры
			
			imHere = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			Log.d(MainActivity.TAG, "Location");
		}
		
		@Override
		public void onLocationChanged(Location loc) {
			imHere = loc;
		}
		@Override
		public void onProviderDisabled(String provider) {}
		@Override
		public void onProviderEnabled(String provider) {}
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {}
	}

	private MapView mapview;
	private boolean showObjects = false;
	private UserLocationLayer userLocationLayer;
	private Button showBtn;
	private static final String MAPKIT_API_KEY = "9c26de41-ab93-4e3e-8220-33f04a1bf315";
	private final Point TARGET_LOCATION = new Point(59.945933, 30.320045);
	private final int MY_PERMISSION_REQUEST = 10;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		MapKitFactory.setApiKey(MAPKIT_API_KEY);
		MapKitFactory.initialize(this);
		// Укажите имя activity вместо map.
		setContentView(R.layout.activity_main);
		super.onCreate(savedInstanceState);
		locationRequest();
		MyLocationListener.SetUpLocationListener(this);
		showBtn = (Button) findViewById(R.id.show_objects);
		showBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (showObjects)
				{
					hideObjects();
					showObjects = false;
				}
				else
				{
					showObjects();
					showObjects = true;
				}
			}
		});
		mapview = (MapView) findViewById(R.id.mapview);
		mapview.getMap().setRotateGesturesEnabled(false);
		MapKit mapKit = MapKitFactory.getInstance();
		userLocationLayer = mapKit.createUserLocationLayer(mapview.getMapWindow());
		displayLocationFromGoogle();
	}
	
	protected void locationRequest(){
		/**
		 * Check permission that may to get user location.
		 */
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
				!= PackageManager.PERMISSION_GRANTED) {
			/**
			 * Request permission. You can use ACCESS_COARSE_LOCATION or ACCESS_FINE_LOCATION
			 */
			ActivityCompat.requestPermissions(this,
					new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
					MY_PERMISSION_REQUEST);
		}
	}
	
	@Override
	protected void onStop() {
		mapview.onStop();
		MapKitFactory.getInstance().onStop();
		super.onStop();
	}

	@Override
	protected void onStart() {
		super.onStart();


		MapKitFactory.getInstance().onStart();
		mapview.onStart();
	}
	protected void showObjects(){
		userLocationLayer.setVisible(true);
		userLocationLayer.setHeadingEnabled(true);
		userLocationLayer.setObjectListener(this);
		showBtn.setText("unshow me");

	}
	protected void hideObjects(){
		userLocationLayer.setObjectListener(null);
		userLocationLayer.setVisible(false);
		showBtn.setText("show me");
	}
	@Override
	public void onObjectAdded(UserLocationView userLocationView) {
		userLocationLayer.setAnchor(
				new PointF((float)(mapview.getWidth() * 0.5), (float)(mapview.getHeight() * 0.5)),
				new PointF((float)(mapview.getWidth() * 0.5), (float)(mapview.getHeight() * 0.83)));

		userLocationView.getArrow().setIcon(ImageProvider.fromResource(
				this, R.drawable.pin));

		CompositeIcon pinIcon = userLocationView.getPin().useCompositeIcon();

		pinIcon.setIcon(
				"pin",
				ImageProvider.fromResource(this, R.drawable.search_result),
				new IconStyle().setAnchor(new PointF(0.5f, 0.5f))
						.setRotationType(RotationType.ROTATE)
						.setZIndex(1f)
						.setScale(0.5f)
		);
		userLocationView.getAccuracyCircle().setFillColor(Color.rgb(15,30,66));
	}

	@Override
	public void onObjectRemoved(UserLocationView view) {
	}

	@Override
	public void onObjectUpdated(UserLocationView view, ObjectEvent event) {
	}
	
	protected void displayLocationFromGoogle(){
		Point myPoint;
		if (MyLocationListener.imHere != null){
			myPoint = new Point(MyLocationListener.imHere.getLatitude(), MyLocationListener.imHere.getLongitude());
			mapview.getMap().getMapObjects().addPlacemark(myPoint)
					.setIcon(ImageProvider.fromResource(MainActivity.this, R.drawable.pin));
			Log.d(TAG, "My location is: " + myPoint.getLatitude() + " " + myPoint.getLongitude());
		}
		else {
			Log.e(TAG, "imHere == null");
		}
	}
}
