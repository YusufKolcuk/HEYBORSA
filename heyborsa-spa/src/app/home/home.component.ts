import { Component, OnInit } from '@angular/core';
import { MarketService } from '../service/market.service';
declare var jQuery: any;
declare var $ : any;
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private marketService:MarketService) { }
  data:any;
  currencies:any=[];
  specifiedData:any;
  goldValue:any;
  bistValue:any;
  base:any;
  bist:any;
  ngOnInit() {
    
    this.prepareData();
    this.prepareGraphics();
    
  }

  prepareGraphics()
  {
    if ($('#webticker-1').length) {   
      $("#webticker-1").webTicker({
        height:'auto', 
        duplicate:true, 
        startEmpty:false, 
        rssfrequency:5
      });
    }

    $('#example1').DataTable({
      'paging'      : false,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : false,
      'autoWidth'   : false
    });

    
      if ($('.coins-exchange').length) {
        $('.coins-exchange').select2();
    }
    if ($('.money-exchange').length) {
        $('.money-exchange').select2();
    }
 
  }

  prepareData()
  {
    this.bistValue="95.850";
    this.goldValue=[
      {name : "Gram Altın", value:"250.39",icon:"fas fa-coins"},
      {name : "Çeyrek Altın",value:"398.95",icon:"fas fa-coins"}
    ];

    this.bist=[
      {name:"BIST 100",value:87.060},
      {name:"BIST 30",value:108.969}
    ]

    
    

    this.marketService.getAll().subscribe(data=>{
      this.data = data;
      this.data = this.data.rates;
      this.base = this.data["TRY"];
      this.specifiedData = [
        {
          name : "DOLAR",
          value :  this.base / this.data["USD"],
          icon:"fa fa-dollar"
        },
        {
          name : "EURO",
          value : this.base /  this.data["EUR"] ,
          icon:"fa fa-euro"
        },
        {
          name : "POUND",
          value : this.base /  this.data["GBP"],
          icon:"fa fa-gbp"
        },
        {
          name : "JAPON YENİ",
          value : this.base /  this.data["JPY"],
          icon : "fa fa-yen"
        },
      ];

      //Object.keys(this.data).length
        
        
    });
  }


}
