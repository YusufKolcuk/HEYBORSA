import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MarketService {
  url = "http://data.fixer.io/api/latest?access_key=f08d0093cd3ad8cccffdce05027bcbab";
  spring_url = "http://localhost:8080/controller/favorites/";
  constructor(private httpClient : HttpClient) { }

  getAll()
  {
    return this.httpClient.get(this.url);
  }

  getAllFavoritesByUserId(id){
    return this.httpClient.get(this.spring_url + "getall/?id=" +id);
  }

  checkFavorites(data:any)
  {
    return this.httpClient.get(this.spring_url + "checkmultiple",data)
  }

  checkFavoritesByFavoriteType(data:any)
  {
    return this.httpClient.post(this.spring_url + "checkfavoritesbyfavoritetype",data);
  }

  addFavorite(data:any)
  {
    return this.httpClient.post(this.spring_url + "addfavorite",data);
  }

  removeFavorite(data:any)
  {
    return this.httpClient.post(this.spring_url + "removefavorite",data);
  }
}
