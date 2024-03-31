package vn.webbanthuoc.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HoaDonChiTiet")
public class hoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHoaDonChiTiet;
    private int idHoaDon;
    private int idThuoc;
    private String tenThuoc;
    private int soLuong;
    private double gia;
    private double thanhTien;
    private String donVi;
    
    @ManyToOne
    private hoaDon hoaDon;

	public hoaDonChiTiet() {
		super();
	}

	public hoaDonChiTiet(int idHoaDonChiTiet, int idHoaDon, int idThuoc, String tenThuoc, int soLuong, double gia,
			double thanhTien, String donVi, vn.webbanthuoc.entity.hoaDon hoaDon) {
		super();
		this.idHoaDonChiTiet = idHoaDonChiTiet;
		this.idHoaDon = idHoaDon;
		this.idThuoc = idThuoc;
		this.tenThuoc = tenThuoc;
		this.soLuong = soLuong;
		this.gia = gia;
		this.thanhTien = thanhTien;
		this.donVi = donVi;
		this.hoaDon = hoaDon;
	}

	public int getIdHoaDonChiTiet() {
		return idHoaDonChiTiet;
	}

	public void setIdHoaDonChiTiet(int idHoaDonChiTiet) {
		this.idHoaDonChiTiet = idHoaDonChiTiet;
	}

	public int getIdHoaDon() {
		return idHoaDon;
	}

	public void setIdHoaDon(int idHoaDon) {
		this.idHoaDon = idHoaDon;
	}

	public int getIdThuoc() {
		return idThuoc;
	}

	public void setIdThuoc(int idThuoc) {
		this.idThuoc = idThuoc;
	}

	public String getTenThuoc() {
		return tenThuoc;
	}

	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	public hoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(hoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
    
    
}
