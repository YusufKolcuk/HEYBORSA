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
import { DovizComponent } from './doviz/doviz.component';
import { BorsaComponent } from './borsa/borsa.component';
import { SorularimComponent } from './sorularim/sorularim.component';
import { FavorilerimComponent } from './favorilerim/favorilerim.component';
import { AltinComponent } from './altin/altin.component';
import { SorularimicerikComponent } from './sorularimicerik/sorularimicerik.component';
import { Doviz } from './entities/Doviz';
import { Altin } from './entities/Altin';
import { Borsa } from './entities/Borsa';


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
    DovizComponent,
    BorsaComponent,
    SorularimComponent,
    FavorilerimComponent,
    AltinComponent,
    SorularimicerikComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
