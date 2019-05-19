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
    const headers = new HttpHeaders({ Authorization:btoa(data.email + ':' + data.password) });
      return this.httpClient.post(this.url + "login",data,{headers});
  }

  validate(token)
  {
      return this.httpClient.get(this.url + "validate?token="+token);
  }

  register(data:any)
  {
    return this.httpClient.post(this.url + "register",data);
  }

  verify(key:any)
  {
    return this.httpClient.get(this.url + "verifyemail?key=" +key);
  }

}
