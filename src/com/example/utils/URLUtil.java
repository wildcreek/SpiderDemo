package com.example.utils;

public class URLUtil {

	public static final String COLUMN_MOVIE_URL = "http://www.longbl.com/movie";
	public static final String COLUMN_TELIVISION_URL = "http://www.longbl.com/television";
	public static final String COLUMN_CARTOON_URL = "http://www.longbl.com/dongman";
	public static final String COLUMN_VIDEO_URL = "http://www.longbl.com/video";
//	public static final String COLUMN_DLDY_URL = "http://www.longbl.com/movie/dldy/";
//	public static final String COLUMN_GTDY_URL = "http://www.longbl.com/movie/dldy/";

	/**
	 * 根据文章类型，和当前页码生成url
	 * 
	 * @param newsType
	 * @param currentPage
	 * @return
	 */
	public static String generateUrl(int newsType, int currentPage) {
		currentPage = currentPage > 0 ? currentPage : 1;
		String urlStr = "";
		switch (newsType) {
		case Constaint.COLUMN_TYPE_MOVIE:
			urlStr = COLUMN_MOVIE_URL;
			break;
		case Constaint.COLUMN_TYPE_TELIVISION:
			urlStr = COLUMN_TELIVISION_URL;
			break;
		case Constaint.COLUMN_TYPE_CARTOON:
			urlStr = COLUMN_CARTOON_URL;
			break;
		case Constaint.COLUMN_TYPE_VIDEO:
			urlStr = COLUMN_VIDEO_URL;
			break;
		default:
			urlStr = COLUMN_MOVIE_URL;
			break;
		}

		//urlStr += "/page/"+currentPage;

		return urlStr;

	}

}
