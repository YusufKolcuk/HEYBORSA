import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../service/question.service';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {

  questions: any = [];
  token: any;
  isLogged: any;
  user: any;

  totalQuestions:any;
  answeredQuestions:any;
  resolvedQuestions:any;
  waitingQuestions:any;

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
          this.questionStatus();
        });
      });
      
    }

  }

  questionStatus()
  {
    this.totalQuestions = this.questions.length;
    if(this.totalQuestions == null) this.totalQuestions = 0;

    this.waitingQuestions = this.questions.filter(
      data=> (data.status == "waiting")
    ).length;
    if(this.waitingQuestions == null) this.waitingQuestions = 0;

    this.answeredQuestions = this.questions.filter(
      data=> (data.status == "answered")
    ).length;
    if(this.answeredQuestions == null) this.answeredQuestions = 0;

    this.resolvedQuestions = this.questions.filter(
      data=> (data.status == "resolved")
    ).length;
    if(this.resolvedQuestions == null) this.resolvedQuestions = 0;
  }

  deleteQuestion(question:any)
  {
    this.questions.forEach((item, index) => {
      if (item === question) {
        this.questions.splice(index, 1);

        this.questionService.delete(item).subscribe(data=>{});
        this.questionStatus();
      }
    });
  }

  dateFormat(date)
  {
    return formatDate(date,'dd/MM/yyyy',"en-US");
  }

}
