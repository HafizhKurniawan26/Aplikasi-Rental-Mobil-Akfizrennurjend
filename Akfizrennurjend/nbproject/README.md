# Aplikasi Rental Mobil Akfizrennurjend

Aplikasi desktop untuk manajemen rental mobil yang dikembangkan oleh Kelompok 6. Aplikasi ini menyediakan sistem manajemen untuk rental mobil dengan tiga level akses: Admin, Pegawai, dan Pelanggan.

## Fitur

### Sistem Autentikasi
* Login dengan hak akses yang dibedakan (Admin, Pegawai, dan Pelanggan)
* Form registrasi untuk pengguna baru
* Form ganti password

### Admin
* **Manajemen User**: Tambah, lihat, edit, dan hapus semua user
* **Manajemen Pegawai**: CRUD lengkap data pegawai
* **Manajemen Mobil**: CRUD lengkap data kendaraan
* **Manajemen Rental**: CRUD lengkap transaksi rental
* **Manajemen Pembayaran**: CRUD lengkap data pembayaran

### Pegawai
* **Manajemen Pelanggan**: Lihat dan edit data pelanggan
* **Profil**: Lihat dan edit profil sendiri
* **Manajemen Mobil**: Input mobil baru, lihat semua mobil, edit status mobil, hapus mobil
* **Manajemen Rental**: Buat transaksi rental, lihat semua rental, edit status rental
* **Manajemen Pembayaran**: Input pembayaran, lihat semua pembayaran, edit status pembayaran

### Pelanggan
* **Profil**: Lihat dan edit profil sendiri
* **Katalog Mobil**: Lihat katalog mobil yang tersedia
* **Manajemen Rental**: Buat permintaan rental, lihat rental sendiri, edit rental sendiri (terbatas), batalkan rental
* **Pembayaran**: Buat pembayaran, lihat pembayaran sendiri, edit metode pembayaran

## Struktur Database

**Tabel:**
* `users` - Data pengguna sistem
* `pegawai` - Data karyawan rental
* `mobil` - Data kendaraan yang tersedia
* `rental` - Data transaksi rental
* `pembayaran` - Data pembayaran transaksi

## Kebutuhan Sistem

1. JDK (Java Development Kit) 8 atau yang lebih baru.
2. NetBeans IDE 8.2 atau yang lebih baru.
3. XAMPP dengan server database MySQL.

## Cara Instalasi
1. **Clone Repositori:**
   * Gunakan aplikasi GitHub Desktop atau `git clone` untuk mengunduh proyek ini.
2. **Impor Database:**
   * Buka XAMPP dan jalankan Apache & MySQL.
   * Buka phpmyadmin di browser.
   * Buat database baru dengan nama Akfizrennurjend.
   * Pilih database yang baru dibuat, lalu klik tab Import.
   * Pilih file Akfizrennurjend(1).sql yang ada di repositori ini dan klik Go.
3. **Buka Proyek di NetBeans:**
   * Buka NetBeans IDE.
   * Klik File -> Open Project.
   * Arahkan ke folder proyek yang sudah di-clone dan klik Open Project.
4. **Clone Repositori:**
   * Cari file main.java di dalam package auth.
   * Klik kanan pada file tersebut dan pilih Run File.
   * Klik tombol register, lalu isi form register.
   * Login dengan email dan password yang anda buat pada saat register.
