package com.rlms.Repository;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/**
 * Created by srishti on 27/07/17.
 */
public class RestClient {

    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String HEADER_ACCEPT = "accept";
    protected String mContentType = "application/json";

    public String mUrl = null;
    private HttpMethod mHttpMethod = HttpMethod.POST;

    protected String mBody ;
    private TrustManager[] mTrustManagers;
    protected boolean mShouldCacheResponse = false;
    private boolean mInvalidateCacheOnSuccess = false; //if set to true, this will clear the complete cache folder for that particular api before caching the new response.

    public RestClient(){super();}

    public RestClient(String url, HttpMethod requestType) {
        super();
        this.mUrl = url;
        this.mHttpMethod = requestType;
        this.mShouldCacheResponse = false;
    }

    public void setBody(String body) {
        this.mBody = body;
    }

    public void setContentType(String contentType) {
        this.mContentType = contentType;
    }

    public boolean isUrlHttps() {
        boolean isUrlHttps = false;
        if (this.mUrl != null) {
            isUrlHttps = this.mUrl.startsWith("https://");
        }
        return isUrlHttps;
    }

    private HttpURLConnection initializeHttpUrlConnectionRequest() throws IOException {
        URL url = new URL(mUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        if (this.isUrlHttps() && (httpURLConnection instanceof HttpsURLConnection)) {
            /**
             * If the url is an https url, the openConnection method will return an instance of the HttpsURLConnection class
             * other wise it will return an instance of HttpURLConnection.
             * Initialize the trust managers only if the connection is an https connection.
             */
            this.initializeHttpsConnection((HttpsURLConnection) httpURLConnection);
        }
        httpURLConnection.setUseCaches(true);
        httpURLConnection.setRequestMethod(mHttpMethod.getHttpMethodString());
//        httpURLConnection.setConnectTimeout(APIHelper.getConnectionTimeOut());
        httpURLConnection.setRequestProperty("Content-Type", this.mContentType);//HTTP.CONTENT_TYPE
       // httpURLConnection.setRequestProperty(HEADER_ACCEPT, APIHelper.getAcceptHeader());
        if (APIHelper.getAuthorizationHeader() != null)
            httpURLConnection.setRequestProperty(HEADER_AUTHORIZATION, APIHelper.getAuthorizationHeader());
        if (this.mBody != null)
            addBodyContent(httpURLConnection);
        return httpURLConnection;
    }

    public void addBodyContent(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.setDoOutput(true);
        OutputStream outputStream = (OutputStream) httpURLConnection.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.write(this.mBody);
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }

    private void initializeHttpsConnection(HttpsURLConnection conn) {
        if (this.mTrustManagers != null) {
            try {
                //TODO - why is TLS used here? Figure out the alternatives and significance.
                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, this.mTrustManagers, null);
                conn.setSSLSocketFactory(sslContext.getSocketFactory());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public HttpURLConnection getUrlConnection() throws IOException {
        return initializeHttpUrlConnectionRequest();
    }
}
