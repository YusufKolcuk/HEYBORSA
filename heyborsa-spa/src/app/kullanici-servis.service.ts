import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class KullaniciServisService {
  url:string = "http://localhost:8080/controller/kullanici/";
  constructor(private httpClient : HttpClient) { }
   
  giris(_eposta:string, _parola:string){
      return this.httpClient.post(this.url + "giris",
      { 
        eposta: _eposta, 
        parola : _parola
      }
      );
  }

  kayit(data:any)
  {
    return this.httpClient.post(this.url + "kayit",data);
  }

}
