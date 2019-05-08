import { Component, OnInit } from '@angular/core';
import { KullaniciServisService } from '../kullanici-servis.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
   eposta:string = '';
   parola:string = '';
  constructor(private kullaniciServis: KullaniciServisService,
              private router: Router) { }
  kullanici:Kullanici;
  ngOnInit() {
  
  }

  giris()
  {
    this.kullaniciServis.giris(this.eposta,this.parola).subscribe(data=>{
      console.log(data);
      if(data != null)
        this.router.navigateByUrl("/");
    })
  }

}
