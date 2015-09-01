package com.example.engine;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.example.bean.ColumnItem;
import com.example.bean.CommonException;
import com.example.utils.DataUtil;
import com.example.utils.URLUtil;


/**
 * 处理NewItem的业务类
 * 
 * @author hzc
 * 
 */
public class ColumnItemBiz {
	/**
	 * 业界、移动、云计算
	 * 
	 * @param htmlStr
	 * @return
	 * @throws CommonException
	 */
	public List<ColumnItem> getColumnItems(int newsType, int currentPage)
			throws CommonException {
		String urlStr = URLUtil.generateUrl(newsType, currentPage);

		String htmlStr = DataUtil.doGet(urlStr);

		List<ColumnItem> newsItems = new ArrayList<ColumnItem>();
		ColumnItem newsItem = null;

		Document doc = Jsoup.parse(htmlStr);
		Elements units = doc.getElementsByClass("postlist");
		for (int i = 0; i < units.size(); i++) {
			newsItem = new ColumnItem();
			newsItem.setColumnType(newsType);

			Element unit_ele = units.get(i);
			Element h1_ele = unit_ele.getElementsByTag("h4").get(0);
			Element h1_a_ele = h1_ele.child(0);
			String title = h1_a_ele.text();
			String href = h1_a_ele.attr("href");
			
			newsItem.setLink(href);
			newsItem.setTitle(title);
			
			Element unit_content = unit_ele.child(1);
			String content = unit_content.text();
			newsItem.setContent(content);
			
			Element unit_date = unit_ele.child(2);
			//Element unit_categoty_one = unit_date.child(0);
			String date = unit_date.text().substring(0, unit_date.text().indexOf("|")) ;
			newsItem.setDate(date);
//
//			Element dl_ele = unit_ele.getElementsByTag("dl").get(0);// dl
//			Element dt_ele = dl_ele.child(0);// dt
//			try {// 可能没有图片
//				Element img_ele = dt_ele.child(0);
//				String imgLink = img_ele.child(0).attr("src");
//				newsItem.setImgLink(imgLink);
//			} catch (IndexOutOfBoundsException e) {
//
//			}
//			Element content_ele = dl_ele.child(1);// dd
//			String content = content_ele.text();
//			newsItem.setContent(content);
			newsItems.add(newsItem);
		}

		return newsItems;

	}

}
