import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../service/question.service';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-newquestion',
  templateUrl: './newquestion.component.html',
  styleUrls: ['./newquestion.component.css']
})
export class NewQuestionComponent implements OnInit {

  public subject: String = "";
  public header: String = "";
  public content: String = "";

  token: any;
  isLogged: any;
  user: any;

  constructor(private questionService: QuestionService,
    private router: Router,
    private userService: UserService) { }

  ngOnInit() {
    this.token = localStorage.getItem("Token");
    this.isLogged = false;
    if (this.token == null) {
      this.router.navigateByUrl("/");
    }
    if (this.token != null) {
      this.userService.validate(this.token).subscribe(data => {
        this.user = data;
        this.isLogged = true;
      });
  }
  }

  add() {
    this.questionService.add(
      {
        user_id: this.user.id,
        subject: this.subject,
        header: this.header,
        content: this.content
      }
    ).subscribe(data => {
      console.log(data);
      if (data != null)
        this.router.navigateByUrl("/questions/" + data);
    });
  }



}
