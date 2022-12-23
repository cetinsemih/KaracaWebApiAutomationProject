Siparis Islemleri Test Senaryolari
==================================
//100TL altı ürünler
//48413644 19,99 TL
//48413643 69,99 TL
//48413646 14,99 TL
//48413647 39,99 TL
//48413645 69,99 TL
//100TL Üstü Ürünler
//48413632 129,99 TL
//48413681 199,99 TL
//48413682 599,99 TL
//48413683 209,99 TL
//48413684 169 TL
T - Siparis Detay - Siparisin Teslim Edilmesinden 14 veya Daha Az Gun Gectiginde Kolay Iade Butonunun Kontrol Edilmesi
----------------------------------------------------------------------------------------------------------------------------
tags: T - Siparis Detay - Siparisin Teslim Edilmesinden 14 veya Daha Az Gun Gectiginde Kolay Iade Butonunun Kontrol Edilmesi
* T_login olunur.
* T_urun_detay 48413644(100TL alti) siparis nolu urunun sayfasina gidilir.
* T_urun_detay 'Kolay Iade' butonu kontrol edilir.

T - Siparis Detay - Siparisin Teslim Edilmesinden 14 Gunden Fazla Gun Gectigi Durumda Kolay Iade Butonunun Kontrol Edilmesi
---------------------------------------------------------------------------------------------------------------------------------
tags: T - Siparis Detay - Siparisin Teslim Edilmesinden 14 Gunden Fazla Gun Gectigi Durumda Kolay Iade Butonunun Kontrol Edilmesi
* T_login olunur.
* T_urun_detay 16460712 siparis nolu urunun sayfasina gidilir.
* "UrunDetaySayfasi_KolayIadeButonu" elementi yokmu kontrol et
//
T - Siparis Detay - Kolay İade Butonuna Tiklanmasi
--------------------------------------------------------
tags: T - Siparis Detay - Kolay Iade Butonuna Tiklanmasi
* T_login olunur.
* T_urun_detay 48413644(100TL alti) siparis nolu urunun sayfasina gidilir.
//2. adımda 14 günden önce teslim edilmiş herhangi bir ürün olabilir.
* T_urun_detay 'Kolay Iade' butonuna tiklanir.
//
T - Siparis Detay - "Kolay Iade" Pop-upi "BURADAN" Linkine Tıklanmasi
---------------------------------------------------------------------------
tags: T - Siparis Detay - Kolay Iade - Pop-upi -BURADAN- Linkine Tiklanmasi
* T_login olunur.
* T_urun_detay 48413644(100TL alti) siparis nolu urunun sayfasina gidilir.
* T_urun_detay 'Kolay Iade' butonuna tiklanir.
* T_urun_detay Kolay Iade popupinda 'BURADAN' linkine tiklanir.
//
T - Siparis Detay - "Kolay Iade" Pop-up' inda "Magazadan Iade" Linkine Tiklanmasi
---------------------------------------------------------------------------------------
tags: T - Siparis Detay - Kolay Iade- Pop-up inda -Magazadan Iade- Linkine Tiklanmasi
* T_login olunur.
* T_urun_detay 48413644(100TL alti) siparis nolu urunun sayfasina gidilir.
* T_urun_detay 'Kolay Iade' butonuna tiklanir.
* T_urun_detay Kolay Iade popupinda 'Magazadan Iade' linkine tiklanir.
//
T - Siparis Detay - "Kolay Iade" Pop-up' inda "Internetten Iade" Butonuna Tiklanmasi
------------------------------------------------------------------------------------------
tags: T - Siparis Detay - Kolay Iade- Pop-up' inda -Internetten Iade- Butonuna Tiklanmasi
* T_login olunur.
* T_urun_detay 48413644(100TL alti) siparis nolu urunun sayfasina gidilir.
* T_urun_detay 'Kolay Iade' butonuna tiklanir.
* T_urun_detay Kolay Iade popupinda 'Internetten Iade' butonuna tiklanir.
//
T - Siparis Detay - "Iade Yontemi" Pop-up' inda Tum Alanlar Bos Birakilarak "Iade Olustur" Butonuna Tiklanmasi
--------------------------------------------------------------------------------------------------------------------
tags: T - Siparis Detay - Iade Yontemi- Pop-up inda Tum Alanlar Bos Birakilarak -Iade Olustur- Butonuna Tiklanmasi
* T_login olunur.
* T_urun_detay 48413644(100TL alti) siparis nolu urunun sayfasina gidilir.
* T_urun_detay 'Kolay Iade' butonuna tiklanir.
* T_urun_detay Kolay Iade popupinda 'Internetten Iade' butonuna tiklanir.
* T_urun_detay Iade Yontemi popupinda 'Iade Olustur' butonuna tiklanir.
* T_urun_detay Iade Yontemi popupinda "Lütfen iade adedi ve iade nedeni alanlarını doldurunuz." uyarisinin oldugu kontrol edilir.
//
T - Siparis Detay - "Iade Yontemi" Pop-up' inda Iade Adedi Alaninda Secim Yapilip Diger Alanlar Bos Birakilarak "Devam Et" Butonuna Tiklanmasi
------------------------------------------------------------------------------------------------------------------------------------------------------
tags: T - Siparis Detay - Iade Yontemi- Pop-up inda Iade Adedi Alaninda Secim Yapilip Diger Alanlar Bos Birakilarak -Devam Et- Butonuna Tiklanmasi
* T_login olunur.
* T_urun_detay 48413644(100TL alti) siparis nolu urunun sayfasina gidilir.
* T_urun_detay 'Kolay Iade' butonuna tiklanir.
* T_urun_detay Kolay Iade popupinda 'Internetten Iade' butonuna tiklanir.
* T_urun_detay Iade Yontemi popupinda 'Urun Adedi' dropdownindan secim yapilir.
* T_urun_detay Iade Yontemi popupinda 'Iade Olustur' butonuna tiklanir.
* T_urun_detay Iade Yontemi popupinda "Lütfen iade adedi ve iade nedeni alanlarını doldurunuz." uyarisinin oldugu kontrol edilir.
//
T - Siparis Detay - "Iade Yontemi" Pop-up' inda Iade Nedeni Alaninda Secim Yapilip Diger Alanlar Bos Birakilarak "Devam Et" Butonuna Tiklanmasi
------------------------------------------------------------------------------------------------------------------------------------------------------
tags: T - Siparis Detay - Iade Yontemi- Pop-up inda Iade Nedeni Alaninda Secim Yapilip Diger Alanlar Bos Birakilarak -Devam Et- Butonuna Tiklanmasi
* T_login olunur.
* T_urun_detay 48413644(100TL alti) siparis nolu urunun sayfasina gidilir.
* T_urun_detay 'Kolay Iade' butonuna tiklanir.
* T_urun_detay Kolay Iade popupinda 'Internetten Iade' butonuna tiklanir.
* T_urun_detay Iade Yontemi popupinda 'Iade Nedeni' dropdownindan "5". siradaki secenek secilir.
* T_urun_detay Iade Yontemi popupinda 'Iade Olustur' butonuna tiklanir.
* T_urun_detay Iade Yontemi popupinda "Lütfen iade adedi ve iade nedeni alanlarını doldurunuz." uyarisinin oldugu kontrol edilir.
//
T - Siparis Detay - "Iade Yontemi" Pop-up' inda Iade Aciklamasi Alanina Aciklama Girilip Diger Alanlar Bos Birakilarak "Devam Et" Butonuna Tiklanmasi
-----------------------------------------------------------------------------------------------------------------------------------------------------------
tags: T - Siparis Detay - Iade Yontemi Pop-up inda Iade Aciklamasi Alanina Aciklama Girilip Diger Alanlar Bos Birakilarak -Devam Et- Butonuna Tiklanmasi
* T_login olunur.
* T_urun_detay 48413644(100TL alti) siparis nolu urunun sayfasina gidilir.
* T_urun_detay 'Kolay Iade' butonuna tiklanir.
* T_urun_detay Kolay Iade popupinda 'Internetten Iade' butonuna tiklanir.
* T_urun_detay Iade Yontemi popupinda 'Urun Adedi' dropdownindan secim yapilir.
* T_urun_detay Iade Yontemi popupinda 'Iade Nedeni' dropdownindan "5". siradaki secenek secilir.
* T_urun_detay Iade Yontemi popupinda 'Iade Olustur' butonuna tiklanir.
* T_urun_detay Iade Yontemi popupinda "Lütfen iade açıklaması alanını doldurunuz." uyarisinin oldugu kontrol edilir.
//
//T_Siparis Detay -  (100 TL Uzeri Urun Icin) "Iade Yontemi" Pop-up' inda Tum Alanlar Doldurularak "Iade Olustur" Butonuna Tiklanmasi
//-------------------------------------------------------------------------------------------------------------------------------------------
//tags: T - Siparis Detay -  (100 TL Uzeri Urun Icin) "Iade Yontemi" Pop-up' inda Tum Alanlar Doldurularak "Iade Olustur" Butonuna Tiklanmasi
//* T_login olunur.
//* T_urun_detay 48413682(100TL ustu) siparis nolu urunun sayfasina gidilir.
//* T_urun_detay 'Kolay Iade' butonuna tiklanir.
//* T_urun_detay Kolay Iade popupinda 'Internetten Iade' butonuna tiklanir.
//* T_urun_detay Iade Yontemi popupinda 'Urun Adedi' dropdownindan secim yapilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Nedeni' dropdownindan "5". siradaki secenek secilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Aciklamasi' alanina "Test171717" girilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Olustur' butonuna tiklanir.
//* T_urun_detay 'IADE BASARILI' popupinin acildigi kontrol edilir.
//* T_urun_detay 'IADE BASARILI' popupi kapatilir.
//* T_urun_detay 'IADE TALEBINI IPTAL ET' butonuna tiklanir.
//
//T_Siparis Detay -  (100 TL Uzeri Urun Icin) "IADE BASARILI" Pop-up' indaki Alanlarin Kontrol Edilmesi
//------------------------------------------------------------------------------------------------------------
//tags: T - Siparis Detay - (100 TL Uzeri Urun Icin) "IADE BASARILI" Pop-up' indaki Alanlarin Kontrol Edilmesi
//* T_login olunur.
//* T_urun_detay 48413682(100TL ustu) siparis nolu urunun sayfasina gidilir.
//* T_urun_detay 'Kolay Iade' butonuna tiklanir.
//* T_urun_detay Kolay Iade popupinda 'Internetten Iade' butonuna tiklanir.
//* T_urun_detay Iade Yontemi popupinda 'Urun Adedi' dropdownindan secim yapilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Nedeni' dropdownindan "5". siradaki secenek secilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Aciklamasi' alanina "Test171717" girilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Olustur' butonuna tiklanir.
//* T_urun_detay 'IADE BASARILI' popupinda headerin altindaki yazi kontrol edilir.
//* T_urun_detay 'IADE BASARILI' popupinda iade kodu icerigi kontrol edilir.
//* T_urun_detay 'IADE BASARILI' popupinda alici kodu icerigi kontrol edilir.
//* T_urun_detay 'IADE BASARILI' popupi kapatilir.
//* T_urun_detay 'IADE TALEBINI IPTAL ET' butonuna tiklanir.
//* T_urun_detay 'Kolay Iade' butonu kontrol edilir.
//
//T_Siparis Detay -  (100 TL Uzeri Urun Icin) "IADE BASARILI" Pop-up' inin Kapatilmasi
//--------------------------------------------------------------------------------------------
//tags: T - Siparis Detay -  (100 TL Uzeri Urun Icin) "IADE BASARILI" Pop-up' inin Kapatilmasi
//* T_login olunur.
//* T_urun_detay 48413682(100TL ustu) siparis nolu urunun sayfasina gidilir.
//* T_urun_detay 'Kolay Iade' butonuna tiklanir.
//* T_urun_detay Kolay Iade popupinda 'Internetten Iade' butonuna tiklanir.
//* T_urun_detay Iade Yontemi popupinda 'Urun Adedi' dropdownindan secim yapilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Nedeni' dropdownindan "5". siradaki secenek secilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Aciklamasi' alanina "Test171717" girilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Olustur' butonuna tiklanir.
//* T_urun_detay 'IADE BASARILI' popupinin acildigi kontrol edilir.
//* T_urun_detay 'IADE BASARILI' popupi kapatilir.
//* T_urun_detay 'IADE TALEBINI IPTAL ET' butonuna tiklanir.
//* "UrunDetaySayfasi_IadeTalebiIptalButton" elementine tikla
//* Press Enter
//* T_urun_detay 'Kolay Iade' butonu kontrol edilir.
//
//T - Siparis Detay -  (100 TL Uzeri Urun Icin) Karta Iade Isleminden Sonra Urun Detay Sayfasinda "Para Iadesi Talebi Olusturuldu", "Iade Kodu", "Alici Kodu", "Iade Talebiniz Alindi" Alanlarinin Kontrol Edilmesi
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//tags: T - Siparis Detay -  (100 TL Uzeri Urun Icin) Karta Iade Isleminden Sonra Urun Detay Sayfasinda "Para Iadesi Talebi Olusturuldu", "Iade Kodu", "Alici Kodu", "Iade Talebiniz Alindi" Alanlarinin Kontrol Edilmesi
//* T_login olunur.
//* T_urun_detay 48413682(100TL ustu) siparis nolu urunun sayfasina gidilir.
//* T_urun_detay 'Kolay Iade' butonuna tiklanir.
//* T_urun_detay Kolay Iade popupinda 'Internetten Iade' butonuna tiklanir.
//* T_urun_detay Iade Yontemi popupinda 'Urun Adedi' dropdownindan secim yapilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Nedeni' dropdownindan "5". siradaki secenek secilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Aciklamasi' alanina "Test171717" girilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Olustur' butonuna tiklanir.
//* T_urun_detay 'IADE BASARILI' popupinin acildigi kontrol edilir.
//* T_urun_detay 'IADE BASARILI' popupi kapatilir.
//* T_urun_detay 'Para Iadesi Talebi Olusturuldu' yazisi kontrol edilir.
//* T_urun_detay 'Iade Kodu' alani kontrol edilir.
//* T_urun_detay 'Alici Kodu' alani kontrol edilir.
//* T_urun_detay 'Iade Talebiniz Alindi' yazisi kontrol edilir.
//* T_urun_detay 'IADE TALEBINI IPTAL ET' butonuna tiklanir.
//* T_urun_detay 'Kolay Iade' butonu kontrol edilir.
//
//T - Siparis Detay -  (100 TL Uzeri Urun Icin) Karta Iade Isleminden Sonra Urun Detay Sayfasinda "IADE TALEBINI IPTAL ET" Butonuna Tiklanmasi
//--------------------------------------------------------------------------------------------------------------------------------------------------
//tags: T - Siparis Detay -  (100 TL Uzeri Urun Icin) Karta Iade Isleminden Sonra Urun Detay Sayfasinda "IADE TALEBINI IPTAL ET" Butonuna Tiklanmasi
//* T_login olunur.
//* T_urun_detay 48413682(100TL ustu) siparis nolu urunun sayfasina gidilir.
//* T_urun_detay 'Kolay Iade' butonuna tiklanir.
//* T_urun_detay Kolay Iade popupinda 'Internetten Iade' butonuna tiklanir.
//* T_urun_detay Iade Yontemi popupinda 'Urun Adedi' dropdownindan secim yapilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Nedeni' dropdownindan "5". siradaki secenek secilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Aciklamasi' alanina "Test171717" girilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Olustur' butonuna tiklanir.
//* T_urun_detay 'IADE BASARILI' popupinin acildigi kontrol edilir.
//* T_urun_detay 'IADE BASARILI' popupi kapatilir.
//* T_urun_detay 'IADE TALEBINI IPTAL ET' butonuna tiklanir.
//* T_urun_detay 'Kolay Iade' butonu kontrol edilir.

