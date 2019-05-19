import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { ResetpasswordComponent } from './resetpassword/resetpassword.component';
import { CurrencyComponent } from './currency/currency.component';
import { ExchangeComponent } from './exchange/exchange.component';
import { QuestionComponent } from './question/question.component';
import { FavoritesComponent } from './favorites/favorites.component';
import { GoldComponent } from './gold/gold.component';
import { QuestionContentComponent } from './question_content/question_content.component';
import { NewQuestionComponent } from './newquestion/newquestion.component';
import { FuPanelComponent } from './fu-panel/fu-panel.component';
import { FuPanelContentComponent } from './fu-panel-content/fu-panel-content.component';
import { VerifyComponent } from './verify/verify.component';

const routes: Routes = [
  {path:"",component:HomepageComponent,pathMatch:"full"},
  {path:"register",component:RegisterComponent},
  {path:"login",component:LoginComponent},
  {path:"resetpassword",component:ResetpasswordComponent},

  {path:"currency",component:CurrencyComponent},
  {path:"gold",component:GoldComponent,},
  {path:"exchange",component:ExchangeComponent},
  {path:"questions",component:QuestionComponent},
  {path:"questions/:id",component:QuestionContentComponent},
  {path:"favorites",component:FavoritesComponent},
  {path:"newquestion",component:NewQuestionComponent},
  {path:"fu-panel",component:FuPanelComponent},
  {path:"fu-panel/question/:id",component:FuPanelContentComponent},
  {path:"verifyemail/:key",component:VerifyComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
