import { Component, OnInit } from '@angular/core';
import { SoruServiceService } from '../service/soru-service.service';

@Component({
  selector: 'app-sorularim',
  templateUrl: './sorularim.component.html',
  styleUrls: ['./sorularim.component.css']
})
export class SorularimComponent implements OnInit {

  sorularim : any;
  constructor(private sorularimService:SoruServiceService) { }

  ngOnInit() {
    this.sorularimService.kullaniciSorulariniGetir(4).subscribe(data=>{
      this.sorularim = data;

      console.log(data);
    });
  }

}
