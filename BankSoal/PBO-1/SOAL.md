# Soal
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
