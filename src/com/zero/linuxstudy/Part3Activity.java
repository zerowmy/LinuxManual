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

public class Part3Activity extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.listview);//设置视图列表
		String cmds[] = new String[]{ 
				"3.1 网络配置命令",
				"3.1.1 ifconfig",
				"3.1.2 route",
				"3.2 网络操作命令",
				"3.2.1 netstat",
				"3.2.2 nslookup",
				"3.2.3 host",
				"3.2.4 finger",
				"3.2.5 Ping 命令",
				"3.3 常用网络配置文件介绍",
				"3.3.1 /etc/sysconfig/network 网络设置",
				"3.3.2 /etc/hosts IP 地址和主机名的映射",
				"3.3.3 /etc/services",
				"3.3.4 /etc/host.conf 配置名字解析器",
				"3.3.5 /etc/nsswitch.conf 配置名字解析器",
				"3.3.6 /etc/resolv.conf 配置 DNS 客户",
				"3.3.7 /etc/xinetd.conf",
				"3.3.8 /etc/modules.conf 文件",
				"3.3.9 /etc/sysconfig/network-scripts/ifcfg-ethN 文件",
				"3.4 常用网络操作方法",
				"3.4.1 ftp 远程文件传输",
				"3.4.2 telnet",
				"3.4.3 r-系列命令" };
		ListAdapter adapter = new MyAdapter(this, cmds);
        ListView listView = (ListView) findViewById(R.id.listview);
		listView.setAdapter(adapter);
        
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> l, View v, int position, long id) {
				String s = (String)l.getItemAtPosition(position);
				Toast.makeText(Part3Activity.this, s, Toast.LENGTH_SHORT).show();
				showText("part3/"+position+".txt");
			}
		});
	}
	/***显示文本**/
	public void showText(String name){
		//往下一个界面传值，可省略
		startActivity( new Intent(this,ShowText.class).putExtra("key",name) );
	}
}
