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
| ![Home Screen](https://github.com/user-attachments/assets/b86f8806-002f-4bb9-95c2-f346be453f44) | ![Notification](https://github.com/user-attachments/assets/2ebe8cc1-259a-4e42-835c-0028297b9119) | ![LockScreen](https://github.com/user-attachments/assets/9aaddfcf-de21-43fa-8791-5ad86ceec3fd)
