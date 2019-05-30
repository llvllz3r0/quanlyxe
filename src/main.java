import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int select;
        do {
            System.out.println("---- CỬA HÀNG BÁN BẢO HIỂM LẬU ----");
            System.out.println("***********************************");
            System.out.println("Danh sách dịch vụ");
            System.out.println("1 - Hiện thị danh sách xe ăn cắp được");
            System.out.println("2 - Hiện thị danh sách xe ăn cắp ngon");
            System.out.println("3 - Hiện thị danh sách xe ăn cắp bình thường");
            System.out.println("4 - Hiện thị danh sách xe ăn cắp lởm");
            System.out.println("5 - Mua bảo hiểm cái nhỉ");
            System.out.println("6 - Toàn xe đểu không mua!");
            System.out.println("Chọn đê: ");
            select = scan.nextInt();
            switch (select){
                case 1: {
                    Car c = new Car();
                    c.showCarInfo();
                    break;
                }
                case 2: {
                    Car c = new ModernCar();
                    c.showCarInfo();
                    break;
                }
                case 3: {
                    Car c = new MediumCar();
                    c.showCarInfo();
                    break;
                }
                case 4: {
                    Car c = new OldCar();
                    c.showCarInfo();
                    break;
                }
                case 5: {
                    InsurancePackage ins = new InsurancePackage();
                    ins.SellInsurance();
                    break;
                }
                default: System.out.println("Biến nhé");
            }
        } while( select > 0 && select <=5 );

    }
}
