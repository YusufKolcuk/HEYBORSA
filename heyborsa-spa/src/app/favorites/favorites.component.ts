import { Component, OnInit } from '@angular/core';
import { MarketService } from '../service/market.service';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.css']
})
export class FavoritesComponent implements OnInit {

  constructor(private marketService:MarketService,
              private userService:UserService,
              private router:Router) { }
  goldData:any;
  exchangeData:any;
  currencyData:any;
  data:any;
  token:any;
  user:any;
  ngOnInit() {
    this.token = localStorage.getItem("Token");

    if(this.token == null)
      this.router.navigateByUrl("/login");

    this.userService.validate(this.token).subscribe(data=>{
      if(data != null){
        this.user = data;
        this.marketService.getAllFavoritesByUserId(this.user.id).subscribe(data=>{
          this.data = data;
          this.goldData = this.data.filter(gold=>(gold.favorite_type == "gold"));
          this.exchangeData = this.data.filter(exchange => (exchange.favorite_type == "exchange") );
          this.currencyData = this.data.filter(currency => (currency.favorite_type == "currency") );
        });
      }
    });
    
  }

  removeFavorite(id)
  {

  }

}
