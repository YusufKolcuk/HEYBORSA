import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { FooterComponent } from './footer/footer.component';
import { ControlSidebarComponent } from './control-sidebar/control-sidebar.component';
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
import { FormsModule } from '@angular/forms';
import { Currency } from './entities/Currency';
import { Gold } from './entities/Gold';
import { Exchange } from './entities/Exchange';
import { User } from './entities/User';
import { Favorite } from './entities/Favorite';
import { Question } from './entities/Question';
import { Answer } from './entities/Answer';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NewQuestionComponent } from './newquestion/newquestion.component';
import { FuPanelComponent } from './fu-panel/fu-panel.component';
import { FuPanelContentComponent } from './fu-panel-content/fu-panel-content.component';
import localeEN from "@angular/common/locales/en";
import { SearchPipe } from './search.pipe';
import { VerifyComponent } from './verify/verify.component';
import { SearchV2Pipe } from './search-v2.pipe';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    SidebarComponent,
    FooterComponent,
    ControlSidebarComponent,
    RegisterComponent,
    HomepageComponent,
    LoginComponent,
    ResetpasswordComponent,
    CurrencyComponent,
    ExchangeComponent,
    QuestionComponent,
    FavoritesComponent,
    GoldComponent,
    QuestionContentComponent,
    NewQuestionComponent,
    FuPanelComponent,
    FuPanelContentComponent,
    SearchPipe,
    VerifyComponent,
    SearchV2Pipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
  
 }
