package skarlat.dev.requiresofvacancy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

public class MainActivity extends AppCompatActivity {
	ExpandableListView expandableListView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		expandableListView = (ExpandableListView) findViewById(R.id.expanded_menu);
//		expandableListView.setAdapter();
	}
}
