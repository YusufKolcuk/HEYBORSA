import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../service/question.service';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fu-panel',
  templateUrl: './fu-panel.component.html',
  styleUrls: ['./fu-panel.component.css']
})
export class FuPanelComponent implements OnInit {
  token:any;
  all:any;
  isLogged:any;
  openedQuestions:any;
  user:any;
  constructor(private questionService:QuestionService,
              private userService:UserService,
              private router:Router) { }

  ngOnInit() {

    this.token = localStorage.getItem("Token");
    this.isLogged = false;
    if(this.token ==null)
      {
          this.router.navigateByUrl("/");
      }
    if (this.token != null) {
      this.userService.validate(this.token).subscribe(data => {
        this.user = data;
        this.isLogged = true;
        if(this.user.user_type != 0)
        {
          this.router.navigateByUrl("/");
        }
        else{
          this.questionService.getAll().subscribe(data=>{
            this.all = data;
          });
      
          this.questionService.getAllOpenedQuestions().subscribe(data=>{
            this.openedQuestions = data;
            console.log(this.openedQuestions);
          });
        }
      });
      
    }



    
  }

}
