package vn.webbanthuoc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Thuoc")
public class Thuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idThuoc;
    private String ten;
    private String idNhomThuoc;
    private int soLuong;
    private Double gia;
    private int idKhachHang;
    private int idMaNV;
    private String nguonGoc;
    private String congDung;
    private java.sql.Date ngaySanXuat;
    private String baoQuan;
    private String donVi;
    
    @ManyToOne
    private hoaDonChiTiet hoaDonChiTietList;

	public Thuoc() {
		super();
	}

	public Thuoc(int idThuoc, String ten, String idNhomThuoc, int soLuong, Double gia, int idKhachHang, int idMaNV,
			String nguonGoc, String congDung, Date ngaySanXuat, String baoQuan, String donVi,
			hoaDonChiTiet hoaDonChiTietList) {
		super();
		this.idThuoc = idThuoc;
		this.ten = ten;
		this.idNhomThuoc = idNhomThuoc;
		this.soLuong = soLuong;
		this.gia = gia;
		this.idKhachHang = idKhachHang;
		this.idMaNV = idMaNV;
		this.nguonGoc = nguonGoc;
		this.congDung = congDung;
		this.ngaySanXuat = ngaySanXuat;
		this.baoQuan = baoQuan;
		this.donVi = donVi;
		this.hoaDonChiTietList = hoaDonChiTietList;
	}

	public int getIdThuoc() {
		return idThuoc;
	}

	public void setIdThuoc(int idThuoc) {
		this.idThuoc = idThuoc;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getIdNhomThuoc() {
		return idNhomThuoc;
	}

	public void setIdNhomThuoc(String idNhomThuoc) {
		this.idNhomThuoc = idNhomThuoc;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Double getGia() {
		return gia;
	}

	public void setGia(Double gia) {
		this.gia = gia;
	}

	public int getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(int idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public int getIdMaNV() {
		return idMaNV;
	}

	public void setIdMaNV(int idMaNV) {
		this.idMaNV = idMaNV;
	}

	public String getNguonGoc() {
		return nguonGoc;
	}

	public void setNguonGoc(String nguonGoc) {
		this.nguonGoc = nguonGoc;
	}

	public String getCongDung() {
		return congDung;
	}

	public void setCongDung(String congDung) {
		this.congDung = congDung;
	}

	public java.sql.Date getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(java.sql.Date ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}

	public String getBaoQuan() {
		return baoQuan;
	}

	public void setBaoQuan(String baoQuan) {
		this.baoQuan = baoQuan;
	}

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	public hoaDonChiTiet getHoaDonChiTietList() {
		return hoaDonChiTietList;
	}

	public void setHoaDonChiTietList(hoaDonChiTiet hoaDonChiTietList) {
		this.hoaDonChiTietList = hoaDonChiTietList;
	}

}

