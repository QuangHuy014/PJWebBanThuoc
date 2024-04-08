//package test;
//
//import javax.persistence.Column;
//
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "KhachHang")
//@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u order by u.idkhachhang")
//public class User {
//	private static final long serialVersionUID = 1L;
//	@Id
//	@Column(name = "IDKhachHang")
//	int idkhachhang;
//	@Column(name = "TenDangNhap")
//	String tendangnhap;
//	@Column(name = "MatKhau")
//	String matkhau;
//	@Column(name = "Ten")
//	String ten;
//	@Column(name = "GioiTinh")
//	private boolean gioitinh;
//	public User() {
//		super();
//	}
//	public User(int idkhachhang, String tendangnhap, String matkhau, String ten, boolean gioitinh) {
//		super();
//		this.idkhachhang = idkhachhang;
//		this.tendangnhap = tendangnhap;
//		this.matkhau = matkhau;
//		this.ten = ten;
//		this.gioitinh = gioitinh;
//	}
//	public int getIdkhachhang() {
//		return idkhachhang;
//	}
//	public void setIdkhachhang(int idkhachhang) {
//		this.idkhachhang = idkhachhang;
//	}
//	public String getTendangnhap() {
//		return tendangnhap;
//	}
//	public void setTendangnhap(String tendangnhap) {
//		this.tendangnhap = tendangnhap;
//	}
//	public String getMatkhau() {
//		return matkhau;
//	}
//	public void setMatkhau(String matkhau) {
//		this.matkhau = matkhau;
//	}
//	public String getTen() {
//		return ten;
//	}
//	public void setTen(String ten) {
//		this.ten = ten;
//	}
//	public boolean isGioitinh() {
//		return gioitinh;
//	}
//	public void setGioitinh(boolean gioitinh) {
//		this.gioitinh = gioitinh;
//	}
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//
//	
//	
//
//	
//}
package test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "KhachHang")
//@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u order by u.TenDangNhap")
public class KhachHang {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "TenDangNhap")
    private String tendangnhap;

    @Column(name = "MatKhau")
    private String matkhau;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "GioiTinh")
    private boolean gioitinh;

    public KhachHang() {
        super();
    }

	public KhachHang(String tendangnhap, String matkhau, String ten, boolean gioitinh) {
		super();
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
		this.ten = ten;
		this.gioitinh = gioitinh;
	}

	public String getTendangnhap() {
		return tendangnhap;
	}

	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public boolean isGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

	

	

   
}
