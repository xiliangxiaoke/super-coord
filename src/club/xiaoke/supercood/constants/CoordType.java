package club.xiaoke.supercood.constants;

public class CoordType {
	
	/**
	 * wgs84
	 */
	public static int CT_WGS84 = 0X0001;
	/**
	 * 国测局
	 * guo jia ce hui ju 
	 */
	public static int CT_GCJ02 = 0X0002;
	/**
	 * 百度
	 * baidu
	 */
	public static int CT_BD09 = 0X0003;
	/**
	 * google earth
	 */
	public static int CT_GOOGLE_EARTH = CT_WGS84;
	/**
	 * GPS模块
	 */
	public static int CT_GPS_DEVICE = CT_WGS84;
	
	/**
	 * 谷歌地图
	 */
	public static int CT_GOOGLE_MAP = CT_GCJ02;
	/**
	 * 高德地图
	 */
	public static int CT_AMAP_GAODE = CT_GCJ02;
	
	/**
	 * 腾讯地图
	 */
	public static int CT_TECENT = CT_GCJ02;

}
