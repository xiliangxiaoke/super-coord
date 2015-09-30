package club.xiaoke.supercood.task;

import club.xiaoke.supercood.R;
import club.xiaoke.supercood.constants.CoordType;
import club.xiaoke.supercood.math.CoordMath;
import club.xiaoke.supercood.model.MyLatLngPoint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class CoordConverttask {
	
	double lat;
	double lng;
	int originCoordType;
	int resultCoordType;
	Context context;
	double reslat;
	double reslng;
	LayoutInflater inflater;
	TextView tv;

	public CoordConverttask(double lat, double lng, int originCoordType,
			int resultCoordType,
			Context context,
			TextView tv) {
		
		this.lat = lat;
		this.lng = lng;
		this.originCoordType = originCoordType;
		this.resultCoordType = resultCoordType;
		this.context = context;
		this.tv = tv;
		MyLatLngPoint point = new MyLatLngPoint(lat, lng);
		inflater = LayoutInflater.from(context);
		//执行转换
		switch(originCoordType){
		case CoordType.CT_WGS84:
		case CoordType.CT_GOOGLE_EARTH:
		case CoordType.CT_GPS_DEVICE:
			WGS84_OTHER(point);
			break;
		case CoordType.CT_BD09:
			BD09_OTHER(point);
			break;
		case CoordType.CT_GCJ02:
		case CoordType.CT_GOOGLE_MAP:
		case CoordType.CT_AMAP_GAODE:
		case CoordType.CT_TECENT:
			GCJ02_OTHER(point);
			break;
		
		}
	}
	
	private void WGS84_OTHER(MyLatLngPoint point){
		switch(resultCoordType){
		case CoordType.CT_WGS84:
			showWGS84(point);
			break;
		case CoordType.CT_GOOGLE_EARTH:
			showGoogleEarth(point);
			break;
		case CoordType.CT_GPS_DEVICE:
			showGpsDevides(point);
			break;
		case CoordType.CT_BD09:			
			showBd09(CoordMath.wgs2bd(point));
			break;
		case CoordType.CT_GCJ02:			
			showGcj02(CoordMath.wgs2gcj(point));
			break;
		case CoordType.CT_GOOGLE_MAP:			
			showGoogleMap(CoordMath.wgs2gcj(point));
			break;
		case CoordType.CT_AMAP_GAODE:			
			showGaode(CoordMath.wgs2gcj(point));
			break;
		case CoordType.CT_TECENT:						
			showTencent(CoordMath.wgs2gcj(point));
			break;
		
		}
	}
	
	private void BD09_OTHER(MyLatLngPoint point){
		switch(resultCoordType){
		case CoordType.CT_WGS84:
			showWGS84(CoordMath.bd2wgs(point));
			break;
		case CoordType.CT_GOOGLE_EARTH:
			showGoogleEarth(CoordMath.bd2wgs(point));
			break;
		case CoordType.CT_GPS_DEVICE:
			showGpsDevides(CoordMath.bd2wgs(point));			
			break;
		case CoordType.CT_BD09:
			showBd09(point);
			break;
		case CoordType.CT_GCJ02:
			showGcj02(CoordMath.bd2gcj(point));
			break;
		case CoordType.CT_GOOGLE_MAP:
			showGoogleMap(CoordMath.bd2gcj(point));
			break;
		case CoordType.CT_AMAP_GAODE:
			showGaode(CoordMath.bd2gcj(point));
			break;
		case CoordType.CT_TECENT:
			showTencent(CoordMath.bd2gcj(point));
			break;
		
		}
	}
	
	private void GCJ02_OTHER(MyLatLngPoint point){
		switch(resultCoordType){
		case CoordType.CT_WGS84:
			showWGS84(CoordMath.gcj2wgs(point));
			break;
		case CoordType.CT_GOOGLE_EARTH:
			showGoogleEarth(CoordMath.gcj2wgs(point));
			break;
		case CoordType.CT_GPS_DEVICE:
			showGpsDevides(CoordMath.gcj2wgs(point));
			break;
		case CoordType.CT_BD09:
			showBd09(CoordMath.gcj2bd(point));
			break;
		case CoordType.CT_GCJ02:
			showGcj02(point);
			break;
		case CoordType.CT_GOOGLE_MAP:
			showGoogleMap(point);
			break;
		case CoordType.CT_AMAP_GAODE:
			showGaode(point);
			break;
		case CoordType.CT_TECENT:
			showTencent(point);
			break;
		
		}
	}
	
	
	private void showWGS84(MyLatLngPoint point){
		setTextViewText(R.id.ac_coord_convert_result_WGS84,point);
	}
	
	private void showGcj02(MyLatLngPoint point){
		setTextViewText(R.id.ac_coord_convert_result_GCJ02,point);
	}
	
	private void showBd09(MyLatLngPoint point){
		setTextViewText(R.id.ac_coord_convert_result_BAIDU,point);
	}
	
	private void showGoogleEarth(MyLatLngPoint point){
		setTextViewText(R.id.ac_coord_convert_result_GOOGLE_EARTH,point);
	}
	
	private void showGoogleMap(MyLatLngPoint point){
		setTextViewText(R.id.ac_coord_convert_result_GOOGLE_MAP,point);
	}
	
	private void showGpsDevides(MyLatLngPoint point){
		setTextViewText(R.id.ac_coord_convert_result_GPS_DEVICE,point);
	}
	
	private void showGaode(MyLatLngPoint point){
		setTextViewText(R.id.ac_coord_convert_result_AMAP,point);
	}
	
	private void showTencent(MyLatLngPoint point){
		setTextViewText(R.id.ac_coord_convert_result_TECENT,point);
	}
	
	
	/**
	 * 设置指定textView的文本，这里用来设置转换后的坐标值
	 * @param textViewID
	 * @param point
	 */
	private void setTextViewText(int textViewID,MyLatLngPoint point){
		View view = (View) inflater.inflate(R.layout.activity_coordconvert, null);
		//Log.v("SHANG", view.toString());
		
		
		if(tv != null){
			//Log.v("SHANG-tv", tv.toString());
			tv.setText(point.getLng()+","+point.getLat());	
			//tv.invalidate();
		}
	}
	
	
	
	
	

	
}
