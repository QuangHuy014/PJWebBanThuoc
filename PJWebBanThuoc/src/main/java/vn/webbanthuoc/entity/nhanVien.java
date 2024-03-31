package vn.webbanthuoc.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NhanVien")
public class nhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMaNV;
    private String ten;
    private int age;
    private Date birthday;
    private boolean vaiTro;
    private String diaChi;
    private boolean gioiTinh;
    private boolean trangThai;
    private String matKhau;
    private String tenDangNhap;
    
   
}
