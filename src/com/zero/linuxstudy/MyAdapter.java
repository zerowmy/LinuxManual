package com.zero.linuxstudy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<String>
{
	public MyAdapter(Context context, String[] values) 
	{
		super(context, R.layout.list_style_size, values);
	}

	public View getView(int position, View convertView, ViewGroup parent)
	{
		LayoutInflater inflater = LayoutInflater.from(getContext());
		View view = inflater.inflate(R.layout.list_style_size, parent, false);
		
		String text = getItem(position);

		TextView textView = (TextView) view.findViewById(R.id.listTextView);
		textView.setText(text);

		ImageView imageView = (ImageView) view.findViewById(R.id.listImageView);
		imageView.setImageResource(android.R.drawable.ic_menu_edit);
		
		if("Google".equals(text))
			imageView.setImageResource(android.R.drawable.ic_menu_gallery);
		
		return view;
	}
}