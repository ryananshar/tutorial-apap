# Tutorial APAP
## Authors
* **Muhammad Ryan Anshar Haryanto** - *1806147073* - *B*

## Tutorial 5
1. Apa itu Postman? Apa kegunaannya?
    - Postman adalah aplikasi yang berfungsi sebagai REST Client untuk menggunakan REST API.
    - Kegunaan dari Postman adalah untuk menyediakan wadah bagi developer untuk melakukan proses development API karena fitur-fitur yang tersedia sangat mendukung proses tersebut.
2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
    - @JsonIgnoreProperties digunakan untuk menandai properti atau pun atribut pada level class agar diabaikan pada proses Json
    - @JsonProperty berguna untuk mengubah nama suatu properti pada saat digunakan pada environment Json.
3. Apa kegunaan atribut WebClient?
    - WebClient digunakan utuk memanggil service REST external. WebClient bisa dikatakan sebagai interface untuk memanggil REST API dari web.
4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
    - ResponseEntity digunakan untuk merepresentasikan HTTP response. Dengan ResponseEntity, kita dapat mengatur HTTP Respon sesuai keinginan kita.
    - BindingResult adalah suatu Interface yang menampung hasil dari proses binding dan validation yang telah berlangsung. Kita dapat menggunakan BindingResult untuk menyimpan atau     mengambil hasil dari validasi yang ada.