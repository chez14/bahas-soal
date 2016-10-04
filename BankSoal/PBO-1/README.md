#PBO-1
## Abstrak
Repositori ini akan membahas soal dari Kumpulan Soal PBO, no.1.

## Deskripsi singkat
- `shell.bat` adalah script runner untuk Batang.java (Compiler + Runner)
- `README.md` adalah dokumentasi dari repo ini.
- `SOAL.md` adalah soal dari repo ini.
- `PEMBAHASAN.md` adalah pembahasan dari repo ini.
- `Batang.java` adalah Solution dari soal tersebut.

## Soal
Buatlah sebuah program yang menerima sebuah bilangan bulat positif N
dan mengeluarkan sebuah grafik batang dengan ukuran tiap batangnya diambil dari digit-digit bilangan N. Tiap batang dituliskan secara horizontal dengan ukuran untuk batang paling bawah diambil dari nilai digit paling kiri.

Tiap batang pada grafik ini dituliskan secara rata kiri. Grafik ini disusun oleh karakter-karakter `*`. Grafik batang ini akan dibatasi oleh sebuah kotak dengan tinggi T+2 karakter (T adalah jumlah digit pada N) dan lebar 11. Kotak pembatas ini disusun oleh karakter-karakter `#`. Sebagai contoh, di bawah ini adalah grafik batang yang dihasilkan oleh nilai `N = 12309` beserta penjelasannya.

```
###########
#*********#    (batang untuk digit 9)
#         #    (batang untuk digit 0)
#***      #    (batang untuk digit 3)
#**       #    (batang untuk digit 2)
#*        #    (batang untuk digit 1)
###########
```

## Pembahasan
Dari soal, kita cuma dikasih sebuah bilangan, trus kita bikinin grafiknya dari angka yang dikasih. Nah, kita akan pake looping buat ambil digit ke-`...` buat bikin grafiknya.
Kedua, untuk *mempercantik* kodenya, gw akan membuat sebuah method statik bernama `bariskan` untuk membuatkan barisannya. Bagian ini opsional, boleh kalian ikuti (membuatnya di method terpisah, atau dalam 1 method main semuanya), boleh juga tidak.

Kita mulai dengan membuat `public static void main`~

```java
  Scanner sc = new Scanner(System.in);
  int data = sc.nextInt(); // Meminta data
```
dua baris snippets di atas kita gunakan untuk membuat variabel baru, dan menginisialisasikannya.
yang satu, `sc`, buat bikin Scanner, yang satunya lagi, `data`, untuk mengambil data yang di*enter* oleh user.

```java
  System.out.println(bariskan("#",11));
```
Barisan berikutnya, kita akan memprint `#` sebanyak 11x. Caranya bagaimana? Gw cukup memanggil method `String bariskan(String, int)`. Ingat di bahasan-bahasan sebelumnya, bahwa gw bikin method yang gunanya bikin barisan karakter.

```java
public static String bariskan(String karakter, int banyak){
    String temp=""; // variabel penampung.
    while(banyak-->0)
       temp+=karakter;
    return temp;
}
```
Jadi di method ini kurang lebih kita akan looping sebanyak `int banyak`-kali, dan meng*concat* karakter ke variabel temp, baru kita return.

*Loh, kok bisa?!* **Iya,** pada baris ke-3, `temp+=karakter;` berguna untuk meng*concat* variabel `karakter` ke dalam temp, lalu di ulang-ulang hingga `banyak` menjadi 1.

Dan, deklarasi perulangan `while(banyak-->0)` bekerja seperti ini:
- `banyak` akan di kurangi 1 terlebih dahulu;
- `banyak` yang telah di kurangi 1, akan kita cek, **apakah dia lebih besar daripada 0?**,
- Jika ya, ia akan terus mengulang hingga `banyak`=1.
- Jika tidak, ia akan keluar dari perulangan, dan melanjutkan kode program di bawahnya.

*Loh, kok bisa?!* **Iya,** kita bisa coba ke CodePadnya Blue-J dan mengetikkan kode berikut:
```java
  int banyak=10;
```
tidak muncul apa-apa pada Blue-J? Ini karena kita hanya menginisialisasi sebuah variabel, dan statement di atas sebetulnya tidak mengeluarkan apa-apa.
```java
  banyak--;
```
pada Blue-J, akan tampil angka 9. Ini artinya ekspresi `banyak--` bisa mengeluarkan value hasil ekspresinya pengurangan dia. **Pstt!... Ini bisa memperpendek kode kita!**

Jadi, bisa begitu karena memang kita bisa melakukannya dengan pendek.

### Lanjuttt...

Berikutnya kita akan memprint data dari bilangan yang kita ambil barusan.

```java
while(data>0){
    System.out.printf("#%-9s#%n", bariskan("*",data%10));
    data/=10;
}
```
Perulangan ini akan kita lakukan hingga `data`=0. Selama perulangan, kita akan mengambil digit terbelakang `data`,

caranya kita menggunakan `data%10`.

Berikutnya, kita akan buat barisan `*` menggunakan method yang kita gunakan barusan, `bariskan("*",data%10)`.

Lihat? kita hanya perlu memanggil method yang kita buat barusan ketimbang memasukannya lebih dari 1x...

Bagus, sekarang jika kita langsung printout-kan, mereka akan menghasilkan ini:

```plain
###########
*********

***
**
*
```
SAATNYA KITA PAKE CARA AJAIB! Kita akan gunakan `printf` dari `System.out`! Mantep!

Cara kerja mereka, kita cukup bikin parameter formattingnya, lalu biarkan mereka bekerja memformat data yang kita kasih, lalu dia print!

`#%-9s#%n` adalah format untuk membuat `#(bintangnya disini)#(enter)`. `%-9s` asalnya dari sini `%s`.

`%s` adalah kode untuk String, nanti mereka akan kita ganti dengan Stringnya kita.

Selanjutnya, gw pengen kalo mereka di kasih *padding* hingga 9 digit. Makannya gw kasih angka `9` di depan `%s` itu.

Sekarang `%9s` akan mengeluarkan output ini:

```
###########
#*********#
#         #
#      ***#
#       **#
#        *#
```
Yahh, kebalikk.... Setelah liat [dokumentasi](https://docs.oracle.com/javase/tutorial/java/data/numberformat.html) dari javadoc, ternyata `-` bisa bikin formatnya jadi ke kiri, alias ngasih spasinya terakhir.

Oh iya, lupa ngomong, spasinya itu nilai otomatis buat formatting loh! kita bisa pake buat integer, float dan lain lainnya. Tapi biasanya kalo kita pake float, karakter setelah koma(titik) biasanya 0 sih. hehe...

oke, sekarang kita jadiin `%-9s`. Sekarang formattingnya jadi bener:

```
###########
#*********#
#         #
#***      #
#**       #
#*        #
```

Yay! Sekarang tinggal bikin pager bawahnya :P.

```java
System.out.println(bariskan("#",11));
```

udah yah, bisa copy dari yang atasnya barusan... nggak perlu penjelasan lebih lanjut khyann~? Mirip sih ini mah sama yang diatas barusan. Seriusan hahahahah

Sip. Selesai.
Solusinya bisa di liat di [sini](Batang.java)
