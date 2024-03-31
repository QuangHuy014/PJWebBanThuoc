package vn.webbanthuoc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "HoaDon")
public class hoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHoaDon;
    private LocalDate ngayTao;
    private double tongTien;
    
    // Mối quan hệ với HoaDonChiTiet
    @OneToMany(mappedBy = "hoaDon")
    private List<hoaDonChiTiet> chiTietHoaDonList;

	public hoaDon() {
		super();
	}

	public hoaDon(int idHoaDon, LocalDate ngayTao, double tongTien, List<hoaDonChiTiet> chiTietHoaDonList) {
		super();
		this.idHoaDon = idHoaDon;
		this.ngayTao = ngayTao;
		this.tongTien = tongTien;
		this.chiTietHoaDonList = chiTietHoaDonList;
	}

	public int getIdHoaDon() {
		return idHoaDon;
	}

	public void setIdHoaDon(int idHoaDon) {
		this.idHoaDon = idHoaDon;
	}

	public LocalDate getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(LocalDate ngayTao) {
		this.ngayTao = ngayTao;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public List<hoaDonChiTiet> getChiTietHoaDonList() {
		return chiTietHoaDonList;
	}

	public void setChiTietHoaDonList(List<hoaDonChiTiet> chiTietHoaDonList) {
		this.chiTietHoaDonList = chiTietHoaDonList;
	}
    
   
    
}
