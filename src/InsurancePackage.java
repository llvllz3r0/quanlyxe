import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class InsurancePackage {
    public void ShowInsurance() {
        try {
            Connection con = JDBCConnection.getJDBCConection();
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM INSURANCE_PACKAGE";
            ResultSet rs = statement.executeQuery(sql);

            System.out.println("*** DANH SÁCH BẢO HIỂM HIỆN CÓ ***");
            System.out.println("Mã bảo hiểm ------ Tên bảo hiểm ------ Kiểu bảo hiểm");
            while (rs.next()) {
                int id = rs.getInt(1);
                String insuranceName = rs.getString(2);
                String insuranceType = rs.getString(3);
                System.out.println(id + "      " +insuranceName+ "      " +insuranceType);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void SellInsurance() {

        try {
            Connection con = JDBCConnection.getJDBCConection();
            Statement statement = con.createStatement();
            String sql1 = "SELECT * FROM CAR";
            ResultSet rs1 = statement.executeQuery(sql1);
            Scanner scan = new Scanner(System.in);
            Car c = new Car();
            c.showCarInfo();
            System.out.println("Nhập mã số xe muốn mua bảo hiểm");
            String selectCar = scan.nextLine();
            while(rs1.next()){
                String sql2 = "SELECT * FROM CAR WHERE ID = " + Integer.parseInt(selectCar);
                ResultSet rs2 = statement.executeQuery(sql2);
                while(rs2.next()) {
                    int year = Integer.parseInt(rs2.getString(4));
                    if (rs2.getInt(5) == 1) {
                        System.out.println("Có bảo hiểm rồi mua làm gì nữa");
                    } else {
                        this.ShowInsurance();
                        System.out.println("Muốn mua bảo hiểm nào: ");
                        String selectInsurance = scan.nextLine();
                        String sql3 = "SELECT * FROM INSURANCE_PACKAGE WHERE ID =" + Integer.parseInt(selectInsurance);
                        ResultSet rs3 = statement.executeQuery(sql3);

                        while(rs3.next()) {
                            String insuranceType = rs3.getString(3);
                            if(year >= 2010 && insuranceType.equals("A") || year < 2010 && year >= 2005 && insuranceType.equals("B") || year < 2005 && insuranceType.equals("C")){
                                String sql4 = "DELETE FROM INSURANCE_PACKAGE WHERE ID = " + Integer.parseInt(selectInsurance);
                                String sql5 = "UPDATE CAR SET INSURANCE = 1 WHERE ID = " +Integer.parseInt(selectCar);
                                ResultSet rs4 = statement.executeQuery(sql4);
                                ResultSet rs5 = statement.executeQuery(sql5);
                                System.out.println("Mua thành công");
                            } else{
                                System.out.println("Chọn nhầm rồi");
                            }
                        }
                    }
                }
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
