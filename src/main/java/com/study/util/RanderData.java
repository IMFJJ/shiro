package com.study.util;

import com.alibaba.fastjson.JSON;
import com.study.controller.UserController;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RanderData {
	/**
	 * 通过PrintWriter将响应数据写入response，ajax可以接受到这个数据
	 *
	 * @param response
	 * @param data
	 */
	public static void renderData(HttpServletResponse response, String data, Class class1) {
		PrintWriter printWriter = null;
		try {
//			response.setHeader("Content-Type","text/html;charset=UTF-8");
//			response.setCharacterEncoding("utf-8");
			response.setContentType ("text/html;charset=UTF-8");
			printWriter = response.getWriter();
			printWriter.print(data);
		} catch (IOException ex) {
			Logger.getLogger(class1.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (null != printWriter) {
				printWriter.flush();
				printWriter.close();
			}
		}
	}

	public static void newRenderData(HttpServletResponse resp, List<Object> objectList) {
		Map<String, Object> map1 = new HashMap<String, Object>(10);
		List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>(5);
		if(objectList.size()>0)
		{
			map1.put("draw", 2);
			map1.put("recordsTotal", objectList.size());
			map1.put("recordsFiltered", objectList.size());
			map1.put("data", objectList);
			datas.add(map1);
			String jsonResult = JSON.toJSONString(datas);
			int length=jsonResult.length();
			if(length>1)
			{
				jsonResult=jsonResult.substring(1, length-1);
			}
			RanderData.renderData(resp, jsonResult, UserController.class);
		}
	}


	/**
	 * 向指定 URL 发送POST方法的请求
	 *
	 * @param url 发送请求的 URL
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
		}
		//使用finally块来关闭输出流、输入流
		finally{
			try{
				if(out!=null){
					out.close();
				}
				if(in!=null){
					in.close();
				}
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		return result;
	}


}
