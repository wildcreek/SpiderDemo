package com.example.utils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.example.bean.CommonException;

public class DataUtil {

	/**
	 * ���ظ����ӵ�ַ��html����
	 * 
	 * @param urlStr
	 * @return
	 * @throws CommonException
	 */
	public static String doGet(String urlStr) throws CommonException {
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5000);
			conn.setDoInput(true);
			conn.setDoOutput(true);

			if (conn.getResponseCode() == 200) {
				InputStream is = conn.getInputStream();
				int len = 0;
				byte[] buf = new byte[1024];

				while ((len = is.read(buf)) != -1) {
					sb.append(new String(buf, 0, len, "UTF-8"));
				}

				is.close();
			} else {
				throw new CommonException("��������ʧ�ܣ�");
			}

		} catch (Exception e) {
			throw new CommonException("��������ʧ�ܣ�");
		}
		return sb.toString();
	}

}
