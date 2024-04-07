package test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NhanVien")
//@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u order by u.idkhachhang")
public class NhanVien {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "IDKhachHang")
    private int idkhachhang;
    
    @Column(name = "TenDangNhap")
    private String tendangnhap;

    @Column(name = "MatKhau")	
    private String matkhau;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "GioiTinh")
    private boolean gioitinh;

    
	

   
}
