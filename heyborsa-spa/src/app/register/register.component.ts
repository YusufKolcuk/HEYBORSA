import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  first_name : string;
  last_name: string;
  password: string;
  password_again:string;
  email:string;
  telephone:string;

  constructor(private userService: UserService,
              private router: Router) { }

  ngOnInit() {
  }

  register()
  {
    if(this.password_again == this.password)
    {
      this.userService.register({
        first_name : this.first_name,
        last_name : this.last_name,
        email: this.email,
        password : this.password,
        telephone : this.telephone
      }).subscribe(data=>{
        if(data != null)
          this.router.navigateByUrl("/login");
      });
    }
  }

}
