package test;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "KhachHang")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u order by u.idKhachHang")
public class User {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "IDKhachHang")
	int idKhachHang;
	@Column(name = "TenDangNhap")
	String tenDangNhap;
	@Column(name = "MatKhau")
	String matKhau;
	@Column(name = "Ten")
	String ten;
	@Column(name = "GioiTinh")
	private boolean gioiTinh;
	public User() {
		super();
	}

	public User(int idKhachHang, String tenDangNhap, String matKhau, String ten, boolean gioiTinh) {
		super();
		this.idKhachHang = idKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
	}

	public int getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(int idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	

	
}
