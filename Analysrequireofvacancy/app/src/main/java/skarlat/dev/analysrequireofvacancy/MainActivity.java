package skarlat.dev.analysrequireofvacancy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
	private final String url = "https://docs.oracle.com/javase/8/docs/api/allclasses-noframe.html";
	ListView listView;
	ArrayAdapter<String> adapter;
	int sorts = 0;
	Comparator<String> [] comparators;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) findViewById(R.id.list_classes);
		ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
		try {
			JavaClass.downLoad(url);
			JavaClass.progressBar = progressBar;
			JavaClass.thread.start();
			if (JavaClass.thread.isAlive()) {
				JavaClass.thread.join();
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		JavaClass.stringsList.add(url);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, JavaClass.stringsList);
		listView.setAdapter(adapter);
		initComparators();
	}
	
	public void onSort(View v){
			adapter.sort(comparators[sorts++ % 2]);
	}
	private void initComparators(){
		comparators = new Comparator[2];
		comparators[0] = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		};
		comparators[1] = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
	}
}
