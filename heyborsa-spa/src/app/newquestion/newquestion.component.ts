import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../service/question.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-newquestion',
  templateUrl: './newquestion.component.html',
  styleUrls: ['./newquestion.component.css']
})
export class NewQuestionComponent implements OnInit {

  public subject:String = "";
  public header:String = "";
  public content:String = "";


  constructor(private questionService:QuestionService,
              private router:Router) { }

  ngOnInit() {
  }

  add()
  {
    this.questionService.add(
     {
       user_id : 1,
       subject : this.subject,
       header : this.header,
       content : this.content
     }
    ).subscribe(data=>{
      console.log(data);
      if(data != null)
        this.router.navigateByUrl("/questions/" + data);
    });
  }



}
