package DomGeneratorXml.util.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huyuanxin
 * @create 2020/12/10 9:31
 */
public class GetColumnFromDataBase {
    public static List<String> getDataBaseColumn(String dataTableName) {
        List<String> list = new ArrayList<>();
        Connection conn = ConfigDataBase.getSqlConnection();
        String sql = String.format("Select * From %s Where 1>2", dataTableName);
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData data = rs.getMetaData();
            for (int i = 1; i <= data.getColumnCount(); i++) {
                String columnName = data.getColumnName(i);
                list.add(columnName);
            }
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        }
        return list;
    }
}
