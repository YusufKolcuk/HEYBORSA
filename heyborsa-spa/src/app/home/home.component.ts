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
  }

  prepareData()
  {
    this.bistValue="95.850";
    this.goldValue=[
      {name : "Gram Altın", value:"250.39"},
      {name : "Çeyrek Altın",value:"398.95"}
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
          name : "USD",
          value :  this.base / this.data["USD"] 
        },
        {
          name : "EUR",
          value : this.base /  this.data["EUR"] 
        },
        {
          name : "GBP",
          value : this.base /  this.data["GBP"] 
        },
        {
          name : "RUB",
          value : this.base /  this.data["RUB"]
        },
      ];

      //Object.keys(this.data).length
        
        
    });
  }


}
