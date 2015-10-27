package cn.david.listview.activity;

import cn.david.listview.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyArrayAdapter extends ArrayAdapter<String> {
	private Context context;
	private String[] values;
	public MyArrayAdapter(Context context, String[] values) {
		super(context, R.layout.list_item, values);
		this.context = context;
		this.values = values;
	}

	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//		View rowView = inflater.inflate(R.layout.list_item, parent, false);
//		TextView firstLine = (TextView)rowView.findViewById(R.id.firstLine);
//		TextView secondLine = (TextView)rowView.findViewById(R.id.secondLine);
//		firstLine.setText(values[position]);
//		secondLine.setText(values[position]);
//		ImageView imageView = (ImageView)rowView.findViewById(R.id.icon);
//		if(values[position].startsWith("iPhone")) {
//			imageView.setImageResource(R.drawable.facebook_hdpi);
//		}else {
//			imageView.setImageResource(R.drawable.gmail_hdpi);
//		}
//		return rowView;
//		
//	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = null;
		if(position%2 == 0) {
			rowView = inflater.inflate(R.layout.list_item, parent, false);
		} else {
			rowView = inflater.inflate(R.layout.list_item2, parent, false);
		}
		
		TextView firstLine = (TextView)rowView.findViewById(R.id.firstLine);
		TextView secondLine = (TextView)rowView.findViewById(R.id.secondLine);
		firstLine.setText(values[position]);
		secondLine.setText(values[position]);
		ImageView imageView = (ImageView)rowView.findViewById(R.id.icon);
		imageView.setImageResource(R.drawable.facebook_hdpi);
	
		return rowView;
		
	}
	
	

}
