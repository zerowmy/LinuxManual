package com.zero.linuxstudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Part6Activity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.listview);// 设置视图列表
		String cmds[] = new String[] { "Zero整理","GitHub擎天渡劫-1-开场","GitHub擎天渡劫-2-操作系统基础","GitHub擎天渡劫-3-操作系统基础","GitHub擎天渡劫-4-操作系统及常用命令","GitHub擎天渡劫-5-Linux根文件系統詳解","GitHub擎天渡劫-6-Linux命令詳解","GitHub擎天渡劫-7-Linux文件管理命令詳解","GitHub擎天渡劫-8-Linux目录管理命令詳解","GitHub擎天渡劫-9-文件处理","GitHub擎天渡劫-10-Linux的Bash特性","GitHub擎天渡劫-11-用户及其权限","GitHub擎天渡劫-12用户管理命令" };
		ListAdapter adapter = new MyAdapter(this, cmds);
        ListView listView = (ListView) findViewById(R.id.listview);
		listView.setAdapter(adapter);
        
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> l, View v, int position, long id) {
				String s = (String)l.getItemAtPosition(position);
				Toast.makeText(Part6Activity.this, s, Toast.LENGTH_SHORT).show();
				showText("part6/"+position+".txt");
			}
		});
	}
	/***显示文本**/
	public void showText(String name){
		//往下一个界面传值，可省略
		startActivity( new Intent(this,ShowText.class).putExtra("key",name) );
	}
}
