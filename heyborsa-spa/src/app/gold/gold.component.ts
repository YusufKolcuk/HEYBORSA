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
  searchText:any="";
  ngOnInit() {
    this.data = [
      {
        "name": "GRAM ALTIN",
        "selling_price": "254,45",
        "buying_price": "254,10",
        "date": "20/05/2019 09:45",
        "isFavorite": 0,
        "favoriteId": 0
      },
      {
        "name": "ÇEYREK ALTIN",
        "selling_price": "414,23",
        "buying_price": "404,12",
        "date": "20/05/2019 09:45",
        "isFavorite": 0,
        "favoriteId": 0
      },
      {
        "name": "TAM ALTIN",
        "selling_price": "827,05",
        "buying_price": "806,12",
        "date": "20/05/2019 09:45",
        "isFavorite": 0,
        "favoriteId": 0
      },
      {
        "name": "CUMHURIYET ALTIN",
        "selling_price": "1.700,21",
        "buying_price": "1.675,92",
        "date": "20/05/2019 09:45",
        "isFavorite": 0,
        "favoriteId": 0
      },
      {
        "name": "ALTIN (ONS)",
        "selling_price": "1.399,45",
        "buying_price": "1.375,32",
        "date": "20/05/2019 09:45",
        "isFavorite": 0,
        "favoriteId": 0
      },
      {
        "name": "ATA ALTIN",
        "selling_price": "1.680,23",
        "buying_price": "1.639,37",
        "date": "20/05/2019 09:45",
        "isFavorite": 0,
        "favoriteId": 0
      },
      {
        "name": "14 AYAR ALTIN",
        "selling_price": "141,67",
        "buying_price": "141,58",
        "date": "20/05/2019 09:45",
        "isFavorite": 0,
        "favoriteId": 0
      },
      {
        "name": "18 AYAR ALTIN",
        "selling_price": "181,44",
        "buying_price": "181,32",
        "date": "20/05/2019 09:45",
        "isFavorite": 0,
        "favoriteId": 0
      },
      {
        "name": "22 AYAR BILEZIK",
        "selling_price": "226,68",
        "buying_price": "226,53",
        "date": "20/05/2019 09:45",
        "isFavorite": 0,
        "favoriteId": 0
      },
      {
        "name": "IKI BUÇUK ALTIN",
        "selling_price": "4.036,54",
        "buying_price": "3.974,24",
        "date": "20/05/2019 09:45",
        "isFavorite": 0,
        "favoriteId": 0
      },
      {
        "name": "BESLI ALTIN",
        "selling_price": "8.078,06",
        "buying_price": "7.923,65",
        "date": "20/05/2019 09:45",
        "isFavorite": 0,
        "favoriteId": 0
      },
      {
        "name": "GREMSE ALTIN",
        "selling_price": "4.063,88",
        "buying_price": "3.974,24",
        "date": "20/05/2019 09:45",
        "isFavorite": 0,
        "favoriteId": 0
      },
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
