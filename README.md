# 🧪 Hepsiburada UI Test Automation Project

---

## 📑 İçindekiler

- [📌 Proje Tanımı](#-proje-tanımı)
- [🛠 Kullanılan Teknolojiler](#-kullanılan-teknolojiler)
- [🔍 Test Senaryosu Akışı](#-test-senaryosu-akışı)
- [📂 Proje Yapısı](#-proje-yapısı)
- [🖥 Olası Test Çıktısı](#-olası-test-çıktısı)

---

## 📌 Proje Tanımı

Proje chrome driver, java, junit ve maven kullanılarak https://www.hepsiburada.com/ sitesinde;

Arama çubuğunda **Kitap,mouse,Klavye veya Harici disk** anahtar kelimelerinden biriyle ürünü aratır.

Arama sonuç sayfasının açıldığını, sayfa açıldığında görür olan;

```css
h1[data-test-id="header-h1"]
```

```xpath
//div[starts-with(@id,'SortingBox_')]
```

```xpath
//div[starts-with(@id,'ProductList_')]
```

```id
stickyVerticalFilter
```

locatorlarına sahip elementlerinin görünürlük kontrolü yapılarak doğrulanıyor.

---

## 🔍 Test Senaryosu Akışı

- Arama sonuç sayfasında soldaki dikey menüdeki markalardan rastgele seçim yapılıyor.
- Rastgele bir marka seçildikten sonra sonuçların güncellendiği sayfa yeniden yüklendikten sonra, ürün listesinden

```xpath
//div[starts-with(@id,'ProductList_')]//ul/li//div[starts-with(@class,'productCard-')]/a
```

rastgele birinin title ının markayı içerdiği kontrol ediliyor.

> ⚠ Bazı ürünlerin title ında marka olmuyor. Ama manuel gidip bakıldığında ürünün markası seçilen oluyor.

- Sonuç listesinden herhangi bir ürünü seçiliyor.
- Seçilen ürünün title ı kaydediliyor.
- Sonra ürün detay sayfasına gidiliyor.
- Kaydedilen title ın value sunun ürün detay sayfasındaki ürün adını içerdiği kontrol ediliyor.
- Ürün detay sayfasındaki bazı elementlerin varlığı kontrol ediliyor.
- Ürün sepete eklendikten sonra 2 farklı popup açılıyor.

    - "Sepete git"
    - "Alışverişe devam et"

  butonları olan popuptan butona tıklayarak ilerleyebiliyor.

> ⚠ Fakat sayfa kenarında açılan popupdaki sepete git linki ile gidemiyor. Onun locator unu yakalayamadım. Sepete gitmeyi url ile sağlattım.

- Seçilen ürünün sepette bulunduğunu ürün adını kontrol ederek doğruluyor.

---

## 🛠 Kullanılan Teknolojiler

| Teknoloji | Açıklama |
|-----------|----------|
| ☕ Java | Test dili |
| 🌐 Selenium WebDriver | UI otomasyon |
| 🧪 JUnit | Test framework |
| 📦 Maven | Dependency management |
| 🌍 ChromeDriver | Browser driver |

---

## 📂 Proje Yapısı

```
src
 ├── main
 │   └── java
 │       ├── pages
 │       │    └── (Her bir sayfaya özel metotlar)
 │       │
 │       └── utils
 │            ├── OtherHelper (Selenium harici yardımcı Java metotları)
 │            └── SeleniumHelper (Tüm sayfalarda kullanılabilir Selenium metotları)
 │
 └── test
     └── java
         ├── base
         │     └── (Test öncesi/sonrası çalışan metotlar)
         │
         └── cart
               └── (Sepet testinin yazıldığı class)
```

- `src/main/java/pages` altında her bir sayfaya özel metotlar var.
- `src/main/java/utils` altındaki OtherHelper class ında Selenium haricindeki yardımcı Java metotları yazıldı.
- `src/main/java/utils` altındaki SeleniumHelper class ında Selenium metotları yazılır. Her sayfa için kullanılabilir metotlar.
- `src/test/java/base` içinde test çalışmadan önce çalıştıktan sonra gerekli metotlar yazılı.
- `src/test/java/cart` Sepet testinin yazıldığı kısım. Bu class ta sadece çağırma ve gerekli sınıf nesneleri tanımlanır.

---

### ➕ Yeni Test Senaryosu Eklenirse

Eğer yeni bir test senaryosu yazılsaydı ve bu anasayfaya ait olsaydı

```
src/test/java/home
```

oluşturup içine `Home` class ı oluştururdum.

Bu class ta da sadece çağırma ve gerekli sınıf nesneleri tanımlanırdı.

---

## 🖥 Olası Test Çıktısı (Console)

![Test Output](assets/screenshot.png)

---

# ✅ Not

- Page Object Model (POM) yapısı kullanılmıştır.
- Selenium metotları merkezi olarak yönetilmektedir.
- Test class’larında yalnızca çağırma işlemleri yapılmaktadır.
- Kod tekrarını önlemek için helper sınıfları kullanılmıştır.