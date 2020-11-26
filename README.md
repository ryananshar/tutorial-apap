# Tutorial APAP
## Authors
* **Muhammad Ryan Anshar Haryanto** - *1806147073* - *B*

## Tutorial 6
1. Dalam konteks website, **Otentikasi** adalah proses untuk membuktikan bahwa orang yang melakukan login adalah orang yang valid dan benar. Sedangkan **Otorisasi** adalah proses pemberian izin orang yang sudah **terotentikasi** untuk menggunakan fitur tertentu yang disediakan oleh website.

2. **BCryptPasswordEncoder** adalah metode hashing guna merahasiakan password yang dimasukkan oleh user dan yang disimpan di database. BCrypt adalah salah satu algoritme slow-hashing di samping algoritme lain seperti SCrypt, Pbkdf2, dan lainnya. Salah satu contohnya pada program Spring ini terletak pada class UserServiceImpl fungsi `encrypt()`. Cara kerjanya adalah BCrypt di-*import* sebagai sebuah objek kemudian fungsi .encode() objek tersebut dijalankan pada parameter password yang dimasukkan user. Fungsi tersebut akan mengembalikan password yang sudah di-*hash*. Password yang sudah di-*hash* tersebut lah yang dijadikan perbandingan saat user melakukan otentikasi atau mengganti password.

3. UUID (Universally Unique Identifier) adalah data 128-bit yang digunakan untuk mengidentifikasikan sebuah informasi. Metode tersbut menjamin identitas unik bagi masing-masing objek dalam sebuah tabel database. UUID berguna bagi database yang besar (seperti user) yang perlu menjamin bahwa tidak ada dua data user yang sama sehingga mudah diidentifikasikan.

4. Berbeda dengan `UserServiceImpl`, UserDetailsServiceImpl mengimplementasikan class UserDetailsService yang disediakan oleh framework Security yang disediakan Spring Boot (`org.springframework.security.core`). UserDetailsServiceImpl digunakan untuk menggunakan custom database untuk database user kita.