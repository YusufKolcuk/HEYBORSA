import { Component, OnInit } from '@angular/core';
import { SoruServiceService } from '../service/soru-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-yenisoru',
  templateUrl: './yenisoru.component.html',
  styleUrls: ['./yenisoru.component.css']
})
export class YenisoruComponent implements OnInit {

  public konu:String = "";
  public baslik:String = "";
  public icerik:String = "";


  constructor(private soruService:SoruServiceService,
              private router:Router) { }

  ngOnInit() {
  }

  ekle()
  {
    this.soruService.ekle(
     {
       konu : this.konu,
       baslik : this.baslik,
       icerik : this.icerik
     }
    ).subscribe(data=>{
      console.log(data);
      if(data != null)
        this.router.navigateByUrl("/sorularim/" + data);
    });
  }



}