T - Siparis Detay -  (100 TL Alti Urun Icin) "Iade Yontemi" Pop-up' inda Tum Alanlar Doldurularak "Iade Olustur" Butonuna Tiklanmasi
------------------------------------------------------------------------------------------------------------------------------------------
tags: T - Siparis Detay - -100 TL Alti Urun Icin- Iade Yontemi- Pop-up inda Tum Alanlar Doldurularak -Iade Olustur- Butonuna Tiklanmasi
* T_login olunur.
* T_urun_detay 48413644(100TL alti) siparis nolu urunun sayfasina gidilir.
* T_urun_detay 'Kolay Iade' butonuna tiklanir.
* T_urun_detay Kolay Iade popupinda 'Internetten Iade' butonuna tiklanir.
* T_urun_detay Iade Yontemi popupinda 'Urun Adedi' dropdownindan secim yapilir.
* T_urun_detay Iade Yontemi popupinda 'Iade Nedeni' dropdownindan "5". siradaki secenek secilir.
* T_urun_detay Iade Yontemi popupinda 'Iade Aciklamasi' alanina "Test171717" girilir.
* T_urun_detay Iade Yontemi popupinda 'Iade Olustur' butonuna tiklanir.
* T_urun_detay Iade Yontemi popupinin acildigi gorulur.

