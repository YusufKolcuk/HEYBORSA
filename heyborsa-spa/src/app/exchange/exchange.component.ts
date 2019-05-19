import { Component, OnInit } from '@angular/core';
import { MarketService } from '../service/market.service';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-exchange',
  templateUrl: './exchange.component.html',
  styleUrls: ['./exchange.component.css']
})
export class ExchangeComponent implements OnInit {

  data:any;
  favorite:any;
  user:any;
  token:any;
  isLogged:any;
  id:any;
  searchText:any;
  constructor(private marketService:MarketService,
              private userService:UserService,
              private router:Router) { }

  ngOnInit() {
    this.data =[
      {
        name : "GARAN", price: "7,67", change:"0,04", volume:"94.350.259,00",isFavorite:0,favoriteId:0
      },
      {
        name : "ADESE", price: "1,61", change:"0,01", volume:"72.607.788,00",isFavorite:0,favoriteId:0
      },
      {
        name : "KRDMD", price: "2,07", change:"0,04", volume:"70.953.688,00",isFavorite:0,favoriteId:0
      },
      {
        name : "AKBNK", price: "5,78", change:"0,01	", volume:"57.112.063,00",isFavorite:0,favoriteId:0
      },
      {
        name : "YKBNK", price: "1,94", change:"-0,25", volume:"56.693.095,00",isFavorite:0,favoriteId:0
      },
      {
        name : "THYAO", price: "12,02", change:"0,04", volume:"54.009.803,00",isFavorite:0,favoriteId:0
      },
      {
        name : "HALKB", price: "4,98", change:"0,04", volume:"52.618.586,00",isFavorite:0,favoriteId:0
      },
      {
        name : "SMART", price: "2,87", change:"-0,04", volume:"66.128.302,00	",isFavorite:0,favoriteId:0
      },
      {
        name : "TTKOM", price: "4,19", change:"-0,16", volume:"27.377.188,00",isFavorite:0,favoriteId:0
      },
      {
        name : "ASELS", price: "18,87", change:"1,17", volume:"25.302.114,00",isFavorite:0,favoriteId:0
      },
    ]
    
    this.token = localStorage.getItem("Token");
    this.isLogged = false;
    if (this.token != null) {
        this.userService.validate(this.token).subscribe(data=>{
          this.user = data;
          this.isLogged = true;
          this.id = this.user.id;
          

          this.marketService.checkFavoritesByFavoriteType({
            user_id: this.id,
            favorite_type: "exchange"
          }).subscribe(data => {
            this.favorite = data;
            for (let i = 0; i < this.data.length; i++) {
              let _favorite = this.favorite.filter(
                favorite => (favorite.favorite_data == this.data[i].name));
              if (_favorite.length == 1) {
                console.log(_favorite[i]);
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
      favorite_type: "exchange",
      favorite_data: currencyName,
      user_id: this.id
    }).subscribe(data => {
      this.router.navigateByUrl("/favorites");
    });
  }

  removeFavorite(currencyName, id) {
    this.marketService.removeFavorite({
      favorite_type: "exchange",
      favorite_data: currencyName,
      user_id: this.id,
      id: id
    }).subscribe(data => {
    });
  }

}
