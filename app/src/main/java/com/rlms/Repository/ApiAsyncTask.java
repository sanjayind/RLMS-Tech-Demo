package com.rlms.Repository;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.rlms.R;
import com.rlms.apiresponsehandler.ApiResponseListener;
import com.rlms.apiresponsehandler.AsyncApiResponse;
import com.rlms.exception.ApiException;
import com.rlms.utils.CommonUtil;
import com.rlms.utils.RLMSApplication;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;


public class ApiAsyncTask<T> extends AsyncTask<RestClient, Float, AsyncApiResponse> {

    int statusCode = 0;
    private Class<T> mClassType;
    private RestClient restClientInExecution;
    private WeakReference<ApiResponseListener> weakCallbackRef;

    public ApiAsyncTask(ApiResponseListener eventListener, Class<T> classType) {
        weakCallbackRef = new WeakReference<ApiResponseListener>(eventListener);
        this.mClassType = classType;
    }

    public ApiAsyncTask startRequestExecution(RestClient restClient, ReqPriority reqPriority) {
        if (reqPriority == ReqPriority.HIGH) {
            return (ApiAsyncTask) executeOnExecutor(ForegroundReqExecutor.getInstance(), restClient);
        } else {
            return (ApiAsyncTask) executeOnExecutor(BackgroundReqExecutor.getInstance(), restClient);
        }
    }

    @Override
    protected AsyncApiResponse doInBackground(RestClient... params) {
        restClientInExecution = params[0];
        AsyncApiResponse responseModel = this.executeConnection(restClientInExecution);
        return responseModel;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        weakCallbackRef = null;
    }

    private AsyncApiResponse executeConnection(RestClient restClient) {
        AsyncApiResponse responseModel = null;
        HttpURLConnection httpUrlConnection = null;
        long startTime = System.currentTimeMillis();
        long totalTime = 0L;
        try {
            if (!CommonUtil.isNetworkAvaliable(RLMSApplication.getAppContext())) {
                statusCode = ApiException.NO_CONNECTION_STATUS_CODE;
                throw new ApiException(statusCode, ApiException.API_EXCEPTION_TYPE.HTTP_EXCEPTION, RLMSApplication.getAppContext().getResources().getString(R.string.no_connection));
            }
            httpUrlConnection = getUrlConnection(restClient);

            if (httpUrlConnection != null) {
                if (this.isCancelled()) {
                    return null;
                }
                statusCode = httpUrlConnection.getResponseCode();
                if (this.isCancelled()) {
                    return null;
                }
                // Get elapsed time in seconds
                totalTime = System.currentTimeMillis() - startTime;
                if (statusCode != HttpURLConnection.HTTP_OK) {

                    // if server provided the error message then use that
                    // else use generic message based on status code
                    String errorMessage = getErrorMessage(httpUrlConnection.getErrorStream());
                    if (this.isCancelled()) {
                        return null;
                    } else {
                        throw new ApiException(statusCode, ApiException.API_EXCEPTION_TYPE.HTTP_EXCEPTION, errorMessage);
                    }
                }
                if (this.isCancelled()) {
                    return null;
                } else {
                    responseModel = this.processSuccessResponse(httpUrlConnection.getInputStream(), restClient.mUrl);


                }
            }
        } catch (IOException e) {
            String errorMessage = httpUrlConnection != null ? getErrorMessage(httpUrlConnection.getErrorStream()) : RLMSApplication.getAppContext().getResources().getString(R.string.server_conn_error);
            responseModel = new AsyncApiResponse(new ApiException(statusCode, ApiException.API_EXCEPTION_TYPE.HTTP_EXCEPTION, errorMessage));
        } catch (JsonSyntaxException e) {
            responseModel = new AsyncApiResponse(new ApiException(statusCode, ApiException.API_EXCEPTION_TYPE.HTTP_EXCEPTION, RLMSApplication.getAppContext().getResources().getString(R.string.parsing_error)));
        } catch (ApiException e) {
                responseModel = new AsyncApiResponse(e);
        } catch (Exception e) {
            responseModel = new AsyncApiResponse(new ApiException(ApiException.API_EXCEPTION_TYPE.IO_EXCEPTION, RLMSApplication.getAppContext().getResources().getString(R.string.something_went_wrong)));
        } finally {
            if (httpUrlConnection != null) {
                httpUrlConnection.disconnect();
            }
//            if (statusCode == HttpURLConnection.HTTP_OK) {
//
//            } else {
//
//            }
        }

        return responseModel;
    }

