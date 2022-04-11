package kr.ac.kpu.ce2019152012.hair_you.service;

import android.util.Log;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;

import kr.ac.kpu.ce2019152012.hair_you.dto.ShopDto;

public class GpsService {
    private double latitude;
    private double longitude;
    private String regionAddress;

    private String GEOCODE_URL = "http://dapi.kakao.com/v2/local/search/address.json?query=";
    private String R_GEOCODE_URL = "http://dapi.kakao.com/v2/local/geo/coord2address.json?";
    private String KAKAO_API_KEY = "KakaoAK 6c15981489ac8f7193df22c979df29f2";


    public GpsService(String regionAddress) throws Exception {
        this.latitude = 1;
        this.longitude = 1;
        this.regionAddress = regionAddress;
    }

    public GpsService() {
    }

    public String geocoding(String address) throws Exception {

        try {
            String encodedAddress = URLEncoder.encode(address, "UTF-8");
            URL obj = new URL(GEOCODE_URL + encodedAddress);

            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", KAKAO_API_KEY);
            conn.setRequestProperty("content-type", "application/json");
            conn.setDoOutput(true);
            conn.setDefaultUseCaches(false);
            conn.setUseCaches(false);

            Charset charset = Charset.forName("UTF-8");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));

            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }


            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public String reverseGeocoding(double latitude, double longitude) {
        try {
            String y = String.valueOf(latitude); // 위도
            String x = String.valueOf(longitude); // 경도
            String coordinatesystem = "WGS84";

            URL obj = new URL(R_GEOCODE_URL + "x=" + x + "&y=" + y + "&input_coord=" + coordinatesystem);

            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestMethod("GET"); // request 방식
            conn.setRequestProperty("Authorization", KAKAO_API_KEY); // request 속성
            conn.setRequestProperty("content-type", "application/json");
            conn.setDoOutput(true); // 출력 가능 상태로 설정
            conn.setUseCaches(false);

            Charset charset = Charset.forName("UTF-8");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getCurrentAddress(double latitude, double longitude)throws Exception{
        GpsService gps = new GpsService();
        String json = gps.reverseGeocoding(latitude, longitude);
        String shopAddress;

        try {

            JSONParser jsonParser = new JSONParser();

            // String 객체 json으로 parsing
            JSONObject jsonMain = (JSONObject) jsonParser.parse(json);

            JSONArray jsonDocumentsArr = (JSONArray) jsonMain.get("documents");
            JSONObject documentsObject = (JSONObject) jsonDocumentsArr.get(0);
            JSONObject jsonObject = (JSONObject) documentsObject.get("road_address");

            shopAddress = jsonObject.get("address_name").toString();

            return shopAddress;
        } catch (Exception e){
            Log.i("gps", "getCurrentAddress: "+ e.toString());
            return null;
        }
    }

    public static ArrayList<Double> getLatitudeLongitude(String address) throws Exception{
        GpsService gps = new GpsService();
        String json = gps.geocoding(address);

        // String 객체 json으로 parsing
        JSONParser jsonParser=new JSONParser();

        JSONObject jsonMain = (JSONObject) jsonParser.parse(json); // String->json
        JSONArray jsonDocumentsArr = (JSONArray) jsonMain.get("documents");
        JSONObject jsonObject = (JSONObject) jsonDocumentsArr.get(0);

        double latitude = Double.parseDouble((String)jsonObject.get("y"));
        double longitude = Double.parseDouble((String)jsonObject.get("x"));

        ArrayList<Double> list = new ArrayList<>();
        list.add(latitude); // index : 0
        list.add(longitude); // index : 1

        return list;
    }


}
