import { Component, OnInit } from '@angular/core';
import {Market} from '../entities/Market';
@Component({
  selector: 'app-altin',
  templateUrl: './altin.component.html',
  styleUrls: ['./altin.component.css']
})
export class AltinComponent implements OnInit {
  data:any;
  constructor() { 
    
  }

  ngOnInit() {
    this.data = [
      new Market(1,"Çeyrek Altın","ALTIN",402,390,"00000"),
      new Market(2,"Yarım Altın","ALTIN",804,780,"0000"),
      new Market(2,"Tam Altın","ALTIN",1608,1550,"000"),
    ]
  }

}
