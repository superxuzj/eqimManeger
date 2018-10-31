package com.boliangshenghe.eqim.util;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.util.Assert;


public class HttpClientUtils {
    /**
     * 连接超时时间 单位 毫秒
     */
    public static final int CONNECTION_TIMEOUT_MS = 90000;

    /**
     * 读取数据超时时间
     */
    public static final int SO_TIMEOUT_MS = 90000;

    /**
     * httpclient读取内容时使用的字符集
     */
    public static final String DEFAULT_CHARSET_UTF8 = "UTF-8";
    public static final Charset UTF_8 = Charset.forName(DEFAULT_CHARSET_UTF8);


    /**
     * 简单get调用
     *
     * @param url
     * @param params
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @throws URISyntaxException
     */
    public static String doGet(String url, Map<String, String> params) {
        return doGet(url, params, DEFAULT_CHARSET_UTF8);
    }

    /**
     * 调用get
     * @param url
     * @return
     */
    public static String doGet(String url){
        return doGet(url,null,DEFAULT_CHARSET_UTF8);
    }

    /**
     * 简单get调用
     *
     * @param url
     * @param params
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @throws URISyntaxException
     */
    public static String doGet(String url, Map<String, String> params, String charset) {

        HttpClient client = buildHttpClient(false);

        HttpGet get;
        try {
            get = buildHttpGet(url, params);
            HttpResponse response;
            response = client.execute(get);
            assertStatus(response);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String returnStr = EntityUtils.toString(entity, charset);
                return returnStr;
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 简单post调用
     *
     * @param url
     * @param params
     * @return
     * @throws URISyntaxException
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String doPost(String url, Map<String, String> params) {
        return doPost(url, params, DEFAULT_CHARSET_UTF8);
    }

    /**
     * 简单post调用
     *
     * @param url
     * @param params
     * @return
     * @throws URISyntaxException
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String doPost(String url, Map<String, String> params, String charset){


        try {
            HttpClient client = buildHttpClient(false);

            HttpPost postMethod = buildHttpPost(url, params);
            HttpResponse response;
            response = client.execute(postMethod);
            assertStatus(response);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String returnStr;
                returnStr = EntityUtils.toString(entity, charset);
                return returnStr;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 创建HttpClient
     *
     * @param isMultiThread
     * @return
     */
    public static HttpClient buildHttpClient(boolean isMultiThread) {

        CloseableHttpClient client;

        if (isMultiThread){
            client = HttpClientBuilder
                    .create()
                    .setConnectionManager(
                            new PoolingHttpClientConnectionManager()).build();
        }else{
            client = HttpClientBuilder.create().build();
        }
        // 设置代理服务器地址和端口
        // client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port);
        return client;
    }

    /**
     * 构建httpPost对象
     *
     * @param url
     * @return
     * @throws UnsupportedEncodingException
     * @throws URISyntaxException
     */
    public static HttpPost buildHttpPost(String url, Map<String, String> params) {
        Assert.notNull(url, "构建HttpPost时,url不能为null");
        HttpPost post = new HttpPost(url);
        setCommonHttpMethod(post);
        HttpEntity he = null;
        if (params != null) {
            List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            for (String key : params.keySet()) {
                formparams.add(new BasicNameValuePair(key, params.get(key)));
            }
            he = new UrlEncodedFormEntity(formparams, UTF_8);
            post.setEntity(he);
        }
        // 在RequestContent.process中会自动写入消息体的长度，自己不用写入，写入反而检测报错
        // setContentLength(post, he);
        return post;

    }

    /**
     * 构建httpGet对象
     *
     * @param url
     * @return
     * @throws URISyntaxException
     */
    public static HttpGet buildHttpGet(String url, Map<String, String> params)
            throws URISyntaxException {
        Assert.notNull(url, "构建HttpGet时,url不能为null");
        HttpGet get = new HttpGet(buildGetUrl(url, params));
        return get;
    }

    /**
     * build getUrl str
     *
     * @param url
     * @param params
     * @return
     */
    private static String buildGetUrl(String url, Map<String, String> params) {
        StringBuffer uriStr = new StringBuffer(url);
        try {
            if (params != null) {
                List<NameValuePair> ps = new ArrayList<NameValuePair>();
                for (String key : params.keySet()) {
                    ps.add(new BasicNameValuePair(key, params.get(key)));
                }
                uriStr.append("?");
                uriStr.append(URLEncodedUtils.format(ps, UTF_8));
            }
        }catch (Exception e){
        	e.printStackTrace();
        }
        return uriStr.toString();
    }

    /**
     * 设置HttpMethod通用配置
     *
     * @param httpMethod
     */
    public static void setCommonHttpMethod(HttpRequestBase httpMethod) {
        httpMethod.setHeader(HTTP.CONTENT_ENCODING, DEFAULT_CHARSET_UTF8);// setting
    }

    /**
     * 设置成消息体的长度 setting MessageBody length
     *
     * @param httpMethod
     * @param he
     */
    public static void setContentLength(HttpRequestBase httpMethod,
                                        HttpEntity he) {
        if (he == null) {
            return;
        }
        httpMethod.setHeader(HTTP.CONTENT_LEN, String.valueOf(he.getContentLength()));
    }

    /**
     * 构建公用RequestConfig
     *
     * @return
     */
    public static RequestConfig buildRequestConfig() {
        // 设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(SO_TIMEOUT_MS)
                .setConnectTimeout(CONNECTION_TIMEOUT_MS).build();
        return requestConfig;
    }

    /**
     * 强验证必须是200状态否则报异常
     *
     * @param res
     */
    static void assertStatus(HttpResponse res) throws IOException {
        Assert.notNull(res, "http响应对象为null");
        Assert.notNull(res.getStatusLine(), "http响应对象的状态为null");
        switch (res.getStatusLine().getStatusCode()) {
            case HttpStatus.SC_OK:
                break;
            default:
                throw new IOException("服务器响应状态异常,失败.");
        }
    }

    private HttpClientUtils() {
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        //System.out.println(doGet("http://www.baidu.com", new HashMap<>()));
    }
}