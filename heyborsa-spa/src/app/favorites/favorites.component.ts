import { Component, OnInit } from '@angular/core';
import { MarketService } from '../service/market.service';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.css']
})
export class FavoritesComponent implements OnInit {

  constructor(private marketService:MarketService) { }
  goldData:any;
  exchangeData:any;
  currencyData:any;
  data:any;
  ngOnInit() {
    this.marketService.getAllFavoritesByUserId(1).subscribe(data=>{
      this.data = data;
      this.goldData = this.data.filter(gold=>(gold.favorite_type == "gold"));
      this.exchangeData = this.data.filter(exchange => (exchange.favorite_type == "exchange") );
      this.currencyData = this.data.filter(currency => (currency.favorite_type == "currency") );
    });
  }

  removeFavorite(id)
  {

  }

}
