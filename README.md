# Tutorial APAP
## Authors
* **Muhammad Ryan Anshar Haryanto** - *1806147073* - *B*

## Tutorial 7
1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi
dari apa yang Anda jelaskan.
    -   Pada latihan no.1 saya memutuskan untuk mengganti checkbox dengan tombol cheklist   dan close. Caranya adalah menggunakan conditional statement yang mengecek apakah item
    yang diclick sudah pernah di-checked atau belum.
    https://ibb.co/cc4xNMN
    -   Pada latihan no.2 saya membuat fitur untuk menghapus semua daftar favorite. Hal ini dilakukan dengan cara memeriksa apakah objek list **favItems** kosong atau tidak. Bila terdapat item di dalam list tersebut, maka kita kan mereset state dari **favItems** tersebut menjadi list kosong
    https://ibb.co/7RSfPbN
    -   Pada latihan no.3 saya menggunakan 2 method yang meng-handle masing-masing list kiri dan kanan. Pada list kiri hanya dapat menambah item kedalam **favItems**, sedangkan pada list kanan hanya dapat menghapus item dari **favItems**.
    https://ibb.co/19sjgGq
    -   Pada latihan no.4 saya menggunakan switch dengan sudut yang melingkar. Switch ini memiliki state default false. Ketika switch ini diclick, maka akan ada method yang merubah kondisi state dari false menjadi true, sehingga akan memenuhi kondisi dari conditial statement yang akan memunculkan list favorite.
    https://ibb.co/JxtxTpr
    https://ibb.co/zJ1BQqm
    -   Pada latihan no.5 memiliki konsep pengerjaan yang sama dengan latihan no.2 dimana ketika **favItems** kosong, maka akan muncul notifikasi bahwa belum ada item yang terpilih.
    https://ibb.co/vZmQdSd
2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props ?
    -   State adalah data private sebuah component. Data ini hanya tersedia untuk component tersebut dan tidak bisa di akses dari component lain. Component dapat merubah statenya sendiri.
    -   Props adalah suatu atribut/properti yang dapat kita kirim untuk membuat tampilan di html.
3. Apa keuntungan menggunakan component (e.g. List, Item) di React? Berikan contohnya!
    -   Untuk lebih mudah mengoper atau mengubah variabel yang ada sehingga kita dapat mengolah tampilan yang nantinya akan dilihat oleh user.
4. Menurut kamu, apa saja kelebihan menggunakan React dalam pengembangan web?
    -   Proses rendering lebih cepat dari pengembangan menggunakan spring boot biasa.
    -   Kemampuan untuk menggunakan kembali komponen
5. Menurut kamu, apa saja kekurangan menggunakan React dalam pengembangan web?
    -   Terlalu terpaku pade layer view.
    -   Tidak semua browser mendukung