import { Component, OnInit } from '@angular/core';
import { MarketService } from '../service/market.service';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

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
  user:any;
  token:any;
  isLogged:any;
  constructor(private marketService:MarketService,
              private userService:UserService,
              private router:Router) { }
  
  ngOnInit() {

    this.token = localStorage.getItem("Token");
    this.isLogged = false;
    if (this.token != null) {
        this.userService.validate(this.token).subscribe(data=>{
          this.user = data;
          this.isLogged = true;
          
        });
    }


    this.marketService.getAll().subscribe(data=>{
      this.currency = data;
      this.currency = this.currency.rates;
      this.base = this.currency["TRY"];
      
      this.marketService.checkFavoritesByFavoriteType(
        {
          user_id : this.user.id,
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
      user_id:this.user.id,
    }).subscribe(data=>{
      this.router.navigateByUrl("/favorites");
    });
    
  }

  removeFavorite(currencyName,id)
  {
    this.marketService.removeFavorite({
      user_id:this.user.id,
      favorite_type:"currency",
      favorite_data:currencyName,
      id:id
  }).subscribe(data=>{
    
  });
  }

}
