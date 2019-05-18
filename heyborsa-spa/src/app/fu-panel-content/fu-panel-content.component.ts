import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';
import { QuestionService } from '../service/question.service';

@Component({
  selector: 'app-fu-panel-content',
  templateUrl: './fu-panel-content.component.html',
  styleUrls: ['./fu-panel-content.component.css']
})
export class FuPanelContentComponent implements OnInit {

  constructor(private router:Router,
              private userService:UserService,
              private questionService:QuestionService) { }
  token:any;
  isLogged:any;
  user:any;
  data:any =[];
  message:any;
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
          let url = this.router.url;
          url = url.substring(19);
          
          this.questionService.getAnswersByQuestionId(url).subscribe(data=>{
            this.data = data;
          });
        }
      });
    }
    
  }

  sendMessage()
  {
    let url = this.router.url;
          url = url.substring(19);
      this.questionService.addAnswerWithFu(this.message,url).subscribe(data=>{
        console.log(data);
        this.questionService.getAnswerById(data).subscribe(_data=>{
          this.data.push(_data);
        })
      })
  }

}
