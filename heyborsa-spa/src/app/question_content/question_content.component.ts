import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../service/question.service';
import { Router,ActivatedRoute, ParamMap } from '@angular/router';
import { stringify } from '@angular/core/src/render3/util';
import { Answer } from '../entities/Answer';

@Component({
  selector: 'app-question_content',
  templateUrl: './question_content.component.html',
  styleUrls: ['./question_content.component.css']
})
export class QuestionContentComponent implements OnInit {
  answer:any = [];
  public message:any;
  constructor(private questionService:QuestionService,
              private router:Router) { }
  url:any;
  ngOnInit() {
     this.url = this.router.url;
    this.url = this.url.substring(11);
    this.questionService.getAnswersByQuestionId(this.url).subscribe(data=>{
      this.answer = data;
    });
  }

  sendMessage()
  {
    
    this.questionService.addAnswerWithUser(this.message,this.url).subscribe(data=>{
      console.log(data);
      let _answer;
      this.questionService.getAnswerById(data).subscribe(_data=>{
        this.answer.push(_data);
      });
     
    });
  }

}
