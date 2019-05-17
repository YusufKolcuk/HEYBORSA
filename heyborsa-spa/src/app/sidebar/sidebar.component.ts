import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  data: any;
  token: any;
  isLogged:any;
  constructor(private userService: UserService) { }

  ngOnInit() {
    this.token = localStorage.getItem("Token");
    this.isLogged = false;
    if (this.token != null) {
        this.userService.validate(this.token).subscribe(data=>{
          this.data = data;
          this.isLogged = true;
        });
    }
  }

  logout()
  {
    localStorage.removeItem("Token");
    
  }

}
