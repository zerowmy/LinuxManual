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
import com.zero.linuxstudy.MyAdapter;
public class Part2Activity extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.listview);//设置视图列表
		String cmds[] = new String[]{
				"2.1 cat 命令介绍",
				"2.2 vi 命令介绍",
				"2.2.1 vi 的进入与退出",
				"2.2.2 vi 中显示行号",
				"2.2.3 光标移动操作",
				"2.2.4 文本插入操作",
				"2.2.5 文本修改操作",
				"2.2.6 文本搜索与替换操作",
				"2.3 head 及 tail 命令介绍"};
		ListAdapter adapter = new MyAdapter(this, cmds);
        ListView listView = (ListView) findViewById(R.id.listview);
		listView.setAdapter(adapter);
        
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> l, View v, int position, long id) {
				String s = (String)l.getItemAtPosition(position);
				Toast.makeText(Part2Activity.this, s, Toast.LENGTH_SHORT).show();
				showText("part2/"+position+".txt");
			}
		});
	}
	/***显示文本**/
	public void showText(String name){
		//往下一个界面传值，可省略
		startActivity( new Intent(this,ShowText.class).putExtra("key",name) );
	}
}
