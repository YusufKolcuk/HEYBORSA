import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../service/question.service';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {

  questions : any;
  constructor(private questionService:QuestionService) { }

  ngOnInit() {
    this.questionService.getQuestionsByUserId(1).subscribe(data=>{
      this.questions = data;
      console.log(data);
    });
  }

}
