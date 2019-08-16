package com.zero.linuxstudy;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class MianActivity extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		// 隐藏状态栏
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
				
		//判断屏幕横着还是竖着
		int orientation = getResources().getConfiguration().orientation;//从清单文件获得屏幕方向
		if(orientation == Configuration.ORIENTATION_LANDSCAPE){
			setContentView(R.layout.main_landscape);//加载横屏视图			
		}else if(orientation == Configuration.ORIENTATION_PORTRAIT){
			setContentView(R.layout.main_portrait);//加载竖屏视图				
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_meun, menu);
		return true;
	}
	@Override  //菜单设置方法
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.readMenu:
				Toast.makeText(this, "阅读目录", Toast.LENGTH_SHORT).show();
				startActivity( new Intent(this,ReadMenuActivity.class) );
				break;
			case R.id.about:
				Toast.makeText(this, "关于", Toast.LENGTH_SHORT).show();
				//setContentView(R.layout.about);
				startActivity( new Intent(this,AboutActivity.class) );
				break;
			case R.id.author:
				Toast.makeText(this, "作者：魏明遥", Toast.LENGTH_SHORT).show();
				startActivity( new Intent(this,AuthorActivity.class) );
				break;	
			case R.id.exit:
				finish();
				return true;

		}
		return super.onOptionsItemSelected(item);
	}
	Intent intent;
	public void part1(View view){
		//showText("zhuchi.txt");
		Toast.makeText(this,"第 1 章 命令行操作及常用命令使用",Toast.LENGTH_SHORT).show();
		startActivity( new Intent(this,Part1Activity.class) );
	}
	public void part2(View view){
		Toast.makeText(this,"第 2 章 文件查看/编辑方法介绍",Toast.LENGTH_SHORT).show();
		startActivity( new Intent(this,Part2Activity.class) );
	}
		
	public void part3(View view){
		Toast.makeText(this,"第 3 章 网络配置及操作",Toast.LENGTH_SHORT).show();
		startActivity( new Intent(this,Part3Activity.class) );
	}
	public void part4(View view){
		Toast.makeText(this,"第 4 章 常用使用技巧",Toast.LENGTH_SHORT).show();
		startActivity( new Intent(this,Part4Activity.class) );
	}
	public void part5(View view){
		Toast.makeText(this,"第 5 章 网络配置",Toast.LENGTH_SHORT).show();
		startActivity( new Intent(this,Part5Activity.class) );
	}
	public void part6(View view){
		Toast.makeText(this,"第 6 章 运维积累",Toast.LENGTH_SHORT).show();
		startActivity( new Intent(this,Part6Activity.class) );
	}
	
	/***显示文本**/
	public void showText(String name){
		//往下一个界面传值，可省略
		startActivity( new Intent(this,ShowText.class).putExtra("key",name) );
	}
}