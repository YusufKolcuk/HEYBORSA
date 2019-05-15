import { Component, OnInit } from '@angular/core';
import { MarketService } from '../service/market.service';

@Component({
  selector: 'app-currency',
  templateUrl: './currency.component.html',
  styleUrls: ['./currency.component.css']
})
export class CurrencyComponent implements OnInit {
  currency:any;
  base:any;
  currencies:any = [];
  favorites:any = [];
  constructor(private marketService:MarketService) { }
  
  ngOnInit() {
    this.marketService.getAll().subscribe(data=>{
      this.currency = data;
      this.currency = this.currency.rates;
      this.base = this.currency["TRY"];
      
      this.marketService.checkFavoritesByFavoriteType(
        {
          user_id : 1,
          favorite_type : "currency"
        }
      ).subscribe(data=>{
        this.favorites = data;
        
        for(let i=0;i<Object.keys(this.currency).length;i++)
        {
          let isFavorite = 0;
          let favoriteId = 0;
          let _favorite = this.favorites.filter(favorite => (favorite.favorite_data == Object.keys(this.currency)[i]));
            if(_favorite.length == 1){
              isFavorite = 1;
              favoriteId = _favorite[0].id;

            }
          this.currencies.push(
            {
              "currencyname" : Object.keys(this.currency)[i],
              "value" : this.base / this.currency[Object.keys(this.currency)[i]],
              "isFavorite" : isFavorite,//0
              "id" : favoriteId
            }
          )    
      }
      });

      

    });
  }

  addFavorite(currencyName)
  {
    
    this.marketService.addFavorite({
      favorite_type:"currency",
      favorite_data:currencyName,
      user_id:1,
    }).subscribe(data=>{
      console.log(data);
    });
    
  }

  removeFavorite(currencyName,id)
  {
    console.log(id);
    this.marketService.removeFavorite({
      user_id:1,
      favorite_type:"currency",
      favorite_data:currencyName,
      id:id
  }).subscribe(data=>{

  });
  }

}
