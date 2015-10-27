package cn.david.listview.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.david.listview.R;
import cn.david.listview.adapter.ChatMsgAdapter;
import cn.david.listview.domain.ChatMessage;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ChatListActivity extends Activity {

	private List<ChatMessage> chatMsgs = null;
	private ChatMsgAdapter chatAdapter = null;
	private ListView listView = null;
	private Button button = null;
	private TextView inputTextView = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat_listview);
		listView = (ListView) findViewById(R.id.listview);
		button = (Button) findViewById(R.id.btn_send);
		inputTextView = (TextView) findViewById(R.id.et_content);
		chatMsgs = new ArrayList<ChatMessage>();
		ChatMessage chatMsg = null;
		for(int i=0; i<15; i++) {
			chatMsg = new ChatMessage();
			if(i%2 == 0) {
				chatMsg.setSendMsg(false);
				chatMsg.setMsgRecTime("2012-09-20 15:12:32");
				chatMsg.setMsgContent("hello");
			}else {
				chatMsg.setSendMsg(true);
				chatMsg.setMsgRecTime("2012-09-20 15:22:32");
				chatMsg.setMsgContent("nice to meet you.................................");
			}
			chatMsgs.add(chatMsg);
		}
		chatAdapter = new ChatMsgAdapter(this, chatMsgs);
		listView.setAdapter(chatAdapter);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String inputText = inputTextView.getText().toString();
				if(!inputText.equals("")){
					send(inputText);
				}else {
					Toast.makeText(ChatListActivity.this, "content is empty", Toast.LENGTH_LONG).show();
				}
			}


		});
		
	
	}
	
	private void send(String input) {
		ChatMessage chatMsg = new ChatMessage();
		chatMsg.setMsgRecTime(new Date().toLocaleString());
		chatMsg.setSendMsg(true);
		chatMsg.setMsgContent(input);
		chatMsgs.add(chatMsg);
		Log.i("getView","start send");
		chatAdapter.notifyDataSetChanged();
		listView.setSelection(chatMsgs.size()-1);
		inputTextView.setText("");
	}
	
}
