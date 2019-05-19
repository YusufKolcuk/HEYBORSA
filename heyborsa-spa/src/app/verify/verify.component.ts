import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-verify',
  templateUrl: './verify.component.html',
  styleUrls: ['./verify.component.css']
})
export class VerifyComponent implements OnInit {

  constructor(private router:Router,
              private userService:UserService) { }
  key:any;
  ngOnInit() {

    this.key = this.router.url;
    this.key = this.key.substring(13);
    this.userService.verify(this.key).subscribe(data=>{
      if(data)
        this.router.navigateByUrl("/login");
    });
  }

}
