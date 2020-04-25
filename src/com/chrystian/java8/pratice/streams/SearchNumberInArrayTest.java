package com.chrystian.java8.pratice.streams;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SearchNumberInArrayTest {

    private String searchNumberInArray(int[] array, int input){
        long count =  IntStream.of(array).filter(i -> i == input).count();
        if (count > 0)
            return "Yes";
        else
            return "No";
    }

    static String findNumber(List<Integer> arr, int k) {
        long count =  arr.stream().filter(i -> i == k).count();
        if (count > 0)
            return "YES";
        else
            return "NO";

    }

    static List<Integer> oddNumbers(int l, int r) {
        List<Integer> result = new ArrayList<>();
        IntStream.range(l, r+1).forEach(i -> {
            if ( i%2 != 0){
                result.add(i);
            }
        });
        return result;
    }


    public static String makeRequest(String substr) throws IOException {
        URL urlForGetRequest = new URL("https://jsonmock.hackerrank.com/api/movies/search/");
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        conection.setRequestProperty("Title", substr);
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            }
            in.close();
            // print result
//            System.out.println("JSON String Result " + response.toString());
            return response.toString();
            //GetAndPost.POSTRequest(response.toString());
        } else {
            System.out.println("GET NOT WORKED");
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        String response = makeRequest("maze");
//        getValuesForGivenKey(response, substr);
    }
//    public List<String> getValuesForGivenKey(String jsonArrayStr, String key) {
//        JSONArray jsonArray = new JSONArray(jsonArrayStr);
//        return IntStream.range(0, jsonArray.length())
//                .mapToObj(index -> ((JSONObject)jsonArray.get(index)).optString(key))
//                .collect(Collectors.toList());
//    }


//    public static String executeGet() throws MalformedURLException,
//            ProtocolException, IOException {
//        String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=substr";
//        URL myurl = new URL(url);
//        HttpURLConnection con;
//        con = (HttpURLConnection) myurl.openConnection();
//        try {
//
//
//            con.setRequestMethod("GET");
//
//            StringBuilder content;
//
//            try (BufferedReader in = new BufferedReader(
//                    new InputStreamReader(con.getInputStream()))) {
//
//                String line;
//                content = new StringBuilder();
//
//                while ((line = in.readLine()) != null) {
//                    content.append(line);
//                    content.append(System.lineSeparator());
//                }
//            }
//
//            System.out.println(content.toString());
//
//        } finally {
//
//            con.disconnect();
//        }
//    }
//    public static String executePost(String targetURL, String urlParameters) {
//        HttpURLConnection connection = null;
//
//        try {
//            //Create connection
//            URL url = new URL(targetURL);
//            connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("POST");
//            connection.setRequestProperty("Content-Type",
//                    "application/x-www-form-urlencoded");
//
//            connection.setRequestProperty("Content-Length",
//                    Integer.toString(urlParameters.getBytes().length));
//            connection.setRequestProperty("Content-Language", "en-US");
//
//            connection.setUseCaches(false);
//            connection.setDoOutput(true);
//
//            //Send request
//            DataOutputStream wr = new DataOutputStream (
//                    connection.getOutputStream());
//            wr.writeBytes(urlParameters);
//            wr.close();
//
//            //Get Response
//            InputStream is = connection.getInputStream();
//            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
//            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
//            String line;
//            while ((line = rd.readLine()) != null) {
//                response.append(line);
//                response.append('\r');
//            }
//            rd.close();
//            return response.toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            if (connection != null) {
//                connection.disconnect();
//            }
//        }
//    }
}
