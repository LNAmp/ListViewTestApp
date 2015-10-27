package cn.david.listview.adapter;

import java.util.List;

import cn.david.listview.R;
import cn.david.listview.domain.ChatMessage;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatMsgAdapter extends BaseAdapter {
	private Context context;
	private List<ChatMessage> chatMsgs;
	
	private final int SEND = 1;
	private final int REC = 0;
	public ChatMsgAdapter(Context context , List<ChatMessage> chatMsgs) {
		this.context = context;
		this.chatMsgs = chatMsgs;
	}
	@Override
	public int getCount() {
		return chatMsgs.size();
	}

	@Override
	public Object getItem(int position) {
		return chatMsgs.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;
		Log.i("getView", "called getView");
		ChatMessage chatMsg = (ChatMessage)getItem(position);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		//只得到holder
		SendChatHolder sendHolder = new SendChatHolder();
		RecChatHolder recHolder = new RecChatHolder();
		if(rowView == null) {
			//根据消息类型得到不同的item layout
			Log.i("getView", "convertView is null");
			switch(getItemViewType(position)) {
			case SEND:
				rowView = makeView(inflater,R.layout.send_list_item);
				if(rowView == null) {
					Log.e("listView", "rowView is null");
				}
				fillSendHolder(rowView, sendHolder);
				break;
			case REC:
				
				rowView = makeView(inflater,R.layout.rec_list_item);
				if(rowView == null) {
					Log.e("listView", "rowView is null");
				}
				fillRecHolder(rowView, recHolder);
				break;
			default :
				break;
			}
			if(rowView == null) {
				Log.e("listView", "rowView is null");
			}
		} else {
			Log.i("getView", "convertView is not null");
			switch(getItemViewType(position)) {
			case SEND:
				sendHolder = (SendChatHolder)rowView.getTag();
				if(sendHolder == null) {
					fillSendHolder(rowView, sendHolder);
					Log.i("getView", "sendHolder is null");
				}else {
					Log.i("getView", "sendHolder is not null");
				}
				break;
			case REC:
				 recHolder= (RecChatHolder)rowView.getTag();
				if(recHolder == null) {
					Log.i("getView", "recHolder is null");
					fillSendHolder(rowView, recHolder);
				}else {
					Log.i("getView", "recHolder is not null");
				}
				break;
			default :
				break;
			}
		}
		//到此处为止，holder和rowView均不为空
		//此时应该填充消息到holder中
		switch(getItemViewType(position)) {
		case SEND:
			fillSendMsg(chatMsg, sendHolder);
			break;
		case REC:
			fillRecMsg(chatMsg, recHolder);
			break;
		default :
			break;
		}
		return rowView;
	}
	private View makeView(LayoutInflater inflater, int layoutId) {
		
		View rowView = inflater.inflate(layoutId, null);
		return rowView;
	}
	
	private void fillSendHolder(View rowView, Object holder) {
			TextView timeTextView = (TextView)rowView.findViewById(R.id.tv_time);
			ImageView imageView = (ImageView)rowView.findViewById(R.id.iv_user_image);
			TextView contentTextView = (TextView)rowView.findViewById(R.id.tv_content);
			SendChatHolder mholder = (SendChatHolder) holder;
			mholder.timeTextView  = timeTextView;
			mholder.userImageView  = imageView ;
			mholder.msgContentView  = contentTextView;
			rowView.setTag(mholder);
	}
	private void fillRecHolder(View rowView, Object holder) {
		TextView timeTextView = (TextView)rowView.findViewById(R.id.tv_time);
		ImageView imageView = (ImageView)rowView.findViewById(R.id.iv_user_image);
		TextView contentTextView = (TextView)rowView.findViewById(R.id.tv_content);
		RecChatHolder mholder = (RecChatHolder) holder;
		mholder.timeTextView  = timeTextView;
		mholder.userImageView  = imageView ;
		mholder.msgContentView  = contentTextView;
		rowView.setTag(mholder);
}
	
	private void fillSendMsg(ChatMessage chatMsg,SendChatHolder holder) {
		
		//用msg填充各种view，并将其放入holder中
				
		holder.timeTextView.setText(chatMsg.getMsgRecTime());
		holder.userImageView.setImageResource(R.drawable.a1v);//此处本应该是根据msg中图片路径的不同得到不同的图片的,并且应该是创建对应的activity时就加载到内存中
		holder.msgContentView.setText(chatMsg.getMsgContent());
	
	}
	
	private void fillRecMsg(ChatMessage chatMsg,RecChatHolder holder) {
		
		//用msg填充各种view，并将其放入holder中
				
		holder.timeTextView.setText(chatMsg.getMsgRecTime());
		holder.userImageView.setImageResource(R.drawable.a1v);//此处本应该是根据msg中图片路径的不同得到不同的图片的,并且应该是创建对应的activity时就加载到内存中
		holder.msgContentView.setText(chatMsg.getMsgContent());
	
	}
	
	
	
	@Override
	public int getItemViewType(int position) {
		ChatMessage chatMsg = chatMsgs.get(position);
		if(chatMsg.isSendMsg()) {
			return SEND;
		}else {
			return REC;
		}
	}
	@Override
	public int getViewTypeCount() {
		return 2;
	}



	public static class SendChatHolder {
		public TextView timeTextView;
		public ImageView userImageView;
		public TextView msgContentView;
	}
	
	public static class RecChatHolder {
		public TextView timeTextView;
		public ImageView userImageView;
		public TextView msgContentView;
	}

}
