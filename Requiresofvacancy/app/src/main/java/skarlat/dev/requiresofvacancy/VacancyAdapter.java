package skarlat.dev.requiresofvacancy;

import android.content.Context;
import android.widget.SimpleExpandableListAdapter;

import java.util.List;
import java.util.Map;

public class VacancyAdapter extends SimpleExpandableListAdapter {
	Context context;
	public VacancyAdapter(Context context, List<? extends Map<String, ?>> groupData, int groupLayout,
	                      String[] groupFrom, int[] groupTo,
	                      List<? extends List<? extends Map<String, ?>>> childData, int childLayout,
	                      String[] childFrom, int[] childTo) {
		super(context, groupData, groupLayout, groupFrom, groupTo, childData, childLayout, childFrom, childTo);
	}
	
	public VacancyAdapter(Context context, List<? extends Map<String, ?>> groupData,
	                      int expandedGroupLayout, int collapsedGroupLayout, String[] groupFrom,
	                      int[] groupTo, List<? extends List<? extends Map<String, ?>>> childData,
	                      int childLayout, String[] childFrom, int[] childTo) {
		super(context, groupData, expandedGroupLayout, collapsedGroupLayout, groupFrom, groupTo,
				childData, childLayout, childFrom, childTo);
	}
	
	public VacancyAdapter(Context context, List<? extends Map<String, ?>> groupData,
	                      int expandedGroupLayout, int collapsedGroupLayout, String[] groupFrom,
	                      int[] groupTo, List<? extends List<? extends Map<String, ?>>> childData,
	                      int childLayout, int lastChildLayout, String[] childFrom, int[] childTo) {
		super(context, groupData, expandedGroupLayout, collapsedGroupLayout, groupFrom, groupTo,
				childData, childLayout, lastChildLayout, childFrom, childTo);
	}
}
