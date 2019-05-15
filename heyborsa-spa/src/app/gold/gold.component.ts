import { Component, OnInit } from '@angular/core';
import { MarketService } from '../service/market.service';
@Component({
  selector: 'app-gold',
  templateUrl: './gold.component.html',
  styleUrls: ['./gold.component.css']
})
export class GoldComponent implements OnInit {

  constructor(private marketService:MarketService) { 
    
  }
  data:any;
  ngOnInit() {
    this.data=[
      {
        "name" : "Gram Altın",
        "selling_price" : "254",
        "buying_price" : "254",
        "date" : "111"
      },
      {
        "name" : "Çeyrek Altın",
        "selling_price" : "414",
        "buying_price" : "404",
        "date" : "111"
      },
      {
        "name" : "Yarım Altın",
        "selling_price" : "827",
        "buying_price" : "806",
        "date" : "111"
      },
      {
        "name" : "Cumhuriyet Altın",
        "selling_price" : "1700",
        "buying_price" : "1675",
        "date" : "111"
      },
      {
        "name" : "Altın (ONS)",
        "selling_price" : "1399",
        "buying_price" : "1375",
        "date" : "111"
      }
    ]
  }

}