    private String getErrorMessage(InputStream stream) {
        String errorMessage;
        try {
            if (stream != null) {
                errorMessage = convertToString(stream);

                // if server provided error message is empty then user generic error message
                if (errorMessage == null || errorMessage.isEmpty()) {
                    errorMessage = CommonUtil.getErrorMessage(statusCode);
                }

            } else {
                // if server not provided any message, use generic message
                errorMessage = CommonUtil.getErrorMessage(statusCode);
            }
        } catch (IOException ex) {
            errorMessage = CommonUtil.getErrorMessage(statusCode);
        }

        return errorMessage;
    }


    protected HttpURLConnection getUrlConnection(RestClient restClient) throws IOException {
        return restClient.getUrlConnection();
    }

    @Override
    protected void onPostExecute(AsyncApiResponse result) {

        if (result != null && result.getException() != null && result.getException().getHttpStatusCode() == HttpURLConnection.HTTP_UNAUTHORIZED) {

        }
        if (this.weakCallbackRef != null) {
            ApiResponseListener resp = this.weakCallbackRef.get();
            if (resp != null && result != null && result.getException() == null) {
                resp.onSuccess(result.getResultModel(), result.getApiResponseMode());
            } else if (resp != null) {
                if (result == null) {
                    resp.onError(null,new ApiException(statusCode, ApiException.API_EXCEPTION_TYPE.HTTP_EXCEPTION, RLMSApplication.getAppContext().getResources().getString(R.string.http_generic)));
                } else {
                    resp.onError(null,result.getException());
                }
            }
            weakCallbackRef = null;
        }
    }

    protected AsyncApiResponse processErrorResponse(HttpURLConnection urlConnection) throws Exception {
        AsyncApiResponse<T> response = null;
        if (urlConnection != null) {
            String errorString = this.convertToString(urlConnection.getErrorStream());
            if (errorString != null) {
                response = new AsyncApiResponse(null);
            }
        }
        return response;
    }

    private AsyncApiResponse processSuccessResponse(InputStream inputStream, String url) throws JsonSyntaxException {
        AsyncApiResponse<T> result = null;
        try {
            if (inputStream != null) {
                String parsedResponse = this.convertToString(inputStream);
                if (parsedResponse != null) {
                    result = new AsyncApiResponse<T>(new Gson().fromJson(parsedResponse, mClassType));
                }
            }
        } catch (IOException e) {
            result = new AsyncApiResponse(new ApiException(ApiException.API_EXCEPTION_TYPE.IO_EXCEPTION, RLMSApplication.getAppContext().getResources().getString(R.string.parsing_error)));
        }
        return result;
    }


    private String convertToString(InputStream result) throws IOException {
        String response = null;
        ByteArrayOutputStream bOutStream = new ByteArrayOutputStream();
        try {
            if (result != null) {
                int bytesRead = 0;
                int curBytesRead = 0;
                byte[] buff = new byte[1024];

                while ((curBytesRead = result.read(buff)) != -1) {
                    bytesRead = bytesRead + curBytesRead;

                    bOutStream.write(buff, 0, curBytesRead);
                }

                byte[] data = bOutStream.toByteArray();
                response = new String(data);
            }
        } catch (IOException e) {
        } finally {
            bOutStream.close();
        }
        return response;
    }

}
