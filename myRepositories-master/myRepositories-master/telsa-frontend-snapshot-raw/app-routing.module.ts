import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { AdminComponent } from './admin/admin.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { ChangeRoleComponent } from './change-role/change-role.component';
import { ContactComponent } from './contact/contact.component';
import { DeleteUserComponent } from './delete-user/delete-user.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { ResendTokenComponent } from './resend-token/resend-token.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path:'register',component:RegisterComponent},
  {path:'user',component:UserComponent},
  {path:'admin',component:AdminComponent},
  {path:'about',component:AboutComponent},
  {path:'contact',component:ContactComponent},
  {path:'resend-token',component:ResendTokenComponent},
  {path:'change-password',component:ChangePasswordComponent},
  {path:'forgot-password',component:ForgotPasswordComponent},
  {path:'user-list',component:UserListComponent},
  {path:'delete-user',component:DeleteUserComponent},
  {path:'update-profile',component:UpdateProfileComponent},
  {path:'change-role',component:ChangeRoleComponent},
  {path:'',redirectTo:'home',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
