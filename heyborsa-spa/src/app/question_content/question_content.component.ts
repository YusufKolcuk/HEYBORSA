import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../service/question.service';

@Component({
  selector: 'app-question_content',
  templateUrl: './question_content.component.html',
  styleUrls: ['./question_content.component.css']
})
export class QuestionContentComponent implements OnInit {
  answer:any;
  constructor(private questionService:QuestionService) { }
  
  ngOnInit() {
    this.questionService.getAnswersByQuestionId(1).subscribe(data=>{
      this.answer = data;
    });
  }

}
