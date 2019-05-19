import { Component, OnInit } from '@angular/core';
import { MarketService } from '../service/market.service';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.css']
})
export class FavoritesComponent implements OnInit {

  constructor(private marketService: MarketService,
    private userService: UserService,
    private router: Router) { }
  goldData: any = [];
  exchangeData: any = [];
  currencyData: any = [];
  data: any;
  token: any;
  user: any;
  ngOnInit() {
    this.token = localStorage.getItem("Token");
    if (this.token == null)
      this.router.navigateByUrl("/login");

    this.userService.validate(this.token).subscribe(data => {
      if (data != null) {
        this.user = data;
        this.marketService.getAllFavoritesByUserId(this.user.id).subscribe(data => {
          this.data = data;
          this.goldData = this.data.filter(gold => (gold.favorite_type == "gold"));
          this.exchangeData = this.data.filter(exchange => (exchange.favorite_type == "exchange"));
          this.currencyData = this.data.filter(currency => (currency.favorite_type == "currency"));
        });
      }
    });

  }

  removeCurrencyFavorite(favorite: any) {
    this.currencyData.forEach((item, index) => {
      if (item === favorite) {
        this.currencyData.splice(index, 1);

        this.marketService.removeFavorite({
          favorite_type : "currency",
          favorite_data : favorite.favorite_data,
          user_id : favorite.user_id,
          id : favorite.id
        })
          .subscribe(data=>{
          
        });
      }
    });
  }

  removeGoldFavorite(favorite: any) {
    this.goldData.forEach((item, index) => {
      if (item === favorite) {
        this.goldData.splice(index, 1);

        this.marketService.removeFavorite({
          favorite_type : "gold",
          favorite_data : favorite.favorite_data,
          user_id : favorite.user_id,
          id : favorite.id
        })
          .subscribe(data=>{
          
        });
      }
    });
  }

  removeExchangeFavorite(favorite: any) {
    this.exchangeData.forEach((item, index) => {
      if (item === favorite) {
        this.exchangeData.splice(index, 1);

        this.marketService.removeFavorite({
          favorite_type : "exchange",
          favorite_data : favorite.favorite_data,
          user_id : favorite.user_id,
          id : favorite.id
        })
          .subscribe(data=>{
          
        });
      }
    });
  }

  dateFormat(date)
  {
    return formatDate(date,'dd/MM/yyyy',"en-US");
  }

}
