package apap.tutorial.haidokter.model;

public class ResepModel {
    private String noResep;
    private String namaDokter;
    private String namaPasien;
	private String catatan;
	

	public ResepModel() {
	}

	public ResepModel(String noResep, String namaDokter, String namaPasien, String catatan) {
		this.noResep = noResep;
		this.namaDokter = namaDokter;
		this.namaPasien = namaPasien;
		this.catatan = catatan;
	}

	public String getNoResep() {
		return this.noResep;
	}

	public void setNoResep(String noResep) {
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
	

}