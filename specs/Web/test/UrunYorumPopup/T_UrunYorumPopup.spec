Urunle Ilgili Yorumum Var Test Senaryolari
==========================================

T - Siparis Detay - "Urunle ilgili yorumum var" Linkine Tıklanmasi
------------------------------------------------------------------------
tags: T - Siparis Detay - Urunle ilgili yorumum var Linkine Tiklanmasi
* T_login olunur.
* T_urun_detay 16460712 siparis nolu urunun sayfasina gidilir.
* T_urun_yorum_popup 'Urunle ilgili yorumum var.' linkine tiklanir.
* T_urun_yorum_popup acildigi kontrol edilir.

T - Urun Yorum Pop-Up - Yildizla Derecelendirme Yapilip 'Yorum Yap' Butonuna Tiklanmasi
---------------------------------------------------------------------------------------------
tags: T - Urun Yorum Pop-Up - Yildizla Derecelendirme Yapilip Yorum Yap Butonuna Tiklanmasi
* T_login olunur.
* T_urun_detay 16460712 siparis nolu urunun sayfasina gidilir.
* T_urun_yorum_popup 'Urunle ilgili yorumum var.' linkine tiklanir.
* T_urun_yorum_popup acildigi kontrol edilir.
* T_urun_yorum_popup ("2"+1) yildiz verilir.
* T_urun_yorum_popup 'Yorum Yap' butonuna tiklanir.
* "UrunYorumPopUp_UyariMesaji" elementi yokmu kontrol et

T - Urun Yorum Pop-Up - "Yorumunuz" Alaninın Bos Bırakilip "Yorum Yap" Butonuna Tiklanmasi
------------------------------------------------------------------------------------------------
tags: T - Urun Yorum Pop-Up - Yorumunuz- Alaninın Bos Bırakilip Yorum Yap Butonuna Tiklanmasi
* T_login olunur.
* T_urun_detay 16460712 siparis nolu urunun sayfasina gidilir.
* T_urun_yorum_popup 'Urunle ilgili yorumum var.' linkine tiklanir.
* T_urun_yorum_popup acildigi kontrol edilir.
* T_urun_yorum_popup yorum alanina "" girilir.
* T_urun_yorum_popup 'Yorum Yap' butonuna tiklanir.
* T_urun_yorum_popup uyari mesajinin "Uyarı: Lütfen yorumunuz için puanlama yapınız." textini icerdigi kontrol edilir.

T - Urun Yorum Pop-Up - "Yorumunuz" Alanina Yorum Yazilip "Yorum Yap" Butonuna Tiklanmasi
-----------------------------------------------------------------------------------------------
tags: T - Urun Yorum Pop-Up - Yorumunuz Alanina Yorum Yazilip Yorum Yap Butonuna Tiklanmasi
* T_login olunur.
* T_urun_detay 16460712 siparis nolu urunun sayfasina gidilir.
* T_urun_yorum_popup 'Urunle ilgili yorumum var.' linkine tiklanir.
* T_urun_yorum_popup acildigi kontrol edilir.
* T_urun_yorum_popup yorum alanina "Ürün kaliteli herhangi bir problem yaşamadım. Test123123" girilir.
* T_urun_yorum_popup 'Yorum Yap' butonuna tiklanir.
* T_urun_yorum_popup uyari mesajinin "Uyarı: Lütfen yorumunuz için puanlama yapınız." textini icerdigi kontrol edilir.

//T_Urun Yorum Pop-Up - "Yorumunuza Resim Ekleyin" Alaninda "Dosya Sec" Butonuna Tiklanarak Resim Eklenip "Yorum Yap" Butonuna Tiklanmasi
//-----------------------------------------------------------------------------------------------------------------------------------------------
//* T_login olunur.
//* T_urun_detay 16460712 siparis nolu urunun sayfasina gidilir.
//* T_urun_yorum_popup 'Urunle ilgili yorumum var.' linkine tiklanir.
//* T_urun_yorum_popup acildigi kontrol edilir.
//* T_urun_yorum_popup resim eklenir.
//* "4" saniye bekle
////resim eklenme süresi. Resim ekleme manuel yapılıyor.
//* T_urun_yorum_popup 'Yorum Yap' butonuna tiklanir.
//* T_urun_yorum_popup uyari mesajinin "Uyarı: Lütfen yorumunuz için puanlama yapınız." textini icerdigi kontrol edilir.
////Bu senaryoyu koşarken 16:06-18:17 aralığında yeni.krc html olarak görünüyordu.


