package apap.tutorial.haidokter.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "resep")
public class ResepModel implements Serializable {
    // private String noResep;
    // private String namaDokter;
    // private String namaPasien;
	// private String catatan;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long noResep;
	
	@NotNull
	@Size(max = 30)
	@Column(name = "nama_dokter", nullable = false)
	private String namaDokter;

	@NotNull
	@Size(max = 30)
	@Column(name = "nama_pasien", nullable = false)
	private String namaPasien;
	
	@NotNull
	@Size(max = 40)
	@Column(name = "catatan", nullable = false)
	private String catatan;

	@OneToMany(mappedBy = "resepModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ObatModel> listObat;

	public Long getNoResep() {
		return this.noResep;
	}

	public void setNoResep(Long noResep) {
		this.noResep = noResep;
	}

	public String getNamaDokter() {
		return this.namaDokter;
	}

	public void setNamaDokter(String namaDokter) {
		this.namaDokter = namaDokter;
	}

	public String getNamaPasien() {
		return this.namaPasien;
	}

	public void setNamaPasien(String namaPasien) {
		this.namaPasien = namaPasien;
	}

	public String getCatatan() {
		return this.catatan;
	}

	public void setCatatan(String catatan) {
		this.catatan = catatan;
	}

	public List<ObatModel> getListObat() {
		return this.listObat;
	}

	public void setListObat(List<ObatModel> listObat) {
		this.listObat = listObat;
	}
	

}