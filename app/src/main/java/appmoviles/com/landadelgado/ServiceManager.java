package appmoviles.com.landadelgado;

import com.google.gson.Gson;

import java.io.IOException;

public class ServiceManager {

    public static final String SIMPLEGET_URL = "https://www.icesi.edu.co/";
    public static String CODIGOSHASH_URL = "https://sniff-eb43f.firebaseio.com/Sniff/Hash/%HASH%.json";

    public static class SimpleGET{
        OnResponseListener listener;
        public SimpleGET(OnResponseListener listener){
            this.listener = listener;
            HTTPSWebUtilDomi util = new HTTPSWebUtilDomi();
            try {
                String response = util.GETrequest(SIMPLEGET_URL);
                listener.onResponse(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public interface OnResponseListener{
            void onResponse(String response);
        }
    }

    public static class hashGET{
        OnResponseListener listener;

        public hashGET(String hash, OnResponseListener listener){
            this.listener = listener;
            HTTPSWebUtilDomi util = new HTTPSWebUtilDomi();
            try {
                String response = util.GETrequest(CODIGOSHASH_URL.replace("%HASH%", hash));
                listener.onResponse(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public interface OnResponseListener{
            void onResponse(String response);
        }
    }

    public static class usuariosPOST{
        OnResponseListener listener;
        public usuariosPOST(Hash hash, OnResponseListener listener){
            this.listener = listener;
            HTTPSWebUtilDomi util = new HTTPSWebUtilDomi();
            try {
                Gson g = new Gson();
                String response = util.POSTrequest( CODIGOSHASH_URL, g.toJson(hash) );
                listener.onResponse(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public interface OnResponseListener{
            void onResponse(String response);
        }
    }
}
