import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  url:string = "http://localhost:8080/controller/user/";
  constructor(private httpClient : HttpClient) { }
   
  login(data:any){
      return this.httpClient.post(this.url + "login",data);
  }

  register(data:any)
  {
    return this.httpClient.post(this.url + "register",data);
  }

}
