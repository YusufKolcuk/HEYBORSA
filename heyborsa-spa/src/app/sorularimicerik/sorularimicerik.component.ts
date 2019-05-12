import { Component, OnInit } from '@angular/core';
import { SoruServiceService } from '../service/soru-service.service';

@Component({
  selector: 'app-sorularimicerik',
  templateUrl: './sorularimicerik.component.html',
  styleUrls: ['./sorularimicerik.component.css']
})
export class SorularimicerikComponent implements OnInit {
  soruCevap:any;
  constructor(private soruService:SoruServiceService) { }

  ngOnInit() {
    this.soruService.kullaniciSoruCevaplariGetir(1).subscribe(data=>{
      this.soruCevap = data;
    })
  }

}
