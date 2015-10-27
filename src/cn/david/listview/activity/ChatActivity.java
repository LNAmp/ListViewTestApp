package cn.david.listview.activity;

import java.util.ArrayList;

import cn.david.listview.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ChatActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_ex1);
		//先创建一个ArrayList，保存着要显示的String
		String[] values = new String[] {
				"Android", "iPhone", "WindowsMobile",
		        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
		        "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
		        "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
		        "Android", "iPhone", "WindowsMobile" };
		final ArrayList<String> lists = new ArrayList<String>();
		for(int i=0; i<values.length; i++) {
			lists.add(values[i]);
		}
		ArrayAdapter<String> adapter = new MyArrayAdapter(this, values);
		
		final ListView listView= (ListView)findViewById(R.id.listview);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String msg = "the p is:" +position+"the id is"+id;
				Toast toast = Toast.makeText(ChatActivity.this, msg, Toast.LENGTH_LONG);
				toast.show();
			}
		});
	}
}
