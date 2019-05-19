import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email: string = '';
  password: string = '';
  data: any;
  badlogin=false;
  constructor(private userService: UserService,
    private router: Router) { }
  ngOnInit() {

  }

  login() {

    this.userService.login({
      email: this.email,
      password: this.password
    }).subscribe(data => {
      console.log(data);
      this.data = data;
      if(this.data == null)
        this.badlogin = true;
      if (data != null) {
        this.badlogin =false;
        if (this.data.active) {
          this.userService.validate(btoa(this.email + ':' + this.password)).subscribe(data => {
            if (data != null) {
              this.router.navigateByUrl("/");
              localStorage.setItem('Token', btoa(this.email + ':' + this.password));
            }
          });

        }
      }
    });
  }

}
