# Tutorial APAP
## Authors
* **Muhammad Ryan Anshar Haryanto** - *1806147073* - *B*

## Tutorial 8
1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian
melakukan langkah - langkah tersebut?
- Saya hanya melakukan setState untuk mengembalikan nilai dari resep kembali menjadi kosong setiap kali proses add selesai dilakukan. Karena state dari langkah sebelumnya masih tersimpan maka perlu dikosongkan agar kolom input kembali menjadi kosong.
2. Jelaskan fungsi dari async dan await !
- Dari yang saya pahami dari Tutorial kali ini, asyinc mendefinisikan method yang dapat dijalankan secara asychronous seperti threading sehingga method lain yang
mungkin berkaitan dapat dijalankan secara bersamaan sementara await adalah method yang berada di dalam suatu method async yang menunggu atau mengirim input
menuju API
3. Masukkan jawaban dari Screenshot yang diperintahkan di halaman 8 pada Component Lifecycle
pada pertanyaan ini.
https://ibb.co/kDwhkDw
https://ibb.co/Jxzx62P
4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate,
componentDidUpdate, componentWillReceiveProps,
componentWillUnmount.
Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “ use case apa saja
yang biasanya menggunakan lifecycle method tersebut”.
componenDidMount berfungsi untuk mencakup apa yg akan dilakukan apabila output sudah di render
shouldComponentUpdate berfungsi sebagai logic gate untuk menentukan apakah perubahan akan ditampilkan atau tidak
componentDidUpdate berfungsi untuk mencakup apa yg akan dilakukan apabila component sudah di update
componentWillReceiveProps berfungsi ketika terjadi pe
componentWillReceiveProps berfungsi ketika terjadi perubahan pada props sebelum component di render
componentWillUnmount berfungsi ketika tepat sebelum component di un-mount.
Fungsi di atas akan sangat berguna dalam penggunaan Hook di React.js