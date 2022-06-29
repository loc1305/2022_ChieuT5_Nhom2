package resisgter.demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
    public class UserModel {

        private static DatabaseMetaData JDBCDataSource;

        public static long nextPk() {
            long pk = 0;
            Connection conn;
            try {
                conn = JDBCDataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("select Max(id) from user");
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    pk = rs.getLong(1);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return pk+1;

        }
        public static long addUser(User user) {
            int i = 0;
            try {
                Connection conn = JDBCDataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
                stmt.setLong(1, nextPk());
                stmt.setString(2 , user.getUsername() );
                stmt.setString(3 , user.getPassword() );

                i =     stmt.executeUpdate();

            } catch (Exception e) {

                e.printStackTrace();
            }


            return i;
        }

        public static void setJDBCDataSource(DatabaseMetaData JDBCDataSource) {
            UserModel.JDBCDataSource = JDBCDataSource;
        }
    }
}