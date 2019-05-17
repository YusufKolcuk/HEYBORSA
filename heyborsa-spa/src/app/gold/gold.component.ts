import { Component, OnInit } from '@angular/core';
import { MarketService } from '../service/market.service';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-gold',
  templateUrl: './gold.component.html',
  styleUrls: ['./gold.component.css']
})
export class GoldComponent implements OnInit {

  constructor(private marketService: MarketService,
              private userService:UserService,
              private router:Router) {

  }
  data: any;
  favorite: any;

  user:any;
  token:any;
  isLogged:any;
  id:any;
  ngOnInit() {
    this.data = [
      {
        "name": "GRAM ALTIN",
        "selling_price": "254",
        "buying_price": "254",
        "date": "111",
        "isFavorite": 0,
        "favoriteId": 0
      },
      {
        "name": "ÇEYREK ALTIN",
        "selling_price": "414",
        "buying_price": "404",
        "date": "111",
        "isFavorite": 0,
        "favoriteId": 0
      },
      {
        "name": "CUMHURİYET ALTIN",
        "selling_price": "827",
        "buying_price": "806",
        "date": "111",
        "isFavorite": 0,
        "favoriteId": 0
      },
      {
        "name": "CUMHURİYET ALTIN",
        "selling_price": "1700",
        "buying_price": "1675",
        "date": "111",
        "isFavorite": 0,
        "favoriteId": 0
      },
      {
        "name": "ALTIN (ONS)",
        "selling_price": "1399",
        "buying_price": "1375",
        "date": "111",
        "isFavorite": 0,
        "favoriteId": 0
      }
    ]

    this.token = localStorage.getItem("Token");
    this.isLogged = false;
    if (this.token != null) {
        this.userService.validate(this.token).subscribe(data=>{
          this.user = data;
          this.isLogged = true;

          this.marketService.checkFavoritesByFavoriteType({
            user_id: this.user.id,
            favorite_type: "gold"
          }).subscribe(data => {
            this.favorite = data;
            for (let i = 0; i < this.data.length; i++) {
              let _favorite = this.favorite.filter(
                favorite => (favorite.favorite_data == this.data[i].name));
              if (_favorite.length == 1) {
                this.data[i].isFavorite = 1;
                this.data[i].favoriteId = _favorite[0].id;
              }
            }
      
          });
        });
    }

    
  }

  addFavorite(currencyName) {
    this.marketService.addFavorite({
      favorite_type: "gold",
      favorite_data: currencyName,
      user_id: this.user.id
    }).subscribe(data => {
      this.router.navigateByUrl("/favorites");
    });
  }

  removeFavorite(currencyName, id) {
    this.marketService.removeFavorite({
      favorite_type: "gold",
      favorite_data: currencyName,
      user_id: this.user.id,
      id: id
    }).subscribe(data => {
    });
  }

}
