package com.boliangshenghe.eqim.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

//13916381779
/**
 * 航班信息
 * @author xuzj
 *
 */
public class FlightUtils {

	public static String makeRequest(String flightNo,String date) throws Exception {
		String url = "http://apemesh.market.alicloudapi.com/devices/055a2472-fd32-595f-add1-726f9987d4d3/invoke-action";
		URL object = new URL(url);

		HttpURLConnection con = (HttpURLConnection) object.openConnection();
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
		con.setRequestProperty("Authorization",
				"APPCODE 46b8fc4323a74f3bbc412de17c9c77c9");
		con.setRequestMethod("POST");

		JSONObject requestData = new JSONObject();
		requestData.put("serviceID", "urn:cdif-io:serviceID:航班信息查询服务");
		requestData.put("actionName", "起降时间查询");

		JSONObject input = new JSONObject();
		input.put("flightNo", flightNo); // 航班号
		input.put("date", date); // 航班时间

		requestData.put("input", input);

		OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
		wr.write(requestData.toString());
		wr.flush();

		// display what returns the POST request
		StringBuilder sb = new StringBuilder();
		int HttpResult = con.getResponseCode();
		if (HttpResult == HttpURLConnection.HTTP_OK) {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					con.getInputStream(), "utf-8"));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();

			return sb.toString();
			//JSONObject(sb.toString())
			//System.out.println("" + sb.toString()); // 打印成功返回结果，可用new
													// JSONObject(sb.toString())构建返回结果对象
		} else {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					con.getErrorStream(), "utf-8"));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			JSONObject result = new JSONObject(sb.toString()); // 错误返回JSON对象的读取方法
			JSONObject fault = result.getJSONObject("fault");
			String reason = fault.getString("reason"); // 获取错误具体原因
			return reason;
			//System.out.println(reason);
		}
	}
}
