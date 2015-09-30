package club.xiaoke.supercood;

import club.xiaoke.supercood.constants.CoordType;
import club.xiaoke.supercood.task.CoordConverttask;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;


/**
 * @author SHANG01
 * 转换坐标界面
 */
public class CoordConvertActivity extends Activity {
	
	//经度
	EditText ac_coord_convert_origin_lng_etxt;
	//纬度
	EditText ac_coord_convert_origin_lat_etxt;
	
	TextView ac_coord_convert_result_doConvert;
	
	
	TextView ac_coord_convert_result_WGS84;
	TextView ac_coord_convert_result_GCJ02;
	TextView ac_coord_convert_result_BAIDU;
	TextView ac_coord_convert_result_GOOGLE_EARTH;
	TextView ac_coord_convert_result_GOOGLE_MAP;
	TextView ac_coord_convert_result_GPS_DEVICE;
	TextView ac_coord_convert_result_AMAP;
	TextView ac_coord_convert_result_TECENT;
	
	
	double originlng;
	double originlat;
	
	
	/**
	 * 原始坐标类型     
	 */
	int originCoordType = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_coordconvert);
		
		initview();
		initlistener();
		initdata();
		
		
	}
	
	private void initview(){
		ac_coord_convert_origin_lng_etxt = (EditText) findViewById(R.id.ac_coord_convert_origin_lng_etxt);
		ac_coord_convert_origin_lat_etxt = (EditText) findViewById(R.id.ac_coord_convert_origin_lat_etxt);
		ac_coord_convert_result_doConvert = (TextView) findViewById(R.id.ac_coord_convert_result_doConvert);
	
		ac_coord_convert_result_WGS84 = (TextView) findViewById(R.id.ac_coord_convert_result_WGS84);
		ac_coord_convert_result_GCJ02 = (TextView) findViewById(R.id.ac_coord_convert_result_GCJ02);
		ac_coord_convert_result_BAIDU = (TextView) findViewById(R.id.ac_coord_convert_result_BAIDU);
		ac_coord_convert_result_GOOGLE_EARTH = (TextView) findViewById(R.id.ac_coord_convert_result_GOOGLE_EARTH);
		ac_coord_convert_result_GOOGLE_MAP = (TextView) findViewById(R.id.ac_coord_convert_result_GOOGLE_MAP);
		ac_coord_convert_result_GPS_DEVICE = (TextView) findViewById(R.id.ac_coord_convert_result_GPS_DEVICE);
		ac_coord_convert_result_AMAP = (TextView) findViewById(R.id.ac_coord_convert_result_AMAP);
		ac_coord_convert_result_TECENT = (TextView) findViewById(R.id.ac_coord_convert_result_TECENT);
	
	
	}
	
	private void initlistener(){
		ac_coord_convert_result_doConvert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				originlat = Double.valueOf(ac_coord_convert_origin_lat_etxt.getText().toString());
				originlng = Double.valueOf(ac_coord_convert_origin_lng_etxt.getText().toString());
				
				/******************************************************
				 * 
				 * 数据转换
				 * 
				 * 
				 *****************************************************/
				//转换为---WGS84
				doconvert(CoordType.CT_WGS84,ac_coord_convert_result_WGS84);
				//转换为---国测局
				doconvert(CoordType.CT_GCJ02,ac_coord_convert_result_GCJ02);
				//转换为---百度地图
				doconvert(CoordType.CT_BD09,ac_coord_convert_result_BAIDU);
				//转换为---谷歌地球
				doconvert(CoordType.CT_GOOGLE_EARTH,ac_coord_convert_result_GOOGLE_EARTH);
				//转换为---谷歌地图
				doconvert(CoordType.CT_GOOGLE_MAP,ac_coord_convert_result_GOOGLE_MAP);
				//转换为---GPS设备
				doconvert(CoordType.CT_GPS_DEVICE,ac_coord_convert_result_GPS_DEVICE);
				//转换为---高德地图
				doconvert(CoordType.CT_AMAP_GAODE,ac_coord_convert_result_AMAP);
				//转换为---腾讯地图
				doconvert(CoordType.CT_TECENT,ac_coord_convert_result_TECENT);
				
				
				
			}
		});
	}
	
	private void initdata(){
		Intent intent = getIntent();
		originCoordType = intent.getIntExtra("originCoordType", 0);
		
	}
	
	private void doconvert(int resultCoordType,TextView tv){
		CoordConverttask task = 
				new CoordConverttask(
						originlat, 
						originlng, 
						originCoordType, 
						resultCoordType, 
						this,tv);
		
	}

}
