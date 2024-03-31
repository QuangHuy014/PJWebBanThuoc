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
    
    // Constructors, getters and setters
}
