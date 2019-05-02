import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
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

const routes: Routes = [
  {path:"",component:HomepageComponent,pathMatch:"full"},
  {path:"register",component:RegisterComponent},
  {path:"login",component:LoginComponent},
  {path:"resetpassword",component:ResetpasswordComponent},

  {path:"doviz",component:DovizComponent},
  {path:"altin",component:AltinComponent,},
  {path:"borsa",component:BorsaComponent},
  {path:"sorularim",component:SorularimComponent},
  {path:"sorularim/:id",component:SorularimicerikComponent},
  {path:"favorilerim",component:FavorilerimComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
