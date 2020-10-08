package apap.tutorial.haidokter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "obat")
public class ObatModel implements Serializable {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 30)
	@Column(name = "nama", nullable = false)
	private String nama;

    @NotNull
	@Column(name = "bentuk", nullable = false)
    private Integer bentuk;
    
    @NotNull
	@Column(name = "kuantitas", nullable = false)
    private Integer kuantitas;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "resep_id", referencedColumnName = "no_resep", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ResepModel resepModel;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getBentuk() {
        return this.bentuk;
    }

    public void setBentuk(Integer bentuk) {
        this.bentuk = bentuk;
    }

    public Integer getKuantitas() {
        return this.kuantitas;
    }

    public void setKuantitas(Integer kuantitas) {
        this.kuantitas = kuantitas;
    }

    public ResepModel getResepModel() {
        return this.resepModel;
    }

    public void setResepModel(ResepModel resepModel) {
        this.resepModel = resepModel;
    }

}
