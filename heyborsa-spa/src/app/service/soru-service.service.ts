import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class SoruServiceService {
  url:string = "http://localhost:8080/controller/sorular/";
  constructor(private httpClient:HttpClient) { }

  ekle(soru:any)
  {
    console.log(soru);
      return this.httpClient.post(this.url + "ekle",
      {
        user_id : 4,
        konu : soru.konu,
        baslik : soru.baslik,
        icerik : soru.icerik
      });
  }

  kullaniciSorulariniGetir(id)
  {
    return this.httpClient.get(this.url + "getir/?id=" + id);
  }
}
