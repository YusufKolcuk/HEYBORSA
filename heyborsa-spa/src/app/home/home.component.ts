import { Component, OnInit } from '@angular/core';
import { MarketService } from '../service/market.service';
declare var jQuery: any;
declare var $: any;
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private marketService: MarketService) { }

  money_1_amount: any;
  money_2_amount: any;
  money_1_type: any;
  money_2_type: any;
  data: any;
  specifiedData: any;
  goldValue: any;
  bistValue: any;
  currencies: any = [];
  base: any;
  bist: any;
  ngOnInit() {

    this.prepareData();
    this.prepareGraphics();

  }


  prepareGraphics() {
    if ($('#webticker-1').length) {
      $("#webticker-1").webTicker({
        height: 'auto',
        duplicate: true,
        startEmpty: false,
        rssfrequency: 5
      });
    }

    $('#example1').DataTable({
      'paging': false,
      'lengthChange': false,
      'searching': false,
      'ordering': true,
      'info': false,
      'autoWidth': false
    });


  }

  prepareData() {
    this.bistValue = "95.850";
    this.goldValue = [
      { name: "Gram Altın", value: "250.39", icon: "fas fa-coins" },
      { name: "Çeyrek Altın", value: "398.95", icon: "fas fa-coins" }
    ];

    this.bist = [
      { name: "BIST 100", value: 87.060 },
      { name: "BIST 30", value: 108.969 }
    ]

    this.marketService.getAll().subscribe(data => {
      this.data = data;
      this.data = this.data.rates;
      this.base = this.data["TRY"];
      this.specifiedData = [
        {
          name: "DOLAR",
          value: this.base / this.data["USD"],
          icon: "fa fa-dollar"
        },
        {
          name: "EURO",
          value: this.base / this.data["EUR"],
          icon: "fa fa-euro"
        },
        {
          name: "POUND",
          value: this.base / this.data["GBP"],
          icon: "fa fa-gbp"
        },
        {
          name: "JAPON YENİ",
          value: this.base / this.data["JPY"],
          icon: "fa fa-yen"
        },
      ];
    });
  }

  val_1: any;
  val_2: any;
  moneyExchange_1() { 
    if (this.val_2 != null && this.val_1 != null)
      this.money_2_amount = this.money_1_amount * (this.val_2 / this.val_1);
  }

  moneyExchange_2() {
    console.log(this.val_2);
    if (this.val_2 != null && this.val_1 != null)
      this.money_1_amount = this.money_2_amount * (this.val_1 / this.val_2);
  }

  change_money_1(id: any) {
    this.money_1_type = id;

    switch (this.money_1_type) {
      case "DOLAR":
        this.val_1 = this.data["USD"];
        break;
      case "EURO":
        this.val_1 = this.data["EUR"];
        break;
      case "POUND":
        this.val_1 = this.data["GBP"];
        break;
      case "JAPON YENİ":
        this.val_1 = this.data["JPY"];
        break;
      case "TÜRK LİRASI":
        this.val_1 = this.data["TRY"];
    }
  }
  change_money_2(id: any) {
    this.money_2_type = id;  

    switch (this.money_2_type) {
      case "DOLAR":
        this.val_2 = this.data["USD"];
        break;
      case "EURO":
        this.val_2 = this.data["EUR"];
        break;
      case "POUND":
        this.val_2 = this.data["GBP"];
        break;
      case "JAPON YENİ":
        this.val_2 = this.data["JPY"];
        break;
      case "TÜRK LİRASI":
        this.val_2 = this.data["TRY"];
    }
  }


}
