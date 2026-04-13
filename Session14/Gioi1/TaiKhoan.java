package Session14.Gioi1;
import java.util.*;
class MyException extends RuntimeException{
    public MyException(){

    }
    public MyException(String message){
        super(message);
    }
}
public class TaiKhoan {
    public String soTaiKhoan;
    public double soDu;
    public enum the{MBBank, Vietcombank, Techombank, Agribank};
    public the loai;
    public double getSoDu() {
        return soDu;
    }

    public TaiKhoan(){
        this.soDu = 1000000;
    }
    public void setSoDu(double soTienRut) {
        if(soDu < 50000) {
            System.out.println("Số dự của bạn là: "+soDu);
            throw new MyException("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
        }else if(soDu < soTienRut){
            System.out.println("Số dự của bạn là: "+soDu);
            throw new MyException("Lỗi: Số tiền rút vượt quá số dư!");
        }else{
            this.soDu = soDu - soTienRut;
        }
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        if(!soTaiKhoan.trim().isEmpty() && soTaiKhoan.matches("^03373\\d{5}$")){
            this.soTaiKhoan = soTaiKhoan;
        }else{
            throw new MyException("Số tài khoản không hợp lệ(03373 + 12345)");
        }
    }
}
