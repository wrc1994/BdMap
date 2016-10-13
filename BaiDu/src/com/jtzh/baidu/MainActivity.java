package com.jtzh.baidu;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ListView listView;
	private List<String> list;
	private Adapter adapter;
	private Map<Integer, Boolean> map=new HashMap<Integer, Boolean>();  //标记checkBox是否被选中
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView=(ListView)findViewById(R.id.listview);
		Toast.makeText(MainActivity.this, "点击了sss", 0).show();
		list=new ArrayList<String>();
		for(int i=0;i<20;i++){
			list.add("abc"+i);
			map.put(i, false);
		}
		adapter=new Adapter();
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "点击了"+arg2, 0).show();
			}
		});
	}


	public class Adapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			for(int i=0;i<20;i++){
				
				map.put(i, false);
			}
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(final int position, View conVertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			final ViewHolder holder;
			if(conVertView==null){
				holder=new ViewHolder();
				conVertView=LayoutInflater.from(MainActivity.this).inflate(R.layout.item, null);
				holder.btn = (Button)conVertView.findViewById(R.id.buttonid);
				holder.textView = (TextView)conVertView.findViewById(R.id.textid);
				holder.checkBtn = (CheckBox)conVertView.findViewById(R.id.radioid);
				conVertView.setTag(holder);
			}else{
				holder=(ViewHolder) conVertView.getTag();
			}
			holder.textView.setText(list.get(position));

			holder.checkBtn.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub

					if (isChecked) {
						map.put(position, true);
					}else{
						map.put(position, false);
					}
				}
			});
			holder.checkBtn.setChecked(map.get(position));

			holder.btn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Toast.makeText(MainActivity.this, position+"", 0).show();

				}
			});
			return conVertView;
		}


	}

	class ViewHolder{

		private TextView textView;
		private CheckBox checkBtn;
		private Button btn;

	}
}

