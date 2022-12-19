import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms'
import { ServicesService } from './services.service';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { ResendTokenComponent } from './resend-token/resend-token.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { UserListComponent } from './user-list/user-list.component';
import { DeleteUserComponent } from './delete-user/delete-user.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { ChangeRoleComponent } from './change-role/change-role.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegisterComponent,
    UserComponent,
    AdminComponent,
    AboutComponent,
    ContactComponent,
    ResendTokenComponent,
    ChangePasswordComponent,
    ForgotPasswordComponent,
    UserListComponent,
    DeleteUserComponent,
    UpdateProfileComponent,
    ChangeRoleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [ServicesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
