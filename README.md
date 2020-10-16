# Tutorial APAP
## Authors
* **Muhammad Ryan Anshar Haryanto** - *1806147073* - *B*

## Tutorial 1
### What I have learned today
Kali ini saya mempelajari bagaimana cara menggunakan framework Spring Boot untuk membuat Website.
Penggunaan beberapa dependency pada framework springboot.
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker? 
- Issue tracker berguna untuk mencatat isu dan melacak bug. Alat ini berguna untuk menyajikan informasi atau peringatan kepada tim developer untuk mengatasi isu yang keluar dengan lebih efisien.

2. Apa perbedaan dari git merge dan git merge --squash?
- Menggunakan `git merge`, kita akan melakukan merge branch kita yang terbaru ke branch master. Sedangkan pada `git merge --squash` akan menggabungkan commit-commit sebelumnya menjadi satu commit baru kemudian di merge ke master.

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu Aplikasi?
- History yang lengkap untuk perubahan jangka panjang
- Mempermudah kontribusi pada tim dengan adanya `branching` dan `merging`
- Kemampuan pelacakan dari setiap perubahan yang terjadi

### Spring
4. Apa itu library & dependency?
- Library adalah kumpulan kode yang memiliki fungsi-fungsi tertentu dan dapat dipanggil kedalam progam lain. 
- Depedency adalah ketergantungan suatu software dengan library atau software lainnya.

5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
- Maven memungkinkan kita untuk mengompilasi source code dengan mudah.
- Maven juga digunakan untuk memanage dan menginstal Library. 
- Alternatif lainnya, kita bisa menggunakan Jira, CircleCI dan Gradle.

6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
- Spring termasuk populer dikalangan pengguna java yang biasanya digunakan untuk mengembangkan web. 
- Namun sebenarnya, spring sering dijadikan sebagai pondasi oleh berbagai framework lainnya. Sehingga Spring framework juga dipakai untuk mengembangkan program, cloud, database dan juga API.

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?
- Dari hasil tutorial kali ini, pada @RequestParam mengharuskan kita untuk memasukkan parameter secara eksplisit kedalam URL.
- Sedangkan, @PathVariable tidak mengharuskan kita untuk memasukkan parameter kedalam url dengan catatan mengetahui masing-masing paramater di kedua argumen.
- Bila terdapat banyak variable, maka disarankan menggunakan @PathVariable agar lebih efisien.


### What I did not understand
- [ ] Kenapa harus menggunakan Spring Framework
- [ ] Pengaplikasian model MVC masih belum mengerti

## Tutorial 2
1. Cobalah untuk menambahkan sebuah resep dengan mengakses link berikut:
http://localhost:8080/resep/add?noResep=1&namaDokter=Papa%20APAP&namaPasien=Quanta%20F
asilkom&catatan=Semangat
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi!

-Hal tersebut bisa terjadi karena view yang disematkan pada Controller“add-resep” belum ada dan dibuat.

2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat  

- @Autowired merupakan peng-implementation dari konsep IoC. @Autowired ini digunakan untuk memasukan variable dari ResepService ke controller.

3. Cobalah untuk menambahkan sebuah resep dengan mengakses link berikut: 

http://localhost:8080/resep/add?noResep=1&namaDokter=Papa%20APAP&namaPasien=Quanta%20Fasilkom 

*Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi*

-Karena tidak semua parameter dipenuhi dan diisi, yaitu catatan.

4. Jika Papa APAP ingin melihat resep untuk pasien yang bernama Quanta, link apa yang harus diakses? 

http://localhost:8080/resep/view/?noResep=1

5. Tambahkan 1 contoh resep lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/resep/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu. 

http://localhost:8080/resep/add?noResep=3&namaDokter=Kinta&namaPasien=Andin&catatan=Semoga%20bisa%20survive

[Image ScreenShot](https://ibb.co/wYLWYsR)

### What I did not understand
- [ ] Kenapa harus menggunakan Autowired

## Tutorial 3

1. Pada class ResepDb , terdapat method findByNoResep , apakah kegunaan dari method tersebut?
    Method findByNoResep pada ResepDb digunakan untuk mencari suatu objek ResepModel di dalam database. Method tersebut diletakkan lagi di class ResepDB untuk memudahkan modifikasi kode karena sudah terdefinisi ada fungsi apa saja yang bisa dilakukan suatu class. Hal yang sama juga bisa dilakukan di dalam class ObatDB.

2. Pada class ResepController , jelaskan perbedaan method addResepFormPage dan addResepSubmit ?
    Pada class ResepController, method addResepFormPage digunakan untuk mempersiapkan atribut-atribut resep dan menyediakan kolom formulir untuk pengisian data resep baru, sedangkan addResepSubmit digunakan untuk menerima input dari formulir tersebut dalam bentuk method POST dan menambahkan resep berdasarkan input-input yang diterima.

3. Jelaskan kegunaan dari JPA Repository !
    JPA (Java Persistence API) adalah cara Springboot untuk menyimpan object-object Java ke dalam database relasional.

4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara ResepModel dan ObatModel dibuat?
    Relasi antara ResepModel dan ObatModel dibentuk dalam class ObatModel dengan menggunakan @ManyToOne sebagai tipe relasi, @JoinColumn untuk menggabungkan dua tabel (join berdasarkan resep_id), dan @OnDelete untuk pengaturan cascade penghapusan sebuah baris.

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER !
    FetchType.LAZY dan FetchType.EAGER adalah dua macam data fetching atau pun loading yang disediakan oleh SpringBoot. FetchType.LAZY akan load data field tertentu ke memori hanya jika diberikan perintah eksplisit yang membutuhkan data tersebut, sedangkan FetchType.EAGER akan me-load semua data field seketika object tersebut dipanggil. CascadeType.ALL digunakan untuk melakukan meng-cascade semua aksi EntityManager (DETACH,MERGE,PERSIST,REFRESH, dan REMOVE).

### What I have learned today
- Pemahaman lebih lanjut mengenai pengaplikasian konsep IoC

## Tutorial 4
1. Jelaskan perbedaan th:include dan th:replace!
    th:include bisa menyertakan bagian dari page lain, sedangkan th:replace akan menggantikan tag yang di-host dengan bagian dari page lain
2. Jelaskan apa fungsi dari th:object!
    th: objek digunakan untuk menentukan objek yang akan diikat oleh data formulir yang dikirimkan
3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
    (*) dipakai untuk menunjuk suatu objek yang sudah terkirim dari formulir sebelumny. Sedangkan ($) menunjuk objek yang di parsing dari kontroler. Keduanya cocok dipakai ketika ingin mengupdate suatu data yang sudah ada di database.
4. Bagaimana kamu menyelesaikan latihan nomor 3?