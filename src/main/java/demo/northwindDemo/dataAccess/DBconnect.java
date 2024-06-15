package demo.northwindDemo.dataAccess;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DBconnect {

    private static volatile DBconnect dbConnect=null;
    private static  String db_url;
    private static  String user;
    private static  String psw;

    private DBconnect(){
           db_url="jdbc:postgresql://localhost:5432/Northwind";
            user="postgres";
            psw ="*";
    }
    private static ResultSet getConnect(String query)
    {

            if (dbConnect==null)
            {
                dbConnect = new DBconnect();
            }
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(db_url, user, psw);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }

    }


    public static JSONArray getJsonList(String query) throws SQLException {
        ResultSet rslt=DBconnect.getConnect(query);
        ResultSetMetaData md = rslt.getMetaData();
        int numCols = md.getColumnCount();
        List<String> colNames = IntStream.range(0, numCols)
                .mapToObj(i -> {
                    try {
                        return md.getColumnName(i + 1);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        return "?";
                    }
                })
                .collect(Collectors.toList());

//        return colNames;

        JSONArray result = new JSONArray();
        while (rslt.next()) {
            JSONObject row = new JSONObject();
            colNames.forEach(cn -> {
                try {
                    row.put(cn, rslt.getObject(cn));
                } catch (JSONException | SQLException e) {
                    e.printStackTrace();
                }
            });
            result.put(row);
        }
        return result;
    }
}
