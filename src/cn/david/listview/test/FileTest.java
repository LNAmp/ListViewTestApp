package cn.david.listview.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.test.AndroidTestCase;
import android.util.Log;

public class FileTest extends Activity{
    @Override public void onCreate(Bundle savedInstanceState) {
        
         FileOutputStream outStream;
//		try {
//			outStream = this.openFileOutput("itcast.txt", Context.MODE_PRIVATE);
//			outStream.write("´«ÖÇ²¥¿Í".getBytes());
//	         outStream.close(); 
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
         
         FileInputStream inputStream;
         try {
        	String path = this.getFilesDir().getAbsolutePath();
        	Log.i("file", path);
//        	File file = new File("/data/data/cn.david.listview/itcast.txt");
//        	if(file.exists()) {
//        		Log.i("file","file exists");
//        	}
        	String imageFileDir = path+"/image";
        	File fileDir = new File(imageFileDir);
        	if(!fileDir.exists()) {
        		fileDir.mkdirs();
        	}
        	if(fileDir.exists()) {
        		Log.i("file", fileDir.getAbsolutePath());
        	}
			inputStream = this.openFileInput("itcast.txt");
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len=inputStream.read(buffer))!=-1) {
				bos.write(buffer, 0, len);
			}
			String out = new String(bos.toByteArray());
			Log.i("file", out+"YES");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		String filePath="/data/userimage";
//		File fileDir = new File(filePath);
//		if(!fileDir.exists()) {
//			fileDir.mkdirs();
//		}
//		String absFileName =
           
    }

	
	
}
