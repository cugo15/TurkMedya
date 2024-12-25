# Kullanılan Teknolojiler Ve Kütüphaneler
-Projede canlı yayın işlemleri için ExoPlayer tercih edildi. 
-Kodun düzenli ve kolay yönetilebilir olması için Dagger Hilt kullanıldı.
-Veri katmanı ve UI ayrı tutuldu; bu ayrımı MVVM mimarisiyle sağladım.
-Uzak sunuculardan veri çekmek için Retrofit kütüphanesini kullandım.
-Uygulama içindeki ekranlar arasında kolay ve hızlı geçişler yapmak için ise Jetpack Navigation kullandım.
-Resim yükleme işlemleri için Glide tercih edildi.
# Uygulamanın Kullanımı
-Uygulamayı açtığınızda, en üstte sizi bir canlı yayın karşılıyor. Bu yayın, ExoPlayer ile sağlanıyor ve foreground servislerl
e entegre çalışıyor. Bu sayede, tıpkı popüler müzik ve video uygulamalarında olduğu gibi, uygulama arka planda olsa bile bildirim üzerinden yayını kontrol edebiliyorsunuz. Oynatmayı durdurma ve devam ettirme işlemleri bildirim panelinden kolayca yapılabiliyor. Uygulama arka plandayken hatta telefon kilit ekranındayken bile canlı yayın devam ediyor.

-Canlı yayının altında ise bizi bir RecyclerView yapısı karşılıyor uzak sunucudan aldığımız veriler kullanıcıya gösteriliyor. Herhangi bir iteme tıklandığında ise bizi o haberin detay sayfasına götürüyor bu işlem gerçekleştiğinde devam eden canlı yayınımız duruyor tekrar geri döndüğümğüzde kaldığı yerden devam ediyor.

-HaberDetaylarında yine bir RecyclerView yapısı kullanılıyor ViewPager yapısına benzer bir kullanım sağlıyor böylelikle kullanıcı bir haberin detayına girdikten sonra sıralı bir şekilde kaydırarak diğer haberlerin detaylarını okumaya devam edebilir.

# TürkMedya
| Home Screen |   Notification   |    LockScreen     |

| ----------- | ---------------- |------------------ | 

![home_ss](https://github.com/user-attachments/assets/5de96e66-b6f8-475e-92cb-4598337ca815) | ![notification_ss](https://github.com/user-attachments/assets/4c1095b5-74ee-444e-a53c-14c9a3dd7df4) | ![lockscreen_ss2](https://github.com/user-attachments/assets/83b82237-1fa3-40c3-b7cb-638e16658214)

