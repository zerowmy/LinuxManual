package com.zero.linuxstudy;

import android.app.*;
import android.content.*;
import android.os.*;
import android.speech.tts.*;
import android.view.*;
import android.widget.*;
import java.io.*;
import java.util.Locale;

public class ShowText extends Activity {
	//private EditText mTTSText;
	//private SpeechUtilOffline offline;

	private int read_status = -1;//阅读状态，1为正在阅读，-1为停止阅读
    private TextToSpeech textToSpeech;
	String text;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
		
        super.onCreate(savedInstanceState);
        // 隐藏状态栏 
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
							 WindowManager.LayoutParams.FLAG_FULLSCREEN); 

		setContentView(R.layout.show_text);
		//下一个界面接收值：
		Intent intent = this.getIntent();
		String name = intent.getStringExtra("key");//如果是int型就getIntgerExtra
		
		try
		{//Return an AssetManager instance for your application's package
			InputStream is = getAssets().open(name);
			int size = is.available();
			// Read the entire asset into a local byte buffer.
			byte[] buffer = new byte[size];//6086
			is.read(buffer);//将文件输入流的内容读到字节数组buffer中
			is.close();
			// Convert the buffer into a string.
			text = new String(buffer);
			// Finally stick the string into the text view.
			TextView tv = (TextView) findViewById(R.id.showText);
			tv.setText(text);//将文子打印到视图tv
			float filesize = (float)size/1024;
			Toast.makeText(this,text.length()+"双击屏幕可以复制文字哦！内容大小"+filesize+"KB", Toast.LENGTH_SHORT).show();
		}
		catch (IOException e)
		{
			// Should never happen!
			throw new RuntimeException(e);
		}
		
		/*  start语音阅读 */
		textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
				@Override
				public void onInit(int status) {
					if (status == TextToSpeech.SUCCESS) {
						int result = textToSpeech.setLanguage(Locale.CHINA);
						if (result != TextToSpeech.LANG_COUNTRY_AVAILABLE
                            && result != TextToSpeech.LANG_AVAILABLE){
							Toast.makeText(ShowText.this, "TTS暂时不支持这种语音的朗读！",
										   Toast.LENGTH_SHORT).show();
						}
					}
				}
			});
		/*  end语音阅读  */
	}

	/* start 菜单或者操作栏 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate main_menu.xml 
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.read_voice, menu);//调用menu下的read_voice.xml视图操作栏目录
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
//		int tempsize=1024;
//		int len = (int)Math.ceil(((float)text.length()/tempsize));
		
		switch(item.getItemId()){	
			case R.id.read_vioce:
				read_status = -read_status;//阅读状态取反
				if(read_status==1){
					Toast.makeText(this,"开始阅读啦！",Toast.LENGTH_SHORT).show();
					textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH, null);
//					for(int x=0;x<len;x++){
//						Toast.makeText(this,len+"开始阅读啦！"+x,Toast.LENGTH_SHORT).show();
//						if(x==len-1)
//						textToSpeech.speak(text.substring(x*tempsize+1,(x+1)*tempsize-text.length()),TextToSpeech.QUEUE_FLUSH, null);
//						else{
//							textToSpeech.speak(text.substring(x*tempsize+1,(x+1)*tempsize),TextToSpeech.QUEUE_FLUSH, null);
//						}
//					}
				}else{
					Toast.makeText(this,"停止阅读啦！",Toast.LENGTH_SHORT).show();
					textToSpeech.speak("",TextToSpeech.QUEUE_FLUSH, null);
				}
				break;
		}
		return super.onOptionsItemSelected(item);
	}
	/* end 菜单或者操作栏 */
	

	/*  start语音阅读判断为空就结束  */
    @Override
    protected void onDestroy() {
        if (textToSpeech != null)
            textToSpeech.shutdown();
        super.onDestroy();
    }
	/*  end语音阅读判断为空就结束  */
}
