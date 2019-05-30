import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModernCar extends Car {

    @Override
    public void showCarInfo() {
        try {
            Connection con = JDBCConnection.getJDBCConection();
            Statement statement = con.createStatement();

            String sql = "SELECT * FROM CAR";

            ResultSet rs = statement.executeQuery(sql);

            System.out.println("*** DANH SÁCH Ô TÔ ĐỜI MỚI ***");
            System.out.println("Mã số xe ----- Hãng xe ----- Biển số ----- Năm sản xuất ----- Bảo hiểm ----- Định vị ----- Trợ lực ----- Năm sử dụng");
            while (rs.next()) {
                int id = rs.getInt(1);
                String brand = rs.getString(2);
                String numberPlate = rs.getString(3);
                String year = rs.getString(4);
                String insurance;
                String positioningDevice;
                String powerSteering;
                int actionDuration = 2019 - Integer.parseInt(year);

                if (rs.getInt(5) == 1) {
                    insurance = "Có";
                } else {
                    insurance = "Không";
                }
                if (rs.getInt(6) == 1) {
                    positioningDevice = "Có";
                } else {
                    positioningDevice = "Không";
                }
                if (rs.getString(7) == "1") {
                    powerSteering = "Có";
                } else {
                    powerSteering = "Không";
                }
                if(Integer.parseInt(year) >= 2010) {
                    System.out.println(id+ "     " +brand + "     " + numberPlate + "     " + year + "     " + insurance + "     " + positioningDevice + "     " + powerSteering + "     " + actionDuration);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}