package test;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "WebBanThuoc")
//@NamedQuery(name = "WebBanThuoc.findAll", query = "SELECT u FROM User u")
public class User {
	@Id
	@Column(name = "IDKhachHang")
	int IDKhachHang;
	@Column(name = "TenDangNhap")
	String TenDangNhap;
	@Column(name = "MatKhau")
	String MatKhau;
	@Column(name = "Ten")
	String Ten;
	@Column(name = "GioiTinh")
	boolean GioiTinh = false;
	
	public User() {
		super();
	}

	public User(int iDKhachHang, String tenDangNhap, String matKhau, String ten, boolean gioiTinh) {
		super();
		IDKhachHang = iDKhachHang;
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
		Ten = ten;
		GioiTinh = gioiTinh;
	}

	public int getIDKhachHang() {
		return IDKhachHang;
	}

	public void setIDKhachHang(int iDKhachHang) {
		IDKhachHang = iDKhachHang;
	}

	public String getTenDangNhap() {
		return TenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return MatKhau;
	}

	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}

	public String getTen() {
		return Ten;
	}

	public void setTen(String ten) {
		Ten = ten;
	}

	public boolean isGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}
   
	
}
