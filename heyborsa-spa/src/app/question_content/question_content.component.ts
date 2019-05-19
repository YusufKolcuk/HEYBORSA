import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../service/question.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { stringify } from '@angular/core/src/render3/util';
import { Answer } from '../entities/Answer';
import { UserService } from '../service/user.service';
import { formatDate, registerLocaleData } from '@angular/common';

@Component({
  selector: 'app-question_content',
  templateUrl: './question_content.component.html',
  styleUrls: ['./question_content.component.css']
})
export class QuestionContentComponent implements OnInit {
  answer: any = [];
  token: any;
  isLogged: any;
  user: any;
  public message: any;
  constructor(private questionService: QuestionService,
    private router: Router,
    private userService: UserService) { }
  url: any;
  ngOnInit() {
    this.token = localStorage.getItem("Token");
    this.isLogged = false;
    if (this.token == null) { //eğer session yoksa
      this.router.navigateByUrl("/");
    }
    if (this.token != null) {
      this.userService.validate(this.token).subscribe(data => { //kullanıcının session kontrolü
        this.user = data;
        this.isLogged = true;
        this.url = this.router.url;
        this.url = this.url.substring(11);
        this.questionService.validateQuestion(this.url, this.user.id).subscribe(data => { //sorunun kullanıcıya ait olup olmadığının kontrolü
          if (data) {
            this.questionService.getAnswersByQuestionId(this.url).subscribe(data => { //soruya ait cevapların çekildiği kısım
              this.answer = data;
            });
          }
          else
          this.router.navigateByUrl("/");
        });
      });
    }
  }

  sendMessage() {

    this.questionService.addAnswerWithUser(this.message, this.url).subscribe(data => {
      console.log(data);
      let _answer;
      this.questionService.getAnswerById(data).subscribe(_data => {
        this.answer.push(_data);
      });

    });
  }

  dateFormat(date)
  {
    return formatDate(date,'dd/MM/yyyy',"en-US");
  }

}
