package com.zero.linuxstudy;

import com.zero.linuxstudy.R;
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

import com.zero.linuxstudy.MyAdapter;
public class Part1Activity extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.listview);//设置视图列表
		String cmds[] = new String[]{
				"1.1.1 Shell 简介",
				"1.1.2 Shell 控制台使用方法",
				"1.2.1 登录和退出 Linux系统",
				"1.2.2 文件和目录操作命令",
				"1.2.3 用户及用户组管理命令",
				"1.2.4 进程及任务管理命令",
				"1.2.5 磁盘及文件系统管理命令",
				"1.2.6 软件安装命令"};
		
		ListAdapter adapter = new MyAdapter(this, cmds);
        ListView listView = (ListView) findViewById(R.id.listview);
		listView.setAdapter(adapter);
        
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> l, View v, int position, long id) {
				String s = (String)l.getItemAtPosition(position);
				Toast.makeText(Part1Activity.this, s, Toast.LENGTH_SHORT).show();
				showText("part1/"+position+".txt");
			}
		});
    }
	/***显示文本**/
	public void showText(String name){
		//往下一个界面传值，可省略
		startActivity( new Intent(this,ShowText.class).putExtra("key",name) );
	}
}
