import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class QuestionService {
  url:string = "http://localhost:8080/controller/questions/";
  constructor(private httpClient:HttpClient) { }

  add(soru:any)
  {
    console.log(soru);
      return this.httpClient.post(this.url + "add",soru);
  }

  getQuestionsByUserId(id)
  {
    return this.httpClient.get(this.url + "get/?id=" + id);
  }

  getAnswersByQuestionId(id)
  {
    return this.httpClient.get(this.url + "getanswer/?id=" + id);
  }
}
