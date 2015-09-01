package com.example.test;

import java.util.List;

import com.example.bean.ColumnItem;
import com.example.bean.CommonException;
import com.example.engine.ColumnItemBiz;
import com.example.utils.Constaint;

public class Test {
	public static void main(String[] args) {
		ColumnItemBiz biz = new ColumnItemBiz();
		int currentPage = 1;
		try {
			/**
			 * ҵ��
			 */
			List<ColumnItem> newsItems = biz.getColumnItems(
					Constaint.COLUMN_TYPE_MOVIE, currentPage);
			for (ColumnItem item : newsItems) {
				System.out.println(item);
			}

			System.out.println("----------------------");
			/**
			 * ����Ա��־
			 */
			newsItems = biz.getColumnItems(Constaint.COLUMN_TYPE_TELIVISION,
					currentPage);
			for (ColumnItem item : newsItems) {
				System.out.println(item);
			}
			System.out.println("----------------------");
			/**
			 * �з�
			 */
			newsItems = biz
					.getColumnItems(Constaint.COLUMN_TYPE_CARTOON, currentPage);
			for (ColumnItem item : newsItems) {
				System.out.println(item);
			}
			System.out.println("----------------------");
			/**
			 * �ƶ�
			 */
			newsItems = biz.getColumnItems(Constaint.COLUMN_TYPE_VIDEO,
					currentPage);
			for (ColumnItem item : newsItems) {
				System.out.println(item);
			}
			System.out.println("----------------------");

		} catch (CommonException e) {
			e.printStackTrace();
		}
	}

}
