Otel Rezervasyon Sistemi


Bu proje, bir otel rezervasyon sistemini Java ile geliştirmek için gerekli olan tüm dosyaları ve kısa açıklamalarını içermektedir. 
Her dosya, sistemin belirli bir işlevini yerine getirmek için tasarlanmıştır.


1. Ana Uygulama Dosyası:

- Main.java
  > Programın başlangıç noktasıdır. Kullanıcı menüsünü çalıştırır ve kullanıcı girişlerini yönlendirir.


2. Model Sınıfları:

- Room.java
  > Odaların özelliklerini ve durumlarını temsil eden sınıf. Örneğin: oda tipi, fiyat, kapasite.

- Reservation.java
  > Rezervasyon bilgilerini tutar. Örneğin: müşteri bilgisi, giriş/çıkış tarihleri, toplam ücret.

- Customer.java
  > Müşterilerin bilgilerini (isim, iletişim bilgileri gibi) içeren sınıf.

3. Controller Sınıfları:

- ReservationController.java
  > Rezervasyon işlemlerini kontrol eder ve iş mantığını yönetir. Kullanıcıdan gelen talepleri doğrulayıp işleyerek uygun hizmet sınıflarını çağırır.

- RoomController.java
  > Oda yönetimiyle ilgili işlemleri (ör. oda ekleme, listeleme) kontrol eder ve iş mantığını hizmet sınıflarına yönlendirir.

- CustomerController.java
  > Müşteri bilgilerini düzenleme ve doğrulama işlemlerini kontrol eder.


4. Hizmet Sınıfları:

- ReservationManager.java
  > Rezervasyon işlemlerini (oluşturma, iptal etme, güncelleme) yöneten sınıf.

- RoomManager.java
  > Odalarla ilgili işlemleri (ekleme, güncelleme, listeleme) yöneten sınıf.


5. Veri Yönetimi:

- Database.java
  > Tüm veri okuma/yazma işlemlerini gerçekleştiren sınıf. Veriler `rooms.txt` ve `reservations.txt` dosyalarında saklanır.

- rooms.txt
  > Oda bilgilerini saklayan veri dosyası. Örneğin: Oda numarası, tipi, fiyatı.

- reservations.txt
  > Rezervasyon bilgilerini saklayan veri dosyası. Örneğin: Müşteri adı, oda numarası, tarih aralıkları.



6. Kullanıcı Arayüzü:

- ConsoleUI.java
  > Kullanıcı ile komut satırı üzerinden etkileşim kuran sınıf. Örneğin: oda rezervasyonu menüsü.


7. Yardımcı Sınıflar:

- DateUtils.java
  > Tarih hesaplamaları ve formatlama işlemleri için yardımcı sınıf.

- Validator.java
  > Kullanıcıdan alınan verileri doğrulamak için kullanılan sınıf. Örneğin: geçerli tarih veya oda numarası kontrolü.


8. Test Dosyaları:

- TestReservationManager.java
  > Rezervasyon işlemlerini test eden birim test sınıfı.

- TestRoomManager.java
  > Oda işlemlerini test eden birim test sınıfı.


9. Bağımlılıklar:

- pom.xml
  > Maven projelerinde kullanılan kütüphaneleri tanımlamak için dosya (Maven kullanıyorsanız).


10. Dokümantasyon:

- README.txt
  > Bu dosya, sistemde bulunan tüm dosyalar hakkında kısa açıklamalar içerir.


11. Çalıştırma Komut Dosyaları:

- run.sh
  > Sistemi Linux veya MacOS'ta başlatmak için bash komut dosyası.

- run.bat
  > Sistemi Windows'ta başlatmak için komut dosyası.
