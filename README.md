1. import file sql , nama database "reservasihotel18102_18229"

2. buka netbean > package rh102_229.db > koneksiDB.java > pastikan nama user sql, db, pass sama

3. buka package rh102_229.controller > line 156 > ubah direktori untuk file pdf yang dicetak sesuai keinginan

 PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("E:\\ReservasiHotel18102_18229\\tamu.pdf"));
   
4. jalankan program di package rh102_229.main

5. user admin : admin  
   pass : admin    