//T - Siparis Detay -  (100 TL Alti Urun Icin) "Iade Yontemi" Pop-up' inda "HEMEN IADE" Butonuna Tiklanmasi
//---------------------------------------------------------------------------------------------------------------
//tags: T - Siparis Detay -  (100 TL Alti Urun Icin) "Iade Yontemi" Pop-up' inda "HEMEN IADE" Butonuna Tiklanmasi
//* T_login olunur.
//* T_urun_detay 48413644(100TL alti) siparis nolu urunun sayfasina gidilir.
//* T_urun_detay 'Kolay Iade' butonuna tiklanir.
//* T_urun_detay Kolay Iade popupinda 'Internetten Iade' butonuna tiklanir.
//* T_urun_detay Iade Yontemi popupinda 'Urun Adedi' dropdownindan secim yapilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Nedeni' dropdownindan "5". siradaki secenek secilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Aciklamasi' alanina "Test171717" girilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Olustur' butonuna tiklanir.
//* T_urun_detay Iade Yontemi popupinin acildigi gorulur.
//* T_urun_detay Iade Yontemi popupinda 'HEMEN IADE' butonuna tiklanir.
//* T_urun_detay Iade basarili popupinin acildigi gorulur.
//* T_urun_detay Iade basarili popupinda 'Kapat' butonuna tiklanir.
//* T_urun_detay 'HEDIYE CEKINI IPTAL ET' butonuna tiklanir.
//* T_urun_detay 'Kolay Iade' butonu kontrol edilir.
//
//
//T - Siparis Detay -  (100 TL Alti Urun Icin) "Iade basarılı" Pop-up' inda "Kapat" Butonuna Tiklanmasi
//-----------------------------------------------------------------------------------------------------------
//tags: T - Siparis Detay -  (100 TL Alti Urun Icin) "Iade basarılı" Pop-up' inda "Kapat" Butonuna Tiklanmasi
//* T_login olunur.
//* T_urun_detay 48413644(100TL alti) siparis nolu urunun sayfasina gidilir.
//* T_urun_detay 'Kolay Iade' butonuna tiklanir.
//* T_urun_detay Kolay Iade popupinda 'Internetten Iade' butonuna tiklanir.
//* T_urun_detay Iade Yontemi popupinda 'Urun Adedi' dropdownindan secim yapilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Nedeni' dropdownindan "5". siradaki secenek secilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Aciklamasi' alanina "Test171717" girilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Olustur' butonuna tiklanir.
//* T_urun_detay Iade Yontemi popupinin acildigi gorulur.
//* T_urun_detay Iade Yontemi popupinda 'HEMEN IADE' butonuna tiklanir.
//* T_urun_detay Iade basarili popupinin acildigi gorulur.
//* T_urun_detay Iade basarili popupinda 'Kapat' butonuna tiklanir.
//* T_urun_detay 'HEDIYE CEKINI IPTAL ET' butonu ve 'Hediye Cekiniz Olusturuldu' yazisi gorulur.
//* T_urun_detay 'HEDIYE CEKINI IPTAL ET' butonuna tiklanir.
//* T_urun_detay 'Kolay Iade' butonu kontrol edilir.
//
//T - Siparis Detay -  (100 TL Alti Urun Icin) "HEDIYE CEKINI IPTAL ET" Butonuna Tiklanmasi
//-----------------------------------------------------------------------------------------------
//tags: T - Siparis Detay -  (100 TL Alti Urun Icin) "HEDIYE CEKINI IPTAL ET" Butonuna Tiklanmasi
//* T_login olunur.
//* T_urun_detay 48413644(100TL alti) siparis nolu urunun sayfasina gidilir.
//* T_urun_detay 'Kolay Iade' butonuna tiklanir.
//* T_urun_detay Kolay Iade popupinda 'Internetten Iade' butonuna tiklanir.
//* T_urun_detay Iade Yontemi popupinda 'Urun Adedi' dropdownindan secim yapilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Nedeni' dropdownindan "5". siradaki secenek secilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Aciklamasi' alanina "Test171717" girilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Olustur' butonuna tiklanir.
//* T_urun_detay Iade Yontemi popupinin acildigi gorulur.
//* T_urun_detay Iade Yontemi popupinda 'HEMEN IADE' butonuna tiklanir.
//* T_urun_detay Iade basarili popupinin acildigi gorulur.
//* T_urun_detay Iade basarili popupinda 'Kapat' butonuna tiklanir.
//* T_urun_detay 'HEDIYE CEKINI IPTAL ET' butonu ve 'Hediye Cekiniz Olusturuldu' yazisi gorulur.
//* T_urun_detay 'HEDIYE CEKINI IPTAL ET' butonuna tiklanir.
//* T_urun_detay 'Hediye Cekiniz Olusturuldu' yazisinin olmadigi kontrol edilir.
//* T_urun_detay 'Kolay Iade' butonu kontrol edilir.
//
//T - Siparis Detay -  (100 TL Alti Urun Icin) "Iade basarili" Pop-up' inin Carpi Simgesi ile Kapatilmasi
//-------------------------------------------------------------------------------------------------------------
//tags: T - Siparis Detay -  (100 TL Alti Urun Icin) "Iade basarili" Pop-up' inin Carpi Simgesi ile Kapatilmasi
//* T_login olunur.
//* T_urun_detay 48413644(100TL alti) siparis nolu urunun sayfasina gidilir.
//* T_urun_detay 'Kolay Iade' butonuna tiklanir.
//* T_urun_detay Kolay Iade popupinda 'Internetten Iade' butonuna tiklanir.
//* T_urun_detay Iade Yontemi popupinda 'Urun Adedi' dropdownindan secim yapilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Nedeni' dropdownindan "5". siradaki secenek secilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Aciklamasi' alanina "Test171717" girilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Olustur' butonuna tiklanir.
//* T_urun_detay Iade Yontemi popupinin acildigi gorulur.
//* T_urun_detay Iade Yontemi popupinda 'HEMEN IADE' butonuna tiklanir.
//* T_urun_detay Iade basarili popupinin acildigi gorulur.
//* T_urun_detay Iade basarili popupinda 'Carpi' butonuna tiklanir.
//* T_urun_detay 'HEDIYE CEKINI IPTAL ET' butonu ve 'Hediye Cekiniz Olusturuldu' yazisi gorulur.
//* T_urun_detay 'HEDIYE CEKINI IPTAL ET' butonuna tiklanir.
//* T_urun_detay 'Hediye Cekiniz Olusturuldu' yazisinin olmadigi kontrol edilir.
//* T_urun_detay 'Kolay Iade' butonu kontrol edilir.
//
//T - Siparis Detay -  (100 TL Alti Urun Icin)  "Iade Yontemi" Pop-up' inda "Karta iade et" Linkine Tiklanmasi
//-----------------------------------------------------------------------------------------------------------------
//tags: T - Siparis Detay -  (100 TL Alti Urun Icin) "Iade Yontemi" Pop-up' inda "Karta iade et" Linkine Tiklanmasi
//* T_login olunur.
//* T_urun_detay 48413644(100TL alti) siparis nolu urunun sayfasina gidilir.
//* T_urun_detay 'Kolay Iade' butonuna tiklanir.
//* T_urun_detay Kolay Iade popupinda 'Internetten Iade' butonuna tiklanir.
//* T_urun_detay Iade Yontemi popupinda 'Urun Adedi' dropdownindan secim yapilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Nedeni' dropdownindan "5". siradaki secenek secilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Aciklamasi' alanina "Test171717" girilir.
//* T_urun_detay Iade Yontemi popupinda 'Iade Olustur' butonuna tiklanir.
//* T_urun_detay Iade Yontemi popupinin acildigi gorulur.
//* T_urun_detay 'Iade Yöntemi' popupinda 'Karta iade et' linkine tiklanir.
//* T_urun_detay 'IADE BASARILI' popupinin acildigi kontrol edilir(100TL alti urun icin).
//* T_urun_detay 'IADE BASARILI' popupi kapatilir.
//* T_urun_detay 'IADE TALEBINI IPTAL ET' butonuna tiklanir.
//* T_urun_detay 'Kolay Iade' butonu kontrol edilir.