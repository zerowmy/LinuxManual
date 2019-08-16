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

public class Part4Activity extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.listview);//设置视图列表
		String cmds[] = new String[]{ 
				"4.1 Linux下软件包的安装及卸载",
				"4.1.1 RPM 安装操作",
				"4.1.2 RPM 查询操作",
				"4.1.3 RPM 卸载操作",
				"4.1.4 RPM 升级操作",
				"4.1.5 RPM 验证操作",
				"4.1.6 RPM 的其他附加命令",
				"4.2 Linux操作系统的时钟系统",
				"4.2.1 时钟系统介绍",
				"4.2.2 硬件时钟系统与系统时间的同步",
				"4.3 系统信息及运行状态监控",
				"4.3.1 df 命令",
				"4.3.2 du 命令",
				"4.3.3 top 命令",
				"4.3.4 iostat 命令",
				"4.4 打包/压缩工具 tar",
				"4.5 文件及文件内容的查找",
				"4.5.1 文件查找命令find",
				"4.5.2 文件内容查找命令 grep",
				"4.6 Linux的系统服务及其配置",
				"4.6.1 服务简介",
				"4.6.2 启动和停止服务",
				"4.6.3 服务的添加 删除 自动运行及状态" };
		ListAdapter adapter = new MyAdapter(this, cmds);
        ListView listView = (ListView) findViewById(R.id.listview);
		listView.setAdapter(adapter);
        
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> l, View v, int position, long id) {
				String s = (String)l.getItemAtPosition(position);
				Toast.makeText(Part4Activity.this, s, Toast.LENGTH_SHORT).show();
				showText("part4/"+position+".txt");
			}
		});
	}
	/***显示文本**/
	public void showText(String name){
		//往下一个界面传值，可省略
		startActivity( new Intent(this,ShowText.class).putExtra("key",name) );
	}
}
