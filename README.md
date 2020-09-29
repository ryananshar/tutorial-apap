# Tutorial APAP
## Authors
* **Muhammad Ryan Anshar Haryanto** - *1806147073* - *B*

## Tutorial 1
### What I have learned today
Kali ini saya mempelajari bagaimana cara menggunakan framework Spring Boot untuk membuat Website.
Penggunaan beberap dependency pada framework springboot.
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