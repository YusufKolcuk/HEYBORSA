import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../service/question.service';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {

  questions: any;
  token: any;
  isLogged: any;
  user: any;
  constructor(private questionService: QuestionService,
    private userService: UserService,
    private router: Router) { }

  ngOnInit() {
    this.token = localStorage.getItem("Token");
    this.isLogged = false;
    if(this.token ==null)
      {
          this.router.navigateByUrl("/login");
      }
    if (this.token != null) {
      this.userService.validate(this.token).subscribe(data => {
        this.user = data;
        this.isLogged = true;

        this.questionService.getQuestionsByUserId(this.user.id).subscribe(data => {
          this.questions = data;
          
        });
      });
      
    }

  }

}
