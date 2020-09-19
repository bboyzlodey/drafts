package skarlat.dev.analysrequireofvacancy;

import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class JavaClass implements Serializable {
	String name;
	String link;
	static List<String> stringsList = new ArrayList<>(150);
	static String basicURL = "https://docs.oracle.com/javase/8/docs/api/";
	static Thread thread;
	static ProgressBar progressBar;
	
	private JavaClass(String name, String link){
		this.name = name;
		this.link = basicURL + link;
	}
	private JavaClass(String html){
//		this.name = name;
		String tmp = html.substring(0, html.indexOf('\"'));
		setLink(tmp);
		String [] strings = tmp.split("/");
		if (strings.length > 0){
			name = strings[strings.length - 1];
		}
		stringsList.add(this.name + "\n" + link);
	}
	public String getName() {
		return name;
	}
	public void setLink(String link){
		this.link = basicURL + link;
	}
	static List<JavaClass> downLoad(String url) throws IOException, InterruptedException {
		final URL downloadURL = new URL(url);
		final List<JavaClass> javaClasses = new ArrayList<>(150);
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				
				try {
					URLConnection connection = null;
					connection = downloadURL.openConnection();
					InputStream inputStream = null;
					inputStream = connection.getInputStream();
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
					String tmp;
					while((tmp = bufferedReader.readLine()) != null){
						if(tmp.contains("a href=\"java")){
							javaClasses.add(new JavaClass(tmp.substring(tmp.indexOf('\"') + 1)));
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				progressBar.setVisibility(View.GONE);
			}
		});
		if (javaClasses.isEmpty()){
			Log.e("JavaClass", "Failed");
		}
		return javaClasses;
	}
}