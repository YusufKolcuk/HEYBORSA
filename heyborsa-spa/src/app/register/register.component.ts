import { Component, OnInit } from '@angular/core';
import { KullaniciServisService } from '../kullanici-servis.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  isim : string;
  soyisim: string;
  parola: string;
  parola_yeniden:string;
  eposta:string;
  telefon:string;

  constructor(private kullaniciServis: KullaniciServisService,
              private router: Router) { }

  ngOnInit() {
  }

  kayit()
  {
    if(this.parola_yeniden == this.parola)
    {
      this.kullaniciServis.kayit({
        isim : this.isim,
        soyisim : this.soyisim,
        eposta: this.eposta,
        parola : this.parola,
        telefon : this.telefon
      }).subscribe(data=>{
        if(data != null)
          this.router.navigateByUrl("/login");
      });
    }
  }

}
